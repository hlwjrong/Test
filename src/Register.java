
import java.applet.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.sql.*;

public class Register extends JFrame implements ActionListener{

	private JTextField testName;//用户名
	private JPasswordField testPassword;//用户密码
	private JTextField testCheck;//
	private JPasswordField PasswordCheck;//确认密码
	private JTextField testPname;//用户姓名
	private JTextField testPid;//用户身份证号
	private JTextField testTnumber;//用户电话号码
	private JComboBox sex; //用户性别
	private JButton ok;
	private JButton cancel;
	public Register(){
		
		super("用户注册");
		
		//添加背景图片
		ImageIcon image = new ImageIcon("1.jpg");
		JLabel logolabel = new JLabel(image);
		//设置标签的位置从（0,0）点开始，充满整个窗口
		logolabel.setBounds(0, 0, image.getIconWidth(), image.getIconHeight());
		//设置顶层面板，将背景标签添加到窗口的顶层面板（LayeredPane）里
		this.getLayeredPane().add(logolabel, new Integer(Integer.MIN_VALUE));
		//设置内容面板
		JPanel panel1 = (JPanel)this.getContentPane();
		//设置内容面板为透明
		panel1.setOpaque(false);
		
		panel1.setLayout(new GridLayout(8, 2, 0, 20));
		panel1.setBorder(new EmptyBorder(50, 30, 50, 30));//分别对应上、左、下、右
		JLabel labelName = new JLabel("用户名：");
		labelName.setFont(new Font("黑体",Font.BOLD, 20));
		testName = new JTextField(20);
		testName.setFont(new Font("黑体",Font.BOLD, 20));
		testName.addActionListener(this);
		//设置输入框为透明
		testName.setOpaque(false);
		panel1.add(labelName);
		panel1.add(testName);
		
		JLabel labelPassword = new JLabel("密码：");
		labelPassword.setFont(new Font("黑体",Font.BOLD, 20));
		testPassword = new JPasswordField(20);
		testPassword.setFont(new Font("黑体",Font.BOLD, 20));
		testPassword.setEchoChar('*');//设置回显字符
		//设置输入框为透明
		testPassword.setOpaque(false);
		testPassword.addActionListener(this);
		panel1.add(labelPassword);
		panel1.add(testPassword);
		
		JLabel labelPasswordCheck = new JLabel("确认密码：");
		labelPasswordCheck.setFont(new Font("黑体",Font.BOLD, 20));
		PasswordCheck = new JPasswordField(20);
		PasswordCheck.setFont(new Font("黑体",Font.BOLD, 20));
		PasswordCheck.setEchoChar('*');//设置回显字符
		//设置输入框为透明
		PasswordCheck.setOpaque(false);
		PasswordCheck.addActionListener(this);
		panel1.add(labelPasswordCheck);
		panel1.add(PasswordCheck);
		
		JLabel labelPName = new JLabel("姓名：");
		labelPName.setFont(new Font("黑体",Font.BOLD, 20));
		testPname = new JTextField(15);
		testPname.setFont(new Font("黑体",Font.BOLD, 20));
		//设置输入框为透明
		testPname.setOpaque(false);
		testPname.addActionListener(this);
		panel1.add(labelPName);
		panel1.add(testPname);
		
		JLabel labelPid = new JLabel("身份证号：");
		labelPid.setFont(new Font("黑体",Font.BOLD, 20));
		testPid = new JTextField(15);
		testPid.setFont(new Font("黑体",Font.BOLD, 20));
		//设置输入框为透明
		testPid.setOpaque(false);
		testPid.addActionListener(this);
		panel1.add(labelPid);
		panel1.add(testPid);
		
		JLabel labelTnumber = new JLabel("电话号码：");
		labelTnumber.setFont(new Font("黑体",Font.BOLD, 20));
		testTnumber = new JTextField(15);
		testTnumber.setFont(new Font("黑体",Font.BOLD, 20));
		//设置输入框为透明
		testTnumber.setOpaque(false);
		testTnumber.addActionListener(this);
		panel1.add(labelTnumber);
		panel1.add(testTnumber);
		
		JLabel labelInterge = new JLabel("性别：");
		labelInterge.setFont(new Font("黑体",Font.BOLD, 20));
		String[] sexs = {"男", "女"};
		sex = new JComboBox(sexs);
		sex.setFont(new Font("黑体",Font.BOLD, 18));
		sex.setOpaque(false);
		panel1.add(labelInterge);
		panel1.add(sex);
		
		
		
		ok = new JButton("注册");
		ok.setFont(new Font("黑体",Font.BOLD, 20));
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
		//设置按钮为透明色
		ok.setContentAreaFilled(false);
		panel1.add(ok);
		
		cancel = new JButton("去登录");
		cancel.setFont(new Font("黑体",Font.BOLD, 20));
		//设置按钮为透明色
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
		
		
    	String testname = testName.getText();//用户名
		String password = testPassword.getText();//用户密码
		String passwordcheck = PasswordCheck.getText();//确认密码
		String testpname = testPname.getText();//用户姓名
		String testpid = testPid.getText();//用户身份证号
		String testnumber = testTnumber.getText();//用户手机号
		
		if (!passwordcheck.equals(password)){
			JOptionPane.showConfirmDialog(null, "密码不一致，请重新输入！", "提示", JOptionPane.WARNING_MESSAGE);
			return;
		}
		
		if(testname == "" || password == "" || passwordcheck == "" || 
				testpname == ""|| testpid == "" || testnumber == "" ){
			JOptionPane.showConfirmDialog(null, "请输入输入完整信息！", "提示", JOptionPane.YES_NO_OPTION);
			return;
		}
		
		if(password.length()  >16 || password.length() < 2){
			JOptionPane.showConfirmDialog(null, "密码长度应在2-16之间！", "提示", JOptionPane.YES_NO_OPTION);
		}
		
		if(testpid.length() != 18 ){
			JOptionPane.showConfirmDialog(null, "身份证号码应为18位！", "提示", JOptionPane.YES_NO_OPTION);
			return;
		}
	}

	
	   //注册用户和密码 （1）首先先检查数据库中是否有相应的数据，如果有的话提示"该用户存在，请直接登录。"  
    private void cheak() throws Exception  
    {         	    	
		if (validate(testName.getText()))  
		{  
			JOptionPane.showConfirmDialog(null, "账号已存在！", "提示", JOptionPane.YES_NO_OPTION);
		}  
		else  
		{  
			String sql="insert into Passenger values(?,?,?,?,?,?)";  
			//找到数据库相关信息
			String driverName="com.microsoft.sqlserver.jdbc.SQLServerDriver";
			String dbURL="jdbc:sqlserver://127.0.0.1:1433;DatabaseName=ATS";
			String userName="sa";
			String userPwd="123";
			//加载驱动
			Class.forName(driverName);
			//获取连接
			Connection con = DriverManager.getConnection(dbURL, userName, userPwd);
			
			//将注册信息添加到数据库Passenger表中
			PreparedStatement pstmt = con.prepareStatement(sql); 
			pstmt.setString(1, testName.getText());  
			pstmt.setString(2, testPassword.getText());  
			pstmt.setString(3, testPid.getText());  
			pstmt.setString(4, sex.getSelectedItem().toString() );  
			pstmt.setString(5, testPname.getText());  
			pstmt.setString(6, testTnumber.getText());  
			//执行更新操作
			pstmt.executeUpdate();
		}         
    }  
	
	 //判断数据库中是否已有人用此账号  
    private boolean validate(String testname)  
    {  
    	String sql="select * from Passenger where pID = '"+testname+"'" ; 
    	try{//如果查询的ResultSet里有超过一条的记录，则登录成功 
  
    		//找到数据库相关信息
    		String driverName="com.microsoft.sqlserver.jdbc.SQLServerDriver";
    		String dbURL="jdbc:sqlserver://127.0.0.1:1433;DatabaseName=ATS";
    		String userName="sa";
    		String userPwd="123";
    		//加载驱动
			Class.forName(driverName);
			//获取连接
			Connection con = DriverManager.getConnection(dbURL, userName, userPwd);
			
			//获取PreparedStatement对象
			PreparedStatement ps = con.prepareStatement(sql);
			//执行查询
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
		//获得屏幕大小
		Dimension screen=Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation((screen.width-300)/2,(screen.height-220)/2 - 200);
	
	}

}
