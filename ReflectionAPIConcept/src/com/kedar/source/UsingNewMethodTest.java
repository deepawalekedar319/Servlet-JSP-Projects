package com.kedar.source;

public class UsingNewMethodTest {
	private int a=10,b=20;
	public UsingNewMethodTest() {
		System.out.println("UsingNewMethodTest.UsingNewMethodTest() :: Zero param");
	} // Constructor
	public UsingNewMethodTest(int a, int b){
		System.out.println("UsingNewMethodTest.UsingNewMethodTest() :: Two param");
		this.a=a;
		this.b=b;
	} // two param
	@Override
	public String toString() {
		return "UsingNewMethodTest [a=" + a + ", b=" + b + "]";
	}
} // class
