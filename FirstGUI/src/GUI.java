import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.sql.*;

public class GUI implements ActionListener{
	
	private static JLabel userlabel;
	private static JTextField userText;
	private static JLabel userPassword;
	private static JPasswordField passwordText;
	private static JButton button;
	private static JButton button2;
	private static JLabel success;
	
	Connection conn=null;
	PreparedStatement pst= null;
	ResultSet rs = null;
	
	public static void main(String[] args) {
		
		JPanel panel = new JPanel();
		
		JFrame frame = new JFrame("MyFlights Login");
		frame.setSize(400,200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		frame.add(panel);
		
		panel.setLayout(null);
		
		userlabel = new JLabel("User");
		userlabel.setBounds(10,20,80,25);
		panel.add(userlabel);
		
		userText = new JTextField();
		userText.setBounds(100,20,165,20);
		panel.add(userText);
		
		userPassword = new JLabel("Password");
		userPassword.setBounds(10,50,80,25);
		panel.add(userPassword);
		
		passwordText = new JPasswordField();
		passwordText.setBounds(100,50,165,25);
		panel.add(passwordText);
		
		button = new JButton("Login");
		button.setBounds(10,100,90,30);
		button.addActionListener(new ActionListener() 
		{	@Override
			public void actionPerformed(ActionEvent e) {
				
				String user = userText.getText();
				@SuppressWarnings("deprecation")
				String password = passwordText.getText();
				Login user1 = new Login(user,password);
				user1.logging();					
				}
		});
		panel.add(button);
		
		button2 = new JButton("Register");
		button2.setBounds(250,100,90,30);
		button2.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String user = userText.getText();
				@SuppressWarnings("deprecation")
				String password = passwordText.getText();				
				Register user1 = new Register(user,password);
				user1.registering();
					
				}
		});		
		panel.add(button2);
		
		success = new JLabel("");
		success.setBounds(130,100,150,25);
		panel.add(success);
		frame.setVisible(true);		
		
	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}}


