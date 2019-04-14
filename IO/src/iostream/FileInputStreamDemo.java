package iostream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInputStreamDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FileInputStream fis = null;
		try {
			fis = new FileInputStream("deed.txt");
			System.out.println(fis.available());//该方法返回剩余未读的字节数
//			byte [] by = new byte[fis.available()];
//			fis.read(by);
//			System.out.println(new String(by));
			byte[] b = new byte[1024];
			int num = 0;
			while((num=fis.read(b))!=-1){
				System.out.println(new String(b,0,num));
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			if(fis!=null){
				try {
					fis.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

}
