import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * 使用装饰者模式构造缓冲字符输入流
 * @author Administrator
 *
 */
class MyBufferedReader{
		private FileReader fr;
		public MyBufferedReader(FileReader fr){
			this.fr = fr;
		}
		
		public String readLine() throws IOException{
			StringBuilder sb = new StringBuilder();
			int ch = 0;
			while((ch = fr.read())!=-1){
				if(ch=='\r')
					continue;
				if(ch=='\n')
					return sb.toString();
				else sb.append((char)ch);
			}
			if(sb.length()!=0){
				return sb.toString();
			}
			return null;
		}
		
		public void close() throws IOException{
			if(fr!=null){
				fr.close();
			}
		}
	}
public class MyBufferedReaderDemo {
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FileReader fr = null;
		MyBufferedReader mbr = null;
		try {
			fr = new FileReader("deed.txt");
			mbr = new MyBufferedReader(fr);
			String str = "";
			while((str=mbr.readLine())!=null){
				System.out.println(str);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			if(mbr!=null){
				try {
					mbr.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}

}

