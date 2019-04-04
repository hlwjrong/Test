import java.awt.CardLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.swing.*;
import javax.swing.border.EmptyBorder;


public class addInformation  extends JFrame implements ActionListener{

	JMenuBar menuBar;
	JMenu menu,submenu;
	JMenuItem menuItem;
	JCheckBoxMenuItem cbMenuItem;
	JRadioButtonMenuItem rbMenuItem;
	
	public JTextField fid = null;
	public JTextField aid = null;
	public JTextField fstart = null ;
	public JTextField fend = null;
	public JTextField ftime = null ;
	public JTextField fstime = null;
	public JTextField fsdate = null ;
	public JTextField efare = null;
	public JTextField bfare = null ;
	public JTextField Ffare = null;
	private JButton ok;
	private JButton cancel;
	private JPanel panel;
	
	public addInformation(){
		super("航班信息录入");
		
		
		//添加背景图片
		ImageIcon image = new ImageIcon("5.jpg");
		JLabel logolabel = new JLabel(image);
		//设置标签的位置从（0,0）点开始，充满整个窗口
		logolabel.setBounds(0, 0, image.getIconWidth(), image.getIconHeight());
		//设置顶层面板，将背景标签添加到窗口的顶层面板（LayeredPane）里
		this.getLayeredPane().add(logolabel, new Integer(Integer.MIN_VALUE));
		//设置内容面板
		JPanel panel1 = (JPanel)this.getContentPane();
		//设置内容面板为透明
		panel1.setOpaque(false);
		
		panel1.setLayout(new GridLayout(11, 2, 0, 20));
		panel1.setBorder(new EmptyBorder(30, 30, 30, 30));//分别对应上、左、下、右
						
		JLabel Lflightnum = new JLabel("航班编号：");
		Lflightnum.setFont(new Font("黑体",Font.BOLD, 18));
		fid = new JTextField(15);
		fid.setFont(new Font("黑体",Font.BOLD, 18));
		fid.setOpaque(false);
		fid.addActionListener(this);
		panel1.add(Lflightnum);
		panel1.add(fid);
				
		JLabel Laid = new JLabel("飞机编号：");
		Laid.setFont(new Font("黑体",Font.BOLD, 18));
		aid  = new JTextField(15);
		aid .setFont(new Font("黑体",Font.BOLD, 18));
		aid .setOpaque(false);
		aid .addActionListener(this);
		panel1.add(Laid);
		panel1.add(aid);
		
		JLabel Lfstart = new JLabel("始发地：");
		Lfstart.setFont(new Font("黑体",Font.BOLD, 18));
		fstart = new JTextField(15);
		fstart.setFont(new Font("黑体",Font.BOLD, 18));
		fstart.setOpaque(false);
		fstart.addActionListener(this);
		panel1.add(Lfstart);
		panel1.add(fstart);
		
		JLabel Lfend  = new JLabel("目的地：");
		Lfend .setFont(new Font("黑体",Font.BOLD, 18));
		fend  = new JTextField(15);
		fend .setFont(new Font("黑体",Font.BOLD, 18));
		fend .setOpaque(false);
		fend .addActionListener(this);
		panel1.add(Lfend );
		panel1.add(fend);
		
		JLabel Lftime = new JLabel("起飞时间：");
		Lftime.setFont(new Font("黑体",Font.BOLD, 18));
		ftime = new JTextField(15);
		ftime.setFont(new Font("黑体",Font.BOLD, 18));
		ftime.setOpaque(false);
		ftime.addActionListener(this);
		panel1.add(Lftime);
		panel1.add(ftime);
		
		JLabel Lfstime = new JLabel("飞行时间：");
		Lfstime.setFont(new Font("黑体",Font.BOLD, 18));
		fstime = new JTextField(15);
		fstime.setFont(new Font("黑体",Font.BOLD, 18));
		fstime.setOpaque(false);
		fstime.addActionListener(this);
		panel1.add(Lfstime);
		panel1.add(fstime);
		
		JLabel Lfsdate = new JLabel("飞行日期：");
		Lfsdate.setFont(new Font("黑体",Font.BOLD, 18));
		fsdate = new JTextField(15);
		fsdate.setFont(new Font("黑体",Font.BOLD, 18));
		fsdate.setOpaque(false);
		fsdate.addActionListener(this);
		panel1.add(Lfsdate);
		panel1.add(fsdate);
		
		JLabel Lefare = new JLabel("经济舱票价：");
		Lefare.setFont(new Font("黑体",Font.BOLD, 18));
		efare = new JTextField(15);
		efare.setFont(new Font("黑体",Font.BOLD, 18));
		efare.setOpaque(false);
		efare.addActionListener(this);
		panel1.add(Lefare);
		panel1.add(efare);
		
		JLabel Lbfare = new JLabel("商务舱票价：");
		Lbfare.setFont(new Font("黑体",Font.BOLD, 18));
		bfare = new JTextField(15);
		bfare.setFont(new Font("黑体",Font.BOLD, 18));
		bfare.setOpaque(false);
		bfare.addActionListener(this);
		panel1.add(Lbfare);
		panel1.add(bfare);
		
		JLabel LFfare = new JLabel("头等舱票价：");
		LFfare.setFont(new Font("黑体",Font.BOLD, 18));
		Ffare = new JTextField(15);
		Ffare.setFont(new Font("黑体",Font.BOLD, 18));
		Ffare.setOpaque(false);
		Ffare.addActionListener(this);
		panel1.add(LFfare);
		panel1.add(Ffare);
		
		ok = new JButton("添加");
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
		
		cancel = new JButton("取消");
		cancel.setFont(new Font("黑体",Font.BOLD, 20));
		//设置按钮为透明色
		cancel.setContentAreaFilled(false);
		cancel.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				System.exit(0);
			}
		});
		panel1.add(cancel);
		
		
		menuBar = new JMenuBar();//生成菜单条
		setJMenuBar(menuBar);
		menu = new JMenu("信息录入");//创建第一个菜单
		menu.setFont(new Font("黑体",Font.BOLD, 16));
		menu.setMnemonic(KeyEvent.VK_A);
		menuBar.add(menu);
		menuItem = new JMenuItem("航班信息录入");//创建菜单项
		menuItem.setFont(new Font("黑体",Font.BOLD, 16));
		menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1,
								ActionEvent.ALT_MASK));
		menuItem.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				  panel1.setVisible(true);
				 // panel.setVisible(true);
			}
		});
		menu.add(menuItem);
		

		menuItem = new JMenuItem("旅客信息录入");//创建菜单项
		menuItem.setFont(new Font("黑体",Font.BOLD, 16));
		menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_2,
								ActionEvent.ALT_MASK));
		menuItem.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				  //panel.setVisible(false);
				 // panel1.setVisible(true);
			}
		});
		menu.add(menuItem);
		
		menuItem = new JMenuItem("座位信息录入");//创建菜单项
		menuItem.setFont(new Font("黑体",Font.BOLD, 16));
		menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_2,
								ActionEvent.ALT_MASK));
		menuItem.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				 // panel.setVisible(false);
				 // panel1.setVisible(true);
			}
		});
		menu.add(menuItem);
		menuBar.add(menu);
	
	}
	

	   //注册用户和密码 （1）首先先检查数据库中是否有相应的数据，如果有的话提示"该用户存在，请直接登录。"  
    private void cheak() throws Exception  
    {         	    	
		
		String sql="insert into Flight values(?,?,?,?,?,?,?,?,?,?)";  
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
		pstmt.setString(1, fid.getText());  
		pstmt.setString(2, aid.getText());  
		pstmt.setString(3, fstart.getText());  
		pstmt.setString(4, fend.getText() );  
		pstmt.setString(5, ftime.getText());  
		pstmt.setString(6, fstime.getText());  
		pstmt.setString(7, fsdate.getText());  
		pstmt.setFloat(8, Float.parseFloat(efare.getText()));  
		pstmt.setFloat(9,Float.parseFloat(bfare.getText()));  
		pstmt.setFloat(10,Float.parseFloat(Ffare.getText()));  
		//执行更新操作
		pstmt.executeUpdate();
	        
    }  
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		addInformation frame = new addInformation();
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setSize(500, 640);
		frame.setVisible(true);
		frame.setResizable(false);
		//获得屏幕大小
		Dimension screen=Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation((screen.width-300)/2,(screen.height-220)/2 - 200);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}



