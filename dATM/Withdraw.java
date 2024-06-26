package dATM;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.geom.RoundRectangle2D;
import java.awt.event.ActionEvent;

public class Withdraw extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel bgPane;
	private BufferedImage backgroundImage;
	private Dashboard dashboard;
	private ReceiptAsk receiptAsk;
	private DefaultTableModel database;
	private int i;
	private String a;
	private String dataBalance;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Withdraw frame = new Withdraw(new DefaultTableModel(), 0, new String());
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
	public Withdraw(DefaultTableModel database, int i, String a) {
		this.database = database;
		this.i = i;
		this.a = a;
		
		setTitle("Withdraw Dashboard");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1024, 768);

		// Load background image
		try {
			backgroundImage = ImageIO.read(new File("C:\\Users\\Kirt Asia\\Dangal-ATM\\dATM\\img\\bg.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		// Custom JPanel for background image
		bgPane = new JPanel() {
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

		bgPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(bgPane);
		
		// Custom panel for logo image
		JPanel logoPnl = new ImagePanel("C:\\Users\\Kirt Asia\\Dangal-ATM\\dATM\\img\\Dangal ATM Dashboard.png");
		logoPnl.setBounds(380, 80, 250, 100);
		bgPane.setLayout(null);
		
		JPanel withdrawPnl = new RoundedPanel();
		withdrawPnl.setLayout(null);
		withdrawPnl.setBounds(40, 230, 930, 480);
		withdrawPnl.setBackground(new Color(255, 255, 255));
		
		JLabel withdrawLbl = new JLabel("Withdraw");
		withdrawLbl.setBounds(21, 25, 307, 43);
		withdrawLbl.setFont(new Font("Tahoma", Font.BOLD, 35));
		withdrawLbl.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel accInfoLbl = new JLabel("Account Information: ");
		accInfoLbl.setBounds(114, 79, 336, 33);
		accInfoLbl.setFont(new Font("Tahoma", Font.BOLD, 25));
		
		JLabel accNameLbl = new JLabel("Client Name:");
		accNameLbl.setBounds(140, 111, 140, 30);
		accNameLbl.setFont(new Font("Tahoma", Font.BOLD, 17));
		
		JLabel nameLbl = new JLabel();
		String getName = (String) database.getValueAt(i, 1);
		nameLbl.setText(getName);
		nameLbl.setBounds(294, 115, 250, 25);
		nameLbl.setFont(new Font("Tahoma", Font.BOLD, 15));
		nameLbl.setForeground(new Color(17, 141, 87));
		
		JLabel studNumLbl = new JLabel("Client No.:");
		studNumLbl.setBounds(140, 140, 108, 30);
		studNumLbl.setFont(new Font("Tahoma", Font.BOLD, 17));
		
		JLabel numberLbl = new JLabel();
		String getNum = (String) database.getValueAt(i, 0);
		numberLbl.setText(getNum);
		numberLbl.setBounds(294, 144, 135, 25);
		numberLbl.setFont(new Font("Tahoma", Font.BOLD, 15));
		numberLbl.setForeground(new Color(17, 141, 87));
	
		JLabel currentLbl = new JLabel("Current Balance:");
		currentLbl.setBounds(140, 168, 158, 30);
		currentLbl.setFont(new Font("Tahoma", Font.BOLD, 17));
		
		JLabel balanceLbl = new JLabel();
		String getBal = (String) database.getValueAt(i, 2);
		balanceLbl.setText("₱" + getBal);	
		balanceLbl.setBounds(294, 172, 258, 25);
		balanceLbl.setFont(new Font("Tahoma", Font.BOLD, 15));
		balanceLbl.setForeground(new Color(17, 141, 87));
		
		JLabel amountLbl = new JLabel("Amount:");
		amountLbl.setBounds(114, 220, 400, 21);
		amountLbl.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		JLabel pesoLbl = new JLabel("₱");
		pesoLbl.setFont(new Font("Tahoma", Font.BOLD, 95));
		pesoLbl.setBounds(36, 241, 78, 113);
		pesoLbl.setHorizontalAlignment(SwingConstants.CENTER);
		
		JTextField amountTxtField = new JTextField();
		amountTxtField.setBounds(117, 252, 765, 102);
		amountTxtField.setFont(new Font("Tahoma", Font.PLAIN, 44));
		amountTxtField.setBackground(new Color(192, 192, 192));
		amountTxtField.setForeground(new Color(0, 100, 0));
		amountTxtField.setHorizontalAlignment(SwingConstants.CENTER);
		amountTxtField.setColumns(10);
		
		JButton eraseBtn = new RoundedButton("CLEAR");
		eraseBtn.setBounds(300, 376, 135, 63);
		eraseBtn.setFont(new Font("Tahoma", Font.BOLD, 20));
		eraseBtn.setBackground(new Color(255, 127, 127));
		eraseBtn.setForeground(new Color(240, 255, 255));
		
		JButton cancelBtn = new RoundedButton("CANCEL");
		cancelBtn.setBounds(500, 376, 135, 63);
		cancelBtn.setFont(new Font("Tahoma", Font.BOLD, 20));
		cancelBtn.setBackground(new Color(0, 191, 255));
		cancelBtn.setForeground(new Color(255, 255, 255));
		
		JButton confirmBtn = new RoundedButton("CONFIRM");
		confirmBtn.setBounds(700, 376, 135, 63);
		confirmBtn.setFont(new Font("Tahoma", Font.BOLD, 20));
		confirmBtn.setBackground(new Color(26, 172, 119));
		confirmBtn.setForeground(new Color(240, 255, 255));
		
//		------------- ADDING COMPONENTS TO PANEL -------------

		bgPane.add(logoPnl);
		bgPane.add(withdrawPnl);
		withdrawPnl.add(withdrawLbl);
		withdrawPnl.add(accInfoLbl);
		withdrawPnl.add(accNameLbl);
		withdrawPnl.add(nameLbl);
		withdrawPnl.add(studNumLbl);
		withdrawPnl.add(numberLbl);
		withdrawPnl.add(currentLbl);
		withdrawPnl.add(balanceLbl);
		withdrawPnl.add(amountLbl);
		withdrawPnl.add(pesoLbl);
		withdrawPnl.add(amountTxtField);
		withdrawPnl.add(eraseBtn);
		withdrawPnl.add(cancelBtn);
		withdrawPnl.add(confirmBtn);
		
//		------------- EVENTS -------------
		
		amountTxtField.addKeyListener(new KeyAdapter() {
    		@Override
    		public void keyTyped(KeyEvent e) {
    			char c = e.getKeyChar();
        		if(!Character.isDigit(c)) {
        			e.consume();
        		}

    		}
		});
		
		amountTxtField.addKeyListener(new KeyAdapter() {
			@Override
	        public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == e.VK_ENTER) {
					if(Double.parseDouble(amountTxtField.getText())> Double.parseDouble(getBal)) {
	        			amountTxtField.setText("Insufficient");
	        		} else {
	    				double totalBalance = Double.parseDouble(getBal);
	    				double withdrawAmount = Double.parseDouble(amountTxtField.getText());
	    				double finalBalance = totalBalance - withdrawAmount;
	    				dataBalance = Double.toString(finalBalance);
	        			receiptAsk = new ReceiptAsk(database, i, a, dataBalance);
	    				receiptAsk.setVisible(true);
	    				receiptAsk.setLocationRelativeTo(null);
	    				Withdraw.this.dispose();
	        		}
				}
			}
	            	
		});
		
		cancelBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dashboard = new Dashboard(database, i);
				dashboard.setVisible(true);
				dashboard.setLocationRelativeTo(null);
				Withdraw.this.dispose();
			}
		});
		
		confirmBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Double.parseDouble(amountTxtField.getText())> Double.parseDouble(getBal)) {
        			amountTxtField.setText("Insufficient");
        		} else {
    				double totalBalance = Double.parseDouble(getBal);
    				double withdrawAmount = Double.parseDouble(amountTxtField.getText());
    				double finalBalance = totalBalance - withdrawAmount;
    				dataBalance = Double.toString(finalBalance);
        			receiptAsk = new ReceiptAsk(database, i, a, dataBalance);
    				receiptAsk.setVisible(true);
    				receiptAsk.setLocationRelativeTo(null);
    				Withdraw.this.dispose();
        		}
			}
		});
		
		eraseBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				amountTxtField.setText(null);
			}
		});
	}

// 	Custom JPanel class with rounded corners
    class RoundedPanel extends JPanel {
        private static final long serialUID = 1L;
        private int cornerRadius = 15;

        public RoundedPanel() {
            super();
            setOpaque(false); // To ensure the background is transparent
        }

        public RoundedPanel(int radius) {
            this();
            this.cornerRadius = radius;
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setColor(getBackground());
            g2.fillRoundRect(0, 0, getWidth(), getHeight(), cornerRadius, cornerRadius);
        }
    }

// 	Custom JPanel class for displaying an image
    class ImagePanel extends JPanel {
        private static final long serialUID = 1L;
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

// 	Custom JButton class with rounded corners and no visible border
    class RoundedButton extends JButton {
        private static final long serialUID = 1L;
        
        public RoundedButton(String text) {
            super(text);
            setContentAreaFilled(false); // To remove the default fill behavior
            setBorderPainted(false); // To ensure the border is not painted
            setFocusPainted(false); // To remove the focus border
        }

        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setColor(getBackground());
            g2.fillRoundRect(0, 0, getWidth(), getHeight(), 30, 30);
            super.paintComponent(g2);
            g2.dispose();
        }

        @Override
        protected void paintBorder(Graphics g) {
            // Overridden to remove the border painting
        }

        @Override
        public boolean contains(int x, int y) {
            int width = getWidth();
            int height = getHeight();
            int arcWidth = 30;
            int arcHeight = 30;
            return new RoundRectangle2D.Float(0, 0, width, height, arcWidth, arcHeight).contains(x, y);
        }
    }
}