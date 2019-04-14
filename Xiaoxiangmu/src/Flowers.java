import java.awt.CardLayout;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
public class Flowers extends JFrame {
	private JPanel p;
	// ������ǩ����
	private JLabel[] lbls;
	// ������Ƭ���ֹ�����
	private CardLayout cl;
	//����ͼ������
	private ImageIcon[] icon;
	public Flowers() {
		super("��������");
		// ʵ������Ƭ���ֹ���������
		cl=new CardLayout();
		p=new JPanel(cl);
		// ʵ������ǩ����ĳ���
		lbls=new JLabel[26];
		//ʵ����ͼ������ĳ���
		icon= new ImageIcon[26];
		// ѭ��ʵ���������е�ÿ����ǩ����ͼ�����
		for (int i = 0; i < lbls.length; i++) {
			icon[i]=new ImageIcon("images\\"+i+".jpg");
			//����ͼƬ��С
			icon[i].setImage(icon[i].getImage().getScaledInstance(540, 380,Image.SCALE_DEFAULT ));
			lbls[i] = new JLabel(icon[i]);
			lbls[i].setSize(540, 380);
		}
		// ѭ���������еı�ǩ��ӵ������
		for (int i = 0; i < lbls.length; i++) {
			p.add(lbls[i]);
		}
		// �������ӵ�������
		this.add(p);
		//��ʾ��һ��
		cl.first(p);
		//�����߳�
		Thread t=new Thread(new Runnable(){
			//��дrun()����
			public void run() {
				// TODO �Զ����ɵķ������
				while(true){
					//�л�����һ��
					cl.next(p);
					try{
						Thread.sleep(200);
					}catch(InterruptedException e){
						e.printStackTrace();
					}
				}
			}		
		});
		//�����߳�
		t.start();
		// �趨���ڴ�С
		this.setSize(540, 380);
		// �趨�������Ͻ�����
		this.setLocation(200, 100);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}	
	public static void main(String[] args) {
		new Flowers();
	}
}

