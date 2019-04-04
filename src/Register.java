
import java.applet.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.sql.*;

public class Register extends JFrame implements ActionListener{

	private JTextField testName;//�û���
	private JPasswordField testPassword;//�û�����
	private JTextField testCheck;//
	private JPasswordField PasswordCheck;//ȷ������
	private JTextField testPname;//�û�����
	private JTextField testPid;//�û����֤��
	private JTextField testTnumber;//�û��绰����
	private JComboBox sex; //�û��Ա�
	private JButton ok;
	private JButton cancel;
	public Register(){
		
		super("�û�ע��");
		
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
		
		panel1.setLayout(new GridLayout(8, 2, 0, 20));
		panel1.setBorder(new EmptyBorder(50, 30, 50, 30));//�ֱ��Ӧ�ϡ����¡���
		JLabel labelName = new JLabel("�û�����");
		labelName.setFont(new Font("����",Font.BOLD, 20));
		testName = new JTextField(20);
		testName.setFont(new Font("����",Font.BOLD, 20));
		testName.addActionListener(this);
		//���������Ϊ͸��
		testName.setOpaque(false);
		panel1.add(labelName);
		panel1.add(testName);
		
		JLabel labelPassword = new JLabel("���룺");
		labelPassword.setFont(new Font("����",Font.BOLD, 20));
		testPassword = new JPasswordField(20);
		testPassword.setFont(new Font("����",Font.BOLD, 20));
		testPassword.setEchoChar('*');//���û����ַ�
		//���������Ϊ͸��
		testPassword.setOpaque(false);
		testPassword.addActionListener(this);
		panel1.add(labelPassword);
		panel1.add(testPassword);
		
		JLabel labelPasswordCheck = new JLabel("ȷ�����룺");
		labelPasswordCheck.setFont(new Font("����",Font.BOLD, 20));
		PasswordCheck = new JPasswordField(20);
		PasswordCheck.setFont(new Font("����",Font.BOLD, 20));
		PasswordCheck.setEchoChar('*');//���û����ַ�
		//���������Ϊ͸��
		PasswordCheck.setOpaque(false);
		PasswordCheck.addActionListener(this);
		panel1.add(labelPasswordCheck);
		panel1.add(PasswordCheck);
		
		JLabel labelPName = new JLabel("������");
		labelPName.setFont(new Font("����",Font.BOLD, 20));
		testPname = new JTextField(15);
		testPname.setFont(new Font("����",Font.BOLD, 20));
		//���������Ϊ͸��
		testPname.setOpaque(false);
		testPname.addActionListener(this);
		panel1.add(labelPName);
		panel1.add(testPname);
		
		JLabel labelPid = new JLabel("���֤�ţ�");
		labelPid.setFont(new Font("����",Font.BOLD, 20));
		testPid = new JTextField(15);
		testPid.setFont(new Font("����",Font.BOLD, 20));
		//���������Ϊ͸��
		testPid.setOpaque(false);
		testPid.addActionListener(this);
		panel1.add(labelPid);
		panel1.add(testPid);
		
		JLabel labelTnumber = new JLabel("�绰���룺");
		labelTnumber.setFont(new Font("����",Font.BOLD, 20));
		testTnumber = new JTextField(15);
		testTnumber.setFont(new Font("����",Font.BOLD, 20));
		//���������Ϊ͸��
		testTnumber.setOpaque(false);
		testTnumber.addActionListener(this);
		panel1.add(labelTnumber);
		panel1.add(testTnumber);
		
		JLabel labelInterge = new JLabel("�Ա�");
		labelInterge.setFont(new Font("����",Font.BOLD, 20));
		String[] sexs = {"��", "Ů"};
		sex = new JComboBox(sexs);
		sex.setFont(new Font("����",Font.BOLD, 18));
		sex.setOpaque(false);
		panel1.add(labelInterge);
		panel1.add(sex);
		
		
		
		ok = new JButton("ע��");
		ok.setFont(new Font("����",Font.BOLD, 20));
		ok.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				  try {  
		                cheak();   
		               
		            } catch (Exception e1) {  
		                // TODO Auto-generated catch block  
		                e1.printStackTrace();  
		            }  
			}
		});
		//���ð�ťΪ͸��ɫ
		ok.setContentAreaFilled(false);
		panel1.add(ok);
		
		cancel = new JButton("ȥ��¼");
		cancel.setFont(new Font("����",Font.BOLD, 20));
		//���ð�ťΪ͸��ɫ
		cancel.setContentAreaFilled(false);
		cancel.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				UserLogin select = new UserLogin();
				select.setSize(400, 280);
				Dimension screen=Toolkit.getDefaultToolkit().getScreenSize();
				select.setLocation((screen.width-300)/2,(screen.height-220)/2 - 200);
				select.setVisible(true);
			}
		});
		panel1.add(cancel);
		
	}
	
	public void actionPerformed(ActionEvent e){
		
		
    	String testname = testName.getText();//�û���
		String password = testPassword.getText();//�û�����
		String passwordcheck = PasswordCheck.getText();//ȷ������
		String testpname = testPname.getText();//�û�����
		String testpid = testPid.getText();//�û����֤��
		String testnumber = testTnumber.getText();//�û��ֻ���
		
		if (!passwordcheck.equals(password)){
			JOptionPane.showConfirmDialog(null, "���벻һ�£����������룡", "��ʾ", JOptionPane.WARNING_MESSAGE);
			return;
		}
		
		if(testname == "" || password == "" || passwordcheck == "" || 
				testpname == ""|| testpid == "" || testnumber == "" ){
			JOptionPane.showConfirmDialog(null, "����������������Ϣ��", "��ʾ", JOptionPane.YES_NO_OPTION);
			return;
		}
		
		if(password.length()  >16 || password.length() < 2){
			JOptionPane.showConfirmDialog(null, "���볤��Ӧ��2-16֮�䣡", "��ʾ", JOptionPane.YES_NO_OPTION);
		}
		
		if(testpid.length() != 18 ){
			JOptionPane.showConfirmDialog(null, "���֤����ӦΪ18λ��", "��ʾ", JOptionPane.YES_NO_OPTION);
			return;
		}
	}

	
	   //ע���û������� ��1�������ȼ�����ݿ����Ƿ�����Ӧ�����ݣ�����еĻ���ʾ"���û����ڣ���ֱ�ӵ�¼��"  
    private void cheak() throws Exception  
    {         	    	
		if (validate(testName.getText()))  
		{  
			JOptionPane.showConfirmDialog(null, "�˺��Ѵ��ڣ�", "��ʾ", JOptionPane.YES_NO_OPTION);
		}  
		else  
		{  
			String sql="insert into Passenger values(?,?,?,?,?,?)";  
			//�ҵ����ݿ������Ϣ
			String driverName="com.microsoft.sqlserver.jdbc.SQLServerDriver";
			String dbURL="jdbc:sqlserver://127.0.0.1:1433;DatabaseName=ATS";
			String userName="sa";
			String userPwd="123";
			//��������
			Class.forName(driverName);
			//��ȡ����
			Connection con = DriverManager.getConnection(dbURL, userName, userPwd);
			
			//��ע����Ϣ��ӵ����ݿ�Passenger����
			PreparedStatement pstmt = con.prepareStatement(sql); 
			pstmt.setString(1, testName.getText());  
			pstmt.setString(2, testPassword.getText());  
			pstmt.setString(3, testPid.getText());  
			pstmt.setString(4, sex.getSelectedItem().toString() );  
			pstmt.setString(5, testPname.getText());  
			pstmt.setString(6, testTnumber.getText());  
			//ִ�и��²���
			pstmt.executeUpdate();
		}         
    }  
	
	 //�ж����ݿ����Ƿ��������ô��˺�  
    private boolean validate(String testname)  
    {  
    	String sql="select * from Passenger where pID = '"+testname+"'" ; 
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
	
	public static void main(String[] args){
		// TODO Auto-generated method stub

		Register frame = new Register();
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setSize(500, 560);
		frame.setVisible(true);
		frame.setResizable(false);
		//�����Ļ��С
		Dimension screen=Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation((screen.width-300)/2,(screen.height-220)/2 - 200);
	
	}

}
