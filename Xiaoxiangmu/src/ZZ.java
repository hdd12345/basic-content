import java.util.Random;
import java.util.Scanner;
public class ZZ {
	//静态方法getRandomString(int length)用于随机生成字符串
	//参数length为生成的字符串的长度
	public static String getRandomString(int length) {   
	    String base = "abcdefghijklmnopqrstuvwxyzABCDEFGH"
	    		+ "IJKLMNOPQRSTUVWXYZ0123456789";     
	    Random random = new Random();     
	    StringBuffer sb = new StringBuffer();     
	    for (int i = 0; i < length; i++) {     
	        int number = random.nextInt(base.length());
	        //charAt(int index)返回指定位置的字符
	        //append(String s)结尾插入
	        sb.append(base.charAt(number));     
	    }     
	    return sb.toString();     
	 }     
	public static void main(String[] args) {
		String str1=ZZ.getRandomString(6);
		System.out.println("验证码："+str1);
		System.out.println("请输入验证码：");
		Scanner scanner=new Scanner(System.in);
		String str2=scanner.next();
		if(str1.equalsIgnoreCase(str2)){
			System.out.println("验证码正确！");
		}else{
			System.out.println("验证码错误！");
		}
	}
}
