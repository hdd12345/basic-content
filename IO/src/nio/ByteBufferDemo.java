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
		//新建ByteBuffer对象，参数为缓冲区容量，以字节为单位
		//ByteBuffer bb = ByteBuffer.allocate(10);
		File file = new File("deed.txt");
		FileInputStream fis = new FileInputStream(file);
		FileOutputStream fos = new FileOutputStream("filewriter.txt");
		FileChannel inChannel = fis.getChannel();
		FileChannel outChannel = fos.getChannel();
		//将通道中的数据全部映射成ByteBuffer,该inChannel对象是由输入流获取的，所以只可读
		MappedByteBuffer mbb = inChannel.map(FileChannel.MapMode.READ_ONLY,0,file.length());
		//将Buffer中的数据全部输出
		outChannel.write(mbb);
		mbb.clear();
		
		//创建字符编码
		Charset charset = Charset.forName("GBK");
		//通过字符编码创建解码器对象
		CharsetDecoder cd = charset.newDecoder();
		//通过解码器对象将ByteBuffer转换成CharBuffer
		CharBuffer charBuffer = cd.decode(mbb);
		System.out.println(charBuffer);
		
		inChannel.close();
		outChannel.close();
		fis.close();
		fos.close();
	}

}
