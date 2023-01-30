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

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.SwingConstants;

public class Score extends JFrame {

	private JPanel contentPane;


	
	public Score(String name,String id,String dept,String ses,String exam,String tmark,String omark,String date,String time) {
		setAlwaysOnTop(true);
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(225, 120, 1000, 450);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(255, 255, 255));
		contentPane.setBackground(new Color(0, 51, 102));
		contentPane.setBorder(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("X");
		btnNewButton.setBorder(null);
		btnNewButton.setBackground(new Color(0, 51, 102));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				StudentScores.running=0;
				StudentScores.table.enable(true);
				MyScore.opened=0;
				MyScore.table.enable(true);
			}
		});
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton.setBounds(957, 11, 43, 23);
		contentPane.add(btnNewButton);
		
		
			
			JTextArea textArea = new JTextArea(name);
			textArea.setBackground(new Color(0, 51, 102));
			textArea.setForeground(Color.WHITE);
			textArea.setFont(new Font("Tahoma", Font.BOLD, 16));
			textArea.setColumns(200);
			textArea.setWrapStyleWord(true);
			textArea.setLineWrap(true);
			textArea.setRows(2);
			textArea.setBounds(167, 91, 409, 23);
			contentPane.add(textArea);
			
			JTextArea textArea_1 = new JTextArea(id);
			textArea_1.setBackground(new Color(0, 51, 102));
			textArea_1.setForeground(Color.WHITE);
			textArea_1.setFont(new Font("Tahoma", Font.BOLD, 16));
			textArea_1.setColumns(200);
			textArea_1.setRows(2);
			textArea_1.setBounds(658, 91, 216, 23);
			contentPane.add(textArea_1);
			
			JTextArea textArea_2 = new JTextArea(dept);
			textArea_2.setBackground(new Color(0, 51, 102));
			textArea_2.setForeground(Color.WHITE);
			textArea_2.setFont(new Font("Tahoma", Font.BOLD, 16));
			textArea_2.setRows(2);
			textArea_2.setBounds(218, 154, 356, 23);
			contentPane.add(textArea_2);
			
			JTextArea textArea_3 = new JTextArea(ses);
			textArea_3.setBackground(new Color(0, 51, 102));
			textArea_3.setForeground(Color.WHITE);
			textArea_3.setFont(new Font("Tahoma", Font.BOLD, 16));
			textArea_3.setRows(2);
			textArea_3.setBounds(701, 154, 169, 23);
			contentPane.add(textArea_3);
			
			JTextArea textArea_4 = new JTextArea(date);
			textArea_4.setBackground(new Color(0, 51, 102));
			textArea_4.setForeground(Color.WHITE);
			textArea_4.setFont(new Font("Tahoma", Font.BOLD, 16));
			textArea_4.setRows(2);
			textArea_4.setBounds(161, 217, 129, 23);
			contentPane.add(textArea_4);
			
			JTextArea textArea_5 = new JTextArea(exam);
			textArea_5.setBackground(new Color(0, 51, 102));
			textArea_5.setForeground(Color.WHITE);
			textArea_5.setFont(new Font("Tahoma", Font.BOLD, 16));
			textArea_5.setColumns(200);
			textArea_5.setRows(2);
			textArea_5.setBounds(167, 280, 447, 23);
			contentPane.add(textArea_5);
			
			JLabel lblNewLabel = new JLabel("Name:");
			lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
			lblNewLabel.setForeground(SystemColor.text);
			lblNewLabel.setBounds(104, 89, 65, 23);
			contentPane.add(lblNewLabel);
			
			JLabel lblOption = new JLabel("ID:");
			lblOption.setHorizontalAlignment(SwingConstants.LEFT);
			lblOption.setForeground(Color.WHITE);
			lblOption.setFont(new Font("Tahoma", Font.BOLD, 16));
			lblOption.setBounds(629, 89, 35, 23);
			contentPane.add(lblOption);
			
			JLabel lblOption_1 = new JLabel("Department:");
			lblOption_1.setHorizontalAlignment(SwingConstants.LEFT);
			lblOption_1.setForeground(Color.WHITE);
			lblOption_1.setFont(new Font("Tahoma", Font.BOLD, 16));
			lblOption_1.setBounds(104, 152, 104, 23);
			contentPane.add(lblOption_1);
			
			JLabel lblOption_2 = new JLabel("Session:");
			lblOption_2.setHorizontalAlignment(SwingConstants.LEFT);
			lblOption_2.setForeground(Color.WHITE);
			lblOption_2.setFont(new Font("Tahoma", Font.BOLD, 16));
			lblOption_2.setBounds(629, 152, 74, 23);
			contentPane.add(lblOption_2);
			
			JLabel lblOption_3 = new JLabel("Date:");
			lblOption_3.setHorizontalAlignment(SwingConstants.LEFT);
			lblOption_3.setForeground(Color.WHITE);
			lblOption_3.setFont(new Font("Tahoma", Font.BOLD, 16));
			lblOption_3.setBounds(104, 215, 43, 23);
			contentPane.add(lblOption_3);
			
			JLabel lblAnswer = new JLabel("Obtained Mark:");
			lblAnswer.setHorizontalAlignment(SwingConstants.LEFT);
			lblAnswer.setForeground(Color.WHITE);
			lblAnswer.setFont(new Font("Tahoma", Font.BOLD, 16));
			lblAnswer.setBounds(104, 342, 129, 23);
			contentPane.add(lblAnswer);
			
			JTextArea textArea_6 = new JTextArea(time);
			textArea_6.setBackground(new Color(0, 51, 102));
			textArea_6.setForeground(Color.WHITE);
			textArea_6.setFont(new Font("Tahoma", Font.BOLD, 16));
			textArea_6.setRows(2);
			textArea_6.setColumns(200);
			textArea_6.setBounds(686, 217, 184, 23);
			contentPane.add(textArea_6);
			
			JTextArea textArea_7 = new JTextArea(omark);
			textArea_7.setBackground(new Color(0, 51, 102));
			textArea_7.setForeground(Color.WHITE);
			textArea_7.setFont(new Font("Tahoma", Font.BOLD, 16));
			textArea_7.setRows(2);
			textArea_7.setColumns(200);
			textArea_7.setBounds(236, 343, 94, 23);
			contentPane.add(textArea_7);
			
			JTextArea textArea_8 = new JTextArea(tmark);
			textArea_8.setBackground(new Color(0, 51, 102));
			textArea_8.setForeground(Color.WHITE);
			textArea_8.setFont(new Font("Tahoma", Font.BOLD, 16));
			textArea_8.setRows(2);
			textArea_8.setColumns(200);
			textArea_8.setBounds(723, 280, 104, 23);
			contentPane.add(textArea_8);
			
			JLabel lblExam = new JLabel("Exam:");
			lblExam.setHorizontalAlignment(SwingConstants.LEFT);
			lblExam.setForeground(Color.WHITE);
			lblExam.setFont(new Font("Tahoma", Font.BOLD, 16));
			lblExam.setBounds(104, 278, 59, 23);
			contentPane.add(lblExam);
			
			JLabel lblTime = new JLabel("Time:");
			lblTime.setHorizontalAlignment(SwingConstants.LEFT);
			lblTime.setForeground(Color.WHITE);
			lblTime.setFont(new Font("Tahoma", Font.BOLD, 16));
			lblTime.setBounds(629, 215, 52, 23);
			contentPane.add(lblTime);
			
			JLabel lblTotalMark = new JLabel("Total Mark:");
			lblTotalMark.setHorizontalAlignment(SwingConstants.LEFT);
			lblTotalMark.setForeground(Color.WHITE);
			lblTotalMark.setFont(new Font("Tahoma", Font.BOLD, 16));
			lblTotalMark.setBounds(624, 278, 94, 23);
			contentPane.add(lblTotalMark);
			
	}
}
