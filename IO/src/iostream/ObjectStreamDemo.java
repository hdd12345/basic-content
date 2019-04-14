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
	 * 对象的序列化，将对象信息保存在硬盘文件中
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 * @throws ClassNotFoundException 
	 */
	public static void writeObject() throws FileNotFoundException, IOException, ClassNotFoundException{
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("save.object"));
		oos.writeObject(new Person("老梁",20,"男"));
		oos.close();
	}
	
	/**
	 * 对象的反序列化，从硬盘文件中读取对象
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
