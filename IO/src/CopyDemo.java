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
			//����������
			 fr = new FileReader(new File("deed.txt"));
			//���������
			 fw = new FileWriter("filewriter.txt",true);
			char[] cbuf = new char[1024];
			//��ȡ�ļ����ݲ�д��ָ���ļ�
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
