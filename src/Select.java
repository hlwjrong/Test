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
	public CardLayout card = null; // CardLayout布局管理器
	public JPanel pane = null;// 主要的JPanel，该JPanel的布局管理将被设置成CardLayout
	public JPanel panel,panel1;
	 
	public Select(){
		super("用户");
		
		
		Container c = getContentPane();//获得内容面板

		 card = new CardLayout(5, 5);
	     pane = new JPanel(card); // JPanel的布局管理将被设置成CardLayout
		
		panel1 = new JPanel();
		//设置内容面板为透明
		panel1.setOpaque(false);
						
		panel1.setLayout(new GridLayout(4, 2, 0, 20));
		panel1.setBorder(new EmptyBorder(30, 30, 30, 30));
						
		JLabel Lflightnum = new JLabel("航班编号：");
		Lflightnum.setFont(new Font("黑体",Font.BOLD, 18));
		flightnum = new JTextField(15);
		flightnum.setFont(new Font("黑体",Font.BOLD, 18));
		flightnum.setOpaque(false);
		flightnum.addActionListener(this);
		panel1.add(Lflightnum);
		panel1.add(flightnum);
				
		select1 = new JButton("搜索");
		select1.setFont(new Font("黑体",Font.BOLD, 18));
		select1.setContentAreaFilled(false);//设置按钮为透明色
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
		
		
		//设置内容面板
		panel = new JPanel();
		//设置内容面板为透明
		panel.setOpaque(false);
		
		panel.setLayout(new GridLayout(4, 2, 0, 20));
		panel.setBorder(new EmptyBorder(30, 30, 30, 30));
		
		JLabel labelFrom = new JLabel("出发城市：");
		labelFrom.setFont(new Font("黑体",Font.BOLD, 18));
		fromcity = new JTextField(15);
		fromcity.setFont(new Font("黑体",Font.BOLD, 18));
		fromcity.setOpaque(false);
		fromcity.addActionListener(this);
		panel.add(labelFrom);
		panel.add(fromcity);
		
		JLabel labelTo = new JLabel("到达城市：");
		labelTo.setFont(new Font("黑体",Font.BOLD, 18));
		tocity = new JTextField(15);
		tocity.setFont(new Font("黑体",Font.BOLD, 18));
		tocity.setOpaque(false);
		tocity.addActionListener(this);
		panel.add(labelTo);
		panel.add(tocity);
		
		JLabel labelfromTime = new JLabel("出发时间：");
		labelfromTime.setFont(new Font("黑体",Font.BOLD, 18));
		String[] date = {"2018/12/23", "2018/12/24", "2018/12/25", "2018/12/26",
						"2018/12/27", "2018/12/28", "2018/12/29", "2018/12/30"};
		fromtime = new JComboBox(date);
		fromtime.setFont(new Font("黑体",Font.BOLD, 18));
		fromtime.setOpaque(false);
		fromtime.addActionListener(this);
		panel.add(labelfromTime);
		panel.add(fromtime);
		
		select2 = new JButton("搜索");
		select2.setFont(new Font("黑体",Font.BOLD, 18));
		select2.setContentAreaFilled(false);//设置按钮为透明色
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
	
		menuBar = new JMenuBar();//生成菜单条
		setJMenuBar(menuBar);
		menu = new JMenu("查询");//创建第一个菜单
		menu.setFont(new Font("黑体",Font.BOLD, 16));
		menu.setMnemonic(KeyEvent.VK_A);
		menuBar.add(menu);
		menuItem = new JMenuItem("按起降地查询");//创建菜单项
		menuItem.setFont(new Font("黑体",Font.BOLD, 16));
		menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1,
								ActionEvent.ALT_MASK));
		menuItem.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				  panel1.setVisible(false);
				  panel.setVisible(true);
			}
		});
		menu.add(menuItem);
		
		menuItem = new JMenuItem("按航班编号查询");//创建菜单项
		menuItem.setFont(new Font("黑体",Font.BOLD, 16));
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
		//获得屏幕大小
		Dimension screen=Toolkit.getDefaultToolkit().getScreenSize();
		setLocation((screen.width-300)/2,(screen.height-220)/2 - 200);
	}
	
	public void actionPerformed(ActionEvent e){
		if (e.getActionCommand().equals(select1)){
			if (flightnum.getText() == ""){
				JOptionPane.showConfirmDialog(null, "航班编号不能为空！", "提示", JOptionPane.OK_OPTION);
				return;
			}
		}
		if (e.getActionCommand().equals(select2)){
			if (fromcity.getText() == "" || tocity.getText() == ""){
				JOptionPane.showConfirmDialog(null, "起始地与目的地不能为空！", "提示", JOptionPane.OK_OPTION);
				return;
			}
			
			else if (fromcity.getText() == tocity.getText()){
				JOptionPane.showConfirmDialog(null, "起始地与目的地不能相同！", "提示", JOptionPane.OK_OPTION);
				return;
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		new Select();
		
	}

}


