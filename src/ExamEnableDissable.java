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
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class ExamEnableDissable extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ExamEnableDissable frame = new ExamEnableDissable("");
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
	public ExamEnableDissable(String exam) {
		setAlwaysOnTop(true);
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(480, 300, 400, 210);
		contentPane = new JPanel();
		contentPane.setFocusable(false);
		contentPane.setForeground(new Color(255, 255, 255));
		contentPane.setBackground(new Color(0, 51, 102));
		contentPane.setBorder(null);

		setContentPane(contentPane);
		
		JButton btnNewButton = new JButton("X");
		btnNewButton.setFocusable(false);
		btnNewButton.setBounds(334, 0, 43, 34);
		btnNewButton.setBorder(null);
		btnNewButton.setBackground(new Color(0, 51, 102));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		contentPane.setLayout(null);
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		contentPane.add(btnNewButton);
			
			JButton btnNewButton_1 = new JButton("Enable");
			btnNewButton_1.setBounds(30, 162, 114, 35);
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try{
					Connection c=DBconnection.mysqlcon();
					Statement s= c.createStatement();
					ResultSet r=s.executeQuery("select * from `enabled exams` where name='"+exam+"'");
					if(!r.next())
					{
					PreparedStatement st= c.prepareStatement("INSERT INTO `enabled exams` VALUES('"+exam+"')");
					st.executeUpdate();
					JFrame mess= new JFrame();
					mess.setAlwaysOnTop(true);
					JOptionPane.showMessageDialog(mess,"Enabled");
					}
					else {
						JFrame mess= new JFrame();
						mess.setAlwaysOnTop(true);
						JOptionPane.showMessageDialog(mess,"Already Enabled");
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
			btnNewButton_1.setBorder(null);
			btnNewButton_1.setForeground(new Color(0, 51, 102));
			btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 14));
			btnNewButton_1.setBackground(Color.WHITE);
			contentPane.add(btnNewButton_1);
			
			JButton btnNewButton_1_1 = new JButton("Dissable");
			btnNewButton_1_1.setFocusable(false);
			btnNewButton_1_1.setBounds(263, 162, 114, 35);
			btnNewButton_1_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try{
						Connection c=DBconnection.mysqlcon();
						Statement s= c.createStatement();
						ResultSet r=s.executeQuery("select * from `enabled exams` where name='"+exam+"'");
						if(r.next())
						{
							
							PreparedStatement st= c.prepareStatement("delete from `enabled exams` where name='"+exam+"'");
							st.executeUpdate();
						JFrame mess= new JFrame();
						mess.setAlwaysOnTop(true);
						JOptionPane.showMessageDialog(mess,"Dissabled");
						}
						else {
							JFrame mess= new JFrame();
							mess.setAlwaysOnTop(true);
							JOptionPane.showMessageDialog(mess,"Already Dissabled");
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
			btnNewButton_1_1.setForeground(new Color(0, 51, 102));
			btnNewButton_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
			btnNewButton_1_1.setBorder(null);
			btnNewButton_1_1.setBackground(Color.WHITE);
			contentPane.add(btnNewButton_1_1);
			
			JLabel lblNewLabel = new JLabel(exam);
			lblNewLabel.setBounds(10, 60, 378, 50);
			lblNewLabel.setForeground(Color.WHITE);
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			contentPane.add(lblNewLabel);
	}
}
