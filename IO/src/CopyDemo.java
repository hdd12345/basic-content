import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CopyDemo {

	public static void main(String[] args){
		FileReader fr = null;
		FileWriter fw = null;	
		try {
			//创建输入流
			 fr = new FileReader(new File("deed.txt"));
			//创建输出流
			 fw = new FileWriter("filewriter.txt",true);
			char[] cbuf = new char[1024];
			//读取文件内容并写入指定文件
			int num = 0;
			while((num = fr.read(cbuf,0,1024))!=-1){
				fw.write(cbuf, 0,num);
			}
			
			 
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			try {
				fr.close();
				fw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		}
		
	}

}
