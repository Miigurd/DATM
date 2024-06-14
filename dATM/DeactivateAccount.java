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
import javax.swing.JPasswordField;

public class DeactivateAccount extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel bgPane;
    private BufferedImage backgroundImage;
	private Landing login;
	private Dashboard dashboard;
	private DefaultTableModel database;
	private int i;
	
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                	DeactivateAccount frame = new DeactivateAccount(new DefaultTableModel(), 0);
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
    public DeactivateAccount(DefaultTableModel database, int i) {
    	this.database = database;
    	this.i = i;
    	
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
        
        JPanel deactivatePnl = new JPanel();
        deactivatePnl.setLayout(null);
        deactivatePnl.setBounds(46, 71, 410, 634);
        deactivatePnl.setBackground(SystemColor.control);
        
        JPanel logoPnl = new ImagePanel("C:\\Users\\Kirt Asia\\Dangal-ATM\\dATM\\img\\Dangal ATM.png");
        logoPnl.setBounds(55, 80, 310, 100);
        
        JLabel deactivateLbl = new JLabel("Deactivate Account");
        deactivateLbl.setBounds(31, 221, 352, 31);
        deactivateLbl.setFont(new Font("Poppins", Font.BOLD, 25));
        deactivateLbl.setBackground(Color.GREEN);
        deactivateLbl.setForeground(new Color(46, 139, 87));
        deactivateLbl.setHorizontalAlignment(SwingConstants.CENTER);
        
        JPanel deactivateLblPane = new RoundedPanel(30); 
        deactivateLblPane.setBounds(31, 210, 350, 53);
        deactivateLblPane.setBackground(new Color(144, 238, 144));
        
        JLabel studNumLbl = new JLabel("Student Number:");
        studNumLbl.setBounds(10, 304, 110, 31);
        studNumLbl.setFont(new Font("Tahoma", Font.BOLD, 12));
        studNumLbl.setHorizontalAlignment(SwingConstants.RIGHT);
        
        JTextField studNumTxtField = new JTextFieldLimit(7);
        studNumTxtField.setBounds(128, 304, 241, 31);
        studNumTxtField.setFont(new Font("Tahoma", Font.PLAIN, 16));
        studNumTxtField.setHorizontalAlignment(SwingConstants.CENTER);
        studNumTxtField.setColumns(10);
        
        JLabel pinLbl = new JLabel("PIN:");
        pinLbl.setBounds(10, 358, 110, 31);
        pinLbl.setFont(new Font("Tahoma", Font.BOLD, 12));
        pinLbl.setHorizontalAlignment(SwingConstants.RIGHT);
        
        JPasswordField pinField = new JPasswordFieldLimit(6);
        pinField.setBounds(128, 358, 241, 31);
        pinField.setFont(new Font("Tahoma", Font.PLAIN, 16));
        pinField.setHorizontalAlignment(SwingConstants.CENTER);
        
        JButton deactivateBtn = new RoundedButton("Deactivate");
        deactivateBtn.setBounds(140, 420, 136, 40);
        deactivateBtn.setBackground(new Color(255, 127, 127));
        
        JLabel backLbl = new JLabel("Back");
        backLbl.setBounds(3, 455, 410, 39);
        backLbl.setFont(new Font("Poppins Medium", Font.PLAIN, 12));
        backLbl.setForeground(new Color(46, 139, 87));
        backLbl.setHorizontalAlignment(SwingConstants.CENTER);
        
        // ------------- ADDING COMPONENTS -------------

        bgPane.add(deactivatePnl);
        deactivatePnl.add(logoPnl);
        deactivatePnl.add(deactivateLbl);
        deactivatePnl.add(deactivateLblPane);
        deactivatePnl.add(studNumLbl);
        deactivatePnl.add(studNumTxtField);
        deactivatePnl.add(pinLbl);
        deactivatePnl.add(pinField);
        deactivatePnl.add(deactivateBtn);
        deactivatePnl.add(backLbl);
        
        // ------------- EVENTS -------------
        
        deactivateBtn.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		if (studNumTxtField.getText().equals(database.getValueAt(i, 0)) && pinField.getText().equals(database.getValueAt(i, 3))) {
        			database.removeRow(i);
        			login = new Landing(database, 0);
        			login.setVisible(true);
        			login.setLocationRelativeTo(null);
        			DeactivateAccount.this.dispose();
        		} else {
        			studNumTxtField.setText(null);
        			pinField.setText(null);
        		}
        	}
        });
        
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
            		if (studNumTxtField.getText().equals(database.getValueAt(i, 0)) && pinField.getText().equals(database.getValueAt(i, 3))) {
            			database.removeRow(i);
            			login = new Landing(database, 0);
            			login.setVisible(true);
            			login.setLocationRelativeTo(null);
            			DeactivateAccount.this.dispose();
            		} else {
            			studNumTxtField.setText(null);
            			pinField.setText(null);
            		}
        	   }
            }
        });
        
        studNumTxtField.addKeyListener(new KeyAdapter() {
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
            		if (studNumTxtField.getText().equals(database.getValueAt(i, 0)) && pinField.getText().equals(database.getValueAt(i, 3))) {
            			database.removeRow(i);
            			login = new Landing(database, 0);
            			login.setVisible(true);
            			login.setLocationRelativeTo(null);
            			DeactivateAccount.this.dispose();
            		} else {
            			studNumTxtField.setText(null);
            			pinField.setText(null);
            		}
        	   }
            }
        });
        
        backLbl.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		dashboard = new Dashboard(database, i);
        		dashboard.setVisible(true);
        		dashboard.setLocationRelativeTo(null);
        		DeactivateAccount.this.dispose();
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