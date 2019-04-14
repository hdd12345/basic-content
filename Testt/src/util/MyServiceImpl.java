package util;

import org.springframework.stereotype.Service;

@Service("myServiceImpl")
public class MyServiceImpl {
	public void myMethod() {
		int [] arr = {1,2};
		System.out.println(arr[2]);
		System.out.println("目标对象方法target...");
	}
}
