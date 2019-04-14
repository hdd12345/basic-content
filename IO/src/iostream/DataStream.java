package iostream;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

/**
 * 操作java基本数据类型的读写
 * @author Administrator
 *
 */
public class DataStream {
		public static void main(String[] args) throws IOException{
			//writeData();
			readData();
		}
		
		public static void writeData() throws IOException{
			DataOutputStream dos = new DataOutputStream(new FileOutputStream("data.txt"));
			dos.writeInt(123);
			dos.writeBoolean(false);
			dos.writeDouble(23.5);
			dos.close();
		}
		
		public static void readData() throws IOException{
			DataInputStream din = new DataInputStream(new FileInputStream("data.txt"));
			System.out.println(din.readInt());
			System.out.println(din.readBoolean());
			System.out.println(din.readDouble());
			din.close();
		}
}
