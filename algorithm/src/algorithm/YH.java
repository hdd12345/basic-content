package algorithm;

import java.util.Scanner;
/**
 * ���������
 * @author Administrator
 *
 */
public class YH {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("������������");
		int n=sc.nextInt();
		int[][] a=new int[n][];
		for(int i=0;i<n;i++){
			a[i]=new int[i+1];
		}
		for(int i=0;i<n;i++){
			for(int j=0;j<=i;j++){
				if(j==0||j==i)a[i][j]=1;
				else a[i][j]=a[i-1][j]+a[i-1][j-1];
			}
		}
		for(int i=0;i<n;i++){
			for(int j=0;j<=i;j++){
				if(j==i)System.out.println(a[i][j]);
				else System.out.print(a[i][j]+"\t");
			}
		}
	}
}
