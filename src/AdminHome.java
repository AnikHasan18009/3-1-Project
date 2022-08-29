import java.awt.BorderLayout;
import java.awt.EventQueue;

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
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminHome extends JFrame {
     public static int running=0;
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

	/**
	 * Create the frame.
	 */
	public AdminHome() {
		Border bd=BorderFactory.createLineBorder(new Color(148,0,211));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(40, 40, 1200, 600);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.desktop);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Add Question");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(running == 0)
				{
					running=1;
					new AddQuestion().setVisible(true);
				}
				else {
					JFrame er= new JFrame();
					er.setAlwaysOnTop(true);
					JOptionPane.showMessageDialog(er,"One window already open!");
					
				}
				
			}
		});
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setForeground(new Color(148, 0, 211));
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnNewButton.setBorder(new LineBorder(new Color(148, 0, 211), 3));
		btnNewButton.setBounds(0, 42, 120, 65);
		contentPane.add(btnNewButton);
		
		JButton btnUpdateQuestion = new JButton("Update Question");
		btnUpdateQuestion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(running == 0)
				{
					running=1;
					new UpdateQuestion().setVisible(true);
				}
				else {
					JFrame er= new JFrame();
					er.setAlwaysOnTop(true);
					JOptionPane.showMessageDialog(er,"One window already open!");
					
				}
			}
		});
		btnUpdateQuestion.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnUpdateQuestion.setForeground(new Color(148, 0, 211));
		btnUpdateQuestion.setBackground(new Color(255, 255, 255));
		btnUpdateQuestion.setBorder(new LineBorder(new Color(148, 0, 211), 3));
		btnUpdateQuestion.setBounds(0, 109, 120, 65);
		contentPane.add(btnUpdateQuestion);
		
		JButton btnDeleteQuestion = new JButton("Delete Question");
		btnDeleteQuestion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(running == 0)
				{
					running=1;
					new DeleteQuestion().setVisible(true);
				}
				else {
					JFrame er= new JFrame();
					er.setAlwaysOnTop(true);
					JOptionPane.showMessageDialog(er,"One window already open!");
					
				}
				
			}
		});
		btnDeleteQuestion.setBackground(new Color(255, 255, 255));
		btnDeleteQuestion.setForeground(new Color(148, 0, 211));
		btnDeleteQuestion.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnDeleteQuestion.setBorder(new LineBorder(new Color(148, 0, 211), 3));
		btnDeleteQuestion.setBounds(0, 175, 120, 65);
		contentPane.add(btnDeleteQuestion);
		
		btnShowQuestions = new JButton("Show Questions");
		btnShowQuestions.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(running == 0)
				{
					running=1;
					new SeeQuestions().setVisible(true);
				}
				else {
					JFrame er= new JFrame();
					er.setAlwaysOnTop(true);
					JOptionPane.showMessageDialog(er,"One window already open!");
					
				}
			}
		});
		btnShowQuestions.setBackground(new Color(255, 255, 255));
		btnShowQuestions.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnShowQuestions.setForeground(new Color(148, 0, 211));
		btnShowQuestions.setBorder(new LineBorder(new Color(148, 0, 211), 3));
		btnShowQuestions.setBounds(0, 241, 120, 65);
		contentPane.add(btnShowQuestions);
		
		JButton btnStudentScores = new JButton("Student Scores");
		btnStudentScores.setBackground(new Color(255, 255, 255));
		btnStudentScores.setForeground(new Color(148, 0, 211));
		btnStudentScores.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnStudentScores.setBorder(new LineBorder(new Color(148, 0, 211), 3));
		btnStudentScores.setBounds(0, 307, 120, 65);
		contentPane.add(btnStudentScores);
		
		JButton btnLogout = new JButton("Logout");
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
					new AdminLogin().setVisible(true);
				}}
			}
		});
		btnLogout.setBackground(new Color(255, 255, 255));
		btnLogout.setForeground(new Color(148, 0, 211));
		btnLogout.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnLogout.setBorder(new LineBorder(new Color(148, 0, 211), 3));
		btnLogout.setBounds(0, 373, 120, 65);
		contentPane.add(btnLogout);
	}
}
