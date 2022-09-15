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
import javax.swing.table.DefaultTableModel;

public class ShowExams extends JFrame {

	
	private JPanel contentPane;
	public static JTable table;
    public static int running=0;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
				try {
					ShowExams frame = new ShowExams();
					frame.setVisible(true);
				} catch (Exception e) {
					JFrame er= new JFrame();
					er.setAlwaysOnTop(true);
					JOptionPane.showMessageDialog(er,e);
				}
	}

	/**
	 * Create the frame.
	 */
	public ShowExams() {
		setAlwaysOnTop(true);
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(250, 120, 650, 450);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(255, 255, 255));
		contentPane.setBackground(new Color(0, 51, 102));
		contentPane.setBorder(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("X");
		btnNewButton.setFocusable(false);
		btnNewButton.setBorder(null);
		btnNewButton.setBackground(new Color(0, 51, 102));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminHome.running=0;
				setVisible(false);
			}
		});
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setBounds(594, 29, 40, 23);
		contentPane.add(btnNewButton);
		
		table = new JTable();
		table.setFocusable(false);
		table.getTableHeader().setBackground(new Color(0,51,102));
		table.getTableHeader().setForeground(Color.WHITE);
		table.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 14));
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		table.setRowHeight(30);
		table.setGridColor(new Color(255, 255, 255));
		table.setFont(new Font("Tahoma", Font.BOLD, 14));
		table.setBackground(new Color(0, 51, 102));
		table.setForeground(new Color(255, 255, 255));
		table.setBorder(new LineBorder(new Color(255, 255, 255), 2));
		table.setBounds(10, 56,1030 ,383);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(running==0) {
					running=1;
			int row =table.getSelectedRow();
			String exam= (table.getModel().getValueAt(row, 0)).toString();
			table.enable(false);
			new ExamEnableDissable(exam).setVisible(true);
				}
			}
		});
		JScrollPane span = new JScrollPane(table);
		span.setBounds(225, 63, 409, 359);
		
		contentPane.add(span);
		try {
			Connection c=DBconnection.mysqlcon();	
			Statement s= c.createStatement();
			ResultSet r=s.executeQuery("select * from `exams`");
		    table.setModel(new DefaultTableModel(
		    	new Object[][] {
		    		{"python"},
		    		{"java"},
		    		{"c++"},
		    	},
		    	new String[] {
		    		"name"
		    	}
		    ) {
		    	boolean[] columnEditables = new boolean[] {
		    		false
		    	};
		    	public boolean isCellEditable(int row, int column) {
		    		return columnEditables[column];
		    	}
		    });
		    table.getColumnModel().getColumn(0).setResizable(false);
		    table.getColumnModel().getColumn(0).setPreferredWidth(100);
		   
			}
			catch(Exception e)
			{
				JFrame er= new JFrame();
				er.setAlwaysOnTop(true);
				JOptionPane.showMessageDialog(er,e);
			}
	}

}
