import java.io.FileReader;
import java.io.IOException;

public class FilrReaderDemo {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//创建FilrReader对象
		@SuppressWarnings("resource")
		FileReader fr = new FileReader("filewriter.txt");
		//每次读取一个字符，返回int类型，到达文件末尾返回-1
//		int ch=0;
//		while((ch = fr.read())!=-1){
//			System.out.print((char)ch);
//		}
		
		//将字符读取到字符数组，返回读取的字符数，到达文件末尾返回-1	
		char[] cbuf =new char[512];//一个char占用2个字节，该数组共占1024字节，即1kb
		int num = 0;
//		while((num=fr.read(cbuf))!=-1){
//			System.out.print(new String(cbuf,0,num));
//		}
		num = fr.read(cbuf,2,2);
		System.out.print(new String(cbuf,2,num));
	}

}
