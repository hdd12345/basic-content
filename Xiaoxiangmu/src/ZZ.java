import java.util.Random;
import java.util.Scanner;
public class ZZ {
	//��̬����getRandomString(int length)������������ַ���
	//����lengthΪ���ɵ��ַ����ĳ���
	public static String getRandomString(int length) {   
	    String base = "abcdefghijklmnopqrstuvwxyzABCDEFGH"
	    		+ "IJKLMNOPQRSTUVWXYZ0123456789";     
	    Random random = new Random();     
	    StringBuffer sb = new StringBuffer();     
	    for (int i = 0; i < length; i++) {     
	        int number = random.nextInt(base.length());
	        //charAt(int index)����ָ��λ�õ��ַ�
	        //append(String s)��β����
	        sb.append(base.charAt(number));     
	    }     
	    return sb.toString();     
	 }     
	public static void main(String[] args) {
		String str1=ZZ.getRandomString(6);
		System.out.println("��֤�룺"+str1);
		System.out.println("��������֤�룺");
		Scanner scanner=new Scanner(System.in);
		String str2=scanner.next();
		if(str1.equalsIgnoreCase(str2)){
			System.out.println("��֤����ȷ��");
		}else{
			System.out.println("��֤�����");
		}
	}
}
