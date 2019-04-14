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
		fr.read(cb);//将文件内容读取到缓冲区
		fw.write(cb.array());//从缓冲区数组中读取内容
		fw.flush();
	}

}
