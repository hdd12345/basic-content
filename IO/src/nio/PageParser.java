package nio;
import java.io.BufferedReader;  
import java.io.IOException;  
import java.io.InputStreamReader;  
import java.net.URL;  
import java.nio.CharBuffer;  
  
public class PageParser {  
  
    public static void main(String args[]) {  
    	long start = System.currentTimeMillis();
        BufferedReader in = null;  
        try {  
            in = new BufferedReader(new InputStreamReader(new URL(  
                    "http://finance.people.com.cn/n1/2018/0808/c1004-30215060.html").openStream(),  
                    "GBK"));  
        } catch (Exception e2) {  
            e2.printStackTrace();  
        }  
        CharBuffer bos = CharBuffer.allocate(20480);  
        int read = 0;  
        StringBuilder sb = new StringBuilder();  
        try {  
            while (in.read(bos) != -1) {  
                bos.flip();  
                sb.append(bos.toString());  
            }  
        } catch (IOException e1) {  
            e1.printStackTrace();  
        }  
        long end = System.currentTimeMillis();
        System.out.println(end-start);
        System.out.println(sb.toString());  
    }  
}  