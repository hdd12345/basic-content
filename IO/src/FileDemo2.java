import java.io.File;

public class FileDemo2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		showList(new File("C:"),0);
	}
	
	//列出C盘所有目录和文件
	public static void showList(File file,int count){
		File[] fileList = file.listFiles();
		if(fileList!=null){
			count++;
			System.out.println("----------"+file.getPath()+"---------");
			for(File f:fileList){
				System.out.println(getBlank(count)+f);
				showList(f,count);
			}
		}
	}
	
	public static String getBlank(int count){
		StringBuilder sb = new StringBuilder("");
		for(int i=0;i<count;i++){
			sb.append("   ");
		}
		return sb.toString();
	}
}
