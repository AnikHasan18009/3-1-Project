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
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.table.DefaultTableModel;

public class StudentScores extends JFrame {
    public static int running=0;
	private JPanel contentPane;
	public static JTable table;
	private JTextField textField;
//	public static void main(String[] args) {
//		
//				try {
//					StudentScores frame = new StudentScores();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					JFrame er= new JFrame();
//					er.setAlwaysOnTop(true);
//					JOptionPane.showMessageDialog(er,e);
//				}
//			
//	}

	
	public StudentScores() {
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
				AdminHome.selected=2;
				AdminHome.selected_exam="";
				setVisible(false);
				new ExamSelector().setVisible(true);
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
					running=1;
			int row =table.getSelectedRow();
			String id= (table.getModel().getValueAt(row, 0)).toString();
			String name= (table.getModel().getValueAt(row, 1)).toString();
			String dept= (table.getModel().getValueAt(row, 2)).toString();
			String ses= (table.getModel().getValueAt(row, 3)).toString();
			String date= (table.getModel().getValueAt(row, 7)).toString();
			String time= (table.getModel().getValueAt(row, 8)).toString();
			String exam= (table.getModel().getValueAt(row, 4)).toString();
			String tmark= (table.getModel().getValueAt(row, 5)).toString();
			String omark= (table.getModel().getValueAt(row, 6)).toString();
			table.enable(false);
			new Score(name,id,dept,ses,exam,tmark,omark,date,time).setVisible(true);
				}
			}
		});
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		table.setRowHeight(30);
		table.setGridColor(Color.BLACK);
		table.setFont(new Font("Tahoma", Font.BOLD, 8));
		table.setBackground(Color.WHITE);
		table.setForeground(Color.BLACK);
		table.setBorder(null);
		table.setBounds(10, 56,1030 ,383);
		JScrollPane span = new JScrollPane(table);
		span.setBounds(10, 66, 980, 359);
		
		contentPane.add(span);
		try {
			Connection c=DBconnection.mysqlcon();	
			Statement s= c.createStatement();
			ResultSet r=s.executeQuery("select id,name,department,session,exam,`total mark`,`obtained mark`,date,time from `results` where exam='"+AdminHome.selected_exam+"'");
			table.setModel(DbUtils.resultSetToTableModel(r));
		    table.getColumnModel().getColumn(0).setPreferredWidth(50);
		    table.getColumnModel().getColumn(1).setPreferredWidth(150);
		    table.getColumnModel().getColumn(2).setPreferredWidth(70);
		    table.getColumnModel().getColumn(2).setMinWidth(70);
		    table.getColumnModel().getColumn(3).setPreferredWidth(50);
		    table.getColumnModel().getColumn(3).setMinWidth(50);
		    table.getColumnModel().getColumn(4).setPreferredWidth(100);
		    table.getColumnModel().getColumn(4).setMinWidth(100);
		    table.getColumnModel().getColumn(5).setPreferredWidth(50);
		    table.getColumnModel().getColumn(5).setMinWidth(30);
		    table.getColumnModel().getColumn(6).setPreferredWidth(50);
		    table.getColumnModel().getColumn(6).setMinWidth(30);
		    table.getColumnModel().getColumn(7).setPreferredWidth(30);
		    table.getColumnModel().getColumn(7).setMinWidth(30);
		    table.getColumnModel().getColumn(8).setPreferredWidth(30);
		    table.getColumnModel().getColumn(8).setMinWidth(30);
		    
		    JLabel lblNewLabel = new JLabel("Student ID");
		    lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		    lblNewLabel.setForeground(Color.WHITE);
		    lblNewLabel.setBounds(360, 21, 76, 14);
		    contentPane.add(lblNewLabel);
		    
		    textField = new JTextField();
		    textField.addKeyListener(new KeyAdapter() {
		    	@Override
		    	public void keyReleased(KeyEvent e) {
		    		try {
		    			Connection c=DBconnection.mysqlcon();	
		    			Statement s= c.createStatement();
		    			
		    			String sid=textField.getText();
		    		if(sid.equals(""))
		    		{
		    			ResultSet r=s.executeQuery("select id,name,department,session,exam,`total mark`,`obtained mark`,date,time from `results` where exam='"+AdminHome.selected_exam+"'");
		    		    table.setModel(DbUtils.resultSetToTableModel(r));
		    		}
		    		else {

		    			ResultSet r=s.executeQuery("select * from `results` where exam='"+AdminHome.selected_exam+"' and id='"+sid+"'");
		    			if(r.next()) {
		    			int serial=r.getInt(10);
		    			int l1=serial-10,u1=serial,l2=serial+1,u2=serial+10;
		    			ResultSet r2=s.executeQuery("(select id,name,department,session,exam,`total mark`,`obtained mark`,date,time from `results` where exam='"+AdminHome.selected_exam+"' and serial between "+String.valueOf(l1)+" and "+String.valueOf(u1)+" limit 11) union" 
		    					+"(select id,name,department,session,exam,`total mark`,`obtained mark`,date,time from `results` where exam='"+AdminHome.selected_exam+"' and serial between "+String.valueOf(l2)+" and "+String.valueOf(u2)+" limit 10)");
		    			
		    		    table.setModel(DbUtils.resultSetToTableModel(r2));
		    		    
		    		    DefaultTableModel model =(DefaultTableModel)table.getModel();
		    		    
		    		    for (int i = 0; i < table.getRowCount(); i++) {
		    		         if(table.getValueAt(i, 0).equals(sid))
		    		        	 {
		    		        	 table.addRowSelectionInterval(i, i);
		    		        	 table.setSelectionBackground(new Color(0,51,102));
		    		        	 table.setSelectionForeground(Color.WHITE);
		                         
		    		        	 }
		    		       
		    		        }
		    			}
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
		    textField.setFont(new Font("Tahoma", Font.BOLD, 14));
		    textField.setBounds(445, 18, 141, 20);
		    contentPane.add(textField);
		    textField.setColumns(10);
			}
			catch(Exception e)
			{
				JFrame er= new JFrame();
				er.setAlwaysOnTop(true);
				JOptionPane.showMessageDialog(er,e);
			}
	}
}
