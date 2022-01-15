package com.kedar.destination;

import java.lang.reflect.Constructor;

public class UsingNewMethodDemo {

	public static void main(String[] args) {
		try {
			// Loading Class
			@SuppressWarnings("rawtypes")
			Class c  = Class.forName(args[0]);
			// Creating Object
			@SuppressWarnings("rawtypes")
			Constructor cons[] = c.getDeclaredConstructors();
			// Fetching the Each Constructor
			Object obj1 = cons[1].newInstance();
			Object obj2 = cons[1].newInstance(31,9);
			System.out.println("0 Param :: " + obj1);
			System.out.println("2 Param :: " + obj2);
		} // try
		catch (Exception e) {
			// catch block
			e.printStackTrace();
		} // catch
	} // main
} // class
