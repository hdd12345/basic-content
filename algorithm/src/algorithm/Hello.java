package algorithm;

import java.util.Objects;

public class Hello {
	public static void swap(int[] a,int x,int y){
		int temp=a[x];
		a[x]=a[y];
		a[y]=temp;
	}
	
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
	
	public static int[] heerSort(int[] a){
		int d=a.length;
		while(true){
			d/=2;
			for(int i=0;i<d;i++){
				//冒泡实现
				for(int j=i;j+d<a.length;j+=d){
					for(int n = j;n+d<a.length-j;n+=d){
						if(a[n] > a[n+d]){
							swap(a,n,n+d);
						}
					}
				}
				//插入实现
//				for(int j=i+d;j<a.length;j+=d){
//					int temp=a[j];
//					int k;
//					for(k=j;k<a.length&&k>0&&a[k-d]>temp;k=k-d){
//						a[k]=a[k-d];
//					}
//					a[k]=temp;
//				}
		}
			if(d==1)break;
	}
		return a;
	}
	
	 public static int[] shellSort(int[] arr){
        //增量gap，并逐步缩小增量
         for(int gap=arr.length/2;gap>0;gap/=2){
            //从第gap个元素，逐个对其所在组进行直接插入排序操作
            for(int i=gap;i<arr.length;i++){
                int j = i;
                 int temp = arr[j];
                if(arr[j]<arr[j-gap]){
                     while(j-gap>=0 && temp<arr[j-gap]){
                         //移动法
                         arr[j] = arr[j-gap];
                        j-=gap;
                     }
                     arr[j] = temp;
                 }
            }
        }
         return arr;
     }

	
	public static int[] quickSort(int[] a,int left,int right){
		int i,j,x;
		if(left<right){
			i=left;
			j=right;
			x=a[left];
			while(left<j){
				while(left<j&&a[j]>=x)j--;
				a[left]=a[j];
				while(left<j&&a[left]<=x)left++;
				a[j]=a[left];
			}
			a[left]=x;
			quickSort(a,0,left-1);
			quickSort(a,left+1,right);
		}
		return a;
	}
	
	public static void main(String[] args) {
		
		int[] a={2,3,7,4,12,23,5,7,6,4,-8,54,32,3,24,43,21,-23,42,-33,321,42,11,3,4,90};
		int[] b=heerSort(a);
		
		for(int i=0;i<b.length;i++){
			System.out.print(b[i]+" ");
		}
	}
}
