package dATM;

import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.SystemColor;
import java.awt.Color;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.PlainDocument;
import java.awt.geom.RoundRectangle2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Landing extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel bgPane;
    private BufferedImage backgroundImage;
    private Dashboard dashboard;
    private ActivateAccount activate;
    private DefaultTableModel database;
    private int i;
	
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Landing frame = new Landing(new DefaultTableModel(), 0);
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
    public Landing(DefaultTableModel database, int i) {
    	this.database = database;
    	
        setTitle("Dangal ATM");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1024, 768);

        try {
            backgroundImage = ImageIO.read(new File("C:\\Users\\Kirt Asia\\Dangal-ATM\\dATM\\img\\bg.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Background panel
        bgPane = new JPanel() {
            private static final long serialVersionUID = 1L;

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                if (backgroundImage != null) {
                    g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
                }
            }
        };

        bgPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(bgPane);
        bgPane.setLayout(null);
        
        JPanel loginPanel = new JPanel();
        loginPanel.setBackground(SystemColor.control);
        loginPanel.setBounds(46, 71, 410, 634);
        loginPanel.setLayout(null);
        
        JPanel logoPnl = new ImagePanel("C:\\Users\\Kirt Asia\\Dangal-ATM\\dATM\\img\\Dangal ATM.png");
        logoPnl.setBounds(55, 80, 310, 100);
        
        JLabel userLabel = new JLabel("USER LOGIN");
        userLabel.setBounds(31, 221, 352, 31);
        userLabel.setFont(new Font("Poppins", Font.BOLD, 25));
        userLabel.setBackground(Color.GREEN);
        userLabel.setForeground(new Color(46, 139, 87));
        userLabel.setHorizontalAlignment(SwingConstants.CENTER);
        
        JPanel userLblPane = new RoundedPanel(30);
        userLblPane.setBounds(31, 210, 350, 53);
        userLblPane.setBackground(new Color(144, 238, 144));
        
        JPanel profileIcon = new ImagePanel("C:\\Users\\Kirt Asia\\Desktop\\School\\1CS-A\\2nd Sem\\CCS103\\dATM img\\user-fill.png");
        profileIcon.setBounds(40, 325, 20, 20);
        
        JTextField userTextField = new JTextFieldLimit(7);
        userTextField.setBounds(79, 294, 280, 82);
        userTextField.setFont(new Font("Tahoma", Font.PLAIN, 40));
        userTextField.setHorizontalAlignment(SwingConstants.CENTER);
        userTextField.setColumns(10);
        
        JLabel activateLabel = new JLabel("Activate Account");
        activateLabel.setBounds(3, 435, 410, 39);
        activateLabel.setFont(new Font("Poppins Medium", Font.PLAIN, 12));
        activateLabel.setForeground(new Color(46, 139, 87));
        activateLabel.setHorizontalAlignment(SwingConstants.CENTER);
        
        JButton loginBTN = new RoundedButton("Login");
        loginBTN.setBounds(140, 400, 136, 40);
        loginBTN.setBackground(new Color(26, 172, 119));
        
        // ------------- ADDING COMPONENTS -------------

        bgPane.add(loginPanel);
        loginPanel.add(logoPnl);
        loginPanel.add(userLabel);
        loginPanel.add(userLblPane);
        loginPanel.add(profileIcon);
        loginPanel.add(userTextField);
        loginPanel.add(activateLabel);
        loginPanel.add(loginBTN);
        
        // ------------- EVENTS -------------
        loginBTN.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		for(int i = 0; i < database.getRowCount(); i++) {
        			if(userTextField.getText().equals(database.getValueAt(i, 0))) {
            			Landing.this.dispose();
            			dashboard = new Dashboard(database, i);
                    	dashboard.setVisible(true);
                    	dashboard.setLocationRelativeTo(null);
        			}
        		}
        		userTextField.setText(null);
        	}
        });
        
        userTextField.addKeyListener(new KeyAdapter() {
        	@Override
        	public void keyTyped(KeyEvent e) {
        		char c = e.getKeyChar();
            	if(!Character.isDigit(c)) {
            		e.consume();
            	}
        	}
        });
        	
        userTextField.addKeyListener(new KeyAdapter() {
        	@Override
        	public void keyPressed(KeyEvent e) {
        		if(e.getKeyCode() == e.VK_ENTER) {
        			for(int i = 0; i < database.getRowCount(); i++) {
	           			if(userTextField.getText().equals(database.getValueAt(i, 0))) {
	               			Landing.this.dispose();
	               			dashboard = new Dashboard(database, i);
	                       	dashboard.setVisible(true);
	                       	dashboard.setLocationRelativeTo(null);
	           			}
        			}
        			userTextField.setText(null);
        	   }
            }
        });
        
        activateLabel.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		activate = new ActivateAccount(database, i);
        		activate.setVisible(true);
        		activate.setLocationRelativeTo(null);
        		Landing.this.dispose();
        	}
        });
    }

    // Custom JPanel class with rounded corners
    class RoundedPanel extends JPanel {
        private static final long serialVersionUID = 1L;
        private int cornerRadius;

        public RoundedPanel(int radius) {
            super();
            this.cornerRadius = radius;
            setOpaque(false); // To ensure the background is transparent
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

    // Custom JButton class with rounded corners
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
    
    class JTextFieldLimit extends JTextField {
	    private int limit;

	    public JTextFieldLimit(int limit) {
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
}
