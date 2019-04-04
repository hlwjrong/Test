
import java.applet.*;
import java.sql.*;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class UserLogin extends JFrame implements ActionListener{

	private JTextField textName;
	private JPasswordField textPassword;
	private JButton ok,login;
	ButtonGroup buttongroup = new ButtonGroup();
	JRadioButton manager = new JRadioButton("����Ա");
	JRadioButton user = new JRadioButton("�û�");
	public UserLogin(){
		
		super("��¼");
		
		//���ñ���ͼƬ
		ImageIcon image = new ImageIcon("2.jpg");
		JLabel logolabel = new JLabel(image);
		//���ñ�ǩ��λ�ôӣ�0,0���㿪ʼ��������������
		logolabel.setBounds(0, 0, image.getIconWidth(), image.getIconHeight());
		//���ö�����壬��������ǩ��ӵ����ڵĶ�����壨LayeredPane����
		this.getLayeredPane().add(logolabel, new Integer(Integer.MIN_VALUE));
		//�����������
		JPanel panel = (JPanel)this.getContentPane();
		//�����������Ϊ͸��
		panel.setOpaque(false);
	
		//����Ű�Ϊ��������
		panel.setLayout(new GridLayout(4, 2, 0, 20));
		//��߿�ľ��룬�ֱ��Ӧ�ϡ����¡���
		panel.setBorder(new EmptyBorder(30, 30, 30, 30));
		
		JLabel labelName = new JLabel("�û�����");
		labelName.setFont(new Font("����",Font.BOLD, 20));
		textName = new JTextField(15);
		textName.addActionListener(this);
		textName.setFont(new Font("����",Font.BOLD, 20));
		//���������Ϊ͸��
		textName.setOpaque(false);
		panel.add(labelName);
		panel.add(textName);
		
		JLabel labelPassword = new JLabel("���룺");
		labelPassword.setFont(new Font("����",Font.BOLD, 20));
		textPassword = new JPasswordField(15);
		textPassword.setFont(new Font("����",Font.BOLD, 20));
		textPassword.setEchoChar('*');//���û����ַ�
		//���������Ϊ͸��
		textPassword.setOpaque(false);
		textPassword.addActionListener(this);
		panel.add(labelPassword);
		panel.add(textPassword);
		
		panel.add(manager);
		panel.add(user);
		manager.setFont(new Font("����",Font.BOLD, 18));
		manager.setOpaque(false);
		user.setFont(new Font("����",Font.BOLD, 18));
		user.setOpaque(false);
		buttongroup.add(manager);
		buttongroup.add(user);
		
		ok = new JButton("��¼");
		ok.setFont(new Font("����",Font.BOLD, 20));
		ok.setContentAreaFilled(false);//���ð�ťΪ͸��ɫ
		ok.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				if(validate(textName.getText(), textPassword.getText()) && user.isSelected() ){
					Select select = new Select();
					select.setSize(420, 320);
					Dimension screen=Toolkit.getDefaultToolkit().getScreenSize();
					select.setLocation((screen.width-300)/2,(screen.height-220)/2 - 200);
					select.setVisible(true);
					login.setEnabled(false);
				}
				
				if(validate(textName.getText(), textPassword.getText()) && manager.isSelected() ){
					addInformation select = new addInformation();
					select.setSize(500, 640);
					Dimension screen=Toolkit.getDefaultToolkit().getScreenSize();
					select.setLocation((screen.width-300)/2,(screen.height-220)/2 - 200);
					select.setVisible(true);
				}
				
				if (!validate(textName.getText(), textPassword.getText())){
					JOptionPane.showConfirmDialog(null, "�˺Ż��������", "��ʾ", JOptionPane.YES_NO_OPTION);
					
				}
			}
		});
		panel.add(ok);
		
		login = new JButton("ע��");
		login.setContentAreaFilled(false);//���ð�ťΪ͸��ɫ
		login.setFont(new Font("����",Font.BOLD, 20));
		
		//���ü����¼������û�û��ע����˺�ʱ�����ע�ᰴť������ע�ᴰ��
		login.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				if(!validate(textName.getText(), textPassword.getText()) && user.isSelected() ){
					Register frame2 = new Register();
					frame2.setSize(500, 560);
					Dimension screen=Toolkit.getDefaultToolkit().getScreenSize();
					frame2.setLocation((screen.width-300)/2,(screen.height-220)/2 - 200);
					frame2.setVisible(true);
				}
			}
		});
		
		panel.add(login);
	}
	
	
	public void actionPerformed(ActionEvent e){
		String n = textName.getText();
		char[] s = textPassword.getPassword();
		String p = new String(s);
		if (e.getSource() == textName){
			textPassword.grabFocus();//�����ý���
		}
		
	}
    
    //�ж����ݿ����Ƿ��и��û���������  
    private boolean validate(String testname, String cs)  
    {  
    	String sql;
    	if (user.isSelected())
    		sql="select * from Passenger where pID = '"+testname+"' and pPassword = '"+cs+"'" ;  
    	else
    		sql="select * from Administrator where AdminID = '"+testname+"' and AdminPassword = '"+cs+"'" ;  
    	try{//�����ѯ��ResultSet���г���һ���ļ�¼�����¼�ɹ� 
    		//�ҵ����ݿ������Ϣ
    		String driverName="com.microsoft.sqlserver.jdbc.SQLServerDriver";
    		String dbURL="jdbc:sqlserver://127.0.0.1:1433;DatabaseName=ATS";
    		String userName="sa";
    		String userPwd="123";
    		//��������
			Class.forName(driverName);
			//��ȡ����
			Connection con = DriverManager.getConnection(dbURL, userName, userPwd);
			
			//��ȡPreparedStatement����
			PreparedStatement ps = con.prepareStatement(sql);
			//ִ�в�ѯ
			ResultSet rs = ps.executeQuery();

	        if (rs.next())  
	         {  
	               return true;  
	         }   
	    }  
        catch(Exception e)  
        {  
            e.printStackTrace();  
        }  
        return false;  
    }  
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UserLogin  frame = new UserLogin();
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setSize(400, 280);
		frame.setVisible(true);
		frame.setResizable(false);
		//�����Ļ��С
		Dimension screen=Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation((screen.width-300)/2,(screen.height-220)/2 - 200);
	}

}
//���ܣ����û�������Ա�����ҵ��ѱ�����˺ź�����