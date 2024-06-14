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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.PlainDocument;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.geom.RoundRectangle2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JPasswordField;

public class ActivateAccount extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel bgPane;
    private BufferedImage backgroundImage;
	private DefaultTableModel database;
	private int i;
	private Landing login;
	
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ActivateAccount frame = new ActivateAccount(new DefaultTableModel(), 0);
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
    public ActivateAccount(DefaultTableModel database, int i) {
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
        
        JPanel activatePnl = new JPanel();
        activatePnl.setBackground(SystemColor.control);
        activatePnl.setBounds(46, 71, 410, 634);
        activatePnl.setLayout(null);
        
        JPanel logoPnl = new ImagePanel("C:\\Users\\Kirt Asia\\Dangal-ATM\\dATM\\img\\Dangal ATM.png");
        logoPnl.setBounds(55, 80, 310, 100);
        
        JLabel activateLbl = new JLabel("Activate Account");
        activateLbl.setBounds(31, 221, 352, 31);
        activateLbl.setFont(new Font("Poppins", Font.BOLD, 25));
        activateLbl.setBackground(Color.GREEN);
        activateLbl.setForeground(new Color(46, 139, 87));
        activateLbl.setHorizontalAlignment(SwingConstants.CENTER);
        
        JPanel activateLblPane = new RoundedPanel(30); 
        activateLblPane.setBounds(31, 210, 350, 53);
        activateLblPane.setBackground(new Color(144, 238, 144));
        
        JLabel nameLbl = new JLabel("Name:");
        nameLbl.setBounds(10, 294, 110, 31);
        nameLbl.setFont(new Font("Tahoma", Font.BOLD, 12));
        nameLbl.setHorizontalAlignment(SwingConstants.RIGHT);
        
        JTextField nameTxtField = new JTextFieldLimit(7);
        nameTxtField.setBounds(128, 294, 241, 31);
        nameTxtField.setFont(new Font("Tahoma", Font.PLAIN, 16));
        nameTxtField.setColumns(10);
        
        JLabel studNumLbl = new JLabel("Student Number:");
        studNumLbl.setBounds(10, 349, 110, 31);
        studNumLbl.setFont(new Font("Tahoma", Font.BOLD, 12));
        studNumLbl.setHorizontalAlignment(SwingConstants.RIGHT);
        
        JTextField studNumTxtField = new JTextField();
        studNumTxtField.setBounds(128, 349, 241, 31);
        studNumTxtField.setFont(new Font("Tahoma", Font.PLAIN, 16));
        studNumTxtField.setColumns(10);
        
        JLabel pinLbl = new JLabel("PIN:");
        pinLbl.setBounds(10, 403, 110, 31);
        pinLbl.setFont(new Font("Tahoma", Font.BOLD, 12));
        pinLbl.setHorizontalAlignment(SwingConstants.RIGHT);
        
        JPasswordField pinField = new JPasswordFieldLimit(6);
        pinField.setBounds(128, 403, 241, 31);
        pinField.setFont(new Font("Tahoma", Font.PLAIN, 16));
        
        JButton loginBtn = new RoundedButton("Activate");
        loginBtn.setBounds(140, 470, 136, 40);
        loginBtn.setBackground(new Color(102, 255, 102));
        
        JLabel loginLbl = new JLabel("Login");
        loginLbl.setBounds(3, 505, 410, 39);
        loginLbl.setFont(new Font("Poppins Medium", Font.PLAIN, 12));
        loginLbl.setForeground(new Color(46, 139, 87));
        loginLbl.setHorizontalAlignment(SwingConstants.CENTER);
        
        // ------------- ADDING COMPONENTS -------------

        bgPane.add(activatePnl);
        activatePnl.add(logoPnl);
        activatePnl.add(activateLbl);
        activatePnl.add(activateLblPane);
        activatePnl.add(nameLbl);
        activatePnl.add(nameTxtField);
        activatePnl.add(studNumLbl);
        activatePnl.add(studNumTxtField);
        activatePnl.add(pinLbl);
        activatePnl.add(pinField);
        activatePnl.add(loginBtn);
        activatePnl.add(loginLbl);
        
        // ------------- EVENTS -------------
        
        loginBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (studNumTxtField.getText().equals("") || nameTxtField.getText().equals("") || pinField.getText().equals("")) {
					JOptionPane.showMessageDialog(ActivateAccount.this, "Make sure that all fields are not empty!");
				} else if (studNumTxtField.getText().length() != 7 || pinField.getText().length() != 6) {
					if (studNumTxtField.getText().length() != 7) {
						studNumTxtField.setText(null);
						JOptionPane.showMessageDialog(ActivateAccount.this, "Student No. needs exactly 7 characters!");
					} else if (pinField.getText().length() != 6) {
						pinField.setText(null);
						JOptionPane.showMessageDialog(ActivateAccount.this, "PIN No. needs exactly 6 characters!");
					}
				} else {
					boolean studentExists = false;
					for (int j = 0; j < database.getRowCount(); j++) {
						if (studNumTxtField.getText().equals(database.getValueAt(j, 0))) {
							studentExists = true;
							JOptionPane.showMessageDialog(ActivateAccount.this, "This student number has already been activated!");
							studNumTxtField.setText(null);
							break;
						}
					}
					if (!studentExists) {
						String sn = studNumTxtField.getText();
						String name = nameTxtField.getText();
						String bal = "0.00";
						String pin = pinField.getText();
						
						Object[] data = {sn, name, bal, pin};
						database.addRow(data);
						
						login = new Landing(database, i);
						login.setVisible(true);
						login.setLocationRelativeTo(null);
						ActivateAccount.this.dispose();
					}
				}
			}
		});
        
        nameTxtField.addKeyListener(new KeyAdapter() {
        	@Override
        	public void keyPressed(KeyEvent e) {
        		if(e.getKeyCode() == e.VK_ENTER) {
    				if (studNumTxtField.getText().equals("") || nameTxtField.getText().equals("") || pinField.getText().equals("")) {
    					JOptionPane.showMessageDialog(ActivateAccount.this, "Make sure that all fields are not empty!");
    				} else if (studNumTxtField.getText().length() != 7 || pinField.getText().length() != 6) {
    					if (studNumTxtField.getText().length() != 7) {
    						studNumTxtField.setText(null);
    						JOptionPane.showMessageDialog(ActivateAccount.this, "Student No. needs exactly 7 characters!");
    					} else if (pinField.getText().length() != 6) {
    						pinField.setText(null);
    						JOptionPane.showMessageDialog(ActivateAccount.this, "PIN No. needs exactly 6 characters!");
    					}
    				} else {
    					boolean studentExists = false;
    					for (int j = 0; j < database.getRowCount(); j++) {
    						if (studNumTxtField.getText().equals(database.getValueAt(j, 0))) {
    							studentExists = true;
    							JOptionPane.showMessageDialog(ActivateAccount.this, "This student number has already been activated!");
    							studNumTxtField.setText(null);
    							break;
    						}
    					}
    					if (!studentExists) {
    						String sn = studNumTxtField.getText();
    						String name = nameTxtField.getText();
    						String bal = "0.00";
    						String pin = pinField.getText();
    						
    						Object[] data = {sn, name, bal, pin};
    						database.addRow(data);
    						
    						login = new Landing(database, i);
    						login.setVisible(true);
    						login.setLocationRelativeTo(null);
    						ActivateAccount.this.dispose();
    					}
    				}
        		}
        	}
        });
        
        studNumTxtField.addKeyListener(new KeyAdapter() {
        	@Override
        	public void keyPressed(KeyEvent e) {
        		if(e.getKeyCode() == e.VK_ENTER) {
    				if (studNumTxtField.getText().equals("") || nameTxtField.getText().equals("") || pinField.getText().equals("")) {
    					JOptionPane.showMessageDialog(ActivateAccount.this, "Make sure that all fields are not empty!");
    				} else if (studNumTxtField.getText().length() != 7 || pinField.getText().length() != 6) {
    					if (studNumTxtField.getText().length() != 7) {
    						studNumTxtField.setText(null);
    						JOptionPane.showMessageDialog(ActivateAccount.this, "Student No. needs exactly 7 characters!");
    					} else if (pinField.getText().length() != 6) {
    						pinField.setText(null);
    						JOptionPane.showMessageDialog(ActivateAccount.this, "PIN No. needs exactly 6 characters!");
    					}
    				} else {
    					boolean studentExists = false;
    					for (int j = 0; j < database.getRowCount(); j++) {
    						if (studNumTxtField.getText().equals(database.getValueAt(j, 0))) {
    							studentExists = true;
    							JOptionPane.showMessageDialog(ActivateAccount.this, "This student number has already been activated!");
    							studNumTxtField.setText(null);
    							break;
    						}
    					}
    					if (!studentExists) {
    						String sn = studNumTxtField.getText();
    						String name = nameTxtField.getText();
    						String bal = "0.00";
    						String pin = pinField.getText();
    						
    						Object[] data = {sn, name, bal, pin};
    						database.addRow(data);
    						
    						login = new Landing(database, i);
    						login.setVisible(true);
    						login.setLocationRelativeTo(null);
    						ActivateAccount.this.dispose();
    					}
    				}
        		}
        	}
        	@Override
        	public void keyTyped(KeyEvent e) {
        		char c = e.getKeyChar();
            	if(!Character.isDigit(c)) {
            		e.consume();
            	}
        	}
        });
        
        pinField.addKeyListener(new KeyAdapter() {
        	@Override
        	public void keyPressed(KeyEvent e) {
        		if(e.getKeyCode() == e.VK_ENTER) {
    				if (studNumTxtField.getText().equals("") || nameTxtField.getText().equals("") || pinField.getText().equals("")) {
    					JOptionPane.showMessageDialog(ActivateAccount.this, "Make sure that all fields are not empty!");
    				} else if (studNumTxtField.getText().length() != 7 || pinField.getText().length() != 6) {
    					if (studNumTxtField.getText().length() != 7) {
    						studNumTxtField.setText(null);
    						JOptionPane.showMessageDialog(ActivateAccount.this, "Student No. needs exactly 7 characters!");
    					} else if (pinField.getText().length() != 6) {
    						pinField.setText(null);
    						JOptionPane.showMessageDialog(ActivateAccount.this, "PIN No. needs exactly 6 characters!");
    					}
    				} else {
    					boolean studentExists = false;
    					for (int j = 0; j < database.getRowCount(); j++) {
    						if (studNumTxtField.getText().equals(database.getValueAt(j, 0))) {
    							studentExists = true;
    							JOptionPane.showMessageDialog(ActivateAccount.this, "This student number has already been activated!");
    							studNumTxtField.setText(null);
    							break;
    						}
    					}
    					if (!studentExists) {
    						String sn = studNumTxtField.getText();
    						String name = nameTxtField.getText();
    						String bal = "0.00";
    						String pin = pinField.getText();
    						
    						Object[] data = {sn, name, bal, pin};
    						database.addRow(data);
    						
    						login = new Landing(database, i);
    						login.setVisible(true);
    						login.setLocationRelativeTo(null);
    						ActivateAccount.this.dispose();
    					}
    				}
        		}
        	}
        	@Override
        	public void keyTyped(KeyEvent e) {
        		char c = e.getKeyChar();
            	if(!Character.isDigit(c)) {
            		e.consume();
            	}
        	}
        });
        
        loginLbl.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		login = new Landing(database, 0);
        		login.setVisible(true);
        		login.setLocationRelativeTo(null);
        		ActivateAccount.this.dispose();
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