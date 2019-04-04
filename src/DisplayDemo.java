import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class DisplayDemo extends JFrame{

	//�ҵ����ݿ������Ϣ
	String driverName="com.microsoft.sqlserver.jdbc.SQLServerDriver";
	String dbURL="jdbc:sqlserver://127.0.0.1:1433;DatabaseName=ATS";
	String userName="sa";
	String userPwd="123";
	String sqlstr =  "select * from Flight";
	
	private JTable table;
	
	public DisplayDemo(String sqlstr){
		
		super("��ѯ��Ʊ");
		this.sqlstr=sqlstr;
		if(sqlstr.equals("2018/12/23"))
			this.sqlstr = "select * from Flight";
		else
			this.sqlstr = sqlstr;
		
		//����
		String[] colname = {"������", "�ɻ����", "ʼ����", "Ŀ�ĵ�", "�������", 
							"���ʱ��", "����ʱ��", "���ò�Ʊ��", "�����Ʊ��", "ͷ�Ȳ�Ʊ��"};
		Object[][] rowData = new Object[10][10];//������ݣ�����С
		
		try{
			
			//��������
			Class.forName(driverName);
			//��ȡ����
			Connection con = DriverManager.getConnection(dbURL, userName, userPwd);
			//���ӳɹ�����ʼ��ѯ��䣬��ѯ��
			String sqlstr1 = sqlstr;
			//��ȡPreparedStatement����
			PreparedStatement ps = con.prepareStatement(sqlstr1);
			//ִ�в�ѯ
			ResultSet rs = ps.executeQuery();
			
			//countʵ�ּ���
			int count = 0;
			
			//��ÿһ�е�����������ʾ���������С�1,2,3,4,5,6,7,8,9,10����ʾ����
			while(rs.next()){
				rowData[count][0] = rs.getString(1);
				rowData[count][1] = rs.getString(2);
				rowData[count][2] = rs.getString(3);
				rowData[count][3] = rs.getString(4);
				rowData[count][4] = rs.getString(5);
				rowData[count][5] = rs.getString(6);
				rowData[count][6] = rs.getString(7);
				rowData[count][7] = rs.getString(8);
				rowData[count][8] = rs.getString(9);
				rowData[count][9] = rs.getString(10);
				count ++;
			}
			con.close();//�ر�����
		}catch(Exception e){
			e.printStackTrace();
		}
		
		//�������
		JPanel panel = (JPanel)this.getContentPane();
	    panel.setBorder(new EmptyBorder(30, 30, 30, 30));
	    
		table = new JTable(rowData, colname);//ʵ�������
		table.setRowHeight(40);
		table.setFont(new Font("΢���ź�",Font.PLAIN,18));
		
		//������ʾ
		DefaultTableCellRenderer r = new DefaultTableCellRenderer();   
		r.setHorizontalAlignment(JLabel.CENTER);   
		table.setDefaultRenderer(Object.class, r);
	
		//���ñ�ͷ
		JTableHeader header=table.getTableHeader();
        header.setFont(new Font("΢���ź�",Font.PLAIN,18)); 
        
        JButton gopay = new JButton("���빺��");
        gopay.setContentAreaFilled(false);
        gopay.setFont(new Font("΢���ź�",Font.PLAIN, 18));
        
        //��gopay�����빺�򣩼���װ�����¼������������֧������
        gopay.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				Payment payment = new Payment();
				payment.setSize(800, 320);
				Dimension screen=Toolkit.getDefaultToolkit().getScreenSize();
				payment.setVisible(true);
			}
		});
        
        panel.add(new JScrollPane(table), BorderLayout.CENTER);
        panel.add(gopay, BorderLayout.SOUTH);
		
		setSize(1200,600);
		validate();
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new DisplayDemo("");
	}

}

