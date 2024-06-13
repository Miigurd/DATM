package dATM;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class Dashboard extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private BufferedImage backgroundImage;
	private Balance balance;
	private Withdraw withdraw;
	private Deposit deposit;
	private DeactivateAccount deactivate;
	private DefaultTableModel database;
	private int i;
	private String a;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Dashboard frame = new Dashboard(new DefaultTableModel(), 0);
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Dashboard(DefaultTableModel database, int i) {
		this.database = database;
		this.i = i;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1024, 768);

		// Load background image
		try {
			backgroundImage = ImageIO.read(new File("C:\\Users\\Kirt Asia\\Desktop\\School\\1CS-A\\2nd Sem\\CCS103\\dATM img\\bg.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		// Custom JPanel for background image
		contentPane = new JPanel() {
			private static final long serialVersionUID = 1L;

			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				if (backgroundImage != null) {
					Graphics2D g2d = (Graphics2D) g;
					g2d.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
				}
			}
		};

		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);  // Using null layout for custom placement of components
		
		// Custom panel for logo image
		JPanel logoPanel = new ImagePanel("C:\\Users\\Kirt Asia\\Desktop\\School\\1CS-A\\2nd Sem\\CCS103\\dATM img\\Dangal ATM Dashboard.png");
		logoPanel.setBounds(175, 15, 200, 80);
		contentPane.add(logoPanel);
		
		JButton CBbtn = new JButton("Check Balance");
		
		CBbtn.setText("CHECK BALANCE");
		CBbtn.setForeground(new Color(0, 102, 51));
		CBbtn.setFont(new Font("Poppins Medium", Font.BOLD, 40));
		CBbtn.setBounds(55, 108, 435, 159);
		CBbtn.setBackground(new Color(153, 204, 153));
		contentPane.add(CBbtn);
		
		JButton withdrawBtn = new JButton("WITHDRAW");
		
		withdrawBtn.setFont(new Font("Poppins Medium", Font.BOLD, 40));
		withdrawBtn.setBackground(new Color(153, 204, 153));
		withdrawBtn.setForeground(new Color(0, 102, 51));
		withdrawBtn.setBounds(55, 309, 435, 159);
		contentPane.add(withdrawBtn);
		
		JButton depositBtn = new JButton("DEPOSIT");
		depositBtn.setFont(new Font("Poppins Medium", Font.BOLD, 40));
		depositBtn.setForeground(new Color(0, 102, 51));
		depositBtn.setBackground(new Color(153, 204, 153));
		depositBtn.setBounds(55, 506, 435, 159);
		contentPane.add(depositBtn);
		
		JButton deactivateBtn = new JButton("DEACTIVATE");
		deactivateBtn.setForeground(new Color(0, 102, 51));
		deactivateBtn.setFont(new Font("Poppins Medium", Font.BOLD, 40));
		deactivateBtn.setBackground(new Color(255, 127, 127));
		deactivateBtn.setBounds(527, 506, 435, 159);
		contentPane.add(deactivateBtn);
		
//		------------- EVENTS -----------
		
		CBbtn.addActionListener(new ActionListener() {	
			public void actionPerformed(ActionEvent e) {
				balance = new Balance(database, i );
				balance.setVisible(true);
				balance.setLocationRelativeTo(null);
				Dashboard.this.dispose();
			}
		});
		
		withdrawBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				a = "Withdraw";
				withdraw = new Withdraw(database, i,a);
				withdraw.setVisible(true);
				withdraw.setLocationRelativeTo(null);
				Dashboard.this.dispose();
			}
		});

		depositBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				a = "Deposit";
				deposit = new Deposit(database, i, a);
				deposit.setVisible(true);
				deposit.setLocationRelativeTo(null);
				Dashboard.this.dispose();
			}
		});

		deactivateBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deactivate = new DeactivateAccount(database, i);
				deactivate.setVisible(true);
				deactivate.setLocationRelativeTo(null);
				Dashboard.this.dispose();
			}
		});
	}

	// Custom JPanel class for displaying an image
	class ImagePanel extends JPanel {
		private static final long serialVersionUID = 1L;
		private BufferedImage image;

		public ImagePanel(String imagePath) {
			try {
				image = ImageIO.read(new File(imagePath));
			} catch (IOException e) {
				e.printStackTrace();
			}
			setOpaque(false);
		}

		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			if (image != null) {
				g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
			}
		}
	}
}
