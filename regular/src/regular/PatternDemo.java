package regular;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternDemo {

	public static void main(String[] args) {
		String regex = "\\d{3}";
		String str = "342deg4325";
		//��������ʽ��װ�ɶ���
		Pattern p = Pattern.compile(regex);
		//���ƥ�������󣨽����������Ҫ�������ַ����������
		Matcher m = p.matcher(str);
		//System.out.println(m.matches());
		System.out.println(m.find());//���Ϲ����ִ��Ĳ���
		System.out.println(m.group());//��ȡƥ�����
		System.out.println(m.start());//��һ��ƥ��Ŀ�ʼ����
		System.out.println(m.end());//���ƥ���ַ����ƫ����������һ��ƥ�俪ʼ������
	}

}
