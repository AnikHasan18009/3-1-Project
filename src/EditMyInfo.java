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

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class EditMyInfo extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditMyInfo frame = new EditMyInfo();
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
	public EditMyInfo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setBounds(20, 120, 800, 400);
		setBounds(220, 130, 886, 463);
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
		lblNewLabel.setBounds(26, 195, 112, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setForeground(SystemColor.text);
		lblNewLabel_1.setBounds(469, 274, 123, 30);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField.setBorder(null);
		textField.setBounds(154, 188, 248, 30);
		textField.setEditable(false);
		textField.setText(StudentLogin.id);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Save Changes");
		btnNewButton.setBorder(null);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection c=DBconnection.mysqlcon();	
					String id=textField.getText();
					String name=textField_1.getText();
					String dept=textField_2.getText();
					String ses=textField_3.getText();
					String pass=textField_4.getText();
					PreparedStatement st= c.prepareStatement("update  `students` set name='"+name+"',department='"+dept+"',password='"+pass+"',session='"+ses+"' where id='"+id+"'");
					st.executeUpdate();
					JFrame mess= new JFrame();
					mess.setAlwaysOnTop(true);
					JOptionPane.showMessageDialog(mess,"Saved changes.");
					//setVisible(false);
				}
					catch(Exception ex)
					{
						JFrame er= new JFrame();
						er.setAlwaysOnTop(true);
						JOptionPane.showMessageDialog(er,ex);
					}
			
				
			}
		});
		btnNewButton.setBackground(SystemColor.window);
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 11));
		btnNewButton.setForeground(new Color(0, 51, 102));
		btnNewButton.setBounds(368, 389, 157, 23);
		contentPane.add(btnNewButton);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		textField_1.setColumns(10);
		textField_1.setBorder(null);
		textField_1.setText(StudentHome.name);
		textField_1.setBounds(154, 114, 696, 30);
		contentPane.add(textField_1);
		
		JLabel lblStudentName = new JLabel("Student Name");
		lblStudentName.setHorizontalAlignment(SwingConstants.CENTER);
		lblStudentName.setForeground(Color.WHITE);
		lblStudentName.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblStudentName.setBounds(10, 121, 136, 14);
		contentPane.add(lblStudentName);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField_2.setColumns(10);
		textField_2.setBorder(null);
		textField_2.setText(StudentHome.dept);
		textField_2.setBounds(602, 188, 248, 30);
		contentPane.add(textField_2);
		
		JLabel lblDepartment = new JLabel("Department");
		lblDepartment.setHorizontalAlignment(SwingConstants.CENTER);
		lblDepartment.setForeground(Color.WHITE);
		lblDepartment.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblDepartment.setBounds(456, 195, 136, 14);
		contentPane.add(lblDepartment);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField_3.setColumns(10);
		textField_3.setBorder(null);
		textField_3.setBounds(154, 276, 248, 30);
		textField_3.setText(StudentHome.ses);
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
				StudentHome.running=0;
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton_1.setForeground(SystemColor.text);
		btnNewButton_1.setBackground(new Color(0, 51, 102));
		
		textField_4 = new JTextField();
		textField_4.setBorder(null);
		textField_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField_4.setBounds(602, 276, 248, 30);
		textField_4.setText(StudentHome.pass);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		
		
		
	
	}

}
