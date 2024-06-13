package dATM;

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

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.geom.RoundRectangle2D;


public class Balance extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel bgPane;
    private BufferedImage backgroundImage;
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
                	Balance frame = new Balance(new DefaultTableModel(), 0);
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
    public Balance(DefaultTableModel database, int i) {
    	this.database = database;
    	this.i = i;
 
    	
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1024, 768);

        try {
            backgroundImage = ImageIO.read(new File("C:\\Users\\Kirt Asia\\Dangal-ATM\\dATM\\img\\bg.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

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
        bgPane.setLayout(null); // Allow for absolute positioning
        setContentPane(bgPane);

        // Custom panel for logo image
        JPanel logoPanel = new ImagePanel("C:\\Users\\Kirt Asia\\Desktop\\School\\1CS-A\\2nd Sem\\CCS103\\dATM img\\Dangal ATM Dashboard.png");
        logoPanel.setBounds(380, 80, 250, 100);
        
        JPanel balancePnl = new JPanel();
        balancePnl.setLayout(null);
        balancePnl.setBounds(40, 230, 930, 480);
        balancePnl.setBackground(new Color(255, 255, 255));
        
        JLabel lblCheckBalance = new JLabel("Check Balance");
        lblCheckBalance.setBounds(60, 25, 307, 43);
        lblCheckBalance.setFont(new Font("Tahoma", Font.BOLD, 35));
        lblCheckBalance.setHorizontalAlignment(SwingConstants.CENTER);
        
        JLabel accInfoLbl = new JLabel("Account Information: ");
        accInfoLbl.setBounds(114, 79, 336, 33);
        accInfoLbl.setFont(new Font("Tahoma", Font.BOLD, 25));
        
        JLabel accNameLbl = new JLabel("Client Name:");
        accNameLbl.setBounds(140, 111, 140, 30);
        accNameLbl.setFont(new Font("Tahoma", Font.BOLD, 17));
        
        JLabel nameLbl = new JLabel();
        String getName = (String) database.getValueAt(i, 1);
        nameLbl.setText(getName);
		nameLbl.setBounds(260, 115, 250, 25);
		nameLbl.setFont(new Font("Tahoma", Font.BOLD, 15));
		nameLbl.setForeground(new Color(17, 141, 87));
        
        JLabel clientNumLbl = new JLabel("Client No.:");
        clientNumLbl.setBounds(140, 140, 108, 30);
        clientNumLbl.setFont(new Font("Tahoma", Font.BOLD, 17));
        
        JLabel numberLbl = new JLabel();
        String getNum = (String) database.getValueAt(i, 0);
        numberLbl.setText(getNum);
		numberLbl.setBounds(260, 144, 135, 25);
		numberLbl.setFont(new Font("Tahoma", Font.BOLD, 15));
		numberLbl.setForeground(new Color(17, 141, 87));
        
        JLabel currentLbl = new JLabel("Current Balance:");
        currentLbl.setBounds(117, 211, 271, 33);
        currentLbl.setFont(new Font("Tahoma", Font.BOLD, 25));
		
		JLabel pesoLbl = new JLabel("₱");
		pesoLbl.setBounds(36, 241, 78, 113);
		pesoLbl.setFont(new Font("Tahoma", Font.BOLD, 95));
		pesoLbl.setHorizontalAlignment(SwingConstants.CENTER);
        
        JPanel currentPnl = new JPanel();
        currentPnl.setLayout(null);
        currentPnl.setBounds(117, 252, 765, 102);
        currentPnl.setBackground(new Color(192, 192, 192));
        
        JLabel balanceLbl = new JLabel();
        String getBal = (String) database.getValueAt(i, 2);
        balanceLbl.setText(getBal);
        balanceLbl.setBounds(0, 23, 765, 54);
        balanceLbl.setFont(new Font("Tahoma", Font.PLAIN, 44));
        balanceLbl.setHorizontalAlignment(SwingConstants.CENTER);
        balanceLbl.setForeground(new Color(0, 100, 0));
        balanceLbl.setBackground(new Color(255, 255, 255));
        
        JButton confirmBtn = new RoundedButton("CONFIRM");
		confirmBtn.setBounds(700, 376, 135, 63);
		confirmBtn.setFont(new Font("Tahoma", Font.BOLD, 20));
		confirmBtn.setBackground(new Color(26, 172, 119));
		confirmBtn.setForeground(new Color(240, 255, 255));
        
        // ------------- ADD COMPONENTS TO PANEL -------------

        bgPane.add(logoPanel);
        bgPane.add(balancePnl);
        balancePnl.add(lblCheckBalance);
        balancePnl.add(accInfoLbl);
        balancePnl.add(accNameLbl);
        balancePnl.add(nameLbl);
        balancePnl.add(clientNumLbl);
        balancePnl.add(numberLbl);
        balancePnl.add(currentLbl);
		balancePnl.add(pesoLbl);
        balancePnl.add(currentPnl);
        currentPnl.add(balanceLbl);
        balancePnl.add(confirmBtn);
        
        // ------------- EVENTS -------------

        confirmBtn.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		dashboard = new Dashboard(database, i);
        		dashboard.setVisible(true);
        		dashboard.setLocationRelativeTo(null);
        		Balance.this.dispose();
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
