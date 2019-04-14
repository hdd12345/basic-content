package algorithm;

import java.util.Scanner;

public class Sort {
	//int类型参数是值传递，无法直接改变原始值
	public static void swap(int[] a,int x,int y){
		int temp=a[x];
		a[x]=a[y];
		a[y]=temp;
	}
	
	//二分插入排序
	public static int[] binaryInsertSort(int [] a){
		int left,right,middle;
		for(int i=1;i<a.length;i++){
			left=0;
			right=i-1;
			int temp=a[i];
			while(left<=right){
				middle=(left+right)/2;
				if(a[middle]>temp)right=middle-1;
				else left=middle+1;
			}
			for(int j=i;j>left;j--){
				a[j]=a[j-1];
			}
			if(left!=i)a[left]=temp;
		}
		return a;
	}
	
	//希尔排序
	public static int[] heerSort(int[] a){
		int d=a.length/2;
		while(true){
			for(int i=0;i<d;i++){
				for(int j=i;j+d<a.length;j+=d){
					for(int n = j;n+d<a.length-j;n+=d){
						if(a[n] > a[n+d]){
							swap(a,n,n+d);
						}
					}
				}
			}
			if(d==1)break;
			d--;
		}
		return a;
	}
	//快速排序
	public static int[] quickSort(int[] a,int left,int right){
		int i,j,x;
		if(left<right){
			i=left;
			j=right;
			x=a[left];
			while(i<j){
				while(i<j&&a[j]>=x)j--;
				a[i]=a[j];
				while(i<j&&a[i]<=x)i++;
				a[j]=a[i];
			}
			a[i]=x;
			quickSort(a,0,i-1);
			quickSort(a,i+1,right);
		}
		return a;
	}
	
	//直接插入排序
	public static int[] insertSort(int[] a){
		for(int i=1;i<a.length;i++){
			int temp=a[i];
			int j;
			for(j=i;j>0&&temp<a[j-1];j--){
				a[j]=a[j-1];
			}
			a[j]=temp;
		}
		return a;
	}
	
	//选择排序
	public static int[] selectSort(int[] a){
		for(int i=0;i<a.length-1;i++){
			int min=i;
			for(int j=i+1;j<a.length;j++)
				if(a[j]<a[min])min=j;
			if(min!=i){
				int temp=a[i];
				a[i]=a[min];
				a[min]=temp;
			}
		}
		return a;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("你想给几个数排序：");
		Scanner sc=new Scanner(System.in);
		int b=sc.nextInt();	
		int[] a=new int[b];
		System.out.println("请输入要排序的数：");
		for(int i=0;i<b;i++){
			a[i]=sc.nextInt();
		}
		int[] c=heerSort(a);
		for(int j=0;j<c.length;j++){
			System.out.print(c[j]+" ");
		}
	}
}
