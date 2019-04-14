import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.Random;

import javax.swing.*;
public class VerificationCodeFrame extends JFrame {
	private JPanel p;
	private JLabel a1,a2,a3;
	private JTextField b;
	private JButton btn,btn2;
	
	
	static String str1=VerificationCodeFrame.getRandomString(6);
	
	public VerificationCodeFrame(){
		super("验证码");
		p=new JPanel(null);
		a1=new JLabel("验证码：");
		
		ImageIcon icon=new ImageIcon(VerificationCodeFrame.getCodeImage(str1));
		a2=new JLabel(icon);
		a3=new JLabel("请输入验证码：");
		b=new JTextField(20);
		btn=new JButton("确定");
		btn2=new JButton("换一张");
		btn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				String str2=b.getText();
				if(str1.equalsIgnoreCase(str2)){
					//System.out.println("验证码正确！");
					JOptionPane.showMessageDialog(null,"验证成功!","成功提示",JOptionPane.PLAIN_MESSAGE);
				}else{
					//System.out.println("验证码错误！");
					JOptionPane.showMessageDialog(null,"验证失败!","错误提示",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btn2.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				b.setText("");
				String str3=VerificationCodeFrame.getRandomString(6);
				ImageIcon icon1=new ImageIcon(VerificationCodeFrame.getCodeImage(str3));
				a2.setIcon(icon1);
				str1 = str3;								
			}
			
		});
		
		a1.setBounds(30, 30, 60, 25);
		a2.setBounds(90, 30, 120, 25);
		a3.setBounds(30, 60, 120, 25);
		b.setBounds(30, 90, 120, 25);
		btn.setBounds(30, 120, 80, 25);
		btn2.setBounds(120, 120, 80, 25);
		
		p.add(a1);
		p.add(a2);
		p.add(a3);
		p.add(b);
		p.add(btn);
		p.add(btn2);
		this.add(p);
		this.setSize(280,250);
		this.setLocation(200, 100);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	//随机生成验证码的方法
	public static String getRandomString(int length) {   
	    String base = "abcdefghijklmnopqrstuvwxyzABCDEFGH"
	    		+ "IJKLMNOPQRSTUVWXYZ01234567890";
	    Random random = new Random();     
	    StringBuffer sb = new StringBuffer();     
	    for (int i = 0; i < length; i++) {     
	        int number = random.nextInt(base.length());
	        //charAt(int index)返回指定位置的字符
	        sb.append(base.charAt(number));     
	    }     
	    return sb.toString();     
	 }
	
	//画图片
	public static Image getCodeImage(String str){
		int width=100;
		int height=30;
		//创建一个图片缓冲区，即画板
		BufferedImage bf=new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
		//创建绘制工具
		Graphics gs=bf.createGraphics();
		//绘制矩形
		gs.setColor(VerificationCodeFrame.getRandomColor(128,255));
		gs.fill3DRect(0, 0, width, height,true);
		
		//绘制文字
		Font font=new Font("宋体",Font.BOLD,18);
		gs.setFont(font);
		gs.setColor(VerificationCodeFrame.getRandomColor(0,127));
		gs.drawString(str,20,22);
		
		//绘制干扰点
		double rate=0.05;
		Random random=new Random();
		for(int i=1;i<=rate*width*height;i++){
			int x=random.nextInt(width);
			int y=random.nextInt(height);
			bf.setRGB(x, y, random.nextInt(255));
		}
		
		//绘制线条
		for(int i=1;i<=6;i++){
			gs.setColor(VerificationCodeFrame.getRandomColor(0,255));
			int x1=random.nextInt(width);
			int y1=random.nextInt(height);
			int x2=random.nextInt(width);
			int y2=random.nextInt(height);
			gs.drawLine(x1, y1, x2, y2);
		}
		return bf;
	}
	
	//随机颜色的方法，参数为rgb参数的取值范围
	public static Color getRandomColor(int from,int to){
		Random random=new Random();
		int r=random.nextInt(to-from)+from;
		int g=random.nextInt(to-from)+from;
		int b=random.nextInt(to-from)+from;
		return new Color(r,g,b);
	}
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		new VerificationCodeFrame();
	}

}
