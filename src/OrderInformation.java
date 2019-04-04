import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class OrderInformation  extends JFrame implements ActionListener{

	public JLabel pname;//�û�����
	public JLabel pid;//�û����֤����
	public JLabel fid;//������
	public JLabel sid;//��λ��
	public JLabel fromcity;//��������
	public JLabel tocity; //�������
	public JLabel fromtime;//����ʱ��
	public JLabel fromdate; //��������
	public JLabel slevel;//��λ�ȼ�
	public JLabel price;//�۸�
	
	public JButton ok;
	public JButton cancel;
	public OrderInformation(String pname1, String pid1, String fid1, String sid1, String fromcity1, 
				String tocity1, String fromtime1,String fromdate1, String slevel1,  String price1){
		
		super("������Ϣ");
		
		//��ӱ���ͼƬ
		ImageIcon image = new ImageIcon("1.jpg");
		JLabel logolabel = new JLabel(image);
		//���ñ�ǩ��λ�ôӣ�0,0���㿪ʼ��������������
		logolabel.setBounds(0, 0, image.getIconWidth(), image.getIconHeight());
		//���ö�����壬��������ǩ��ӵ����ڵĶ�����壨LayeredPane����
		this.getLayeredPane().add(logolabel, new Integer(Integer.MIN_VALUE));
		//�����������
		JPanel panel1 = (JPanel)this.getContentPane();
		//�����������Ϊ͸��
		panel1.setOpaque(false);
		
		panel1.setLayout(new GridLayout(12, 2, 0, 20));
		panel1.setBorder(new EmptyBorder(10, 10, 10, 10));//�ֱ��Ӧ�ϡ����¡���
		JLabel labelName = new JLabel("������");
		labelName.setFont(new Font("����",Font.BOLD, 20));
		pname = new JLabel(pname1);
		pname.setFont(new Font("����",Font.BOLD, 20));
		//pname.addActionListener(this);
		//���������Ϊ͸��
		pname.setOpaque(false);
		panel1.add(labelName);
		panel1.add(pname);
		
		JLabel labelPassword = new JLabel("���֤�ţ�");
		labelPassword.setFont(new Font("����",Font.BOLD, 20));
		pid = new JLabel(pid1);
		pid.setFont(new Font("����",Font.BOLD, 20));
		//���������Ϊ͸��
		pid.setOpaque(false);
		//pid.addActionListener(this);
		panel1.add(labelPassword);
		panel1.add(pid);
		
		JLabel labelPasswordCheck = new JLabel("�����ţ�");
		labelPasswordCheck.setFont(new Font("����",Font.BOLD, 20));
		fid = new JLabel(fid1);
		fid.setFont(new Font("����",Font.BOLD, 20));
		//���������Ϊ͸��
		fid.setOpaque(false);
		panel1.add(labelPasswordCheck);
		panel1.add(fid);
		
		JLabel labelPName = new JLabel("��λ�ţ�");
		labelPName.setFont(new Font("����",Font.BOLD, 20));
		sid = new JLabel(sid1);
		sid.setFont(new Font("����",Font.BOLD, 20));
		//���������Ϊ͸��
		sid.setOpaque(false);
		panel1.add(labelPName);
		panel1.add(sid);
		
		JLabel labelInterge = new JLabel("�������У�");
		labelInterge.setFont(new Font("����",Font.BOLD, 20));
		fromcity = new JLabel(fromcity1);
		fromcity.setFont(new Font("����",Font.BOLD, 18));
		fromcity.setOpaque(false);
		panel1.add(labelInterge);
		panel1.add(fromcity);
		
		
		JLabel labeltocity = new JLabel("������У�");
		labeltocity.setFont(new Font("����",Font.BOLD, 20));
		tocity = new JLabel(tocity1);
		tocity.setFont(new Font("����",Font.BOLD, 18));
		tocity.setOpaque(false);
		panel1.add(labeltocity);
		panel1.add(tocity);
		
		JLabel labelftime = new JLabel("����ʱ�䣺");
		labelftime.setFont(new Font("����",Font.BOLD, 20));
		fromtime = new JLabel(fromtime1);
		fromtime.setFont(new Font("����",Font.BOLD, 18));
		fromtime.setOpaque(false);
		panel1.add(labelftime);
		panel1.add(fromtime);
		
		
		JLabel labelfdate = new JLabel("�������ڣ�");
		labelfdate.setFont(new Font("����",Font.BOLD, 20));
		fromdate = new JLabel(fromdate1);
		fromdate.setFont(new Font("����",Font.BOLD, 18));
		fromdate.setOpaque(false);
		panel1.add(labelfdate);
		panel1.add(fromdate);
		
		
		JLabel labelPid = new JLabel("��λ�ȼ���");
		labelPid.setFont(new Font("����",Font.BOLD, 20));
		slevel = new JLabel(slevel1);
		slevel.setFont(new Font("����",Font.BOLD, 20));
		//���������Ϊ͸��
		slevel.setOpaque(false);
		panel1.add(labelPid);
		panel1.add(slevel);
		
		JLabel labelTnumber = new JLabel("�۸�");
		labelTnumber.setFont(new Font("����",Font.BOLD, 20));
		price = new JLabel(price1);
		price.setFont(new Font("����",Font.BOLD, 20));
		//���������Ϊ͸��
		price.setOpaque(false);
		panel1.add(labelTnumber);
		panel1.add(price);
		
		ok = new JButton("ȷ��");
		ok.setFont(new Font("����",Font.BOLD, 20));
		ok.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				  
			}
		});
		//���ð�ťΪ͸��ɫ
		ok.setContentAreaFilled(false);
		panel1.add(ok);
		
		cancel = new JButton("ȡ��");
		cancel.setFont(new Font("����",Font.BOLD, 20));
		//���ð�ťΪ͸��ɫ
		cancel.setContentAreaFilled(false);
		cancel.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				System.exit(0);
			}
		});
		panel1.add(cancel);
		
	}
	
	public void actionPerformed(ActionEvent e){
	
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		OrderInformation frame = new OrderInformation("","","","","","","","","","");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setSize(500, 560);
		frame.setVisible(true);
		frame.setResizable(false);
		//�����Ļ��С
		Dimension screen=Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation((screen.width-300)/2,(screen.height-220)/2 - 200);
	}

}
