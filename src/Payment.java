import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.*;
import javax.swing.border.*;

public class Payment  extends JFrame implements ActionListener{
	
	private JTextField flightNmb;
	private JTextField sid;
	private JTextField slevel;
	private JTextField Pname;
	private JTextField telephoneNmb;
	private JTextField PId;
	private JButton ok;
	int count = 2;
	
	public Payment(){
		
		super("֧��");

		//���ñ���ͼƬ
		ImageIcon image = new ImageIcon("4.jpg");
		JLabel logolabel = new JLabel(image);
		//���ñ�ǩ��λ�ôӣ�0,0���㿪ʼ��������������
		logolabel.setBounds(0, 0, image.getIconWidth(), image.getIconHeight());
		//���ö�����壬��������ǩ��ӵ����ڵĶ�����壨LayeredPane����
		this.getLayeredPane().add(logolabel, new Integer(Integer.MIN_VALUE));
		//�����������
		JPanel panel = (JPanel)this.getContentPane();
		//�����������Ϊ͸��
		panel.setOpaque(false);
		
		panel.setLayout(new GridLayout(4, 4, 30, 10));
		panel.setBorder(new EmptyBorder(30, 30, 30, 30));
		
		JLabel LflightNmb = new JLabel("����ţ�");
		LflightNmb.setFont(new Font("����",Font.BOLD, 18));
		flightNmb = new JTextField(15);
		flightNmb.setFont(new Font("����",Font.BOLD, 18));
		flightNmb.setOpaque(false);
		flightNmb.addActionListener(this);
		panel.add(LflightNmb);
		panel.add(flightNmb);
								
		JLabel LPname = new JLabel("�˿�������");
		LPname.setFont(new Font("����",Font.BOLD, 18));
		Pname = new JTextField(15);
		Pname.setFont(new Font("����",Font.BOLD, 18));
		Pname.setOpaque(false);
		Pname.addActionListener(this);
		panel.add(LPname);
		panel.add(Pname);
		
		JLabel LPid = new JLabel("���֤���룺");
		LPid.setFont(new Font("����",Font.BOLD, 18));
		PId = new JTextField(15);
		PId.setFont(new Font("����",Font.BOLD, 18));
		PId.setOpaque(false);
		PId.addActionListener(this);
		panel.add(LPid);
		panel.add(PId);
		
		
		JLabel LtelephoneNmb = new JLabel("�绰���룺");
		LtelephoneNmb.setFont(new Font("����",Font.BOLD, 18));
		telephoneNmb = new JTextField(15);
		telephoneNmb.setFont(new Font("����",Font.BOLD, 18));
		telephoneNmb.setOpaque(false);
		telephoneNmb.addActionListener(this);
		panel.add(LtelephoneNmb);
		panel.add(telephoneNmb);
		
		
		JLabel labelFrom = new JLabel("��λ�ȼ���");
		labelFrom.setFont(new Font("����",Font.BOLD, 18));
		slevel = new JTextField(15);
		slevel.setFont(new Font("����",Font.BOLD, 18));
		slevel.setOpaque(false);
		slevel.addActionListener(this);
		panel.add(labelFrom);
		panel.add(slevel);
		
		
		JLabel labelTo = new JLabel("��λ�ţ�");
		labelTo.setFont(new Font("����",Font.BOLD, 18));
		sid = new JTextField(15);
		sid.setFont(new Font("����",Font.BOLD, 18));
		sid.setOpaque(false);
		sid.addActionListener(this);
		panel.add(labelTo);
		panel.add(sid);
		
		
		
		ok = new JButton("�ύ����");
		ok.setFont(new Font("����",Font.BOLD, 18));
		ok.setContentAreaFilled(false);//���ð�ťΪ͸��ɫ
		ok.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				try {  
				        cheak(); 
				        JOptionPane.showConfirmDialog(null, "��Ʊ�ɹ���", "��ʾ", JOptionPane.WARNING_MESSAGE);
						
				     } catch (Exception e1) {  
				              // TODO Auto-generated catch block  
				          e1.printStackTrace();  
				    } 
				}
				
			});
		panel.add("Center", ok);
	
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(800, 320);
		validate();
		setVisible(true);
		setResizable(false);
		//�����Ļ��С
		Dimension screen=Toolkit.getDefaultToolkit().getScreenSize();
		setLocation((screen.width-300)/2,(screen.height-220)/2 - 200);
	
	}
	
	public void actionPerformed(ActionEvent e){
	
	}
	
	private void cheak() throws Exception  
    {      
		String sql="insert into Orders values(?,?,?,?,?,?,?,?)";  
		//�ҵ����ݿ������Ϣ
		String driverName="com.microsoft.sqlserver.jdbc.SQLServerDriver";
		String dbURL="jdbc:sqlserver://127.0.0.1:1433;DatabaseName=ATS";
		String userName="sa";
		String userPwd="123";
		//��������
		Class.forName(driverName);
		//��ȡ����
		Connection con = DriverManager.getConnection(dbURL, userName, userPwd);
		Statement state = con.createStatement();//����
		
		String sql1 = "select aID from Flight where fID = '"+ flightNmb.getText() +"'" ;
		ResultSet rs1 = state.executeQuery(sql1);
		String result1 = null;
		while(rs1.next())
			result1 = rs1.getString(1);
		System.out.println(result1);
		state.close();
		
		String sql2 = null;
		Statement state2 = con.createStatement();//����
		if (slevel.getText().equals("���ò�"))
			sql2 = "select eFare from Flight  where fID = '"+ flightNmb.getText() +"'" ;
		else if (slevel.getText().equals("�����"))
			sql2 = "select bFare from Flight where fID = '"+ flightNmb.getText() +"'" ;
		else if (slevel.getText().equals("ͷ�Ȳ�"))
			sql2 = "select fFare from Flight where fID = '"+ flightNmb.getText() +"'" ; 
		ResultSet rs2 = state2.executeQuery(sql2);
		String result2 = null;
		while(rs2.next())
			result2 = rs2.getString(1);
		state2.close();
		
		count ++;
		//��ע����Ϣ��ӵ����ݿ�Passenger����
		PreparedStatement pstmt = con.prepareStatement(sql); 
		pstmt.setString(1, Integer.toString(count));  
		pstmt.setString(2, Pname.getText());  
		pstmt.setString(3, PId.getText());  
		pstmt.setString(4, flightNmb.getText()); 
		pstmt.setString(5, result1); 
		pstmt.setString(6, sid.getText());  
		pstmt.setString(7, slevel.getText()); 
		pstmt.setFloat(8, Float.parseFloat(result2));
		//ִ�и��²���
		pstmt.executeUpdate();
		
		Statement state3 = con.createStatement();//����
		String sql3 = "select fStart from Flight where fID = '"+ flightNmb.getText() +"'" ;
		ResultSet rs3 = state3.executeQuery(sql3);
		String result3 = null;
		while(rs3.next())
			result3 = rs3.getString(1);
		state3.close();
		
		Statement state4 = con.createStatement();//����
		String sql4 = "select fEnd from Flight where fID = '"+ flightNmb.getText() +"'" ;
		ResultSet rs4 = state4.executeQuery(sql4);
		String result4 = null;
		while(rs4.next())
			result4 = rs4.getString(1);
		state4.close();
		
		Statement state5 = con.createStatement();//����
		String sql5 = "select fStartTime from Flight where fID = '"+ flightNmb.getText() +"'" ;
		ResultSet rs5 = state5.executeQuery(sql5);
		String result5 = null;
		while(rs5.next())
			result5 = rs5.getString(1);
		state5.close();
		
		Statement state6 = con.createStatement();//����
		String sql6 = "select fStartDate from Flight where fID = '"+ flightNmb.getText() +"'" ;
		ResultSet rs6 = state6.executeQuery(sql6);
		String result6 = null;
		while(rs6.next())
			result6 = rs6.getString(1);
		state6.close();
		
		con.close();
		System.out.println(result6);
		
		OrderInformation order = new OrderInformation(Pname.getText(), PId.getText(), flightNmb.getText(), sid.getText(), 
				result3,result4, result5, result6,slevel.getText(),result2);
		order.setSize(500, 560);
		Dimension screen=Toolkit.getDefaultToolkit().getScreenSize();
		order.setLocation((screen.width-300)/2,(screen.height-220)/2 - 200);
		order.setVisible(true);
	}         
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Payment();
	}

}

