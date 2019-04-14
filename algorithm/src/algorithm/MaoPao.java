package algorithm;

import java.util.Scanner;

public class MaoPao {

	public static int[] fun(int[] arr){
		int temp;
		for(int i=0;i<arr.length;i++){
			for(int j=0;j<arr.length-1-i;j++){
				if(arr[j]>arr[j+1]){
					temp=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
				}
			}
		}
		return arr;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("你想排序几个数：");	
		int a=sc.nextInt();
		int[] arr=new int[a];
		System.out.println("请输入要排序的数：");
		for(int i=0;i<a;i++)arr[i]=sc.nextInt();
		int[] arr01=MaoPao.fun(arr);
		for(int j=0;j<arr01.length;j++){
			System.out.println(arr01[j]);	
		}

	}

}
