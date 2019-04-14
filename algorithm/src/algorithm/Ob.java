package algorithm;

import java.util.ArrayList;

public class Ob {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Object[] object=new Object[4];//对象数组，所有子类型对象都可成为元素
		object[0]=1;
		object[1]="String";
		object[2]=new Double(3);
		object[3]=new Integer(4);
		for(int i=0;i<object.length;i++){
			System.out.println(object[i]);
		}
		//泛型集合，动态数组,长度随元素的增多而增大
		ArrayList<Object> list=new ArrayList<>();
		list.add(0, 1);
		list.add(1, "String");
		list.add(2, new Double(3));
		list.add(3, new Integer(4));
		for(int i=0;i<list.size();i++){
			System.out.println(list.get(i));
		}
		System.out.println(Double.parseDouble(list.get(2).toString()));
		

	}

}
