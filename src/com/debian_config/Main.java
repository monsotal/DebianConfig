package com.debian_config;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		System.out.println("Welcome To Debian Config tool!");
		
//This reads the input provided by user
//using keyboard
		
		Scanner userinput = new Scanner(System.in);


	    // Display menu graphics
	    System.out.println("========================================================================");
	    System.out.println("|                   Debian config tool Menu                            |");
	    System.out.println("========================================================================");
	    System.out.println("|                         Options:                                     |");
	    System.out.println("|1.set an IP address to an interface                                   |");
	    System.out.println("|2. Display / Add / Remove Routes                                      |");
	    System.out.println("|3. Change machine hostname                                            |");
	    System.out.println("|4. Set proxy                                                          |");
	    System.out.println("|5. Updates the system using apt-get update..                          |");
	    System.out.println("|6. Install packages (nano/apache/java/python/java/jenkins/tcpdump)    |");
	    System.out.println("|7. Add DNS server to resolv.conf                                      |");
	    System.out.println("|8. Run a complete machine config                                      |");
	    System.out.println("|9. Exit                                                               |");
		System.out.println("|======================================================================|"); 
	    
	    
		

	    
//This try block check statements that may cause an exception
	    
try {
	    	
// This method reads the number provided using keyboard
    
    	System.out.println("Pick your option:");
        int num = userinput.nextInt();
        System.out.println(num);
        
// Closing Scanner after the use   
        
        userinput.close();
        
        
        switch (num)
        {
             case 1:
            	 System.out.println("You picked Option 1");
            	 break;
            	 
             case 2:
            	 System.out.println("You picked Option 2");
            	 break;
            	 
             default:
            	 System.out.println("Option doesn't Exist");
        }
	}
        
catch(InputMismatchException  e){
        	
        	System.out.println("Input Error occured");
        	
}

catch(Exception e) {
	
	System.out.println("An unknown error occured");
	e.printStackTrace();
		}

	}

}
