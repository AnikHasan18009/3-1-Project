import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;

public class ExamSelector extends JFrame {

	private JPanel contentPane;

	public static void main(String[] args) {
		
				try {
					ExamSelector frame = new ExamSelector();
					frame.setVisible(true);
				} catch (Exception e) {
				System.out.println(e);
				}
			}
	
	

	/**
	 * Create the frame.
	 */
	public ExamSelector() {
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
			ResultSet r=s.executeQuery("select * from exams");
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
		
		JButton btnNewButton = new JButton("Select");
		btnNewButton.setFocusable(false);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				   String n=String.valueOf(comboBox.getSelectedItem());
				   setVisible(false);
				   AdminHome.selected_exam=n;
				   if(AdminHome.selected==1)
				   {
				   new QuestionManagement().setVisible(true);
				   }
				   else if(AdminHome.selected==2)
				   {
					   new StudentScores().setVisible(true);
					   
				   }
			}
		});
		btnNewButton.setForeground(new Color(0, 51, 102));
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnNewButton.setBorder(null);
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setBounds(101, 357, 113, 39);
		contentPane.add(btnNewButton);
		
		JButton btnClose = new JButton("Close");
		btnClose.setFocusable(false);
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminHome.running=0;
				AdminHome.selected=0;
				setVisible(false);
			}
		});
		btnClose.setBorder(null);
		btnClose.setBackground(new Color(255, 255, 255));
		btnClose.setForeground(new Color(0, 51, 102));
		btnClose.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnClose.setBounds(382, 357, 113, 39);
		contentPane.add(btnClose);
	}
}
