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

//	public static void main(String[] args) {
//				try {
//					AdminLogin frame = new AdminLogin();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					JFrame er= new JFrame();
//					er.setAlwaysOnTop(true);
//					JOptionPane.showMessageDialog(er,e);
//				}
//	}


	public AdminLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setBounds(20, 120, 800, 400);
		setBounds(395, 150, 540, 400);
		setAlwaysOnTop(true);
		setUndecorated(true);
		contentPane = new JPanel();
		contentPane.setForeground(SystemColor.activeCaptionText);
		contentPane.setBackground(new Color(0, 51, 102));
		
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("User Name");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(SystemColor.text);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(230, 70, 100, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setForeground(SystemColor.text);
		lblNewLabel_1.setBounds(234, 154, 96, 14);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBorder(null);
		textField.setBounds(125, 98, 302, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBorder(null);
		passwordField.setBounds(125, 179, 302, 20);
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
		cbox.setBackground(new Color(0, 51, 102));
		cbox.setBounds(230, 206, 126, 23);
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
					r.next();
					do {
					if(textField.getText().equals(r.getString(2)) && passwordField.getText().equals(r.getString(3)))
					{
						flag =1;
						break;
				    }
					}
					while(r.next());
					if(flag==1) {
						setVisible(false);
						Home.frame.setVisible(false);
						new AdminHome().setVisible(true);
					}
					else {
						JFrame er= new JFrame();
						er.setAlwaysOnTop(true);
						JOptionPane.showMessageDialog(er,"Invalid username or password","",JOptionPane.ERROR_MESSAGE);
					
					}}
					catch(Exception ex)
					{JFrame er= new JFrame();
					er.setAlwaysOnTop(true);
					JOptionPane.showMessageDialog(er,e);
					}
			
				
			}
		});
		btnNewButton.setBackground(SystemColor.window);
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 11));
		btnNewButton.setForeground(new Color(0, 51, 102));
		btnNewButton.setBounds(241, 263, 89, 23);
		contentPane.add(btnNewButton);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 102, 0));
		panel.setBounds(0, 0, 540, 30);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton_1 = new JButton("X");
		btnNewButton_1.setFocusable(false);
		btnNewButton_1.setBounds(500, 0, 30, 30);
		panel.add(btnNewButton_1);
		btnNewButton_1.setBorder(null);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton_1.setForeground(SystemColor.text);
		btnNewButton_1.setBackground(new Color(255, 102, 0));
	}
}
