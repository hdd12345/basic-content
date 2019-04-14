import java.awt.CardLayout;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
public class Flowers extends JFrame {
	private JPanel p;
	// 声明标签数组
	private JLabel[] lbls;
	// 声明卡片布局管理器
	private CardLayout cl;
	//声明图标数组
	private ImageIcon[] icon;
	public Flowers() {
		super("花开过程");
		// 实例化卡片布局管理器对象
		cl=new CardLayout();
		p=new JPanel(cl);
		// 实例化标签数组的长度
		lbls=new JLabel[26];
		//实例化图标数组的长度
		icon= new ImageIcon[26];
		// 循环实例化数组中的每个标签对象及图标对象
		for (int i = 0; i < lbls.length; i++) {
			icon[i]=new ImageIcon("images\\"+i+".jpg");
			//设置图片大小
			icon[i].setImage(icon[i].getImage().getScaledInstance(540, 380,Image.SCALE_DEFAULT ));
			lbls[i] = new JLabel(icon[i]);
			lbls[i].setSize(540, 380);
		}
		// 循环将数组中的标签添加到面板中
		for (int i = 0; i < lbls.length; i++) {
			p.add(lbls[i]);
		}
		// 将面板添加到窗体中
		this.add(p);
		//显示第一张
		cl.first(p);
		//创建线程
		Thread t=new Thread(new Runnable(){
			//重写run()方法
			public void run() {
				// TODO 自动生成的方法存根
				while(true){
					//切换到下一张
					cl.next(p);
					try{
						Thread.sleep(200);
					}catch(InterruptedException e){
						e.printStackTrace();
					}
				}
			}		
		});
		//启动线程
		t.start();
		// 设定窗口大小
		this.setSize(540, 380);
		// 设定窗口左上角坐标
		this.setLocation(200, 100);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}	
	public static void main(String[] args) {
		new Flowers();
	}
}

