package iostream;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
/**
 * �ֽ���������ʹ�����Ķ�д˼������������
 * @author Administrator
 *
 */
public class ByteArrayDemo {

	public static void main(String[] args) {
		//���췽������Ϊ����Դ
		ByteArrayInputStream bis = new ByteArrayInputStream("�ˣ����".getBytes());
		//�ڲ�����һ���Զ����ݵ��ֽ����飬������Ϊ����д���Ŀ�ĵأ�writeTo�����ɽ�����ͨ����������д������Ŀ�ĵ�
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		int num = 0;
		while((num=bis.read())!=-1){
			bos.write(num);
		}
		System.out.println(bos.toString());
	}

}
