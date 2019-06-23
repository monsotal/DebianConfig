package com.debian_config;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		System.out.println("Welcome To Debian Config tool!");
		
//This reads the input provided by user
//using keyboard
		
		Scanner userinput = new Scanner(System.in);


	    // Display menu graphics
	    System.out.println("============================");
	    System.out.println("|   MENU SELECTION DEMO    |");
	    System.out.println("============================");
	    System.out.println("| Options:                 |");
	    System.out.println("|        1. Option 1       |");
	    System.out.println("|        2. Option 2       |");
	    System.out.println("|        3. Exit           |");
	    System.out.println("============================");
	    
	    
// This method reads the number provided using keyboard
	    
	    System.out.println("Pick your option:");
        int num = userinput.nextInt();
        
// Closing Scanner after the use   
        
        userinput.close();
        
        System.out.println("You picked:"+num);
	    


	}

}
