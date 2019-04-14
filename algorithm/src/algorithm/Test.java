package algorithm;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Objects;

public class Test {

	public static void main(String[] args) {
		Object obj1 = new Object();
		Object obj2 = new Object();
		System.out.println(obj1.equals(obj2));
		System.out.println(obj1==obj2);
		HashMap<Object,Object> map1 = new HashMap<>();
		map1.put(obj1, obj2);
		HashMap<Object,Object> map2 = new HashMap<>();
		map2.put(obj1, obj2);
		System.out.println(map1.equals(map2));
		System.out.println(Objects.equals(map1,map2));
		System.out.println(map1==map2);
		System.out.println(Objects.equals(obj1,obj2));
	}
}
