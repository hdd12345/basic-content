package nio;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.CharBuffer;

public class CharBufferDemo {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		CharBuffer cb = CharBuffer.allocate(1024);
		FileReader fr = new FileReader("deed.txt");
		FileWriter fw = new FileWriter("filewriter.txt");
		fr.read(cb);//���ļ����ݶ�ȡ��������
		fw.write(cb.array());//�ӻ����������ж�ȡ����
		fw.flush();
	}

}
