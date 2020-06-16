package project;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import net.proteanit.sql.DbUtils;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;


@SuppressWarnings("serial")
public class GUI extends JPanel {
	
	static Logger logger = Logger.getLogger(GUI.class);
	
	private final static int defH = 300;
	private final static int defW = 400;
	private static JTable table;
	private static JTable table2;
	private static Color white = new Color(238, 238, 238);
	private static Color purple = new Color(8, 11, 63);
	private static JTextField loginfield;
	private static JPasswordField passwordfield;
	private static JPasswordField registerfield1;
	private static JTextField registerfield2;
	private static JTextField registerfield3;
	private static JTextField registerfield4;
	private static JTextField registerfield5;
	private static JTextField rescancelfield;
	private static JTextField flytextfield1;
	private static JTextField flytextfield2;
	private static JTextField changepassfield;
	private static JTextField changepassfieldold;
	private static JTable table3;
	
@SuppressWarnings({ "rawtypes", "unchecked" })
static void createGUI() {
	
	JFrame f = new JFrame("DBAir");
	User user = new User();
	
	PropertyConfigurator.configure("log4j.properties");
	logger.trace("GUI logger configured");
	
	/*
	
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
	JPanel login = new JPanel();
	JPanel register = new JPanel();
	JPanel changepass = new JPanel();
	JPanel userdata = new JPanel();
	
	//main panel
	
	panel1.setBackground(purple);
	panel1.setLayout(null);
	panel1.setPreferredSize(new Dimension(defW, defH));
	
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
			logger.info("Menu: My reservations");
		}
	});
	button1_1.setFont(new Font("Source Serif Pro Black", Font.ITALIC, 14));
	button1_1.setForeground(purple);
	button1_1.setBackground(white);
	button1_1.setBounds(10, 152, 120, 60);
	panel1.add(button1_1);
	
	JButton button1_2 = new JGradientButton("<html> <center> Flight search </html>");
	button1_2.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			f.setContentPane(fly);
			f.pack();
			logger.info("Menu: Flight search");
		}
	});
	button1_2.setFont(new Font("Source Serif Pro Black", Font.ITALIC, 14));
	button1_2.setForeground(purple);
	button1_2.setBackground(white);
	button1_2.setBounds(10, 229, 120, 60);
	panel1.add(button1_2);
	
	JButton button1_3 = new JGradientButton("<html> <center> Show my <br/> personal data </html>");
	button1_3.setFont(new Font("Source Serif Pro Black", Font.ITALIC, 14));
	button1_3.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			f.setContentPane(userdata);
			f.pack();
			logger.info("Menu: User data");
		}
	});
	button1_3.setForeground(purple);
	button1_3.setBackground(white);
	button1_3.setBounds(140, 152, 120, 60);
	panel1.add(button1_3);
	
	JButton button1_4 = new JGradientButton("<html> <center> Change password </html>");
	button1_4.setFont(new Font("Source Serif Pro Black", Font.ITALIC, 14));
	button1_4.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			f.setContentPane(changepass);
			f.pack();
			logger.info("Menu: Change pass");
		}
	});
	button1_4.setForeground(purple);
	button1_4.setBackground(white);
	button1_4.setBounds(270, 152, 120, 60);
	panel1.add(button1_4);
	
	JButton button1_5 = new JGradientButton("<html> <center> Logout </html>");
	button1_5.setFont(new Font("Source Serif Pro Black", Font.ITALIC, 14));
	button1_5.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			f.setContentPane(login);
			f.pack();
			passwordfield.setText("");
			loginfield.setText("");
			logger.info("Menu: Logout");
		}
	});
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
		logger.info("Menu: Close program");
		f.dispatchEvent(new WindowEvent(f, WindowEvent.WINDOW_CLOSING));
		}
	});
	panel1.add(button1_6);
	
	//reservations panel

	reservations.setPreferredSize(new Dimension((defW+200), defH));
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
				logger.info("Show reservations button");
				java.sql.Connection conn = DBConnection.ConnectDB();
				ResultSet rs = Reservations.ShowUserReservations(conn, user.username);
				table.setModel(DbUtils.resultSetToTableModel(rs));
				conn.close();		
			}
			catch (Exception exept) {
				exept.printStackTrace();
				logger.error(exept);
			}	
		}
	});
	showtabBut.setFont(new Font("Source Serif Pro Black", Font.ITALIC, 14));
	showtabBut.setBounds(20, 92, 170, 23);
	reservations.add(showtabBut);
	
	JButton backButton = new JGradientButton("Back to menu");
	backButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			logger.info("Back to menu");
			f.setContentPane(panel1);
			f.pack();
		}
	});
	backButton.setFont(new Font("Source Serif Pro Black", Font.ITALIC, 14));
	backButton.setBounds(210, 92, 170, 23);
	reservations.add(backButton);
	
	JLabel reslabel1 = new JLabel("<html> <center> Cancel  Reservation </html>");
	reslabel1.setForeground(white);
	reslabel1.setBounds(410, 11, 171, 85);
	reslabel1.setHorizontalAlignment(SwingConstants.CENTER);
	reslabel1.setFont(new Font("Source Serif Pro Black", Font.ITALIC, 30));
	reservations.add(reslabel1);
	
	JLabel reslabel2 = new JLabel("Reservation ID");
	reslabel2.setForeground(white);
	reslabel2.setFont(new Font("Tahoma", Font.BOLD, 11));
	reslabel2.setHorizontalAlignment(SwingConstants.CENTER);
	reslabel2.setBounds(455, 119, 86, 14);
	reservations.add(reslabel2);
	
	rescancelfield = new JTextField();
	rescancelfield.setBounds(455, 144, 86, 20);
	reservations.add(rescancelfield);
	rescancelfield.setColumns(10);
	
	JButton cancelresbut = new JGradientButton("Done");
	cancelresbut.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			logger.info("Cancel reservation called");
			int resID = Integer.parseInt(rescancelfield.getText());
			Reservations.CancelReservation(user.username, resID);
		}
	});
	cancelresbut.setFont(new Font("Tahoma", Font.BOLD, 11));
	cancelresbut.setBounds(452, 190, 89, 23);
	reservations.add(cancelresbut);
	
	// All flights sort list
	
	ArrayList<String> sortby = new ArrayList();
		sortby.add("ID");
		sortby.add("Origin");
		sortby.add("Destination");
		sortby.add("FlightDate");
		sortby.add("Airlines");
		sortby.add("FreeSeats");
		sortby.add("Price");

	
	// All flights panel
	
	fly.setPreferredSize(new Dimension((defW+400), defH));
	fly.setBackground(purple);
	fly.setLayout(null);
	
	JLabel label3_1 = new JLabel("Flights");
	label3_1.setForeground(white);
	label3_1.setHorizontalAlignment(SwingConstants.CENTER);
	label3_1.setFont(new Font("Source Serif Pro Black", Font.ITALIC, 36));
	label3_1.setBounds(110, 11, 380, 70);
	fly.add(label3_1);
	
	JScrollPane scrollPane2 = new JScrollPane();
	scrollPane2.setBounds(20, 120, 560, 160);
	fly.add(scrollPane2);
	
	table2 = new JTable();
	scrollPane2.setViewportView(table2);
	
	JButton showflyBut = new JGradientButton("Show all flights");
	showflyBut.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			try {
				logger.info("Show all flights called");
				java.sql.Connection conn = DBConnection.ConnectDB();
				ResultSet rs = Flight.ShowFlights(conn);
				table2.setModel(DbUtils.resultSetToTableModel(rs));
				conn.close();
			}
			
			catch (Exception exept) {
				exept.printStackTrace();
				logger.error(exept);
			}
		}
	});
	showflyBut.setFont(new Font("Source Serif Pro Black", Font.ITALIC, 14));
	showflyBut.setBounds(20, 92, 170, 23);
	fly.add(showflyBut);
	
	JButton backButton2 = new JGradientButton("Back to menu");
	backButton2.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			logger.info("Back to menu");
			f.setContentPane(panel1);
			f.pack();
		}
	});
	backButton2.setFont(new Font("Source Serif Pro Black", Font.ITALIC, 14));
	backButton2.setBounds(410, 92, 170, 23);	
	fly.add(backButton2);
	
	//right side of flights
	
	JLabel flylabel1 = new JLabel("Sort by:");
	flylabel1.setForeground(white);
	flylabel1.setHorizontalAlignment(SwingConstants.CENTER);
	flylabel1.setFont(new Font("Tahoma", Font.BOLD, 16));
	flylabel1.setBounds(610, 11, 92, 18);
	fly.add(flylabel1);
	
	JComboBox flybox = new JComboBox(sortby.toArray());
	flybox.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			try {
				java.sql.Connection conn = DBConnection.ConnectDB();
				JComboBox cb = (JComboBox)e.getSource();
				String sort = (String)cb.getSelectedItem();
				logger.info("Combobox interaction: "+sort);
				ResultSet rs = Flight.ShowOrderedFlights(sort, conn);
				table2.setModel(DbUtils.resultSetToTableModel(rs));
				conn.close();
			}
			catch (Exception exept) {
				exept.printStackTrace();
				logger.error(exept);
			}
		}
	});
	flybox.setBounds(694, 11, 86, 22);
	fly.add(flybox);
	
	JLabel flylabel2 = new JLabel("<html> <center> Make reservation </html>");
	flylabel2.setForeground(white);
	flylabel2.setHorizontalAlignment(SwingConstants.CENTER);
	flylabel2.setFont(new Font("Source Serif Pro Black", Font.ITALIC, 30));
	flylabel2.setBounds(610, 60, 170, 70);
	fly.add(flylabel2);
	
	JLabel flylabel3 = new JLabel("Flight ID");
	flylabel3.setForeground(white);
	flylabel3.setFont(new Font("Tahoma", Font.BOLD, 11));
	flylabel3.setBounds(620, 156, 64, 14);
	fly.add(flylabel3);
	
	JLabel flylabel4 = new JLabel("<html> <center> Number of tickets </html>");
	flylabel4.setFont(new Font("Tahoma", Font.BOLD, 11));
	flylabel4.setForeground(white);
	flylabel4.setBounds(620, 189, 64, 28);
	fly.add(flylabel4);
	
	flytextfield1 = new JTextField();
	flytextfield1.setBounds(694, 153, 86, 20);
	fly.add(flytextfield1);
	flytextfield1.setColumns(10);
	
	flytextfield2 = new JTextField();
	flytextfield2.setBounds(694, 193, 86, 20);
	fly.add(flytextfield2);
	flytextfield2.setColumns(10);
	
	JButton flybutton1 = new JButton("Done");
	flybutton1.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			logger.info("Reservation called");
				int flyID = Integer.parseInt(flytextfield1.getText());
				int Noftickets = Integer.parseInt(flytextfield2.getText());
				Reservations.Reserve(user.username, flyID, Noftickets);
		}
	});
	flybutton1.setFont(new Font("Tahoma", Font.BOLD, 11));
	flybutton1.setBounds(653, 232, 89, 23);
	fly.add(flybutton1);
	
	
	
	// Login Panel
	
	login.setPreferredSize(new Dimension(defW, defH));
	login.setBackground(purple);
	login.setLayout(null);
	
	JLabel loginlabel1 = new JLabel("DBAir Login");
	loginlabel1.setForeground(white);
	loginlabel1.setHorizontalAlignment(SwingConstants.CENTER);
	loginlabel1.setFont(new Font("Source Serif Pro Black", Font.ITALIC, 36));
	loginlabel1.setBounds(10, 11, 380, 70);
	login.add(loginlabel1);
	
	loginfield = new JTextField();
	loginfield.setBounds(152, 107, 138, 20);
	login.add(loginfield);
	loginfield.setColumns(10);
	
	JLabel loginlabel2 = new JLabel("Username");
	loginlabel2.setForeground(white);
	loginlabel2.setFont(new Font("Tahoma", Font.BOLD, 11));
	loginlabel2.setBounds(77, 110, 65, 14);
	login.add(loginlabel2);
	
	JLabel loginlabel3 = new JLabel("Password");
	loginlabel3.setForeground(white);
	loginlabel3.setFont(new Font("Tahoma", Font.BOLD, 11));
	loginlabel3.setBounds(77, 141, 65, 14);
	login.add(loginlabel3);
	
	passwordfield = new JPasswordField();
	passwordfield.setBounds(152, 138, 138, 20);
	login.add(passwordfield);
	
	JButton loginbutton = new JGradientButton("Login");
	loginbutton.addActionListener(new ActionListener() {
		@SuppressWarnings("deprecation")
		public void actionPerformed(ActionEvent e) {
				logger.info("Login pressed");
				String uname = loginfield.getText();
				String pass = passwordfield.getText();
				user.Login(uname, pass);
				if(user.op == 1) {
					f.setContentPane(panel1);
					f.pack();
				}
		}
	});
	loginbutton.setFont(new Font("Tahoma", Font.BOLD, 11));
	loginbutton.setBounds(170, 189, 89, 23);
	login.add(loginbutton);
	
	JButton registerbutton = new JGradientButton("Register");
	registerbutton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			logger.info("Register pressed");
			f.setContentPane(register);
			f.pack();
			}
		});
	registerbutton.setFont(new Font("Tahoma", Font.BOLD, 11));
	registerbutton.setBounds(170, 224, 89, 23);
	login.add(registerbutton);
	
	//registration panel 
	
	register.setPreferredSize(new Dimension(defW, defH));
	register.setBackground(purple);
	register.setLayout(null);
	
	JLabel registerlabel = new JLabel("Registration");
	registerlabel.setHorizontalAlignment(SwingConstants.CENTER);
	registerlabel.setFont(new Font("Source Serif Pro Black", Font.ITALIC, 36));
	registerlabel.setForeground(white);
	registerlabel.setBounds(10, 11, 380, 51);
	register.add(registerlabel);
	
	registerfield1 = new JPasswordField();
	registerfield1.setBounds(220, 110, 86, 20);
	register.add(registerfield1);
	registerfield1.setColumns(10);
	
	registerfield2 = new JTextField();
	registerfield2.setColumns(10);
	registerfield2.setBounds(220, 145, 86, 20);
	register.add(registerfield2);
	
	registerfield3 = new JTextField();
	registerfield3.setColumns(10);
	registerfield3.setBounds(220, 180, 86, 20);
	register.add(registerfield3);
	
	registerfield4 = new JTextField();
	registerfield4.setColumns(10);
	registerfield4.setBounds(220, 215, 86, 20);
	register.add(registerfield4);
	
	registerfield5 = new JTextField();
	registerfield5.setColumns(10);
	registerfield5.setBounds(220, 75, 86, 20);
	register.add(registerfield5);
	
	JButton registerButt = new JGradientButton("Register");
	registerButt.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			logger.info("Registration");
			String uname = registerfield5.getText();
			@SuppressWarnings("deprecation")
			String pass = registerfield1.getText();
			String name = registerfield2.getText();
			String surname = registerfield3.getText();
			String email = registerfield4.getText();
			user.Register(uname, pass, name, surname, email);
			f.setContentPane(login);
			f.pack();
			}
		});
	registerButt.setBounds(110, 246, 89, 23);
	registerButt.setFont(new Font("Tahoma", Font.BOLD, 11));
	register.add(registerButt);
	
	JLabel registerlabel1 = new JLabel("Username");
	registerlabel1.setBounds(105, 78, 65, 14);
	registerlabel1.setForeground(white);
	registerlabel1.setFont(new Font("Tahoma", Font.BOLD, 11));
	register.add(registerlabel1);
	
	JLabel registerlabel2 = new JLabel("Password");
	registerlabel2.setFont(new Font("Tahoma", Font.BOLD, 11));
	registerlabel2.setForeground(white);
	registerlabel2.setBounds(105, 113, 65, 14);
	register.add(registerlabel2);
	
	JLabel registerlabel3 = new JLabel("Name");
	registerlabel3.setFont(new Font("Tahoma", Font.BOLD, 11));
	registerlabel3.setForeground(white);
	registerlabel3.setBounds(105, 148, 65, 14);
	register.add(registerlabel3);
	
	JLabel registerlabel4 = new JLabel("Surname");
	registerlabel4.setFont(new Font("Tahoma", Font.BOLD, 11));
	registerlabel4.setForeground(white);
	registerlabel4.setBounds(105, 183, 65, 14);
	register.add(registerlabel4);
	
	JLabel registerlabel5 = new JLabel("Email");
	registerlabel5.setFont(new Font("Tahoma", Font.BOLD, 11));
	registerlabel5.setForeground(white);
	registerlabel5.setBounds(105, 218, 65, 14);
	register.add(registerlabel5);
	
	JButton registerButtback = new JGradientButton("Back");
	registerButtback.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			logger.info("Back to login");
			f.setContentPane(login);
			f.pack();
			}
		});
	registerButtback.setBounds(220, 246, 89, 23);
	registerButtback.setFont(new Font("Tahoma", Font.BOLD, 11));
	register.add(registerButtback);
	
	// change password field
	
	changepass.setPreferredSize(new Dimension(defW, defH));
	changepass.setBackground(purple);
	changepass.setLayout(null);
	
	JLabel changepasslabel1 = new JLabel("<html> <center> Change password </html>");
	changepasslabel1.setForeground(white);
	changepasslabel1.setFont(new Font("Source Serif Pro Black", Font.ITALIC, 36));
	changepasslabel1.setHorizontalAlignment(SwingConstants.CENTER);
	changepasslabel1.setBounds(10, 11, 380, 75);
	changepass.add(changepasslabel1);
	
	JLabel changepasslabel2 = new JLabel("New password");
	changepasslabel2.setForeground(white);
	changepasslabel2.setFont(new Font("Tahoma", Font.BOLD, 11));
	changepasslabel2.setHorizontalAlignment(SwingConstants.CENTER);
	changepasslabel2.setBounds(81, 135, 97, 14);
	changepass.add(changepasslabel2);
	
	changepassfield = new JTextField();
	changepassfield.setBounds(188, 132, 86, 20);
	changepass.add(changepassfield);
	changepassfield.setColumns(10);
	
	JLabel changepasslabel3 = new JLabel("Old password");
	changepasslabel3.setForeground(white);
	changepasslabel3.setFont(new Font("Tahoma", Font.BOLD, 11));
	changepasslabel3.setHorizontalAlignment(SwingConstants.CENTER);
	changepasslabel3.setBounds(81, 100, 97, 14);
	changepass.add(changepasslabel3);
	
	changepassfieldold = new JTextField();
	changepassfieldold.setBounds(188, 97, 86, 20);
	changepass.add(changepassfieldold);
	changepassfieldold.setColumns(10);
	
	JButton changepassbutton = new JGradientButton("Change");
	changepassbutton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			logger.info("Change password called");
			String newpass = changepassfield.getText();
			String oldpass = changepassfieldold.getText();
			user.ChangePassword(oldpass, newpass);
		}
	});
	changepassbutton.setFont(new Font("Tahoma", Font.BOLD, 11));
	changepassbutton.setBounds(140, 182, 89, 23);
	changepass.add(changepassbutton);
	
	JButton changepassmenu = new JGradientButton("Menu");
	changepassmenu.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			logger.info("Back to menu");
			f.setContentPane(panel1);
			f.pack();
		}
	});
	changepassmenu.setFont(new Font("Tahoma", Font.BOLD, 11));
	changepassmenu.setBounds(140, 216, 89, 23);
	changepass.add(changepassmenu);
	
	// show user data fields
	
	userdata.setBackground(purple);
	userdata.setLayout(null);
	userdata.setPreferredSize(new Dimension(defW, defH));
	
	JLabel datalabel1 = new JLabel("Your user data panel");
	datalabel1.setForeground(white);
	datalabel1.setHorizontalAlignment(SwingConstants.CENTER);
	datalabel1.setFont(new Font("Source Serif Pro Black", Font.ITALIC, 36));
	datalabel1.setBounds(10, 11, 380, 70);
	userdata.add(datalabel1);
	
	JScrollPane scrollPane3 = new JScrollPane();
	scrollPane3.setBounds(20, 100, 360, 80);
	userdata.add(scrollPane3);
	
	table3 = new JTable();
	scrollPane3.setViewportView(table3);
	
	JButton databackmenu = new JGradientButton("Back to menu");
	databackmenu.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			logger.info("Back to menu");
			f.setContentPane(panel1);
			f.pack();
		}
	});
	databackmenu.setFont(new Font("Source Serif Pro Black", Font.ITALIC, 14));
	databackmenu.setBounds(210, 210, 170, 23);
	userdata.add(databackmenu);
	
	JButton datashow = new JGradientButton("Refresh user data");
	datashow.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			try {
				logger.info("Refresh data call");
				java.sql.Connection conn = DBConnection.ConnectDB();
				ResultSet rs = user.ShowUserData(conn);
				table3.setModel(DbUtils.resultSetToTableModel(rs));
				conn.close();		
			}
			catch (Exception exept) {
				exept.printStackTrace();
				logger.error(exept);
			}
		}
	});
	datashow.setFont(new Font("Source Serif Pro Black", Font.ITALIC, 14));
	datashow.setBounds(20, 210, 170, 23);
	userdata.add(datashow);
	
	
	
	f.setContentPane(login);
	
	f.pack();
	f.setLocationRelativeTo(null);
	f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	f.setVisible(true);
}
}


// change password , logout zamiast flight search / make reservation
// + list of all flights(reservation, sort)

// cancel reservation




