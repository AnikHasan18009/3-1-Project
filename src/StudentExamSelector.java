import java.awt.BorderLayout;
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
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class StudentExamSelector extends JFrame {

	private JPanel contentPane;


//	public static void main(String[] args) {
//		
//				try {
//					StudentExamSelector frame = new StudentExamSelector();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					JFrame er= new JFrame();
//					er.setAlwaysOnTop(true);
//					JOptionPane.showMessageDialog(er,e);
//				}
//		
//	}


	public StudentExamSelector() {
		setBackground(SystemColor.inactiveCaption);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 120, 632, 436);
		setUndecorated(true);
		contentPane = new JPanel();
		contentPane.setFocusable(false);
		contentPane.setBackground(new Color(0, 51, 102));
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setAlwaysOnTop(true);
		JLabel lblNewLabel = new JLabel("Select an Exam");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel.setBounds(88, 50, 426, 60);
		contentPane.add(lblNewLabel);;
		String[] st= {};
		JComboBox comboBox = new JComboBox(st);
		comboBox.setMaximumRowCount(5);
		comboBox.setFocusable(false);
	
		try {
			Connection c=DBconnection.mysqlcon();
			Statement s= c.createStatement();
			ResultSet r=s.executeQuery("select * from `enabled exams`");
			while(r.next())
					{
				String n=r.getString(1);
				comboBox.addItem(n);
					}
		}
		catch(Exception e)
		{
			JFrame er= new JFrame();
			er.setAlwaysOnTop(true);
			JOptionPane.showMessageDialog(er,e);
		}
		comboBox.setBorder(null);
		comboBox.setFont(new Font("Times New Roman", Font.BOLD, 18));
		comboBox.setBackground(Color.WHITE);
		comboBox.setBounds(88, 139, 426, 39);
		contentPane.add(comboBox);
		
		JButton btnNewButton = new JButton("Start Exam");
		btnNewButton.setFocusable(false);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				   String n=String.valueOf(comboBox.getSelectedItem());
				   StudentHome.selected_exam=n;
				   Connection c=DBconnection.mysqlcon();
				   Statement s= c.createStatement();
				   ResultSet r=s.executeQuery("select * from `"+n+"`");
				   if(r.next()) {
				   setVisible(false);
				   new Exam().setVisible(true);
				   }
				   else {
					   JFrame er= new JFrame();
						er.setAlwaysOnTop(true);
						JOptionPane.showMessageDialog(er,"No question is added for the exam.");
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
		btnNewButton.setForeground(new Color(0, 51, 102));
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnNewButton.setBorder(null);
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setBounds(177, 291, 257, 39);
		contentPane.add(btnNewButton);
		
		JButton btnClose = new JButton("X");
		btnClose.setFocusable(false);
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StudentHome.running=0;
				setVisible(false);
			}
		});
		btnClose.setBorder(null);
		btnClose.setBackground(new Color(0, 51, 102));
		btnClose.setForeground(Color.WHITE);
		btnClose.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnClose.setBounds(559, 11, 63, 39);
		contentPane.add(btnClose);
	}

}
