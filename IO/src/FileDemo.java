import java.io.File;
import java.io.IOException;

public class FileDemo {

	public static void main(String[] args)  throws IOException {
		// TODO Auto-generated method stub
		File file = new File("deed.txt");
		//����file�����������ļ�(�ļ�������ʱ�����ļ�������true���ļ��Ѵ���ʱ����false)
		System.out.println(file.createNewFile());
		//file.mkdir();
		//�ж��ļ��Ƿ����
		System.out.println("�ļ��Ƿ���ڣ�"+file.exists());
		//�ж��ļ��Ƿ��д
		System.out.println("�Ƿ��д��"+file.canWrite());
		//�ж��ļ��Ƿ�ɶ�
		System.out.println("�Ƿ�ɶ���"+file.canRead());
		//�ж�File�����Ƿ�Ϊһ��Ŀ¼
		System.out.println(file.isDirectory());
		//�ж�File�����Ƿ�Ϊһ���ļ�
		System.out.println(file.isFile());
		//�ж�File�����Ƿ���þ���·��
		System.out.println(file.isAbsolute());
		//�����ļ���
		System.out.println(file.getName());
		//����·����
		System.out.println("·������"+file.getPath());
		//���ؾ���·����
		System.out.println("����·������"+ file.getAbsolutePath());
		//������һ��·��
		System.out.println("��һ��·����"+file.getAbsoluteFile().getParent());
		//�ļ����ȣ����ֽ�Ϊ��λ��
		System.out.println("�ļ����ȣ�"+file.length());
		//�������ļ�����·����
		String[] list = new File(".").list();
		System.out.println("�������ļ�����·������");
		for(String str:list){
			System.out.println(str);
		}
		//�������ļ���·��
		File[] fileList = new File("C:").listFiles();
		System.out.println("�������ļ���·����");
		for(File a:fileList){
			System.out.println(a);
		}
		//�г�ϵͳ���и�·��
		File[] roots = File.listRoots();
		System.out.println("��ǰϵͳ���и�·����");
		for(File root:roots){
			System.out.println(root);
		}
	}

}
