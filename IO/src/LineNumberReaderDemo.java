import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

/**
 * LineNumberReader:缓冲字符输入流，跟踪行号(可以设置和获取当前行号)
 * @author Administrator
 *
 */
public class LineNumberReaderDemo {

	public static void main(String[] args) {
		LineNumberReader  lnb = null;
		try {
			FileReader fr = new FileReader("deed.txt");
			lnb = new LineNumberReader(fr);
			String str = "";
			while((str=lnb.readLine())!=null){
				System.out.print(str);
				if(lnb.getLineNumber()==1){
					lnb.setLineNumber(3);
				}
				System.out.println(lnb.getLineNumber());
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
