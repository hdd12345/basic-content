package iostream;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PrintDemo {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		demo1();
	}
	
	/**
	 * 将异常日志信息打印在指定txt文件中
	 * @throws IOException 
	 */
	public static void demo1() throws IOException{
		try{
			int[] arr =new int[]{1,2};
			int a = arr[2];
		}catch(Exception e){
			PrintStream ps = new PrintStream("filewriter.txt");
			ps.write(new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss:").format(new Date()).getBytes());
//			PrintWriter pw = new PrintWriter("filewriter.txt");
//			pw.write(new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss:").format(new Date()));
			e.printStackTrace(ps);
			e.printStackTrace();
//			pw.flush();
		}
		
	}

}
