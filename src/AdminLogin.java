
import java.awt.EventQueue;
import javax.swing.*;
import java.awt.SystemColor;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class AdminLogin extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminLogin frame = new AdminLogin();
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
	public AdminLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(220, 120, 800, 400);
		contentPane = new JPanel();
		contentPane.setForeground(SystemColor.activeCaptionText);
		contentPane.setBackground(SystemColor.desktop);
		
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("User Name");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(SystemColor.text);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(332, 69, 100, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setForeground(SystemColor.text);
		lblNewLabel_1.setBounds(336, 149, 96, 14);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBorder(null);
		textField.setBounds(336, 92, 96, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBorder(null);
		passwordField.setBounds(336, 174, 96, 20);
		contentPane.add(passwordField);
		
		JCheckBox cbox = new JCheckBox("Show Password");
		cbox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cbox.isSelected()) {
					passwordField.setEchoChar((char)0);
				}
				else
					passwordField.setEchoChar('*');
			}
		});
		cbox.setForeground(SystemColor.text);
		cbox.setBackground(SystemColor.desktop);
		cbox.setBounds(333, 231, 113, 23);
		contentPane.add(cbox);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.setBorder(null);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection c=DBconnection.mysqlcon();	
					Statement s= c.createStatement();
					ResultSet r=s.executeQuery("select * from admins");
					int flag =0;
					while(r.next()) {
					if(textField.getText().equals(r.getString(1)) && passwordField.getText().equals(r.getString(2)))
					{
						flag =1;
						break;
				    }
					}
					if(flag==1) {
						setVisible(false);
						new AdminHome().setVisible(true);
					}
					else
						JOptionPane.showMessageDialog(null,"Invalid username or password","",JOptionPane.ERROR_MESSAGE);
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
		btnNewButton.setForeground(new Color(148, 0, 211));
		btnNewButton.setBounds(231, 293, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.setBorder(null);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new Home().setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 11));
		btnNewButton_1.setForeground(new Color(148, 0, 211));
		btnNewButton_1.setBackground(SystemColor.text);
		btnNewButton_1.setBounds(444, 293, 89, 23);
		contentPane.add(btnNewButton_1);
	}
}
