import java.io.FileReader;
import java.io.IOException;

public class FilrReaderDemo {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//����FilrReader����
		@SuppressWarnings("resource")
		FileReader fr = new FileReader("filewriter.txt");
		//ÿ�ζ�ȡһ���ַ�������int���ͣ������ļ�ĩβ����-1
//		int ch=0;
//		while((ch = fr.read())!=-1){
//			System.out.print((char)ch);
//		}
		
		//���ַ���ȡ���ַ����飬���ض�ȡ���ַ����������ļ�ĩβ����-1	
		char[] cbuf =new char[512];//һ��charռ��2���ֽڣ������鹲ռ1024�ֽڣ���1kb
		int num = 0;
//		while((num=fr.read(cbuf))!=-1){
//			System.out.print(new String(cbuf,0,num));
//		}
		num = fr.read(cbuf,2,2);
		System.out.print(new String(cbuf,2,num));
	}

}
