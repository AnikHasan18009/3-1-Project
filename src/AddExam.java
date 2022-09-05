import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class AddExam extends JFrame {

	private JPanel contentPane;
	private JTextField txtA;

	public static void main(String[] args) {
		
		
				try {
					AddExam frame = new AddExam();
					frame.setVisible(true);
				} catch (Exception e) {
					JFrame er= new JFrame();
					er.setAlwaysOnTop(true);
					JOptionPane.showMessageDialog(er,e);
				}
			
	}

	/**
	 * Create the frame.
	 */
	public AddExam() {
		setAlwaysOnTop(true);
		setBackground(SystemColor.inactiveCaption);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 120, 632, 436);
		setUndecorated(true);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 51, 102));
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Enter The Exam Name");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel.setBounds(127, 50, 387, 60);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.setForeground(new Color(0, 51, 102));
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setBorder(null);
		btnNewButton.setBounds(88, 286, 105, 48);
		contentPane.add(btnNewButton);
		
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminHome.running=0;
				setVisible(false);
			}
		});
		btnClose.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnClose.setForeground(new Color(0, 51, 102));
		btnClose.setBackground(Color.WHITE);
		btnClose.setBorder(null);
		btnClose.setBounds(409, 286, 105, 48);
		contentPane.add(btnClose);
		
		JTextArea textArea = new JTextArea();
		textArea.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				try 
				{
					if(!textArea.getText().equals("")) {
					Connection c=DBconnection.mysqlcon();
					Statement s= c.createStatement();
					ResultSet r=s.executeQuery("select * from exams where name='"+textArea.getText()+"'");
					if(r.next())
					{
						txtA.setText("*Exam already exists");
					}
					else
					{
						txtA.setText("");
					}
					}
				}
				catch(Exception ex){
					JFrame er= new JFrame();
					er.setAlwaysOnTop(true);
					JOptionPane.showMessageDialog(er,ex);
				}	
				
			}
		});;
		textArea.setFont(new Font("Times New Roman", Font.BOLD, 16));
		textArea.setForeground(new Color(0, 0, 0));
		textArea.setBounds(88, 154, 426, 39);
		contentPane.add(textArea);
		
		txtA = new JTextField();
		txtA.setBorder(null);
		txtA.setBackground(new Color(0, 51, 102));
		txtA.setForeground(new Color(255, 255, 255));
		txtA.setFont(new Font("Times New Roman", Font.BOLD, 14));
		txtA.setBounds(88, 201, 133, 20);
		contentPane.add(txtA);
		txtA.setColumns(10);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					String name=textArea.getText();
					if(name.equals("")) {
						JFrame mess= new JFrame();
						mess.setAlwaysOnTop(true);
						JOptionPane.showMessageDialog(mess,"Please Enter Exam Name!");
						setVisible(false);
						new AddExam().setVisible(true);
					}
				else {
					Connection c=DBconnection.mysqlcon();
					Statement s= c.createStatement();
					ResultSet r=s.executeQuery("select * from exams where name='"+name+"'");
					if(r.next())
					{
						JFrame mess= new JFrame();
						mess.setAlwaysOnTop(true);
						JOptionPane.showMessageDialog(mess,"This Exam Already Exists.");
						setVisible(false);
						new AddExam().setVisible(true);
					}
					else {
					PreparedStatement st= c.prepareStatement("INSERT INTO exams VALUES('"+name+"')");
					st.executeUpdate();
					st= c.prepareStatement("create table `"+name+"`(number varchar(20),question varchar(500),option1 varchar(500),option2 varchar(500),option3 varchar(500),option4 varchar(500),answer varchar(500))");
					st.executeUpdate();
					JFrame mess= new JFrame();
					mess.setAlwaysOnTop(true);
					JOptionPane.showMessageDialog(mess,"Sucessfully Added.");
					setVisible(false);
					//AdminHome.frame.setVisible(false);
					AdminHome.selected_exam=name;
					new QuestionManagement().setVisible(true);
					}
				}}
				catch(Exception ex)
				{
					JFrame er= new JFrame();
					er.setAlwaysOnTop(true);
					JOptionPane.showMessageDialog(er,ex);
				}
				}
				
			
		}
		);
	
		}
}

