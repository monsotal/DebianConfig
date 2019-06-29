package com.debian_config;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		System.out.println("Welcome To Debian_Config tool!");
		
//This reads the input provided by user
//using keyboard
		
		

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
	
			 if(listcontainsnum) {
				
				 switch (num)
				 {
             case 1:
            	 System.out.println("You picked Option 1");
            	 break;
            	 
             case 2:
            	 System.out.println("You picked Option 2");
            	 break;
        	 
             case 3:
            	 System.out.println("You picked Option 3");
            	 break;
        	 
             case 4:
            	 System.out.println("You picked Option 4");
            	 break;
        	 
             case 5:
            	 System.out.println("You picked Option 5");
            	 break;
            	 
             case 6:
            	 System.out.println("You picked Option 6");
            	 break;
        	 
             case 7:
            	 System.out.println("You picked Option 7");
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
	

		 catch(Exception e) {

			 System.out.println("Invalid Characters typed");
			 getsUserInput();


		 }

				
	}

	}


