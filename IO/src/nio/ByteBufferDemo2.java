package nio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class ByteBufferDemo2 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		ByteBuffer bb = ByteBuffer.allocate(1024);
		File file = new File("deed.txt");
		FileInputStream fis = new FileInputStream(file);
		FileOutputStream fos = new FileOutputStream("filewriter.txt");
		FileChannel inChannel = fis.getChannel();
		FileChannel outChannel = fos.getChannel();
		inChannel.read(bb);
		//bb.clear();
		bb.flip();
		outChannel.write(bb);
		
	}

}
