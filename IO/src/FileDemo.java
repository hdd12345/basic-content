import java.io.File;
import java.io.IOException;

public class FileDemo {

	public static void main(String[] args)  throws IOException {
		// TODO Auto-generated method stub
		File file = new File("deed.txt");
		//根据file对象来创建文件(文件不存在时创建文件并返回true，文件已存在时返回false)
		System.out.println(file.createNewFile());
		//file.mkdir();
		//判断文件是否存在
		System.out.println("文件是否存在："+file.exists());
		//判断文件是否可写
		System.out.println("是否可写："+file.canWrite());
		//判断文件是否可读
		System.out.println("是否可读："+file.canRead());
		//判断File对象是否为一个目录
		System.out.println(file.isDirectory());
		//判断File对象是否为一个文件
		System.out.println(file.isFile());
		//判断File对象是否采用绝对路径
		System.out.println(file.isAbsolute());
		//返回文件名
		System.out.println(file.getName());
		//返回路径名
		System.out.println("路径名："+file.getPath());
		//返回绝对路径名
		System.out.println("绝对路径名："+ file.getAbsolutePath());
		//返回上一级路径
		System.out.println("上一级路径："+file.getAbsoluteFile().getParent());
		//文件长度（以字节为单位）
		System.out.println("文件长度："+file.length());
		//所有子文件名和路径名
		String[] list = new File(".").list();
		System.out.println("所有子文件名和路径名：");
		for(String str:list){
			System.out.println(str);
		}
		//所有子文件和路径
		File[] fileList = new File("C:").listFiles();
		System.out.println("所有子文件和路径：");
		for(File a:fileList){
			System.out.println(a);
		}
		//列出系统所有根路径
		File[] roots = File.listRoots();
		System.out.println("当前系统所有根路径：");
		for(File root:roots){
			System.out.println(root);
		}
	}

}
