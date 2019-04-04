
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
	JRadioButton manager = new JRadioButton("管理员");
	JRadioButton user = new JRadioButton("用户");
	public UserLogin(){
		
		super("登录");
		
		//设置背景图片
		ImageIcon image = new ImageIcon("2.jpg");
		JLabel logolabel = new JLabel(image);
		//设置标签的位置从（0,0）点开始，充满整个窗口
		logolabel.setBounds(0, 0, image.getIconWidth(), image.getIconHeight());
		//设置顶层面板，将背景标签添加到窗口的顶层面板（LayeredPane）里
		this.getLayeredPane().add(logolabel, new Integer(Integer.MIN_VALUE));
		//设置内容面板
		JPanel panel = (JPanel)this.getContentPane();
		//设置内容面板为透明
		panel.setOpaque(false);
	
		//面板排版为四行两列
		panel.setLayout(new GridLayout(4, 2, 0, 20));
		//与边框的距离，分别对应上、左、下、右
		panel.setBorder(new EmptyBorder(30, 30, 30, 30));
		
		JLabel labelName = new JLabel("用户名：");
		labelName.setFont(new Font("黑体",Font.BOLD, 20));
		textName = new JTextField(15);
		textName.addActionListener(this);
		textName.setFont(new Font("黑体",Font.BOLD, 20));
		//设置输入框为透明
		textName.setOpaque(false);
		panel.add(labelName);
		panel.add(textName);
		
		JLabel labelPassword = new JLabel("密码：");
		labelPassword.setFont(new Font("黑体",Font.BOLD, 20));
		textPassword = new JPasswordField(15);
		textPassword.setFont(new Font("黑体",Font.BOLD, 20));
		textPassword.setEchoChar('*');//设置回显字符
		//设置输入框为透明
		textPassword.setOpaque(false);
		textPassword.addActionListener(this);
		panel.add(labelPassword);
		panel.add(textPassword);
		
		panel.add(manager);
		panel.add(user);
		manager.setFont(new Font("黑体",Font.BOLD, 18));
		manager.setOpaque(false);
		user.setFont(new Font("黑体",Font.BOLD, 18));
		user.setOpaque(false);
		buttongroup.add(manager);
		buttongroup.add(user);
		
		ok = new JButton("登录");
		ok.setFont(new Font("黑体",Font.BOLD, 20));
		ok.setContentAreaFilled(false);//设置按钮为透明色
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
					JOptionPane.showConfirmDialog(null, "账号或密码错误！", "提示", JOptionPane.YES_NO_OPTION);
					
				}
			}
		});
		panel.add(ok);
		
		login = new JButton("注册");
		login.setContentAreaFilled(false);//设置按钮为透明色
		login.setFont(new Font("黑体",Font.BOLD, 20));
		
		//设置监听事件，当用户没有注册过账号时，点击注册按钮，弹出注册窗口
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
			textPassword.grabFocus();//密码获得焦点
		}
		
	}
    
    //判断数据库中是否有该用户名和密码  
    private boolean validate(String testname, String cs)  
    {  
    	String sql;
    	if (user.isSelected())
    		sql="select * from Passenger where pID = '"+testname+"' and pPassword = '"+cs+"'" ;  
    	else
    		sql="select * from Administrator where AdminID = '"+testname+"' and AdminPassword = '"+cs+"'" ;  
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
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UserLogin  frame = new UserLogin();
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setSize(400, 280);
		frame.setVisible(true);
		frame.setResizable(false);
		//获得屏幕大小
		Dimension screen=Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation((screen.width-300)/2,(screen.height-220)/2 - 200);
	}

}
//功能：从用户表或管理员表中找到已保存的账号和密码