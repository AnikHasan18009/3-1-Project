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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;

public class UpdateQuestion extends JFrame {

	
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateQuestion frame = new UpdateQuestion();
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
	public UpdateQuestion() {
		setAlwaysOnTop(true);
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(120, 120, 900, 450);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(255, 255, 255));
		contentPane.setBackground(SystemColor.desktop);
		contentPane.setBorder(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Update a Question");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setForeground(SystemColor.textHighlightText);
		lblNewLabel.setBackground(SystemColor.window);
		lblNewLabel.setBounds(279, 0, 308, 45);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Question");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(40, 118, 94, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Option 1");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setBounds(40, 158, 94, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Option 2");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setBounds(40, 201, 94, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Option 3");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4.setBounds(40, 247, 94, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Option 4");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_5.setForeground(new Color(255, 255, 255));
		lblNewLabel_5.setBounds(40, 293, 94, 14);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Answer");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_6.setForeground(new Color(255, 255, 255));
		lblNewLabel_6.setBounds(40, 334, 94, 14);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Question No.");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_7.setForeground(new Color(255, 255, 255));
		lblNewLabel_7.setBounds(222, 86, 94, 14);
		contentPane.add(lblNewLabel_7);
		
		JButton btnNewButton = new JButton("Close");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminHome.running=0;
				setVisible(false);
			}
		});
		btnNewButton.setForeground(new Color(148, 0, 211));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(801, 0, 99, 34);
		contentPane.add(btnNewButton);
		
		textField = new JTextField();
		textField.setBorder(null);
		textField.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField.setBounds(155, 117, 600, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBorder(null);
		textField_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField_1.setColumns(10);
		textField_1.setBounds(155, 157, 600, 20);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setBorder(null);
		textField_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField_2.setColumns(10);
		textField_2.setBounds(155, 200, 600, 20);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setBorder(null);
		textField_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField_3.setColumns(10);
		textField_3.setBounds(155, 246, 600, 20);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setBorder(null);
		textField_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField_4.setColumns(10);
		textField_4.setBounds(155, 292, 600, 20);
		contentPane.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setBorder(null);
		textField_5.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField_5.setColumns(10);
		textField_5.setBounds(155, 333, 600, 20);
		contentPane.add(textField_5);
		
		JButton btnNewButton_1 = new JButton("Update");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String num=textField_6.getText();
				String ques=textField.getText();
				String op1=textField_1.getText();
				String op2=textField_2.getText();
				String op3=textField_3.getText();
				String op4=textField_4.getText();
				String ans=textField_5.getText();
				
				try {
					if(num.equals("")) {
						JFrame mess= new JFrame();
						mess.setAlwaysOnTop(true);
						JOptionPane.showMessageDialog(mess,"Please Enter Question Number.");
						setVisible(false);
						new UpdateQuestion().setVisible(true);
					}
					else {
					Connection c=DBconnection.mysqlcon();	
					PreparedStatement st= c.prepareStatement("update  questions set ques='"+ques+"',op1='"+op1+"',op2='"+op2+"',op3='"+op3+"',op4='"+op4+"',ans='"+ans+"' where number='"+num+"'");
					st.executeUpdate();
					JFrame mess= new JFrame();
					mess.setAlwaysOnTop(true);
					JOptionPane.showMessageDialog(mess,"Sucessfully Updated.");
					setVisible(false);
					new UpdateQuestion().setVisible(true);}
					}
					catch(Exception ex)
					{
						JFrame er= new JFrame();
						er.setAlwaysOnTop(true);
						JOptionPane.showMessageDialog(er,ex);
					}
				
			}
		});
		btnNewButton_1.setForeground(new Color(148, 0, 211));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_1.setBounds(534, 395, 107, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("Clear");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
				textField_1.setText("");
			    textField_2.setText("");
				textField_3.setText("");
				textField_4.setText("");
				textField_5.setText("");
				textField_6.setText("");
				textField_6.setEditable(true);
			}
		});
		btnNewButton_1_1.setForeground(new Color(148, 0, 211));
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_1_1.setBounds(313, 395, 89, 23);
		contentPane.add(btnNewButton_1_1);
		
		JButton btnNewButton_2 = new JButton("Search");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String num= textField_6.getText();
				try {
					Connection c=DBconnection.mysqlcon();	
					Statement s= c.createStatement();
					ResultSet r=s.executeQuery("select * from questions where number='"+num+"'");
					if(r.next()) {
						textField.setText(r.getString(2));
						textField_1.setText(r.getString(3));
					    textField_2.setText(r.getString(4));
						textField_3.setText(r.getString(5));
						textField_4.setText(r.getString(6));
						textField_5.setText(r.getString(7));
						textField_6.setEditable(false);
					}
					else {
						JFrame er= new JFrame();
						er.setAlwaysOnTop(true);
						JOptionPane.showMessageDialog(er,"Question number doesn't exist!");
					}
					}
					catch(Exception ex)
					{
						JFrame er= new JFrame();
						er.setAlwaysOnTop(true);
						JOptionPane.showMessageDialog(er,ex);
					}
			}
		});
		btnNewButton_2.setForeground(new Color(148, 0, 211));
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_2.setBorder(null);
		btnNewButton_2.setBounds(431, 84, 89, 23);
		contentPane.add(btnNewButton_2);
		
		textField_6 = new JTextField();
		textField_6.setBounds(325, 85, 96, 20);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
	}
	}


