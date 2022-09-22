import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.*;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Insets;
import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminHome extends JFrame {
     public static int running=0;
     public static String selected_exam ="";
     public static int selected=0;
     public static JButton btnWaitingApproval;
	private JPanel contentPane;
	private JButton btnShowQuestions;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminHome frame = new AdminHome();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
				
			
	
	

	
	public AdminHome() {
		Border bd=BorderFactory.createLineBorder(new Color(148,0,211));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(40, 40, 1200, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 51, 102));
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Add an Exam");
		btnNewButton.setFocusable(false);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(running == 0)
				{
					running=1;
					new AddExam().setVisible(true);
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
		
		JButton btnUpdateQuestion = new JButton("Update an Exam");
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
							selected=1;
							new ExamSelector().setVisible(true);
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
		
		JButton btnDeleteQuestion = new JButton("Delete an Exam");
		btnDeleteQuestion.setFocusable(false);
		btnDeleteQuestion.addActionListener(new ActionListener() {
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
							new DeleteExam().setVisible(true);
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
		btnDeleteQuestion.setBackground(new Color(255, 102, 0));
		btnDeleteQuestion.setForeground(SystemColor.text);
		btnDeleteQuestion.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnDeleteQuestion.setBorder(null);
		btnDeleteQuestion.setBounds(0, 175, 167, 65);
		contentPane.add(btnDeleteQuestion);
		
		btnShowQuestions = new JButton("Enable/Dissable Exams");
		btnShowQuestions.setFocusable(false);
		btnShowQuestions.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(running == 0)
				{
					running=1;
					new ShowExams().setVisible(true);
				}
				else {
					JFrame er= new JFrame();
					er.setAlwaysOnTop(true);
					JOptionPane.showMessageDialog(er,"One window already open!");
					
				}
			}
		});
		btnShowQuestions.setBackground(new Color(255, 102, 0));
		btnShowQuestions.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnShowQuestions.setForeground(SystemColor.text);
		btnShowQuestions.setBorder(null);
		btnShowQuestions.setBounds(0, 241, 167, 65);
		contentPane.add(btnShowQuestions);
		
		JButton btnStudentScores = new JButton("Student Scores");
		btnStudentScores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(running == 0)
				{
							running=1;
							selected=2;
							new ExamSelector().setVisible(true);
					
					
				}
				else {
					JFrame er= new JFrame();
					er.setAlwaysOnTop(true);
					JOptionPane.showMessageDialog(er,"One window already open!");
					
				}
			}
		});
		btnStudentScores.setFocusable(false);
		btnStudentScores.setBackground(new Color(255, 102, 0));
		btnStudentScores.setForeground(SystemColor.text);
		btnStudentScores.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnStudentScores.setBorder(null);
		btnStudentScores.setBounds(0, 307, 167, 65);
		contentPane.add(btnStudentScores);
		
		JButton btnLogout = new JButton("Logout");
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
		btnLogout.setBounds(0, 440, 167, 65);
		contentPane.add(btnLogout);
		
		btnWaitingApproval = new JButton("Waiting Approval");
		btnWaitingApproval.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(running == 0)
				{
							running=1;
							
							new WaitingApproval().setVisible(true);
					
					
				}
				else {
					JFrame er= new JFrame();
					er.setAlwaysOnTop(true);
					JOptionPane.showMessageDialog(er,"One window already open!");
					
				}
			}
		});
		
		btnWaitingApproval.setForeground(Color.WHITE);
		btnWaitingApproval.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnWaitingApproval.setFocusable(false);
		btnWaitingApproval.setBorder(null);
		btnWaitingApproval.setBackground(new Color(255, 102, 0));
		btnWaitingApproval.setBounds(0, 373, 167, 65);
		try {
			Connection c=DBconnection.mysqlcon();
			Statement s= c.createStatement();
			ResultSet r=s.executeQuery("select count(*) from `waiting approval`");
			r.next();
			String n=r.getString(1);
			if(!n.equals("0"))
			{
				btnWaitingApproval.setText("Waiting Approval("+n+")");
			}
			else
			{
				btnWaitingApproval.setText("Waiting Approval");
			}
		
		}
		catch(Exception ex)
		{
			JFrame er= new JFrame();
			er.setAlwaysOnTop(true);
			JOptionPane.showMessageDialog(er,ex);
		}
		contentPane.add(btnWaitingApproval);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 102, 51));
		panel.setBounds(0, 0, 167, 563);
		contentPane.add(panel);
	}
}
