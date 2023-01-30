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
	public static int flag=0;
	public static String date="";
	public static String time="";
	public static int totalQuestions=0;
	public static int currentQuestion=0;
	public static int correctAnswer=0;
	public static int sec=10;
	public static int addedTime=0;
	public static String ans;
	public static ArrayList<Integer> times= new ArrayList<Integer>();
	public static ArrayList<String> questions= new ArrayList<String>();
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

//	public static void main(String[] args) {
//		
//				try {
//					Exam frame = new Exam();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					JFrame er= new JFrame();
//					er.setAlwaysOnTop(true);
//					JOptionPane.showMessageDialog(er,e);
//				}
//	}


	 
	public Exam() {
		 LocalDateTime myDateObj = LocalDateTime.now();   
		 DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd/MM/yyyy");  
		    date = myDateObj.format(myFormatObj);  
		    myFormatObj = DateTimeFormatter.ofPattern("HH:mm:ss");
		    time= myDateObj.format(myFormatObj);
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
				int decision= JOptionPane.showConfirmDialog(lout,"Do you want to exit?","Exit",JOptionPane.YES_NO_OPTION);
				if(decision==0)
				{
					questions.clear();
					times.clear();
					addedTime=0;
					currentQuestion=0;
					timer.stop();
					StudentHome.running=0;
					StudentHome.selected_exam="";
					dispose();
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
		textArea.setBounds(235, 104, 796, 67);
		contentPane.add(textArea);
		
		JLabel lblNewLabel_1 = new JLabel("Question No:");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(235, 60, 97, 33);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(341, 60, 64, 33);
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
		textArea_1.setBounds(302, 195, 729, 38);
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
		textArea_2.setBounds(302, 269, 729, 38);
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
		textArea_3.setBounds(302, 349, 729, 38);
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
		textArea_4.setBounds(302, 423, 729, 38);
		contentPane.add(textArea_4);
	    btnA = new JButton();
		btnA.setFocusable(false);
		btnA.setText("A");
		btnA.setBorder(null);
		btnA.setBackground(Color.WHITE);
		btnA.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnA.addActionListener(this);
		btnA.setBounds(235, 195, 49, 33);
		
		contentPane.add(btnA);
		
		btnB = new JButton("B");
		btnB.setFocusable(false);
		btnB.setBorder(null);
		btnB.addActionListener(this);
		btnB.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnB.setBackground(Color.WHITE);
		
		btnB.setBounds(235, 269, 49, 33);
		contentPane.add(btnB);
		
		btnC = new JButton("C");
		btnC.setFocusable(false);
		btnC.setBorder(null);
		btnC.addActionListener(this);
		btnC.setFont(new Font("Tahoma", Font.BOLD, 16));
	
		btnC.setBackground(Color.WHITE);
		btnC.setBounds(235, 349, 49, 33);
		contentPane.add(btnC);
		
		btnD = new JButton("D");
		btnD.setFocusable(false);
		btnD.setBorder(null);
		btnD.addActionListener(this);
		btnD.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnD.setBackground(Color.WHITE);
		btnD.setBounds(235, 423, 49, 33);
		contentPane.add(btnD);
		
		lblNewLabel_2_1 = new JLabel("");
		lblNewLabel_2_1.setForeground(Color.WHITE);
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_2_1.setBounds(967, 60, 64, 33);
		contentPane.add(lblNewLabel_2_1);
		
		JButton btnNewButton = new JButton("Skip");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				timer.stop();
				try{
					int t=Integer.parseInt(lblNewLabel_2_1.getText());
					if(times.get(currentQuestion)<=t)
					        addedTime=t-times.get(currentQuestion);
					else
						times.set(currentQuestion,t);
					currentQuestion++;
					nextQuestion();
				
				}
				catch(Exception ex)
				{
					JFrame er= new JFrame();
					er.setAlwaysOnTop(true);
					JOptionPane.showMessageDialog(er,ex);
				}
			}
		});
		btnNewButton.setForeground(new Color(0, 51, 102));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(549, 484, 89, 33);
		contentPane.add(btnNewButton);
		try {
			Connection c=DBconnection.mysqlcon();	
			s= c.createStatement();
			r=s.executeQuery("select count(*) from `"+StudentHome.selected_exam+"`");
			if(r.next())
			totalQuestions=r.getInt(1);
			for(int i=1;i<=totalQuestions;i++)
			{
				questions.add(String.valueOf(i));
				times.add(10);
			}
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
		if(currentQuestion>=questions.size())
		{
			currentQuestion=0;
		}
		if(currentQuestion<questions.size()) {
		try {
	  Connection c=DBconnection.mysqlcon();	
		s= c.createStatement();
		r=s.executeQuery("select * from `"+StudentHome.selected_exam+"` where number ='"+questions.get(currentQuestion)+"'");
		if(r.next()) {
		lblNewLabel_2.setText(r.getString(1));
		textArea.setText(r.getString(2));
		textArea_1.setText(r.getString(3));
		textArea_2.setText(r.getString(4));
		textArea_3.setText(r.getString(5));
		textArea_4.setText(r.getString(6));
		}
		textArea_1.setForeground(Color.WHITE);
		textArea_2.setForeground(Color.WHITE);
		textArea_3.setForeground(Color.WHITE);
		textArea_4.setForeground(Color.WHITE);
		ans=r.getString(7);
		sec=times.get(currentQuestion)+addedTime;
		lblNewLabel_2_1.setText(String.valueOf(sec));
		timer.start();
		}
		catch(Exception ex)
		{
			JFrame er= new JFrame();
			er.setAlwaysOnTop(true);
			JOptionPane.showMessageDialog(er,ex);
		}
		
		}
		else {
			questions.clear();
			times.clear();
			addedTime=0;
			currentQuestion=0;
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
          Timer pause = new Timer(750, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			{
				try{
					btnA.setEnabled(true);
					btnB.setEnabled(true);
					btnC.setEnabled(true);
					btnD.setEnabled(true);
					questions.remove(currentQuestion);
					addedTime=Integer.parseInt(lblNewLabel_2_1.getText());
					times.remove(currentQuestion);
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
	

