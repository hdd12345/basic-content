package com.interfacetest;

public class InterfaceDemo {

	public static void main(String[] args) {
		MyInterface mi = new MyInterfaceImpl();
		mi.hello();
		MyInterface.hello2();
	}
	public static void met() {
		System.out.println("static");
	}

}
