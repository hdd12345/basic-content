package algorithm;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class Demo {
	
	public static void fun(int [] arr) {
		Set<Integer> set = new HashSet<>();//用于存储已找出的相同值
		for(int i = 0;i<arr.length;i++) {
			LinkedList<Integer> list = new LinkedList<>();//用于存储值相同的下标
			String str = "";
			for(int j = 0;j<arr.length;j++) {
				if(arr[j] == arr[i]&& j != i)list.add(j);
			}
			if(list.size()>0&&!set.contains(arr[i])) {
				list.addFirst(i);
				for(int val:list) {
					str += val+",";
				}
				str = str.substring(0,str.length()-1);
				System.out.println("值为："+arr[i]+"，位于："+str);
				set.add(arr[i]);
			}
		}
	}

	public static void main(String[] args) {
		int [] arr = {1,3,34,1,3,43,3,23,3,34,34,24,24};
		fun(arr);
	}

}
