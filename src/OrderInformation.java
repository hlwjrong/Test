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

	public JLabel pname;//用户姓名
	public JLabel pid;//用户身份证号码
	public JLabel fid;//航班编号
	public JLabel sid;//座位号
	public JLabel fromcity;//出发城市
	public JLabel tocity; //到达城市
	public JLabel fromtime;//出发时间
	public JLabel fromdate; //出发日期
	public JLabel slevel;//座位等级
	public JLabel price;//价格
	
	public JButton ok;
	public JButton cancel;
	public OrderInformation(String pname1, String pid1, String fid1, String sid1, String fromcity1, 
				String tocity1, String fromtime1,String fromdate1, String slevel1,  String price1){
		
		super("订单信息");
		
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
		
		panel1.setLayout(new GridLayout(12, 2, 0, 20));
		panel1.setBorder(new EmptyBorder(10, 10, 10, 10));//分别对应上、左、下、右
		JLabel labelName = new JLabel("姓名：");
		labelName.setFont(new Font("黑体",Font.BOLD, 20));
		pname = new JLabel(pname1);
		pname.setFont(new Font("黑体",Font.BOLD, 20));
		//pname.addActionListener(this);
		//设置输入框为透明
		pname.setOpaque(false);
		panel1.add(labelName);
		panel1.add(pname);
		
		JLabel labelPassword = new JLabel("身份证号：");
		labelPassword.setFont(new Font("黑体",Font.BOLD, 20));
		pid = new JLabel(pid1);
		pid.setFont(new Font("黑体",Font.BOLD, 20));
		//设置输入框为透明
		pid.setOpaque(false);
		//pid.addActionListener(this);
		panel1.add(labelPassword);
		panel1.add(pid);
		
		JLabel labelPasswordCheck = new JLabel("航班编号：");
		labelPasswordCheck.setFont(new Font("黑体",Font.BOLD, 20));
		fid = new JLabel(fid1);
		fid.setFont(new Font("黑体",Font.BOLD, 20));
		//设置输入框为透明
		fid.setOpaque(false);
		panel1.add(labelPasswordCheck);
		panel1.add(fid);
		
		JLabel labelPName = new JLabel("座位号：");
		labelPName.setFont(new Font("黑体",Font.BOLD, 20));
		sid = new JLabel(sid1);
		sid.setFont(new Font("黑体",Font.BOLD, 20));
		//设置输入框为透明
		sid.setOpaque(false);
		panel1.add(labelPName);
		panel1.add(sid);
		
		JLabel labelInterge = new JLabel("出发城市：");
		labelInterge.setFont(new Font("黑体",Font.BOLD, 20));
		fromcity = new JLabel(fromcity1);
		fromcity.setFont(new Font("黑体",Font.BOLD, 18));
		fromcity.setOpaque(false);
		panel1.add(labelInterge);
		panel1.add(fromcity);
		
		
		JLabel labeltocity = new JLabel("到达城市：");
		labeltocity.setFont(new Font("黑体",Font.BOLD, 20));
		tocity = new JLabel(tocity1);
		tocity.setFont(new Font("黑体",Font.BOLD, 18));
		tocity.setOpaque(false);
		panel1.add(labeltocity);
		panel1.add(tocity);
		
		JLabel labelftime = new JLabel("出发时间：");
		labelftime.setFont(new Font("黑体",Font.BOLD, 20));
		fromtime = new JLabel(fromtime1);
		fromtime.setFont(new Font("黑体",Font.BOLD, 18));
		fromtime.setOpaque(false);
		panel1.add(labelftime);
		panel1.add(fromtime);
		
		
		JLabel labelfdate = new JLabel("出发日期：");
		labelfdate.setFont(new Font("黑体",Font.BOLD, 20));
		fromdate = new JLabel(fromdate1);
		fromdate.setFont(new Font("黑体",Font.BOLD, 18));
		fromdate.setOpaque(false);
		panel1.add(labelfdate);
		panel1.add(fromdate);
		
		
		JLabel labelPid = new JLabel("座位等级：");
		labelPid.setFont(new Font("黑体",Font.BOLD, 20));
		slevel = new JLabel(slevel1);
		slevel.setFont(new Font("黑体",Font.BOLD, 20));
		//设置输入框为透明
		slevel.setOpaque(false);
		panel1.add(labelPid);
		panel1.add(slevel);
		
		JLabel labelTnumber = new JLabel("价格：");
		labelTnumber.setFont(new Font("黑体",Font.BOLD, 20));
		price = new JLabel(price1);
		price.setFont(new Font("黑体",Font.BOLD, 20));
		//设置输入框为透明
		price.setOpaque(false);
		panel1.add(labelTnumber);
		panel1.add(price);
		
		ok = new JButton("确定");
		ok.setFont(new Font("黑体",Font.BOLD, 20));
		ok.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				  
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
		//获得屏幕大小
		Dimension screen=Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation((screen.width-300)/2,(screen.height-220)/2 - 200);
	}

}
