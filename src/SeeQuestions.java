import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import net.proteanit.sql.DbUtils;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SeeQuestions extends JFrame {

	private JPanel contentPane;
	private JTable table;

	
	public static void main(String[] args) {
	
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SeeQuestions frame = new SeeQuestions();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SeeQuestions() {
		setAlwaysOnTop(true);
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(205, 120, 1000, 450);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(255, 255, 255));
		contentPane.setBackground(new Color(0, 51, 102));
		contentPane.setBorder(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("X");
		btnNewButton.setBorder(null);
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				QuestionManagement.running=0;
				setVisible(false);
			}
		});
		btnNewButton.setForeground(new Color(0, 51, 102));
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
			int row =table.getSelectedRow();
			String num= (table.getModel().getValueAt(row, 0)).toString();
			new QuestionShow(num).setVisible(true);
			}
		});
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		table.setRowHeight(30);
		table.setGridColor(new Color(255, 255, 255));
		table.setFont(new Font("Tahoma", Font.BOLD, 8));
		table.setBackground(new Color(0, 51, 102));
		table.setForeground(new Color(255, 255, 255));
		table.setBorder(new LineBorder(new Color(255, 255, 255), 2));
		table.setBounds(10, 56,1030 ,383);
		JScrollPane span = new JScrollPane(table);
		span.setBounds(10, 66, 980, 359);
		
		contentPane.add(span);
		try {
			Connection c=DBconnection.mysqlcon();	
			Statement s= c.createStatement();
			ResultSet r=s.executeQuery("select * from `"+AdminHome.selected_exam+"`");
		    table.setModel(DbUtils.resultSetToTableModel(r));
		    table.getColumnModel().getColumn(0).setPreferredWidth(48);
		    table.getColumnModel().getColumn(1).setPreferredWidth(159);
		    table.getColumnModel().getColumn(2).setPreferredWidth(150);
		    table.getColumnModel().getColumn(2).setMinWidth(150);
		    table.getColumnModel().getColumn(3).setPreferredWidth(150);
		    table.getColumnModel().getColumn(3).setMinWidth(150);
		    table.getColumnModel().getColumn(4).setPreferredWidth(150);
		    table.getColumnModel().getColumn(4).setMinWidth(150);
		    table.getColumnModel().getColumn(5).setPreferredWidth(150);
		    table.getColumnModel().getColumn(5).setMinWidth(150);
		    table.getColumnModel().getColumn(6).setPreferredWidth(150);
		    table.getColumnModel().getColumn(6).setMinWidth(150);
			}
			catch(Exception e)
			{
				JFrame er= new JFrame();
				er.setAlwaysOnTop(true);
				JOptionPane.showMessageDialog(er,e);
			}
	}
	}


