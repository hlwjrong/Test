import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class DisplayDemo extends JFrame{

	//找到数据库相关信息
	String driverName="com.microsoft.sqlserver.jdbc.SQLServerDriver";
	String dbURL="jdbc:sqlserver://127.0.0.1:1433;DatabaseName=ATS";
	String userName="sa";
	String userPwd="123";
	String sqlstr =  "select * from Flight";
	
	private JTable table;
	
	public DisplayDemo(String sqlstr){
		
		super("查询购票");
		this.sqlstr=sqlstr;
		if(sqlstr.equals("2018/12/23"))
			this.sqlstr = "select * from Flight";
		else
			this.sqlstr = sqlstr;
		
		//列名
		String[] colname = {"航班编号", "飞机编号", "始发地", "目的地", "起飞日期", 
							"起飞时间", "飞行时间", "经济舱票价", "商务舱票价", "头等舱票价"};
		Object[][] rowData = new Object[10][10];//表格数据，表格大小
		
		try{
			
			//加载驱动
			Class.forName(driverName);
			//获取连接
			Connection con = DriverManager.getConnection(dbURL, userName, userPwd);
			//连接成功，开始查询语句，查询航
			String sqlstr1 = sqlstr;
			//获取PreparedStatement对象
			PreparedStatement ps = con.prepareStatement(sqlstr1);
			//执行查询
			ResultSet rs = ps.executeQuery();
			
			//count实现计数
			int count = 0;
			
			//将每一列的内容逐行显示出来，其中“1,2,3,4,5,6,7,8,9,10”表示列名
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
			con.close();//关闭连接
		}catch(Exception e){
			e.printStackTrace();
		}
		
		//界面设计
		JPanel panel = (JPanel)this.getContentPane();
	    panel.setBorder(new EmptyBorder(30, 30, 30, 30));
	    
		table = new JTable(rowData, colname);//实例化表格
		table.setRowHeight(40);
		table.setFont(new Font("微软雅黑",Font.PLAIN,18));
		
		//居中显示
		DefaultTableCellRenderer r = new DefaultTableCellRenderer();   
		r.setHorizontalAlignment(JLabel.CENTER);   
		table.setDefaultRenderer(Object.class, r);
	
		//设置表头
		JTableHeader header=table.getTableHeader();
        header.setFont(new Font("微软雅黑",Font.PLAIN,18)); 
        
        JButton gopay = new JButton("进入购买");
        gopay.setContentAreaFilled(false);
        gopay.setFont(new Font("微软雅黑",Font.PLAIN, 18));
        
        //给gopay（进入购买）键安装监听事件，点击即进入支付界面
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

