package regular;

public class RegularDemo {

	public static void main(String[] args) {
		//���Ž�������飬ÿһ���鶼�б�ţ���1��ʼ����Ҫʹ�����е������ͨ��\n����ȡ��\1��ʾʹ�õ�һ��
		//�����и�
		//splitDemo("dsdfffweecd","(.)\\1+");
		//��б���и�
		//splitDemo("C:\\ads\\hello.txt","\\\\");
		//�������滻�ɵ���
		System.out.println("hhhhdeaffefddkeei".replaceAll("(.)\\1+","$1"));//$1��ȡǰ��ĵ�һ��
	}
	
	public static void splitDemo(String str,String regex) {
		String arr[] = str.split(regex);
		for(String s:arr) {
			System.out.println(s);
		}
	}
}
