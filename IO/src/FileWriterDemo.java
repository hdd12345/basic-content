import java.io.FileWriter;
import java.io.IOException;

/**
 * FileWriter����
 * @author Administrator
 */
public class FileWriterDemo {

	public static void main(String[] args) throws IOException {
		//���ļ��Ѵ��ڣ��ᱻ����
		//FileWriter fw = new FileWriter("filewriter.txt");
		//���ļ��Ѵ��ڣ��������ļ������������ļ�ĩβ������д
		FileWriter fw = new FileWriter("filewriter.txt",true);
		fw.write("�����ó󰡣�");
		fw.write("!!");
		//flush()��������ˢ�������󻺳��е����ݣ�������ˢ��Ŀ���ļ���
		//fw.flush();
		//�ر��������ͷ���Դ���ڹر�ǰ��ˢ��һ�λ����еĶ���
		fw.close();
	}

}
