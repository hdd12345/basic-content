package nio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.Channel;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

public class ByteBufferDemo {

	public static void main(String[] args) throws IOException {
		//�½�ByteBuffer���󣬲���Ϊ���������������ֽ�Ϊ��λ
		//ByteBuffer bb = ByteBuffer.allocate(10);
		File file = new File("deed.txt");
		FileInputStream fis = new FileInputStream(file);
		FileOutputStream fos = new FileOutputStream("filewriter.txt");
		FileChannel inChannel = fis.getChannel();
		FileChannel outChannel = fos.getChannel();
		//��ͨ���е�����ȫ��ӳ���ByteBuffer,��inChannel����������������ȡ�ģ�����ֻ�ɶ�
		MappedByteBuffer mbb = inChannel.map(FileChannel.MapMode.READ_ONLY,0,file.length());
		//��Buffer�е�����ȫ�����
		outChannel.write(mbb);
		mbb.clear();
		
		//�����ַ�����
		Charset charset = Charset.forName("GBK");
		//ͨ���ַ����봴������������
		CharsetDecoder cd = charset.newDecoder();
		//ͨ������������ByteBufferת����CharBuffer
		CharBuffer charBuffer = cd.decode(mbb);
		System.out.println(charBuffer);
		
		inChannel.close();
		outChannel.close();
		fis.close();
		fos.close();
	}

}
