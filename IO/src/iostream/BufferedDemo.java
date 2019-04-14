package iostream;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferedDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedInputStream bfis = null;
		BufferedOutputStream bfos = null;
		try {
			bfis = new BufferedInputStream( new FileInputStream(new File("C:\\Users\\Administrator\\Pictures\\Saved Pictures\\20161223.jpg")));
			bfos = new BufferedOutputStream(new FileOutputStream("jiatenghui.jpg"));
			byte[] b = new byte[1024];
			int num =0;
			while((num=bfis.read(b,0,1024))!=-1){
				bfos.write(b,0,num);
			}
			//一个一个字节地读取
//			int b = 0;
//			while((b=bfis.read())!=-1){
//				bfos.write(b);
//			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			if(bfis!=null){
				try {
					bfis.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(bfos!=null){
				try {
					bfos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

}
