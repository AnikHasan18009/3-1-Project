import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties; 
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class ApproveDisapprove extends JFrame {

	private JPanel contentPane;

	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
	}

	/**
	 * Create the frame.
	 */
	public ApproveDisapprove(String id,String name,String dept,String ses,String email,String pass) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setBounds(20, 120, 800, 400);
		setBounds(225, 120, 1000, 450);
		setAlwaysOnTop(true);
		setUndecorated(true);
		contentPane = new JPanel();
		contentPane.setForeground(SystemColor.activeCaptionText);
		contentPane.setBackground(new Color(0, 51, 102));
		
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("Student ID");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(SystemColor.text);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(26, 211, 112, 14);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField.setBorder(null);
		textField.setBounds(154, 204, 248, 30);
		textField.setEditable(false);
		textField.setText(id);
		textField.setEditable(false);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton approve = new JButton("Approve");
		approve.setBorder(null);
		approve.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					MimeMessage message= sendMail.getmessage();
					message.setFrom(new InternetAddress("mcq.exam.application@gmail.com"));
					message.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
					
					message.setSubject("Registered Succesfully!");
					message.setContent(" <h3 textalign=\"center\">Welcome!\r\n"
							+name+ "</h3> <h3>\r\n"
							+ " Now you can login to the application.</h3>","text/html");
					Transport.send(message);
					JFrame mess= new JFrame();
					mess.setAlwaysOnTop(true);
					Connection c=DBconnection.mysqlcon();		
					PreparedStatement st= c.prepareStatement("delete from `waiting approval` where id='"+id+"' or email='"+email+"'");
					st.executeUpdate();
					st= c.prepareStatement("INSERT INTO students VALUES('"+id+"','"+name+"','"+dept+"','"+pass+"','"+ses+"','"+email+"')");
					st.executeUpdate();
					JOptionPane.showMessageDialog(mess,"Student Approved.");
					WaitingApproval.running=0;
					WaitingApproval.table.enable(true);
					setVisible(false);
				}
					catch(Exception ex)
					{
						JFrame er= new JFrame();
						er.setAlwaysOnTop(true);
						JOptionPane.showMessageDialog(er,ex);
						setVisible(false);
					}
			
				
			}
		});
		approve.setBackground(SystemColor.window);
		approve.setFont(new Font("Times New Roman", Font.BOLD, 11));
		approve.setForeground(new Color(0, 51, 102));
		approve.setBounds(235, 389, 157, 23);
		contentPane.add(approve);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		textField_1.setColumns(10);
		textField_1.setBorder(null);
		textField_1.setText(name);
		textField_1.setEditable(false);
		textField_1.setBounds(154, 72, 696, 30);
		contentPane.add(textField_1);
		
		JLabel lblStudentName = new JLabel("Student Name");
		lblStudentName.setHorizontalAlignment(SwingConstants.CENTER);
		lblStudentName.setForeground(Color.WHITE);
		lblStudentName.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblStudentName.setBounds(10, 80, 136, 14);
		contentPane.add(lblStudentName);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField_2.setColumns(10);
		textField_2.setBorder(null);
		textField_2.setText(dept);
		textField_2.setEditable(false);
		textField_2.setBounds(602, 204, 248, 30);
		contentPane.add(textField_2);
		
		JLabel lblDepartment = new JLabel("Department");
		lblDepartment.setHorizontalAlignment(SwingConstants.CENTER);
		lblDepartment.setForeground(Color.WHITE);
		lblDepartment.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblDepartment.setBounds(456, 211, 136, 14);
		contentPane.add(lblDepartment);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField_3.setColumns(10);
		textField_3.setBorder(null);
		textField_3.setBounds(154, 276, 248, 30);
		textField_3.setText(ses);
		textField_3.setEditable(false);
		contentPane.add(textField_3);
		
		JLabel lblSession = new JLabel("Session");
		lblSession.setHorizontalAlignment(SwingConstants.CENTER);
		lblSession.setForeground(Color.WHITE);
		lblSession.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblSession.setBounds(26, 282, 112, 14);
		contentPane.add(lblSession);
		
		JButton btnNewButton_1 = new JButton("X");
		btnNewButton_1.setBounds(846, 11, 30, 30);
		contentPane.add(btnNewButton_1);
		btnNewButton_1.setFocusable(false);
		btnNewButton_1.setBorder(null);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				WaitingApproval.running=0;
				WaitingApproval.table.enable(true);
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton_1.setForeground(SystemColor.text);
		btnNewButton_1.setBackground(new Color(0, 51, 102));
		
		textField_4 = new JTextField();
		textField_4.setText((String) null);
		textField_4.setFont(new Font("Tahoma", Font.BOLD, 16));
		textField_4.setColumns(10);
		textField_4.setText(email);
		textField_4.setBorder(null);
		textField_4.setEditable(false);
		textField_4.setBounds(154, 136, 696, 30);
		contentPane.add(textField_4);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmail.setForeground(Color.WHITE);
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblEmail.setBounds(10, 144, 136, 14);
		contentPane.add(lblEmail);
		
		JButton disapprove = new JButton("Disapprove");
		disapprove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection c=DBconnection.mysqlcon();		
					PreparedStatement st= c.prepareStatement("delete from `waiting approval` where id='"+id+"'");
					st.executeUpdate();
					
					JFrame mess= new JFrame();
					mess.setAlwaysOnTop(true);
					JOptionPane.showMessageDialog(mess,"Student Disapproved.");
					WaitingApproval.running=0;
					WaitingApproval.table.enable(true);
					setVisible(false);
				}
					catch(Exception ex)
					{
						JFrame er= new JFrame();
						er.setAlwaysOnTop(true);
						JOptionPane.showMessageDialog(er,ex);
						setVisible(false);
					}
			}
		});
		disapprove.setForeground(new Color(0, 51, 102));
		disapprove.setFont(new Font("Times New Roman", Font.BOLD, 11));
		disapprove.setBorder(null);
		disapprove.setBackground(Color.WHITE);
		disapprove.setBounds(530, 389, 157, 23);
		contentPane.add(disapprove);
	}
}
