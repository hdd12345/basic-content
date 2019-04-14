package iostream;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
/**
 * 字节数组流：使用流的读写思想来操作数组
 * @author Administrator
 *
 */
public class ByteArrayDemo {

	public static void main(String[] args) {
		//构造方法参数为数据源
		ByteArrayInputStream bis = new ByteArrayInputStream("嗨！你好".getBytes());
		//内部存在一个自动扩容的字节数组，该数组为数据写入的目的地，writeTo方法可将数据通过其他流来写入其他目的地
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		int num = 0;
		while((num=bis.read())!=-1){
			bos.write(num);
		}
		System.out.println(bos.toString());
	}

}
