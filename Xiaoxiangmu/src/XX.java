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
	        //charAt(int index)����ָ��λ�õ��ַ�
	        //append(String s)��β����
	        sb.append(base.charAt(number));     
	    }     
	    return sb.toString();     
	 }
	String str1=XX.getRandomString(6);
	
	public XX(){
		super("��֤��");
		p=new JPanel(null);
		a1=new JLabel("��֤�룺");
		a2=new JLabel(str1);
		a3=new JLabel("��������֤�룺");
		b=new JTextField(20);
		btn=new JButton("ȷ��");
		btn2=new JButton("ˢ��");
		btn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				// TODO �Զ����ɵķ������
				String str2=b.getText();
				if(str1.equalsIgnoreCase(str2)){
					//System.out.println("��֤����ȷ��");
					JOptionPane.showMessageDialog(null,"��֤����ȷ!","�ɹ���ʾ",JOptionPane.PLAIN_MESSAGE);
				}else{
					//System.out.println("��֤�����");
					JOptionPane.showMessageDialog(null,"��֤�����!","������ʾ",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btn2.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO �Զ����ɵķ������
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
		// TODO �Զ����ɵķ������
		new XX();
	}

}
