import java.io.FileWriter;
import java.io.IOException;

/**
 * FileWriter测试
 * @author Administrator
 */
public class FileWriterDemo {

	public static void main(String[] args) throws IOException {
		//若文件已存在，会被覆盖
		//FileWriter fw = new FileWriter("filewriter.txt");
		//若文件已存在，不覆盖文件，并在已有文件末尾进行续写
		FileWriter fw = new FileWriter("filewriter.txt",true);
		fw.write("老梁好丑啊！");
		fw.write("!!");
		//flush()方法用于刷新流对象缓冲中的数据，将数据刷到目标文件中
		//fw.flush();
		//关闭流对象，释放资源，在关闭前会刷新一次缓冲中的对象
		fw.close();
	}

}
