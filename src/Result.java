import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

public class Result extends JFrame {

	private JPanel contentPane;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Result frame = new Result();
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
	public Result() {
		Border bd=BorderFactory.createLineBorder(new Color(148,0,211));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(40, 40, 1200, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 51, 102));
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		

		
		JButton btnLogout = new JButton("X");
		btnLogout.setFocusable(false);
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				
				JFrame lout= new JFrame();
				lout.setAlwaysOnTop(true);
				int decision= JOptionPane.showConfirmDialog(lout,"Do you want to exit?","Exit",JOptionPane.YES_NO_OPTION);
				if(decision==0)
				{
					setVisible(false);
					StudentHome.selected_exam="";
					StudentHome.running=0;
					Exam.correctAnswer=0;
					Exam.totalQuestions=0;
				}
			}
		});
		btnLogout.setBackground(new Color(0, 51, 102));
		btnLogout.setForeground(SystemColor.text);
		btnLogout.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnLogout.setBorder(null);
		btnLogout.setBounds(1100, 11, 62, 43);
		contentPane.add(btnLogout);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(191, 149, 87, 33);
		contentPane.add(lblNewLabel);
		
		JLabel lblId = new JLabel("ID");
		lblId.setHorizontalAlignment(SwingConstants.CENTER);
		lblId.setForeground(Color.WHITE);
		lblId.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblId.setBounds(191, 216, 87, 33);
		contentPane.add(lblId);
		
		JLabel lblDepartment = new JLabel("Department");
		lblDepartment.setForeground(Color.WHITE);
		lblDepartment.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblDepartment.setBounds(571, 216, 100, 33);
		contentPane.add(lblDepartment);
		
		JLabel lblExam = new JLabel("Exam");
		lblExam.setHorizontalAlignment(SwingConstants.CENTER);
		lblExam.setForeground(Color.WHITE);
		lblExam.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblExam.setBounds(191, 278, 87, 33);
		contentPane.add(lblExam);
		
		JLabel lblObtainedMark = new JLabel("Obtained Mark");
		lblObtainedMark.setHorizontalAlignment(SwingConstants.CENTER);
		lblObtainedMark.setForeground(Color.WHITE);
		lblObtainedMark.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblObtainedMark.setBounds(208, 352, 132, 33);
		contentPane.add(lblObtainedMark);
		
		JLabel lblTotalMark = new JLabel("Total Mark");
		lblTotalMark.setForeground(Color.WHITE);
		lblTotalMark.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTotalMark.setBounds(571, 352, 87, 33);
		contentPane.add(lblTotalMark);
		
		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("Tahoma", Font.BOLD, 16));
		textArea.setEditable(false);
		textArea.setText(StudentHome.name);
		textArea.setBounds(288, 153, 651, 27);
		contentPane.add(textArea);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		textArea_1.setEditable(false);
		textArea_1.setText(StudentLogin.id);
		textArea_1.setBounds(288, 222, 254, 27);
		contentPane.add(textArea_1);
		
		JTextArea textArea_1_1 = new JTextArea();
		textArea_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		textArea_1_1.setEditable(false);
		textArea_1_1.setText(StudentHome.dept);
		textArea_1_1.setBounds(685, 222, 254, 27);
		contentPane.add(textArea_1_1);
		
		JTextArea textArea_2 = new JTextArea();
		textArea_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		textArea_2.setEditable(false);
		textArea_2.setText(StudentHome.selected_exam);
		textArea_2.setBounds(288, 284, 651, 27);
		contentPane.add(textArea_2);
		
		JTextArea textArea_1_2 = new JTextArea();
		textArea_1_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		textArea_1_2.setEditable(false);
		textArea_1_2.setText(String.valueOf(Exam.correctAnswer));
		textArea_1_2.setBounds(350, 352, 192, 27);
		contentPane.add(textArea_1_2);
		
		JTextArea textArea_1_2_1 = new JTextArea();
		textArea_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		textArea_1_2_1.setEditable(false);
		textArea_1_2_1.setText(String.valueOf(Exam.totalQuestions));
		textArea_1_2_1.setBounds(685, 352, 254, 27);
		contentPane.add(textArea_1_2_1);
		try {
			Connection c=DBconnection.mysqlcon();	
			PreparedStatement st= c.prepareStatement("INSERT INTO `results` VALUES('"+StudentLogin.id+"','"+StudentHome.name+"','"+StudentHome.dept+"','"+StudentHome.ses+"','"+StudentHome.selected_exam+"','"+textArea_1_2_1.getText()+"','"+textArea_1_2.getText()+"','"+Exam.date+"','"+Exam.time+"');");
			st.executeUpdate();
		}
		catch(Exception ex)
		{
			JFrame er= new JFrame();
			er.setAlwaysOnTop(true);
			JOptionPane.showMessageDialog(er,ex);
		}
	}
}
