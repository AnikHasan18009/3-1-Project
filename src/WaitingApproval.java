import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import net.proteanit.sql.DbUtils;

public class WaitingApproval extends JFrame {
   public static int running=0;
	private JPanel contentPane;
	public static JTable table;
//	public static void main(String[] args) {
//		
//				try {
//					WaitingApproval frame = new WaitingApproval();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					JFrame er= new JFrame();
//					er.setAlwaysOnTop(true);
//					JOptionPane.showMessageDialog(er,e);
//				}
//			}
		
	
	public WaitingApproval() {
		setAlwaysOnTop(true);
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(225, 120, 1000, 450);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(255, 255, 255));
		contentPane.setBackground(new Color(0, 51, 102));
		contentPane.setBorder(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("X");
		btnNewButton.setBorder(null);
		btnNewButton.setBackground(new Color(0, 51, 102));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminHome.running=0;
				setVisible(false);
				try {
					Connection c=DBconnection.mysqlcon();	
					Statement s= c.createStatement();
					ResultSet r=s.executeQuery("select count(*) from `waiting approval`");
					r.next();
					String n=r.getString(1);
					if(!n.equals("0"))
					{
						AdminHome.btnWaitingApproval.setText("Waiting Approval("+n+")");	
					}
					else {
						AdminHome.btnWaitingApproval.setText("Waiting Approval");
					}
				}
				catch(Exception ex)
				{
					JFrame er= new JFrame();
					er.setAlwaysOnTop(true);
					JOptionPane.showMessageDialog(er,ex);
				}
			}
		});
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(950, 15, 40, 23);
		contentPane.add(btnNewButton);
		
		table = new JTable();
		table.getTableHeader().setBackground(new Color(0,51,102));
		table.getTableHeader().setForeground(Color.WHITE);
		table.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 12));
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			if(running==0) {
				running =1;
			int row =table.getSelectedRow();
			String pass="";
			String id= (table.getModel().getValueAt(row, 0)).toString();
			String name= (table.getModel().getValueAt(row, 1)).toString();
			String dept= (table.getModel().getValueAt(row, 2)).toString();
			String ses= (table.getModel().getValueAt(row, 3)).toString();
			String email= (table.getModel().getValueAt(row, 4)).toString();
			try {
				Connection c=DBconnection.mysqlcon();	
				Statement s= c.createStatement();
				ResultSet r=s.executeQuery("select password from `waiting approval` where id='"+id+"'");
				r.next();
				pass=r.getString(1);
				table.enable(false);
				new ApproveDisapprove(id,name,dept,ses,email,pass).setVisible(true);	
				 s= c.createStatement();
				 r=s.executeQuery("select id,name,dept,session,email from `waiting approval`");
				table.setModel(DbUtils.resultSetToTableModel(r));
				table.getColumnModel().getColumn(0).setPreferredWidth(40);
				table.getColumnModel().getColumn(1).setPreferredWidth(100);
				table.getColumnModel().getColumn(2).setPreferredWidth(80);
				table.getColumnModel().getColumn(2).setMinWidth(70);
				table.getColumnModel().getColumn(3).setPreferredWidth(40);
				table.getColumnModel().getColumn(3).setMinWidth(40);
				table.getColumnModel().getColumn(4).setPreferredWidth(100);
				table.getColumnModel().getColumn(4).setMinWidth(50);
			}
			catch(Exception ex)
			{
				JFrame er= new JFrame();
				er.setAlwaysOnTop(true);
				JOptionPane.showMessageDialog(er,ex);
			}
			
			}
			}
		});
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		table.setRowHeight(30);
		table.setGridColor(Color.BLACK);
		table.setFont(new Font("Tahoma", Font.BOLD, 8));
		table.setBackground(Color.WHITE);
		table.setForeground(Color.BLACK);
		table.setBorder(new LineBorder(new Color(0,0,0), 2));
		table.setBounds(10, 56,1030 ,383);
		JScrollPane span = new JScrollPane(table);
		span.setBounds(10, 66, 980, 359);
		
		contentPane.add(span);
		try {
			Connection c=DBconnection.mysqlcon();	
			Statement s= c.createStatement();
			ResultSet r=s.executeQuery("select id,name,dept,session,email from `waiting approval`");
		    table.setModel(DbUtils.resultSetToTableModel(r));
		    table.getColumnModel().getColumn(0).setPreferredWidth(40);
		    table.getColumnModel().getColumn(1).setPreferredWidth(100);
		    table.getColumnModel().getColumn(2).setPreferredWidth(80);
		    table.getColumnModel().getColumn(2).setMinWidth(70);
		    table.getColumnModel().getColumn(3).setPreferredWidth(40);
		    table.getColumnModel().getColumn(3).setMinWidth(40);
		    table.getColumnModel().getColumn(4).setPreferredWidth(100);
		    table.getColumnModel().getColumn(4).setMinWidth(50);
		   
		    
			}
			catch(Exception e)
			{
				JFrame er= new JFrame();
				er.setAlwaysOnTop(true);
				JOptionPane.showMessageDialog(er,e);
			}
	}

}
