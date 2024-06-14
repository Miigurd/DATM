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
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.PlainDocument;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.geom.RoundRectangle2D;

public class PIN extends JFrame {
	private JPanel bgPane;
	private BufferedImage backgroundImage;
	private Receipt receipt;
	private End end;
	private DefaultTableModel database;
	private int i;
	private int yn;
	private Dashboard dashboard;
	private String a;
	private String dataBalance;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PIN frame = new PIN(new DefaultTableModel(), 0, new String(), 0, new String());
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PIN(DefaultTableModel database, int i, String a, int yn, String dataBalance) {
		this.database = database;
		this.i = i;
		this.a = a;
		this.yn = yn;
		this.dataBalance = dataBalance;
		
		setSize(1024, 768);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

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
		JPanel logoPanel = new ImagePanel("C:\\Users\\Kirt Asia\\Dangal-ATM\\dATM\\img\\Dangal ATM Dashboard.png");
		logoPanel.setBounds(350, 80, 250, 100);
		bgPane.setLayout(null);
		
		JPanel pinPnl = new JPanel();
		pinPnl.setLayout(null);
		pinPnl.setBounds(45, 238, 930, 480);
		pinPnl.setBackground(new Color(255, 255, 255));
		
		JLabel pinLbl = new JLabel("Enter PIN");
		pinLbl.setBounds(10, 25, 307, 43);
		pinLbl.setFont(new Font("Tahoma", Font.BOLD, 35));
		pinLbl.setHorizontalAlignment(SwingConstants.CENTER);
		
		JPasswordField pinField = new JPasswordFieldLimit(6);
		pinField.setBounds(78, 168, 765, 102);
		pinField.setFont(new Font("Tahoma", Font.PLAIN, 45));
		pinField.setBackground(new Color(192, 192, 192));
		pinField.setForeground(new Color(0, 100, 0));
		pinField.setHorizontalAlignment(SwingConstants.CENTER);
		pinField.setColumns(10);
		
		JButton eraseBtn = new RoundedButton("CLEAR");
		eraseBtn.setBounds(137, 367, 135, 63);
		eraseBtn.setFont(new Font("Tahoma", Font.BOLD, 20));
		eraseBtn.setBackground(new Color(255, 127, 127));
		eraseBtn.setForeground(new Color(240, 255, 255));
		
		JButton cancelBtn = new RoundedButton("CANCEL");
		cancelBtn.setBounds(385, 367, 135, 63);
		cancelBtn.setFont(new Font("Tahoma", Font.BOLD, 20));
		cancelBtn.setBackground(new Color(0, 191, 255));
		cancelBtn.setForeground(new Color(255, 255, 255));
		
		JButton confirmBtn = new RoundedButton("CONFIRM");
		confirmBtn.setBounds(635, 367, 135, 63);
		confirmBtn.setFont(new Font("Tahoma", Font.BOLD, 20));
		confirmBtn.setBackground(new Color(26, 172, 119));
		confirmBtn.setForeground(new Color(240, 255, 255));
		
		// ------------- ADDING COMPONENTS -------------

		bgPane.add(logoPanel);
		bgPane.add(pinPnl);
		pinPnl.add(pinLbl);
		pinPnl.add(pinField);
		pinPnl.add(eraseBtn);
		pinPnl.add(cancelBtn);
		pinPnl.add(confirmBtn);
		
		// ------------- EVENTS -------------
		
		pinField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
    			char c = e.getKeyChar();
        		if(!Character.isDigit(c)) {
        			e.consume();
        		}
			}
        	@Override
        	public void keyPressed(KeyEvent e) {
        		if(e.getKeyCode() == e.VK_ENTER) {
    				if (yn == 1) {
    					String getPIN = (String) database.getValueAt(i, 3);
    					if (pinField.getText().equals(getPIN)) {
    	    				database.setValueAt(dataBalance, i, 2);
    						end = new End(database);
    						end.setVisible(true);
    						end.setLocation(50, 50);
    						receipt = new Receipt(database, i, a);
    						receipt.setVisible(true);
    						receipt.setLocation(1000, 135);
    						PIN.this.dispose();
    					}else {
    						pinField.setText(null);
    					}
    				} else if (yn == 2) {
    					String getPIN = (String) database.getValueAt(i, 3);
    					if (pinField.getText().equals(getPIN)) {
    	    				database.setValueAt(dataBalance, i, 2);
    						end = new End(database);
    						end.setVisible(true);
    						end.setLocationRelativeTo(null);
    						PIN.this.dispose();
    					}else {
    						pinField.setText(null);
    					}
    				}
        	   }
            }
		});
		
		confirmBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (yn == 1) {
					String getPIN = (String) database.getValueAt(i, 3);
					if (pinField.getText().equals(getPIN)) {
	    				database.setValueAt(dataBalance, i, 2);
						end = new End(database);
						end.setVisible(true);
						end.setLocation(50, 50);
						receipt = new Receipt(database, i, a);
						receipt.setVisible(true);
						receipt.setLocation(1000, 135);
						PIN.this.dispose();
					}else {
						pinField.setText(null);
					}
				} else if (yn == 2) {
					String getPIN = (String) database.getValueAt(i, 3);
					if (pinField.getText().equals(getPIN)) {
	    				database.setValueAt(dataBalance, i, 2);
						end = new End(database);
						end.setVisible(true);
						end.setLocationRelativeTo(null);
						PIN.this.dispose();
					}else {
						pinField.setText(null);
					}
				}
			}
		});
		
		cancelBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dashboard = new Dashboard(database, i);
				dashboard.setVisible(true);
				dashboard.setLocationRelativeTo(null);
				PIN.this.dispose();
			}
		});
		
		eraseBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pinField.setText(null);
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
	
	class JPasswordFieldLimit extends JPasswordField {
	    private int limit;

	    public JPasswordFieldLimit(int limit) {
	        super();
	        this.limit = limit;
	    }

	    @Override
	    protected Document createDefaultModel() {
	        return new LimitDocument();
	    }

	    private class LimitDocument extends PlainDocument {

	        @Override
	        public void insertString( int offset, String  str, AttributeSet attr ) throws BadLocationException {
	            if (str == null) return;

	            if ((getLength() + str.length()) <= limit) {
	                super.insertString(offset, str, attr);
	            }
	        }       
	    }
	}
	
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