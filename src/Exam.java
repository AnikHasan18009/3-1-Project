import java.awt.BorderLayout; 
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.Timer;
import java.util.*;
import java.util.concurrent.TimeUnit;
public class Exam extends JFrame implements ActionListener{

	
	private JPanel contentPane;
	private JTextArea textArea ;
	private JTextArea textArea_1 ;
	private JTextArea textArea_2 ;
	private JTextArea textArea_3 ;
	private JTextArea textArea_4 ;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_2_1;
	private JButton btnA;
	private JButton btnB;
	private JButton btnC;
	private JButton btnD;
	private ResultSet r;
	private Statement s;
	public static int running=0;
	public static String date="";
	public static String time="";
	public static int totalQuestions=0;
	public static int currentQuestions;
	public static int correctAnswer=0;
	public static int sec=10;
	public static String ans;
Timer timer = new Timer(1000, new ActionListener(){
		@Override
		public void actionPerformed(ActionEvent e) {
			sec--;
			lblNewLabel_2_1.setText(String.valueOf(sec));
			if(sec<=0) {
				try {
				showAnswer();
				}
				catch (Exception ex) {
					JFrame er= new JFrame();
					er.setAlwaysOnTop(true);
					JOptionPane.showMessageDialog(er,ex);
				}
			}
			}
		});
	public static void main(String[] args) {
		
				try {
					Exam frame = new Exam();
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
	 
	public Exam() {
		 LocalDateTime myDateObj = LocalDateTime.now();   
		 DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd/MM/yyyy");  
		    date = myDateObj.format(myFormatObj);  
		    myFormatObj = DateTimeFormatter.ofPattern("HH:mm:ss");
		    time= myDateObj.format(myFormatObj);

		Border bd=BorderFactory.createLineBorder(new Color(148,0,211));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(40, 40, 1200, 600);
		contentPane = new JPanel();
		contentPane.setForeground(Color.WHITE);
		contentPane.setFocusable(false);
		contentPane.setBackground(new Color(0, 51, 102));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnLogout = new JButton("X");
		btnLogout.setFocusable(false);
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				JFrame lout= new JFrame();
				lout.setAlwaysOnTop(true);
				int decision= JOptionPane.showConfirmDialog(lout,"Do you want to exit?","",JOptionPane.YES_NO_OPTION);
				if(decision==0)
				{
					setVisible(false);
					//AdminHome.frame.setVisible(true);
					StudentHome.running=0;
					StudentHome.selected_exam="";
					
				}}
			
		});
		btnLogout.setBackground(new Color(0, 51, 102));
		btnLogout.setForeground(SystemColor.text);
		btnLogout.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnLogout.setBorder(null);
		btnLogout.setBounds(1112, 0, 74, 44);
		contentPane.add(btnLogout);
		JLabel lblNewLabel = new JLabel(StudentHome.selected_exam);
		lblNewLabel.setText(AdminHome.selected_exam);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel.setBounds(10, 11, 1166, 38);
		contentPane.add(lblNewLabel);
		
		textArea = new JTextArea();
		textArea.setForeground(Color.WHITE);
		textArea.setBackground(new Color(0, 51, 102));
		textArea.setBorder(null);
		textArea.setEditable(false);
		textArea.setFont(new Font("Tahoma", Font.BOLD, 14));
		textArea.setRows(2);
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		textArea.setBounds(235, 155, 796, 38);
		contentPane.add(textArea);
		
		JLabel lblNewLabel_1 = new JLabel("Question No:");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(235, 101, 97, 33);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(342, 101, 64, 33);
		contentPane.add(lblNewLabel_2);
		
		textArea_1 = new JTextArea();
		textArea_1.setBackground(new Color(0, 51, 102));
		textArea_1.setForeground(Color.WHITE);
		textArea_1.setBorder(null);
		textArea_1.setEditable(false);
		textArea_1.setRows(2);
		textArea_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		textArea_1.setLineWrap(true);
		textArea_1.setWrapStyleWord(true);
		textArea_1.setBounds(302, 228, 729, 38);
		contentPane.add(textArea_1);
		
		textArea_2 = new JTextArea();
		textArea_2.setBackground(new Color(0, 51, 102));
		textArea_2.setForeground(Color.WHITE);
		textArea_2.setBorder(null);
		textArea_2.setEditable(false);
		textArea_2.setRows(2);
		textArea_2.setLineWrap(true);
		textArea_2.setWrapStyleWord(true);
		textArea_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		textArea_2.setBounds(302, 305, 729, 38);
		contentPane.add(textArea_2);
		
		textArea_3 = new JTextArea();
		textArea_3.setBackground(new Color(0, 51, 102));
		textArea_3.setForeground(Color.WHITE);
		textArea_3.setBorder(null);
		textArea_3.setEditable(false);
		textArea_3.setRows(2);
		textArea_3.setLineWrap(true);
		textArea_3.setWrapStyleWord(true);
		textArea_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		textArea_3.setBounds(302, 380, 729, 38);
		contentPane.add(textArea_3);
		
        textArea_4 = new JTextArea();
        textArea_4.setBackground(new Color(0, 51, 102));
        textArea_4.setForeground(Color.WHITE);
        textArea_4.setBorder(null);
		textArea_4.setEditable(false);
		textArea_4.setRows(2);
		textArea_4.setLineWrap(true);
		textArea_4.setWrapStyleWord(true);
		textArea_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		textArea_4.setBounds(302, 459, 729, 38);
		contentPane.add(textArea_4);
	    btnA = new JButton();
		btnA.setFocusable(false);
		btnA.setText("A");
		btnA.setBorder(null);
		btnA.setBackground(Color.WHITE);
		btnA.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnA.addActionListener(this);
		btnA.setBounds(235, 229, 49, 33);
		
		contentPane.add(btnA);
		
		btnB = new JButton("B");
		btnB.setFocusable(false);
		btnB.setBorder(null);
		btnB.addActionListener(this);
		btnB.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnB.setBackground(Color.WHITE);
		
		btnB.setBounds(235, 306, 49, 33);
		contentPane.add(btnB);
		
		btnC = new JButton("C");
		btnC.setFocusable(false);
		btnC.setBorder(null);
		btnC.addActionListener(this);
		btnC.setFont(new Font("Tahoma", Font.BOLD, 16));
	
		btnC.setBackground(Color.WHITE);
		btnC.setBounds(235, 381, 49, 33);
		contentPane.add(btnC);
		
		btnD = new JButton("D");
		btnD.setFocusable(false);
		btnD.setBorder(null);
		btnD.addActionListener(this);
		btnD.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnD.setBackground(Color.WHITE);
		btnD.setBounds(235, 459, 49, 33);
		contentPane.add(btnD);
		
		lblNewLabel_2_1 = new JLabel("10");
		lblNewLabel_2_1.setForeground(Color.WHITE);
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_2_1.setBounds(929, 101, 64, 33);
		contentPane.add(lblNewLabel_2_1);
		try {
			Connection c=DBconnection.mysqlcon();	
			s= c.createStatement();
			r=s.executeQuery("select count(*) from `"+StudentHome.selected_exam+"`");
			r.next();
			totalQuestions=r.getInt(1);
			r=s.executeQuery("select * from `"+StudentHome.selected_exam+"`");
			nextQuestion();
			}
			catch(Exception e)
			{
				JFrame er= new JFrame();
				er.setAlwaysOnTop(true);
				JOptionPane.showMessageDialog(er,e);
			}
			
				
		
		}
	public void nextQuestion() throws Exception
	{
		if(r.next()) {
		lblNewLabel_2.setText(r.getString(1));
		lblNewLabel_2_1.setText("10");
		sec=10;
		textArea.setText(r.getString(2));
		textArea_1.setText(r.getString(3));
		textArea_2.setText(r.getString(4));
		textArea_3.setText(r.getString(5));
		textArea_4.setText(r.getString(6));
		textArea_1.setForeground(Color.WHITE);
		textArea_2.setForeground(Color.WHITE);
		textArea_3.setForeground(Color.WHITE);
		textArea_4.setForeground(Color.WHITE);
		ans=r.getString(7);
		timer.start();
		}
		else {
			setVisible(false);
			new Result().setVisible(true);
		}
		
	}
	public void showAnswer() throws Exception
	{   
		btnA.setEnabled(false);
		btnB.setEnabled(false);
		btnC.setEnabled(false);
		btnD.setEnabled(false);
		timer.stop();
		if(ans.equals(textArea_1.getText()))
			textArea_1.setForeground(Color.GREEN);
		else
			textArea_1.setForeground(Color.RED);
		if(ans.equals(textArea_2.getText()))
			textArea_2.setForeground(Color.GREEN);
		else
			textArea_2.setForeground(Color.RED);
		if(ans.equals(textArea_3.getText()))
			textArea_3.setForeground(Color.GREEN);
		else
			textArea_3.setForeground(Color.RED);
		if(ans.equals(textArea_4.getText()))
			textArea_4.setForeground(Color.GREEN);
		else
			textArea_4.setForeground(Color.RED);
          Timer pause = new Timer(3000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			{
				try{
					btnA.setEnabled(true);
					btnB.setEnabled(true);
					btnC.setEnabled(true);
					btnD.setEnabled(true);
					nextQuestion();
				}
				catch(Exception ex)
				{
					JFrame er= new JFrame();
					er.setAlwaysOnTop(true);
					JOptionPane.showMessageDialog(er,ex);
				}
				}
			}
  		});
  		pause.setRepeats(false);
  		pause.start();
	}
	@Override
	public void actionPerformed(ActionEvent e)
	{
		btnA.setEnabled(false);
		btnB.setEnabled(false);
		btnC.setEnabled(false);
		btnD.setEnabled(false);
		if(e.getSource()== btnA)
		{
			if(ans.equals(textArea_1.getText())) {
				correctAnswer++;
			
			}
			
		}
		if(e.getSource()== btnB)
		{
			if(ans.equals(textArea_2.getText())) {
				correctAnswer++;
		
			}
			
		}
		if(e.getSource()== btnC)
		{
			if(ans.equals(textArea_3.getText())) {
				correctAnswer++;
				
			}
			
		}
		if(e.getSource()== btnD)
		{
			if(ans.equals(textArea_4.getText())) {
				correctAnswer++;
			}
		
		}
		
		
		try {
	   showAnswer();
		}
		catch(Exception ex)
		{
			JFrame er= new JFrame();
			er.setAlwaysOnTop(true);
			JOptionPane.showMessageDialog(er,ex);
		}
		
	}
	}
	

