import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

/**
 * LineNumberReader:�����ַ��������������к�(�������úͻ�ȡ��ǰ�к�)
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
