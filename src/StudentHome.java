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

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

public class StudentHome extends JFrame {

	 public static int running=0;
     public static String selected_exam ="";
     public static String name;
     public static String dept;
     public static String ses;
     public static String pass;
     public static String email;
	private JPanel contentPane;
//	public static void main(String[] args) {
//		
//				try {
//					StudentHome frame = new StudentHome();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					JFrame er= new JFrame();
//					er.setAlwaysOnTop(true);
//					JOptionPane.showMessageDialog(er,e);
//				}
//			}
		

	
	public StudentHome() {

		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(40, 40, 1200, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 51, 102));
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("My information");
		btnNewButton.setFocusable(false);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(running == 0)
				{
					running=1;
					new EditMyInfo().setVisible(true);
				}
				else {
					JFrame er= new JFrame();
					er.setAlwaysOnTop(true);
					JOptionPane.showMessageDialog(er,"One window already open!");
					
				}
				
			}
		});
		btnNewButton.setBackground(new Color(255, 102, 0));
		btnNewButton.setForeground(SystemColor.text);
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnNewButton.setBorder(null);
		btnNewButton.setBounds(0, 42, 167, 65);
		contentPane.add(btnNewButton);
		
		JButton btnUpdateQuestion = new JButton("Take an Exam");
		btnUpdateQuestion.setFocusable(false);
		btnUpdateQuestion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(running == 0)
				{
					try {
						Connection c=DBconnection.mysqlcon();
						Statement s= c.createStatement();
						ResultSet r=s.executeQuery("select * from exams");
						if(r.next())
						{
							running=1;
							new StudentExamSelector().setVisible(true);
						}
						else
						{
							JFrame er= new JFrame();
							er.setAlwaysOnTop(true);
							JOptionPane.showMessageDialog(er,"No exam is added.");
						}
					}
					catch(Exception ex)
					{
						JFrame er= new JFrame();
						er.setAlwaysOnTop(true);
						JOptionPane.showMessageDialog(er,ex);
					}
					
				}
				else {
					JFrame er= new JFrame();
					er.setAlwaysOnTop(true);
					JOptionPane.showMessageDialog(er,"One window already open!");
					
				}
			}
		});
		btnUpdateQuestion.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnUpdateQuestion.setForeground(SystemColor.text);
		btnUpdateQuestion.setBackground(new Color(255, 102, 0));
		btnUpdateQuestion.setBorder(null);
		btnUpdateQuestion.setBounds(0, 109, 167, 65);
		contentPane.add(btnUpdateQuestion);
		
		JButton btnStudentScores = new JButton("My Scores");
		btnStudentScores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(running==1)
				{
					JFrame er= new JFrame();
					er.setAlwaysOnTop(true);
					JOptionPane.showMessageDialog(er,"Close the opened window!");
				}
				else {
					running=1;
					new MyScore().setVisible(true);
				}
			}
		});
		btnStudentScores.setBounds(0, 174, 167, 65);
		contentPane.add(btnStudentScores);
		btnStudentScores.setFocusable(false);
		btnStudentScores.setBackground(new Color(255, 102, 0));
		btnStudentScores.setForeground(SystemColor.text);
		btnStudentScores.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnStudentScores.setBorder(null);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.setBounds(0, 240, 167, 65);
		contentPane.add(btnLogout);
		btnLogout.setFocusable(false);
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(running==1)
				{
					JFrame er= new JFrame();
					er.setAlwaysOnTop(true);
					JOptionPane.showMessageDialog(er,"Close the opened window!");
				}
				else {
				JFrame lout= new JFrame();
				lout.setAlwaysOnTop(true);
				int decision= JOptionPane.showConfirmDialog(lout,"Do you want to logout?","Logout",JOptionPane.YES_NO_OPTION);
				if(decision==0)
				{
					setVisible(false);
					Home.frame.setVisible(true);
				}}
			}
		});
		btnLogout.setBackground(new Color(255, 102, 0));
		btnLogout.setForeground(SystemColor.text);
		btnLogout.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnLogout.setBorder(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 102, 51));
		panel.setBounds(0, 0, 167, 563);
		contentPane.add(panel);
		try {
			Connection c=DBconnection.mysqlcon();
			Statement s= c.createStatement();
			String id=StudentLogin.id;
			ResultSet r=s.executeQuery("select * from students where id='"+id+"'");
			if(r.next())
			{
			  this.name= r.getString(2);
			  this.dept= r.getString(3);
			  this.pass= r.getString(4);
			  this.ses= r.getString(5);
			  this.email=r.getString(6);
			}
		}
		catch(Exception ex)
		{
			JFrame er= new JFrame();
			er.setAlwaysOnTop(true);
			JOptionPane.showMessageDialog(er,ex);
		}
	}
}
