import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.*;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Insets;
import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AdminHome extends JFrame {
     public static int running=0;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminHome frame = new AdminHome();
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
	public AdminHome() {
		Border bd=BorderFactory.createLineBorder(new Color(148,0,211));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(40, 40, 1200, 600);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.desktop);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBorderPainted(false);
		menuBar.setBackground(SystemColor.text);
		
		menuBar.setBounds(300, 10, 590, 30);
		contentPane.add(menuBar);
		
		JMenu mnNewMenu = new JMenu("Add Question");
		mnNewMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(running == 0)
				{
					running=1;
					new AddQuestion().setVisible(true);
				}
				else {
					JFrame er= new JFrame();
					er.setAlwaysOnTop(true);
					JOptionPane.showMessageDialog(er,"One window already open!");
					
				}
			}
		});
		mnNewMenu.setBackground(new Color(240, 248, 255));
		mnNewMenu.setForeground(new Color(148, 0, 211));
		mnNewMenu.setFont(new Font("Times New Roman", Font.BOLD, 14));
		mnNewMenu.setBorder(new LineBorder(SystemColor.window, 4));
		menuBar.add(mnNewMenu);
		
		
		JMenu mnNewMenu_1 = new JMenu("Update Question");
		mnNewMenu_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(running == 0)
				{
					running=1;
					new UpdateQuestion().setVisible(true);
				}
				else {
					JFrame er= new JFrame();
					er.setAlwaysOnTop(true);
					JOptionPane.showMessageDialog(er,"One window already open!");
					
				}
			}
		});
		mnNewMenu_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		mnNewMenu_1.setForeground(new Color(148, 0, 211));
		mnNewMenu_1.setBorder(new LineBorder(SystemColor.window, 4));
		menuBar.add(mnNewMenu_1);
		
		JMenu mnNewMenu_2 = new JMenu("Delete Question");
	
		mnNewMenu_2.setForeground(new Color(148, 0, 211));
		mnNewMenu_2.setBorder(new LineBorder(SystemColor.window, 4));
		mnNewMenu_2.setFont(new Font("Times New Roman", Font.BOLD, 14));
		menuBar.add(mnNewMenu_2);
		
		JMenu mnNewMenu_3 = new JMenu("See Questions");
		mnNewMenu_3.setFont(new Font("Times New Roman", Font.BOLD, 14));
		mnNewMenu_3.setBorder(new LineBorder(SystemColor.window, 4));
		mnNewMenu_3.setForeground(new Color(148, 0, 211));
		menuBar.add(mnNewMenu_3);
		
		JMenu mnNewMenu_4 = new JMenu("Student Results");
		mnNewMenu_4.setForeground(new Color(148, 0, 211));
		mnNewMenu_4.setBorder(new LineBorder(SystemColor.window, 4));
		mnNewMenu_4.setFont(new Font("Times New Roman", Font.BOLD, 14));
		menuBar.add(mnNewMenu_4);
		
		JMenu mnLogout = new JMenu("Logout");
		mnLogout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(running==1)
				{
					JFrame er= new JFrame();
					er.setAlwaysOnTop(true);
					JOptionPane.showMessageDialog(er,"Close the opened window!");
				}
				else {
				JFrame lout= new JFrame();
				lout.setAlwaysOnTop(true);
				int decision= JOptionPane.showConfirmDialog(lout,"Do you want to logout?","",JOptionPane.YES_NO_OPTION);
				if(decision==0)
				{
					setVisible(false);
					new AdminLogin().setVisible(true);
				}}
			}
		});
		mnLogout.setBorder(new LineBorder(SystemColor.window, 4));
		mnLogout.setFont(new Font("Times New Roman", Font.BOLD, 14));
		mnLogout.setForeground(new Color(148, 0, 211));
		menuBar.add(mnLogout);
	}
}
