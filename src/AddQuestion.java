import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTextField;
import java.sql.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.SwingConstants;

public class AddQuestion extends JFrame {

	private JPanel contentPane;
	private JTextField txtQuestion;
	private JTextField txtOption;
	private JTextField txtOption_1;
	private JTextField txtOption_2;
	private JTextField txtOption_3;
	private JTextField txtAnswer;
    
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddQuestion frame = new AddQuestion();
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
	public AddQuestion() {
		setAlwaysOnTop(true);
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(210, 120, 900, 450);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(255, 255, 255));
		contentPane.setBackground(SystemColor.desktop);
		contentPane.setBorder(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Add a New Question");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setForeground(SystemColor.textHighlightText);
		lblNewLabel.setBackground(SystemColor.window);
		lblNewLabel.setBounds(279, 0, 308, 45);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1_6 = new JLabel("Question No.");
		lblNewLabel_1_6.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_6.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_6.setBounds(40, 83, 94, 14);
		contentPane.add(lblNewLabel_1_6);
		
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
		btnNewButton.setBounds(801, 0, 99, 31);
		contentPane.add(btnNewButton);
		
		txtQuestion = new JTextField();
		txtQuestion.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(txtQuestion.getText().equals("Question"))
				{
					txtQuestion.setText("");
					txtQuestion.setForeground(Color.black);
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(txtQuestion.getText().equals(""))
				{
					txtQuestion.setText("Question");
					txtQuestion.setForeground(Color.GRAY);
				}
			}
		});
		txtQuestion.setForeground(Color.GRAY);
		txtQuestion.setText("Question");
		txtQuestion.setBorder(null);
		txtQuestion.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtQuestion.setBounds(40, 117, 818, 20);
		contentPane.add(txtQuestion);
		txtQuestion.setColumns(10);
		
		txtOption = new JTextField();
		txtOption.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(txtOption.getText().equals("Option 1"))
				{
					txtOption.setText("");
					txtOption.setForeground(Color.black);
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(txtOption.getText().equals(""))
				{
					txtOption.setText("Option 1");
					txtOption.setForeground(Color.GRAY);
				}
			}
		});
		txtOption.setForeground(Color.GRAY);
		txtOption.setText("Option 1");
		txtOption.setBorder(null);
		txtOption.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtOption.setColumns(10);
		txtOption.setBounds(40, 157, 818, 20);
		contentPane.add(txtOption);
		
		txtOption_1 = new JTextField();
		txtOption_1.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(txtOption_1.getText().equals("Option 2"))
				{
					txtOption_1.setText("");
					txtOption_1.setForeground(Color.black);
				}
			}
			
			@Override
			public void focusLost(FocusEvent e) {
				if(txtOption_1.getText().equals(""))
				{
					txtOption_1.setText("Option 2");
					txtOption_1.setForeground(Color.GRAY);
				}
			}
		});
		txtOption_1.setText("Option 2");
		txtOption_1.setForeground(Color.GRAY);
		txtOption_1.setBorder(null);
		txtOption_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtOption_1.setColumns(10);
		txtOption_1.setBounds(40, 200, 818, 20);
		contentPane.add(txtOption_1);
		
		txtOption_2 = new JTextField();
		txtOption_2.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(txtOption_2.getText().equals("Option 3"))
				{
					txtOption_2.setText("");
					txtOption_2.setForeground(Color.black);
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(txtOption_2.getText().equals(""))
				{
					txtOption_2.setText("Option 3");
					txtOption_2.setForeground(Color.GRAY);
				}
			}
		});
		txtOption_2.setForeground(Color.GRAY);
		txtOption_2.setText("Option 3");
		txtOption_2.setBorder(null);
		txtOption_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtOption_2.setColumns(10);
		txtOption_2.setBounds(40, 246, 818, 20);
		contentPane.add(txtOption_2);
		
		txtOption_3 = new JTextField();
		txtOption_3.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(txtOption_3.getText().equals("Option 4"))
				{
					txtOption_3.setText("");
					txtOption_3.setForeground(Color.black);
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(txtOption_3.getText().equals(""))
				{
					txtOption_3.setText("Option 4");
					txtOption_3.setForeground(Color.GRAY);
				}
			}
		});
		txtOption_3.setForeground(Color.GRAY);
		txtOption_3.setText("Option 4");
		txtOption_3.setBorder(null);
		txtOption_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtOption_3.setColumns(10);
		txtOption_3.setBounds(40, 292, 818, 20);
		contentPane.add(txtOption_3);
		
		txtAnswer = new JTextField();
		txtAnswer.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(txtAnswer.getText().equals("Answer"))
				{
					txtAnswer.setText("");
					txtAnswer.setForeground(Color.black);
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(txtAnswer.getText().equals(""))
				{
					txtAnswer.setText("Answer");
					txtAnswer.setForeground(Color.GRAY);
				}
			}
		});
		txtAnswer.setForeground(Color.GRAY);
		txtAnswer.setText("Answer");
		txtAnswer.setBorder(null);
		txtAnswer.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtAnswer.setColumns(10);
		txtAnswer.setBounds(40, 333, 818, 20);
		contentPane.add(txtAnswer);
		
		JLabel lblNewLabel_2 = new JLabel("0");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2.setBackground(new Color(255, 255, 255));
		lblNewLabel_2.setBounds(155, 80, 63, 21);
		contentPane.add(lblNewLabel_2);
		
		JButton btnNewButton_1 = new JButton("Save");
		btnNewButton_1.setBorder(null);
		btnNewButton_1.setBackground(new Color(255, 255, 255));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String num=lblNewLabel_2.getText();
				String ques=txtQuestion.getText();
				String op1=txtOption.getText();
				String op2=txtOption_1.getText();
				String op3=txtOption_2.getText();
				String op4=txtOption_3.getText();
				String ans=txtAnswer.getText();
				try {
					Connection c=DBconnection.mysqlcon();	
					PreparedStatement st= c.prepareStatement("INSERT INTO questions VALUES('"+num+"','"+ques+"','"+op1+"','"+op2+"','"+op3+"','"+op4+"','"+ans+"')");
					st.executeUpdate();
					JFrame mess= new JFrame();
					mess.setAlwaysOnTop(true);
					JOptionPane.showMessageDialog(mess,"Sucessfully Added.");
					setVisible(false);
					new AddQuestion().setVisible(true);
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
		btnNewButton_1.setBounds(534, 395, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("Clear");
		btnNewButton_1_1.setBorder(null);
		btnNewButton_1_1.setBackground(new Color(255, 255, 255));
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtQuestion.setText("");
				txtOption.setText("");
			    txtOption_1.setText("");
				txtOption_2.setText("");
				txtOption_3.setText("");
				txtAnswer.setText("");
			}
		});
		btnNewButton_1_1.setForeground(new Color(148, 0, 211));
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_1_1.setBounds(313, 395, 89, 23);
		contentPane.add(btnNewButton_1_1);
		try {
			Connection c=DBconnection.mysqlcon();	
			Statement s= c.createStatement();
			ResultSet r=s.executeQuery("select count(*) from questions");
			r.next();
			int no=r.getInt(1);
			no++;
			lblNewLabel_2.setText(String.valueOf(no));
			}
			catch(Exception e)
			{
				JFrame er= new JFrame();
				er.setAlwaysOnTop(true);
				JOptionPane.showMessageDialog(er,e);
			}
	}

}
