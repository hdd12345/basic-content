package junitTest;

import static com.interfacetest.InterfaceDemo.met;

import org.junit.Test;

public class JUnitTestDemo {

	@Test
	public void test01() {
		met();
		int [] arr = {12};
		setString(arr);
		System.out.println(arr[0]);
	}
	
	public void setString(int[] arr) {
		arr[0]=9;
	}

}
