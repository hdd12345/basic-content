package iostream;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

public class PropertiesDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Properties pr = new Properties();
		BufferedReader br = null;
		FileWriter fw = null;
		try {
			br = new BufferedReader(new FileReader("src/iostream/my.properties"));
//			fw = new FileWriter("src/iostream/my.properties",true);
			pr.load(br);
//			pr.setProperty("����","������");
//			pr.store(fw,new Date().toString());
			System.out.println(pr.getProperty("����"));
			System.out.println(pr.getProperty("СҰ"));
			System.out.println(pr.getProperty("��ë��"));
			System.out.println(pr.getProperty("����"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			try {
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
