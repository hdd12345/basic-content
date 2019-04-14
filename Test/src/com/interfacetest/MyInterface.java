package com.interfacetest;

public interface MyInterface {
	public default void hello() {
		System.out.println("it is default method!");
	}
	public static void hello2() {
		System.out.println("it is static method!");
	}
}
