package algorithm;

import java.util.Scanner;
/**
 * ���������������
 * @author Administrator
 *
 */
public class Fibonacci {
	//�÷�������ǰc��֮��,aΪ��һ�bΪ�ڶ���
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
		System.out.println("�������1���2���������");
		int a=sc.nextInt();
		int b=sc.nextInt();
		int c=sc.nextInt();
		System.out.println("ǰ"+c+"���Ϊ��"+f.fun(a, b, c));

	}

}
