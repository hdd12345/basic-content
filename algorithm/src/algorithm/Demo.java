package algorithm;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class Demo {
	
	public static void fun(int [] arr) {
		Set<Integer> set = new HashSet<>();//���ڴ洢���ҳ�����ֵͬ
		for(int i = 0;i<arr.length;i++) {
			LinkedList<Integer> list = new LinkedList<>();//���ڴ洢ֵ��ͬ���±�
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
				System.out.println("ֵΪ��"+arr[i]+"��λ�ڣ�"+str);
				set.add(arr[i]);
			}
		}
	}

	public static void main(String[] args) {
		int [] arr = {1,3,34,1,3,43,3,23,3,34,34,24,24};
		fun(arr);
	}

}
