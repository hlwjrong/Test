import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.*;
import javax.swing.border.*;



public class Select  extends JFrame implements ActionListener{

	JMenuBar menuBar;
	JMenu menu,submenu;
	JMenuItem menuItem;
	JCheckBoxMenuItem cbMenuItem;
	JRadioButtonMenuItem rbMenuItem;
	
	public JTextField fromcity = null;
	public JTextField tocity = null ;
	public JTextField flightnum = null;
	public JComboBox fromtime = null;
	public JButton select1,select2;
	public CardLayout card = null; // CardLayout���ֹ�����
	public JPanel pane = null;// ��Ҫ��JPanel����JPanel�Ĳ��ֹ��������ó�CardLayout
	public JPanel panel,panel1;
	 
	public Select(){
		super("�û�");
		
		
		Container c = getContentPane();//����������

		 card = new CardLayout(5, 5);
	     pane = new JPanel(card); // JPanel�Ĳ��ֹ��������ó�CardLayout
		
		panel1 = new JPanel();
		//�����������Ϊ͸��
		panel1.setOpaque(false);
						
		panel1.setLayout(new GridLayout(4, 2, 0, 20));
		panel1.setBorder(new EmptyBorder(30, 30, 30, 30));
						
		JLabel Lflightnum = new JLabel("�����ţ�");
		Lflightnum.setFont(new Font("����",Font.BOLD, 18));
		flightnum = new JTextField(15);
		flightnum.setFont(new Font("����",Font.BOLD, 18));
		flightnum.setOpaque(false);
		flightnum.addActionListener(this);
		panel1.add(Lflightnum);
		panel1.add(flightnum);
				
		select1 = new JButton("����");
		select1.setFont(new Font("����",Font.BOLD, 18));
		select1.setContentAreaFilled(false);//���ð�ťΪ͸��ɫ
		select1.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent event){
				DisplayDemo display = new DisplayDemo("select * from Flight where fID='"+flightnum.getText()+"'");  
				display.setSize(1200,600);
				Dimension screen=Toolkit.getDefaultToolkit().getScreenSize();
				display.setVisible(true);
			}
		});

		panel1.add("Center", select1);
		panel1.setVisible(false);
		
		
		//�����������
		panel = new JPanel();
		//�����������Ϊ͸��
		panel.setOpaque(false);
		
		panel.setLayout(new GridLayout(4, 2, 0, 20));
		panel.setBorder(new EmptyBorder(30, 30, 30, 30));
		
		JLabel labelFrom = new JLabel("�������У�");
		labelFrom.setFont(new Font("����",Font.BOLD, 18));
		fromcity = new JTextField(15);
		fromcity.setFont(new Font("����",Font.BOLD, 18));
		fromcity.setOpaque(false);
		fromcity.addActionListener(this);
		panel.add(labelFrom);
		panel.add(fromcity);
		
		JLabel labelTo = new JLabel("������У�");
		labelTo.setFont(new Font("����",Font.BOLD, 18));
		tocity = new JTextField(15);
		tocity.setFont(new Font("����",Font.BOLD, 18));
		tocity.setOpaque(false);
		tocity.addActionListener(this);
		panel.add(labelTo);
		panel.add(tocity);
		
		JLabel labelfromTime = new JLabel("����ʱ�䣺");
		labelfromTime.setFont(new Font("����",Font.BOLD, 18));
		String[] date = {"2018/12/23", "2018/12/24", "2018/12/25", "2018/12/26",
						"2018/12/27", "2018/12/28", "2018/12/29", "2018/12/30"};
		fromtime = new JComboBox(date);
		fromtime.setFont(new Font("����",Font.BOLD, 18));
		fromtime.setOpaque(false);
		fromtime.addActionListener(this);
		panel.add(labelfromTime);
		panel.add(fromtime);
		
		select2 = new JButton("����");
		select2.setFont(new Font("����",Font.BOLD, 18));
		select2.setContentAreaFilled(false);//���ð�ťΪ͸��ɫ
		select2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				DisplayDemo display = new DisplayDemo("select * from Flight where fStart='"+fromcity.getText()+"' and fEnd = '"+tocity.getText()+"'  and fStartDate = '"+fromtime.getSelectedItem().toString()+"'");
				display.setSize(1200,600);
				Dimension screen=Toolkit.getDefaultToolkit().getScreenSize();
				//display.setLocation((screen.width-300)/2,(screen.height-220)/2 - 200);
				display.setVisible(true);
			}
		});
		panel.add("Center", select2);
		panel.setVisible(false);
		
		pane.add(panel);
		pane.add(panel1);
		
		c.add(pane);
	
		menuBar = new JMenuBar();//���ɲ˵���
		setJMenuBar(menuBar);
		menu = new JMenu("��ѯ");//������һ���˵�
		menu.setFont(new Font("����",Font.BOLD, 16));
		menu.setMnemonic(KeyEvent.VK_A);
		menuBar.add(menu);
		menuItem = new JMenuItem("���𽵵ز�ѯ");//�����˵���
		menuItem.setFont(new Font("����",Font.BOLD, 16));
		menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1,
								ActionEvent.ALT_MASK));
		menuItem.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				  panel1.setVisible(false);
				  panel.setVisible(true);
			}
		});
		menu.add(menuItem);
		
		menuItem = new JMenuItem("�������Ų�ѯ");//�����˵���
		menuItem.setFont(new Font("����",Font.BOLD, 16));
		menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_2,
								ActionEvent.ALT_MASK));
		menuItem.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				  panel.setVisible(false);
				  panel1.setVisible(true);
			}
		});
		menu.add(menuItem);
		menuBar.add(menu);
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(420, 320);
		setVisible(true);
		setResizable(false);
		//�����Ļ��С
		Dimension screen=Toolkit.getDefaultToolkit().getScreenSize();
		setLocation((screen.width-300)/2,(screen.height-220)/2 - 200);
	}
	
	public void actionPerformed(ActionEvent e){
		if (e.getActionCommand().equals(select1)){
			if (flightnum.getText() == ""){
				JOptionPane.showConfirmDialog(null, "�����Ų���Ϊ�գ�", "��ʾ", JOptionPane.OK_OPTION);
				return;
			}
		}
		if (e.getActionCommand().equals(select2)){
			if (fromcity.getText() == "" || tocity.getText() == ""){
				JOptionPane.showConfirmDialog(null, "��ʼ����Ŀ�ĵز���Ϊ�գ�", "��ʾ", JOptionPane.OK_OPTION);
				return;
			}
			
			else if (fromcity.getText() == tocity.getText()){
				JOptionPane.showConfirmDialog(null, "��ʼ����Ŀ�ĵز�����ͬ��", "��ʾ", JOptionPane.OK_OPTION);
				return;
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		new Select();
		
	}

}


