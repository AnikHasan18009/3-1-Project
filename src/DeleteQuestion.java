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
import javax.swing.SwingConstants;


public class DeleteQuestion extends JFrame {

	private JPanel contentPane;
	private JTextField txtQuestion;
	private JTextField txtOption;
	private JTextField txtOption_1;
	private JTextField txtOption_2;
	private JTextField txtOption_3;
	private JTextField txtAnswer;
	private JTextField textField_6;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeleteQuestion frame = new DeleteQuestion();
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
	public DeleteQuestion() {
		setAlwaysOnTop(true);
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(210, 120, 900, 450);
		contentPane = new JPanel();
		contentPane.setForeground(Color.GRAY);
		contentPane.setBackground(SystemColor.desktop);
		contentPane.setBorder(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Delete a Question");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setForeground(SystemColor.textHighlightText);
		lblNewLabel.setBackground(SystemColor.window);
		lblNewLabel.setBounds(279, 0, 308, 45);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_7 = new JLabel("Question No.");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_7.setForeground(new Color(255, 255, 255));
		lblNewLabel_7.setBounds(264, 86, 114, 14);
		contentPane.add(lblNewLabel_7);
		
		JButton btnNewButton = new JButton("Close");
		btnNewButton.setBorder(null);
		btnNewButton.setBackground(new Color(255, 255, 255));
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
		
		txtQuestion = new JTextField();
		txtQuestion.setForeground(Color.GRAY);
		txtQuestion.setText("Question");
		txtQuestion.setBorder(null);
		txtQuestion.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtQuestion.setBounds(40, 117, 829, 20);
		contentPane.add(txtQuestion);
		txtQuestion.setColumns(10);
		
		txtOption = new JTextField();
		txtOption.setForeground(Color.GRAY);
		txtOption.setText("Option 1");
		txtOption.setBorder(null);
		txtOption.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtOption.setColumns(10);
		txtOption.setBounds(40, 157, 829, 20);
		contentPane.add(txtOption);
		
		txtOption_1 = new JTextField();
		txtOption_1.setForeground(Color.GRAY);
		txtOption_1.setText("Option 2");
		txtOption_1.setBorder(null);
		txtOption_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtOption_1.setColumns(10);
		txtOption_1.setBounds(40, 200, 829, 20);
		contentPane.add(txtOption_1);
		
		txtOption_2 = new JTextField();
		txtOption_2.setForeground(Color.GRAY);
		txtOption_2.setText("Option 3");
		txtOption_2.setBorder(null);
		txtOption_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtOption_2.setColumns(10);
		txtOption_2.setBounds(40, 246, 829, 20);
		contentPane.add(txtOption_2);
		
		txtOption_3 = new JTextField();
		txtOption_3.setForeground(Color.GRAY);
		txtOption_3.setText("Option 4");
		txtOption_3.setBorder(null);
		txtOption_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtOption_3.setColumns(10);
		txtOption_3.setBounds(40, 292, 829, 20);
		contentPane.add(txtOption_3);
		
		txtAnswer = new JTextField();
		txtAnswer.setForeground(Color.GRAY);
		txtAnswer.setText("Answer");
		txtAnswer.setBorder(null);
		txtAnswer.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtAnswer.setColumns(10);
		txtAnswer.setBounds(40, 333, 829, 20);
		contentPane.add(txtAnswer);
		
		JButton btnNewButton_1 = new JButton("Delete");
		btnNewButton_1.setBorder(null);
		btnNewButton_1.setBackground(new Color(255, 255, 255));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String num=textField_6.getText();
				String ques=txtQuestion.getText();
				String op1=txtOption.getText();
				String op2=txtOption_1.getText();
				String op3=txtOption_2.getText();
				String op4=txtOption_3.getText();
				String ans=txtAnswer.getText();
				
				try {
					if(num.equals("")) {
						JFrame mess= new JFrame();
						mess.setAlwaysOnTop(true);
						JOptionPane.showMessageDialog(mess,"Please Enter Question Number!");
						setVisible(false);
						new DeleteQuestion().setVisible(true);
					}
					else {
					Connection c=DBconnection.mysqlcon();	
					PreparedStatement st= c.prepareStatement("delete from questions where number='"+num+"'");
					st.executeUpdate();
					JFrame mess= new JFrame();
					mess.setAlwaysOnTop(true);
					JOptionPane.showMessageDialog(mess,"Sucessfully Deleted.");
					setVisible(false);
					new DeleteQuestion().setVisible(true);}
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
		btnNewButton_1_1.setBorder(null);
		btnNewButton_1_1.setBackground(new Color(255, 255, 255));
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtQuestion.setText("Question");
				txtOption.setText("Option 1");
			    txtOption_1.setText("Option 2");
				txtOption_2.setText("Option 3");
				txtOption_3.setText("Option 4");
				txtAnswer.setText("Answer");
				textField_6.setText("");
				textField_6.setEditable(true);
				txtQuestion.setForeground(Color.GRAY);
				txtOption.setForeground(Color.GRAY);
			    txtOption_1.setForeground(Color.GRAY);
				txtOption_2.setForeground(Color.GRAY);
				txtOption_3.setForeground(Color.GRAY);
				txtAnswer.setForeground(Color.GRAY);
			}
		});
		btnNewButton_1_1.setForeground(new Color(148, 0, 211));
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_1_1.setBounds(313, 395, 89, 23);
		contentPane.add(btnNewButton_1_1);
		
		JButton btnNewButton_2 = new JButton("Search");
		btnNewButton_2.setBackground(new Color(255, 255, 255));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String num= textField_6.getText();
				try {
					Connection c=DBconnection.mysqlcon();	
					Statement s= c.createStatement();
					ResultSet r=s.executeQuery("select * from questions where number='"+num+"'");
					if(r.next()) {
						txtQuestion.setText(r.getString(2));
						txtOption.setText(r.getString(3));
					    txtOption_1.setText(r.getString(4));
						txtOption_2.setText(r.getString(5));
						txtOption_3.setText(r.getString(6));
						txtAnswer.setText(r.getString(7));
						textField_6.setEditable(false);
						txtQuestion.setForeground(Color.BLACK);
						txtOption.setForeground(Color.BLACK);
					    txtOption_1.setForeground(Color.BLACK);
						txtOption_2.setForeground(Color.BLACK);
						txtOption_3.setForeground(Color.BLACK);
						txtAnswer.setForeground(Color.BLACK);
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
		btnNewButton_2.setBounds(485, 82, 89, 23);
		contentPane.add(btnNewButton_2);
		
		textField_6 = new JTextField();
		textField_6.setBounds(376, 82, 99, 23);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
	}
	}


