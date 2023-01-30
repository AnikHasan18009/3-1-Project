import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
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
import javax.swing.JTextArea;
import java.awt.SystemColor;

public class QuestionShow extends JFrame {

	private JPanel contentPane;
//	public static void main(String[] args) {
//		
//	}

	
	public QuestionShow(String num) {
		setAlwaysOnTop(true);
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 140, 580, 480);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(255, 255, 255));
		contentPane.setBackground(new Color(0, 51, 102));
		contentPane.setBorder(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1_6 = new JLabel("Question No.");
		lblNewLabel_1_6.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_6.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_6.setBounds(10, 11, 94, 14);
		contentPane.add(lblNewLabel_1_6);
		
		JButton btnNewButton = new JButton("X");
		btnNewButton.setBorder(null);
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SeeQuestions.opened=0;
				SeeQuestions.table.enable(true);
				setVisible(false);
			}
		});
		btnNewButton.setForeground(new Color(0, 51, 102));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton.setBounds(527, 6, 43, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("0");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2.setBackground(new Color(255, 255, 255));
		lblNewLabel_2.setBounds(114, 8, 63, 21);
		contentPane.add(lblNewLabel_2);
		
		
			
			JTextArea textArea = new JTextArea();
			textArea.setColumns(200);
			textArea.setWrapStyleWord(true);
			textArea.setLineWrap(true);
			textArea.setRows(2);
			textArea.setBounds(10, 68, 552, 40);
			contentPane.add(textArea);
			
			JTextArea textArea_1 = new JTextArea();
			textArea_1.setColumns(200);
			textArea_1.setRows(2);
			textArea_1.setBounds(10, 136, 552, 40);
			contentPane.add(textArea_1);
			
			JTextArea textArea_2 = new JTextArea();
			textArea_2.setRows(2);
			textArea_2.setBounds(10, 205, 552, 40);
			contentPane.add(textArea_2);
			
			JTextArea textArea_3 = new JTextArea();
			textArea_3.setRows(2);
			textArea_3.setBounds(10, 272, 552, 40);
			contentPane.add(textArea_3);
			
			JTextArea textArea_4 = new JTextArea();
			textArea_4.setRows(2);
			textArea_4.setBounds(10, 339, 552, 40);
			contentPane.add(textArea_4);
			
			JTextArea textArea_5 = new JTextArea();
			textArea_5.setColumns(200);
			textArea_5.setRows(2);
			textArea_5.setBounds(10, 406, 552, 40);
			contentPane.add(textArea_5);
			
			JLabel lblNewLabel = new JLabel("Question");
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblNewLabel.setForeground(SystemColor.text);
			lblNewLabel.setBounds(10, 49, 94, 14);
			contentPane.add(lblNewLabel);
			
			JLabel lblOption = new JLabel("Option 1");
			lblOption.setForeground(Color.WHITE);
			lblOption.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblOption.setBounds(10, 119, 94, 14);
			contentPane.add(lblOption);
			
			JLabel lblOption_1 = new JLabel("Option 2");
			lblOption_1.setForeground(Color.WHITE);
			lblOption_1.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblOption_1.setBounds(10, 187, 94, 14);
			contentPane.add(lblOption_1);
			
			JLabel lblOption_2 = new JLabel("Option 3");
			lblOption_2.setForeground(Color.WHITE);
			lblOption_2.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblOption_2.setBounds(10, 256, 94, 14);
			contentPane.add(lblOption_2);
			
			JLabel lblOption_3 = new JLabel("Option 4");
			lblOption_3.setForeground(Color.WHITE);
			lblOption_3.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblOption_3.setBounds(10, 323, 94, 14);
			contentPane.add(lblOption_3);
			
			JLabel lblAnswer = new JLabel("Answer");
			lblAnswer.setForeground(Color.WHITE);
			lblAnswer.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblAnswer.setBounds(10, 390, 94, 14);
			contentPane.add(lblAnswer);
			try {
				Connection c=DBconnection.mysqlcon();	
				Statement s= c.createStatement();
				ResultSet r=s.executeQuery("select * from `"+AdminHome.selected_exam+"` where number='"+num+"'");
				if(r.next()) {
					lblNewLabel_2.setText(num);
					textArea.setText(r.getString(2));
					textArea_1.setText(r.getString(3));
					textArea_2.setText(r.getString(4));
					textArea_3.setText(r.getString(5));
					textArea_4.setText(r.getString(6));
					textArea_5.setText(r.getString(7));
					textArea.setEditable(false);
					textArea_1.setEditable(false);
					textArea_2.setEditable(false);
					textArea_3.setEditable(false);
					textArea_4.setEditable(false);
					textArea_5.setEditable(false);
				}
			}
			catch(Exception e)
			{
				JFrame er= new JFrame();
				er.setAlwaysOnTop(true);
				JOptionPane.showMessageDialog(er,e);
			}
	
}

}