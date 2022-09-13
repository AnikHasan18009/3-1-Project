import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class QuestionManagement extends JFrame {

	private JPanel contentPane;
	public static int running=0;
	private JButton btnShowQuestions;
	public static void main(String[] args) {
		
				try {
					QuestionManagement frame = new QuestionManagement();
					frame.setVisible(true);
				} catch (Exception e) {
					System.out.println(e);
				}
			}
	

	/**
	 * Create the frame.
	 */
	public QuestionManagement() {
		Border bd=BorderFactory.createLineBorder(new Color(148,0,211));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(40, 40, 1200, 600);
		contentPane = new JPanel();
		contentPane.setFocusable(false);
		contentPane.setBackground(new Color(0, 51, 102));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Add Question");
		btnNewButton.setFocusable(false);
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
		btnNewButton.setBackground(new Color(255, 102, 0));
		btnNewButton.setForeground(SystemColor.text);
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnNewButton.setBorder(null);
		btnNewButton.setBounds(0, 83, 154, 65);
		contentPane.add(btnNewButton);
		
		JButton btnUpdateQuestion = new JButton("Update Question");
		btnUpdateQuestion.setFocusable(false);
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
		btnUpdateQuestion.setForeground(SystemColor.text);
		btnUpdateQuestion.setBackground(new Color(255, 102, 0));
		btnUpdateQuestion.setBorder(null);
		btnUpdateQuestion.setBounds(0, 149, 154, 65);
		contentPane.add(btnUpdateQuestion);
		
		JButton btnDeleteQuestion = new JButton("Delete Question");
		btnDeleteQuestion.setFocusable(false);
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
		btnDeleteQuestion.setBackground(new Color(255, 102, 0));
		btnDeleteQuestion.setForeground(SystemColor.text);
		btnDeleteQuestion.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnDeleteQuestion.setBorder(null);
		btnDeleteQuestion.setBounds(0, 214, 154, 65);
		contentPane.add(btnDeleteQuestion);
		
		btnShowQuestions = new JButton("Show Questions");
		btnShowQuestions.setFocusable(false);
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
		btnShowQuestions.setBackground(new Color(255, 102, 0));
		btnShowQuestions.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnShowQuestions.setForeground(SystemColor.text);
		btnShowQuestions.setBorder(null);
		btnShowQuestions.setBounds(0, 279, 154, 65);
		contentPane.add(btnShowQuestions);
		
		JButton btnLogout = new JButton("Go Back");
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
				int decision= JOptionPane.showConfirmDialog(lout,"Do you want to go back?","",JOptionPane.YES_NO_OPTION);
				if(decision==0)
				{
					setVisible(false);
					//AdminHome.frame.setVisible(true);
					AdminHome.running=0;
					AdminHome.selected_exam="";
					AdminHome.selected=0;
					
				}}
			}
		});
		btnLogout.setBackground(new Color(255, 102, 0));
		btnLogout.setForeground(SystemColor.text);
		btnLogout.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnLogout.setBorder(null);
		btnLogout.setBounds(0, 344, 154, 65);
		contentPane.add(btnLogout);
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setText(AdminHome.selected_exam);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel.setBounds(10, 11, 1166, 38);
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 102, 0));
		panel.setBounds(0, 0, 154, 563);
		contentPane.add(panel);
	}

}
