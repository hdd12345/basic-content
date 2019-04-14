package iostream;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class TransStreamDemo {
	
	static BufferedReader br = null;
	static BufferedWriter bw =null;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		copy1();
	}
	
	/**
	 * 将输入数据打印在控制台上
	 * @throws IOException 
	 */
	public static void copy1() throws IOException{
		br = new BufferedReader(new InputStreamReader(System.in,"GBK"));
		bw = new BufferedWriter(new OutputStreamWriter(System.out,"GBK"));
		String str = null;
		while((str=br.readLine())!=null){
			bw.write(str);
			bw.newLine();
			bw.flush();
		}
		closeAll();
	}
	
	/**
	 * 将输入的数据存在txt文件中
	 * @throws IOException 
	 */
	public static void copy2() throws IOException{
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new FileWriter("filewriter.txt"));
		String str = null;
		while((str=br.readLine())!=null){
			bw.write(str);
			bw.newLine();
			bw.flush();
		}
		closeAll();
	}
	
	/**
	 * 将txt文件数据打印在控制台中
	 * @throws IOException 
	 */
	public static void copy3() throws IOException{
		br = new BufferedReader(new FileReader("deed.txt"));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String str = null;
		while((str = br.readLine())!=null){
			bw.write(str);
			bw.newLine();
			bw.flush();
		}
	}
	
	/**
	 * 直接使用字节缓冲流实现控制台输入输出
	 * @throws IOException 
	 */
	public static void copy4() throws IOException{
		BufferedInputStream  bis = new BufferedInputStream(System.in);
		BufferedOutputStream bos = new BufferedOutputStream(System.out);
		byte[] b = new byte[1024];
		int num = 0;
		while((num = bis.read(b))!=-1){
			bos.write(b,0,num);
			bos.flush();
		}
		bis.close();
		bos.close();
	}
	
	public static void closeAll(){
		if(br!=null){
			try {
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(bw!=null){
			try {
				bw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
