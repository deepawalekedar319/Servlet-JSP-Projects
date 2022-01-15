package com.kedar.destination;

public class Demo {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		try {
			// Loading the Source Class
			@SuppressWarnings("rawtypes")
			Class c = Class.forName(args[0]);
			// Creating object of source Class
			Object obj = c.newInstance();		
			// Printing the object
			System.out.println(obj);
			// If we want to print the direct methods of Sub class then type cast it
		} // try
		catch (Exception e) {
			//  catch block
			e.printStackTrace();
		} // catch		
	} // main
} // class
