package com.debian_config.Main;


import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;



public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		System.out.println("--Welcome To Debian_Config tool--");


	    // Display menu graphics
		
	    System.out.println("========================================================================");
	    System.out.println("|                   Debian config tool Menu                            |");
	    System.out.println("========================================================================");
	    System.out.println("|                         Options:                                     |");
	    System.out.println("|1.set an IP address to an interface                                   |");
	    System.out.println("|2. Enable SSH login for a 'root' user                                 |");
	    System.out.println("|3. Change machine hostname                                            |");
	    System.out.println("|4. Set proxy                                                          |");
	    System.out.println("|5. Updates the system using apt-get update..                          |");
	    System.out.println("|6. Install packages (nano/apache/java/python/java/jenkins/tcpdump)    |");
	    System.out.println("|7. Add DNS server to resolv.conf                                      |");
	    System.out.println("|8. Run a complete machine config                                      |");
	    System.out.println("|9. Exit                                                               |");
		System.out.println("|======================================================================|"); 

		//Calls getsUserInput function
		
		getsUserInput();
		
        
	}
     

	public static void getsUserInput() {

		//Create an Integer ArrayList with 9 items from 1 to 9
		
		 List<Integer> numlist = new ArrayList<Integer>();
		 numlist.addAll(Arrays.asList(1,2,3,4,5,6,7,8,9));

		 
		 //Getting Integer value from user
		 
		 try {
			 System.out.println("Pick your option:");
			 Scanner userinput = new Scanner(System.in);
			 int num = userinput.nextInt();

		
			 boolean listcontainsnum = numlist.contains(num);

		
		//Checking if input appears in list, then use it in a switch-case
	
			 if (listcontainsnum) {
				
				 switch (num)
				 {
             case 1:
            	 System.out.println("You picked Option 1");
            	 break;
            	 
             case 2:
            	 PermitRootLogin();
            	 break;
        	 
             case 3:
            	System.out.println("Please type a new hostname for your system"); 
     			Scanner hostname = new Scanner(System.in);
     			configureHostname(hostname.nextLine());
            	 break;
        	 
             case 4:
            	 configureProxy();
            	 break;
        	 
             case 5:
            	 System.out.println("You picked Option 5");
            	 break;
            	 
             case 6:
            	 System.out.println("You picked Option 6");
            	 break;
        	 
             case 7:
            	 configureDns();
            	 userinput.close();
            	 break;
            	 
             case 8:
            	 System.out.println("You picked Option 8");
            	 break;
        	 
             case 9:
            	 System.out.println("You picked Option 9");
            	 break;
            	 
             default:
            	 System.out.println("Option doesn't Exist");

				 }
		

			 }
		
	//Use recursion if list doesn't contain number
	
			 else {
				 System.out.println("Invalid selection:");
				 getsUserInput();

	
			 }
		 }
	

		 catch (Exception e) {

			 System.out.println("Invalid Characters typed");
			 getsUserInput();


		 }

				
	}
	
	
	
	
	
		
	public static void configureDns() {
		

		try {
			
			//Gets DNS server address from the user
			
			System.out.println("Please type a DNS server for your system:");
			Scanner dnsinput = new Scanner(System.in);
			String dnsserver = dnsinput.nextLine();

			
			//Define regular expression pattern for a valid IP address
			
			String validdnsinput = "^(([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])\\.){3}([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])$";
			boolean validDns = Pattern.matches(validdnsinput, dnsserver);
			
			
			
			//Checks if boolean variable matches the regular expression pattern, then it edits resolv.conf file

			if(validDns) {
				
				FileWriter resolvfile = new FileWriter("/etc/resolv.conf");
				resolvfile.write("nameserver " + dnsserver);
				resolvfile.close();
				dnsinput.close();
				System.out.println("The DNS server " + dnsserver + " has been successfully configured as your primary DNS server");
			}
			
			
			
			//if boolean variable does not match the regular expression pattern, run recursion
			
			else {
				System.out.println("Invalid DNS server typed!!!");
				configureDns();
				
			}
			
			
		}
		
		catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	
	
	
	
	public static void configureProxy() {
		
		try {
			
//Gets Proxy server address from the user
			
			System.out.println("Please type a Proxy server address for your system,"
					+          "in the following format:\n"
					+ "http://<IP>:<port>\n"
					+ "e.g : http://213.54.21.9:8080");
			
			Scanner proxyinput = new Scanner(System.in);
			String proxyserver = proxyinput.nextLine();
			
			
//Edits apt.conf file with the user input
			
			FileWriter proxyfile = new FileWriter("/etc/apt/apt.conf");
			proxyfile.write("Acquire::http::Proxy \""+proxyserver+"\";");
			proxyfile.close();
			proxyinput.close();
			System.out.println("The Proxy server " + proxyserver + " has been successfully configured for your system");
			
		}
		
		catch(Exception e) {
			e.printStackTrace();
			
		}
		}
	
	
	
	public static String configureHostname(String newhostname) {
		
		try {

//accepting  Hostname parameter from the user & add it to "/etc/hostname" file
			
			FileWriter hostnameinstance = new FileWriter("/etc/hostname");
			hostnameinstance.write(newhostname);
			
		
			System.out.println("The new hostname " + newhostname + " has been successfully configured for your system"
					+ "\nPlease reboot your system for these changes to take effect");
			hostnameinstance.close();
			return newhostname;

			}

		catch(Exception e) {
			e.printStackTrace();
			return null;
			
		}
		
	}
	



	public static void PermitRootLogin() {
		
		
		try {
//backup the original '/etc/ssh/sshd_config' file
			
			sshdConfigBackup();
			
//adding 'PermitRootLogin yes' statement, to the end of'/etc/ssh/sshd_config' file
//adding the 'true' flag, to append data to the file and not overwriting it			
			
			FileWriter permitRootLoginInstance = new FileWriter("/etc/ssh/sshd_config",true);
			permitRootLoginInstance.write("\n"+"PermitRootLogin yes"+"\n");
			
			permitRootLoginInstance.close();
			
			
			
//restart SSH server			
			

			 ProcessBuilder pb = new ProcessBuilder();
			 pb.command("bash", "-c", "top");
			 pb.start();

			System.out.println("SSH login with 'root' user is now permitted");
			
			}

		catch(Exception e) {
			e.printStackTrace();
			
		}
		
	}
	
	
	public static void sshdConfigBackup() throws IOException 
	{
	    Path source = Paths.get("/etc/ssh/sshd_config");
	    Path destination = Paths.get("/etc/ssh/sshd_config.orig");
	 
	    Files.copy(source, destination, StandardCopyOption.REPLACE_EXISTING);
	}
		
}
	

