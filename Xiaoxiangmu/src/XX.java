import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.*;
public class XX extends JFrame {
	private JPanel p;
	private JLabel a1,a2,a3;
	private JTextField b;
	private JButton btn,btn2;
	
	public static String getRandomString(int length) {   
	    String base = "abcdefghijklmnopqrstuvwxyzABCDEFGH"
	    		+ "IJKLMNOPQRSTUVWXYZ0123456789";     
	    Random random = new Random();     
	    StringBuffer sb = new StringBuffer();     
	    for (int i = 0; i < length; i++) {     
	        int number = random.nextInt(base.length());
	        //charAt(int index)返回指定位置的字符
	        //append(String s)结尾插入
	        sb.append(base.charAt(number));     
	    }     
	    return sb.toString();     
	 }
	String str1=XX.getRandomString(6);
	
	public XX(){
		super("验证码");
		p=new JPanel(null);
		a1=new JLabel("验证码：");
		a2=new JLabel(str1);
		a3=new JLabel("请输入验证码：");
		b=new JTextField(20);
		btn=new JButton("确定");
		btn2=new JButton("刷新");
		btn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				String str2=b.getText();
				if(str1.equalsIgnoreCase(str2)){
					//System.out.println("验证码正确！");
					JOptionPane.showMessageDialog(null,"验证码正确!","成功提示",JOptionPane.PLAIN_MESSAGE);
				}else{
					//System.out.println("验证码错误！");
					JOptionPane.showMessageDialog(null,"验证码错误!","错误提示",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btn2.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				b.setText("");
				String str3=XX.getRandomString(6);
				a2.setText(str3);
				str1 = str3;								
			}
			
		});
		
		a1.setBounds(30, 30, 60, 25);
		a2.setBounds(90, 30, 120, 25);
		a3.setBounds(30, 60, 120, 25);
		b.setBounds(30, 90, 120, 25);
		btn.setBounds(30, 120, 60, 25);
		btn2.setBounds(100, 120, 60, 25);
		
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

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		new XX();
	}

}
