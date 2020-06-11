import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import net.proteanit.sql.DbUtils;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JTextField;


@SuppressWarnings("serial")
public class GUI extends JPanel {
	
	private final static int defWidth = 300;
	private final static int defHeight = 400;
	private static JTable table;
	private static JTable table2;
	

private static void createGUI() {
	
	JFrame f = new JFrame("DBAir");
	java.sql.Connection conn = DBConnection.ConnectDB();
	
	final String previous = "Previous";
	final String next = "Next";
	
	final JPanel cards = new JPanel(new CardLayout());
	
	ActionListener myActList = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			CardLayout cl = (CardLayout) cards.getLayout();
			if (e.getActionCommand().equals("Previous")) cl.previous(cards);
			else if (e.getActionCommand().equals("Next")) cl.next(cards);
		}
	};
	
	Color white = new Color(238, 238, 238);
	Color purple = new Color(8, 11, 63);
	
	/*
	JPanel control = new JPanel();
	control.setPreferredSize(new Dimension(defWidth, defHeight));
	
	JButton b1 = new JButton("Previous");
	JButton b2 = new JButton("Next");
	b1.addActionListener(myActList);
	b2.addActionListener(myActList);
	f.add(control, BorderLayout.SOUTH);
	*/
	
	//declarations of panels
	
	JPanel panel1 = new JPanel();
	JPanel reservations = new JPanel();
	JPanel fly = new JPanel();
	
	//main panel
	
	panel1.setBackground(purple);
	panel1.setLayout(null);
	panel1.setPreferredSize(new Dimension(defHeight, defWidth));
	
	JLabel label1_1 = new JLabel("Welcome to our");
	label1_1.setBounds(10, 11, 380, 25);
	label1_1.setForeground(white);
	label1_1.setHorizontalAlignment(SwingConstants.CENTER);
	label1_1.setFont(new Font("Trebuchet MS", Font.ITALIC, 30));
	panel1.add(label1_1);
	
	JLabel label1_2 = new JLabel("DBAir system!");
	label1_2.setBounds(10, 47, 380, 35);
	label1_2.setForeground(white);
	label1_2.setHorizontalAlignment(SwingConstants.CENTER);
	label1_2.setFont(new Font("Trebuchet MS", Font.ITALIC, 30));
	panel1.add(label1_2);
	
	JLabel label1_3 = new JLabel("Choose action to do");
	label1_3.setBounds(10, 93, 380, 25);
	label1_3.setHorizontalAlignment(SwingConstants.CENTER);
	label1_3.setForeground(new Color(238, 238, 238));
	label1_3.setFont(new Font("Trebuchet MS", Font.ITALIC, 30));
	panel1.add(label1_3);
	
	JButton button1_1 = new JGradientButton("<html>"
			+ "<center> My <br/> reservations </html>");
	button1_1.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			f.setContentPane(reservations);
			f.pack();
		}
	});
	button1_1.setFont(new Font("Source Serif Pro Black", Font.ITALIC, 14));
	button1_1.setForeground(purple);
	button1_1.setBackground(white);
	button1_1.setBounds(10, 152, 120, 60);
	panel1.add(button1_1);
	
	JButton button1_2 = new JGradientButton("<html> <center> List of all flights </html>");
	button1_2.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			f.setContentPane(fly);
			f.pack();
		}
	});
	button1_2.setFont(new Font("Source Serif Pro Black", Font.ITALIC, 14));
	button1_2.setForeground(purple);
	button1_2.setBackground(white);
	button1_2.setBounds(10, 229, 120, 60);
	panel1.add(button1_2);
	
	JButton button1_3 = new JGradientButton("<html> <center> Show my <br/> personal data </html>");
	button1_3.setFont(new Font("Source Serif Pro Black", Font.ITALIC, 14));
	button1_3.setForeground(purple);
	button1_3.setBackground(white);
	button1_3.setBounds(140, 152, 120, 60);
	panel1.add(button1_3);
	
	JButton button1_4 = new JGradientButton("Flight search");
	button1_4.setFont(new Font("Source Serif Pro Black", Font.ITALIC, 14));
	button1_4.setForeground(purple);
	button1_4.setBackground(white);
	button1_4.setBounds(270, 152, 120, 60);
	panel1.add(button1_4);
	
	JButton button1_5 = new JGradientButton("Logout");
	button1_5.setFont(new Font("Source Serif Pro Black", Font.ITALIC, 14));
	button1_5.setForeground(purple);
	button1_5.setBackground(white);
	button1_5.setBounds(140, 229, 120, 60);
	panel1.add(button1_5);
	
	JButton button1_6 = new JGradientButton("<html> <center> Close <br /> program </html>");
	button1_6.setFont(new Font("Source Serif Pro Black", Font.ITALIC, 14));
	button1_6.setForeground(purple);
	button1_6.setBackground(white);
	button1_6.setBounds(270, 229, 120, 60);
	button1_6.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		f.dispatchEvent(new WindowEvent(f, WindowEvent.WINDOW_CLOSING));
		}
	});
	panel1.add(button1_6);
	
	//reservations panel

	reservations.setPreferredSize(new Dimension(defHeight, defWidth));
	reservations.setBackground(purple);
	reservations.setLayout(null);
	
	JLabel label2_1 = new JLabel("Your reservations");
	label2_1.setForeground(white);
	label2_1.setHorizontalAlignment(SwingConstants.CENTER);
	label2_1.setFont(new Font("Source Serif Pro Black", Font.ITALIC, 36));
	label2_1.setBounds(10, 11, 380, 70);
	reservations.add(label2_1);
	
	JScrollPane scrollPane = new JScrollPane();
	scrollPane.setBounds(20, 120, 360, 160);
	reservations.add(scrollPane);
	
	table = new JTable();
	scrollPane.setViewportView(table);
	
	JButton showtabBut = new JGradientButton("Show reservations");
	showtabBut.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			try {
				String query="select * from Reservations";
				PreparedStatement pst = conn.prepareStatement(query);
				ResultSet rs = pst.executeQuery();
				table.setModel(DbUtils.resultSetToTableModel(rs));
			}
			
			catch (Exception exept) {
				exept.printStackTrace();
			}
			
		}
	});
	showtabBut.setFont(new Font("Source Serif Pro Black", Font.ITALIC, 14));
	showtabBut.setBounds(20, 92, 170, 23);
	reservations.add(showtabBut);
	
	JButton backButton = new JGradientButton("Back to menu");
	backButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			f.setContentPane(panel1);
			f.pack();
		}
	});
	backButton.setFont(new Font("Source Serif Pro Black", Font.ITALIC, 14));
	backButton.setBounds(210, 92, 170, 23);
	reservations.add(backButton);
	
	// All flights panel
	
	fly.setPreferredSize(new Dimension(defHeight, defWidth));
	fly.setBackground(purple);
	fly.setLayout(null);
	
	JLabel label3_1 = new JLabel("Your reservations");
	label3_1.setForeground(white);
	label3_1.setHorizontalAlignment(SwingConstants.CENTER);
	label3_1.setFont(new Font("Source Serif Pro Black", Font.ITALIC, 36));
	label3_1.setBounds(10, 11, 380, 70);
	fly.add(label3_1);
	
	JScrollPane scrollPane2 = new JScrollPane();
	scrollPane2.setBounds(20, 120, 360, 160);
	fly.add(scrollPane2);
	
	table2 = new JTable();
	scrollPane2.setViewportView(table2);
	
	JButton showflyBut = new JGradientButton("Show all flights");
	showflyBut.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			try {
				String query="select * from FlightsData";
				PreparedStatement pst = conn.prepareStatement(query);
				ResultSet rs = pst.executeQuery();
				table2.setModel(DbUtils.resultSetToTableModel(rs));
			}
			
			catch (Exception exept) {
				exept.printStackTrace();
			}
			
		}
	});
	showflyBut.setFont(new Font("Source Serif Pro Black", Font.ITALIC, 14));
	showflyBut.setBounds(20, 92, 170, 23);
	fly.add(showflyBut);
	
	JButton backButton2 = new JGradientButton("Back to menu");
	backButton2.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			f.setContentPane(panel1);
			f.pack();
		}
	});
	backButton2.setFont(new Font("Source Serif Pro Black", Font.ITALIC, 14));
	backButton2.setBounds(210, 92, 170, 23);	
	fly.add(backButton2);
	
	//Personal data panel
	
	
	
	
	
	f.setContentPane(panel1);
	
	f.pack();
	f.setLocationRelativeTo(null);
	f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	f.setVisible(true);
}




public static void main(String[] args) {
	javax.swing.SwingUtilities.invokeLater(new Runnable() {
		public void run() {
			createGUI();
		}
	});
}
}

