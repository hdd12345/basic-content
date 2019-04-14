package iostream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ObjectStreamDemo {

	public static void main(String[] args) throws FileNotFoundException, ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		//writeObject();
		readObject();
	}
	
	/**
	 * ��������л�����������Ϣ������Ӳ���ļ���
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 * @throws ClassNotFoundException 
	 */
	public static void writeObject() throws FileNotFoundException, IOException, ClassNotFoundException{
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("save.object"));
		oos.writeObject(new Person("����",20,"��"));
		oos.close();
	}
	
	/**
	 * ����ķ����л�����Ӳ���ļ��ж�ȡ����
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 * @throws ClassNotFoundException 
	 */
	public static void readObject() throws FileNotFoundException, IOException, ClassNotFoundException{
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("save.object"));
		Person person = (Person) ois.readObject();
		System.out.println(person);
		ois.close();
	}
}
