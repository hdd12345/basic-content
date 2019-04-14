package nio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;

public class PageParserDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long start = System.currentTimeMillis();
		BufferedReader in = null;  
		try {
			in = new BufferedReader(new InputStreamReader(new URL(  
			        "https://www.lunwendata.com/6674.html").openStream(),  
			        "GBK"));
			String str = null;
			while((str=in.readLine())!=null){
				System.out.println(str);
			}
			long end = System.currentTimeMillis();
			System.out.println(end-start);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
	}

}
