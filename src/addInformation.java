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
		super("������Ϣ¼��");
		
		
		//��ӱ���ͼƬ
		ImageIcon image = new ImageIcon("5.jpg");
		JLabel logolabel = new JLabel(image);
		//���ñ�ǩ��λ�ôӣ�0,0���㿪ʼ��������������
		logolabel.setBounds(0, 0, image.getIconWidth(), image.getIconHeight());
		//���ö�����壬��������ǩ��ӵ����ڵĶ�����壨LayeredPane����
		this.getLayeredPane().add(logolabel, new Integer(Integer.MIN_VALUE));
		//�����������
		JPanel panel1 = (JPanel)this.getContentPane();
		//�����������Ϊ͸��
		panel1.setOpaque(false);
		
		panel1.setLayout(new GridLayout(11, 2, 0, 20));
		panel1.setBorder(new EmptyBorder(30, 30, 30, 30));//�ֱ��Ӧ�ϡ����¡���
						
		JLabel Lflightnum = new JLabel("�����ţ�");
		Lflightnum.setFont(new Font("����",Font.BOLD, 18));
		fid = new JTextField(15);
		fid.setFont(new Font("����",Font.BOLD, 18));
		fid.setOpaque(false);
		fid.addActionListener(this);
		panel1.add(Lflightnum);
		panel1.add(fid);
				
		JLabel Laid = new JLabel("�ɻ���ţ�");
		Laid.setFont(new Font("����",Font.BOLD, 18));
		aid  = new JTextField(15);
		aid .setFont(new Font("����",Font.BOLD, 18));
		aid .setOpaque(false);
		aid .addActionListener(this);
		panel1.add(Laid);
		panel1.add(aid);
		
		JLabel Lfstart = new JLabel("ʼ���أ�");
		Lfstart.setFont(new Font("����",Font.BOLD, 18));
		fstart = new JTextField(15);
		fstart.setFont(new Font("����",Font.BOLD, 18));
		fstart.setOpaque(false);
		fstart.addActionListener(this);
		panel1.add(Lfstart);
		panel1.add(fstart);
		
		JLabel Lfend  = new JLabel("Ŀ�ĵأ�");
		Lfend .setFont(new Font("����",Font.BOLD, 18));
		fend  = new JTextField(15);
		fend .setFont(new Font("����",Font.BOLD, 18));
		fend .setOpaque(false);
		fend .addActionListener(this);
		panel1.add(Lfend );
		panel1.add(fend);
		
		JLabel Lftime = new JLabel("���ʱ�䣺");
		Lftime.setFont(new Font("����",Font.BOLD, 18));
		ftime = new JTextField(15);
		ftime.setFont(new Font("����",Font.BOLD, 18));
		ftime.setOpaque(false);
		ftime.addActionListener(this);
		panel1.add(Lftime);
		panel1.add(ftime);
		
		JLabel Lfstime = new JLabel("����ʱ�䣺");
		Lfstime.setFont(new Font("����",Font.BOLD, 18));
		fstime = new JTextField(15);
		fstime.setFont(new Font("����",Font.BOLD, 18));
		fstime.setOpaque(false);
		fstime.addActionListener(this);
		panel1.add(Lfstime);
		panel1.add(fstime);
		
		JLabel Lfsdate = new JLabel("�������ڣ�");
		Lfsdate.setFont(new Font("����",Font.BOLD, 18));
		fsdate = new JTextField(15);
		fsdate.setFont(new Font("����",Font.BOLD, 18));
		fsdate.setOpaque(false);
		fsdate.addActionListener(this);
		panel1.add(Lfsdate);
		panel1.add(fsdate);
		
		JLabel Lefare = new JLabel("���ò�Ʊ�ۣ�");
		Lefare.setFont(new Font("����",Font.BOLD, 18));
		efare = new JTextField(15);
		efare.setFont(new Font("����",Font.BOLD, 18));
		efare.setOpaque(false);
		efare.addActionListener(this);
		panel1.add(Lefare);
		panel1.add(efare);
		
		JLabel Lbfare = new JLabel("�����Ʊ�ۣ�");
		Lbfare.setFont(new Font("����",Font.BOLD, 18));
		bfare = new JTextField(15);
		bfare.setFont(new Font("����",Font.BOLD, 18));
		bfare.setOpaque(false);
		bfare.addActionListener(this);
		panel1.add(Lbfare);
		panel1.add(bfare);
		
		JLabel LFfare = new JLabel("ͷ�Ȳ�Ʊ�ۣ�");
		LFfare.setFont(new Font("����",Font.BOLD, 18));
		Ffare = new JTextField(15);
		Ffare.setFont(new Font("����",Font.BOLD, 18));
		Ffare.setOpaque(false);
		Ffare.addActionListener(this);
		panel1.add(LFfare);
		panel1.add(Ffare);
		
		ok = new JButton("���");
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
		
		
		menuBar = new JMenuBar();//���ɲ˵���
		setJMenuBar(menuBar);
		menu = new JMenu("��Ϣ¼��");//������һ���˵�
		menu.setFont(new Font("����",Font.BOLD, 16));
		menu.setMnemonic(KeyEvent.VK_A);
		menuBar.add(menu);
		menuItem = new JMenuItem("������Ϣ¼��");//�����˵���
		menuItem.setFont(new Font("����",Font.BOLD, 16));
		menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1,
								ActionEvent.ALT_MASK));
		menuItem.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				  panel1.setVisible(true);
				 // panel.setVisible(true);
			}
		});
		menu.add(menuItem);
		

		menuItem = new JMenuItem("�ÿ���Ϣ¼��");//�����˵���
		menuItem.setFont(new Font("����",Font.BOLD, 16));
		menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_2,
								ActionEvent.ALT_MASK));
		menuItem.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				  //panel.setVisible(false);
				 // panel1.setVisible(true);
			}
		});
		menu.add(menuItem);
		
		menuItem = new JMenuItem("��λ��Ϣ¼��");//�����˵���
		menuItem.setFont(new Font("����",Font.BOLD, 16));
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
	

	   //ע���û������� ��1�������ȼ�����ݿ����Ƿ�����Ӧ�����ݣ�����еĻ���ʾ"���û����ڣ���ֱ�ӵ�¼��"  
    private void cheak() throws Exception  
    {         	    	
		
		String sql="insert into Flight values(?,?,?,?,?,?,?,?,?,?)";  
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
		//ִ�и��²���
		pstmt.executeUpdate();
	        
    }  
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		addInformation frame = new addInformation();
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setSize(500, 640);
		frame.setVisible(true);
		frame.setResizable(false);
		//�����Ļ��С
		Dimension screen=Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation((screen.width-300)/2,(screen.height-220)/2 - 200);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}



