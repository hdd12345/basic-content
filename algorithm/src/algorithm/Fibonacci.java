package algorithm;

import java.util.Scanner;
/**
 * 菲利波切数列求和
 * @author Administrator
 *
 */
public class Fibonacci {
	//该方法返回前c项之和,a为第一项，b为第二项
	public int fun(int a,int b,int c){
		int[] arr=new int[c];
		arr[0]=a;
		arr[1]=b;
		int sum=a+b;
		for(int i=2;i<=c-1;i++){
			arr[i]=arr[i-2]+arr[i-1];
			sum+=arr[i];
		}
		return sum;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		Fibonacci f=new Fibonacci();
		System.out.println("请输入第1项，第2项，及项数：");
		int a=sc.nextInt();
		int b=sc.nextInt();
		int c=sc.nextInt();
		System.out.println("前"+c+"项和为："+f.fun(a, b, c));

	}

}
