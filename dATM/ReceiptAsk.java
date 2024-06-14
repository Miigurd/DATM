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

import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ReceiptAsk extends JFrame {

    private JFrame frame;
    private JPanel bgPane;
    private BufferedImage backgroundImage;
    private PIN pin;
    private DefaultTableModel database;
    private int i;
    private int yn;
    private String a;
    private String dataBalance;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                	ReceiptAsk frame = new ReceiptAsk(new DefaultTableModel(), 0, new String(), new String());
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
    public ReceiptAsk(DefaultTableModel database, int i, String a, String dataBalance) {
    	this.database= database;
    	this.i = i;
    	this.a = a;
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
        bgPane.setLayout(null);

        // Custom panel for logo image
        JPanel logoPnl = new ImagePanel("C:\\Users\\Kirt Asia\\Dangal-ATM\\dATM\\img\\Dangal ATM Dashboard.png");
        logoPnl.setBounds(350, 80, 250, 100);

        JPanel receiptAskPnl = new JPanel();
        receiptAskPnl.setLayout(null);
        receiptAskPnl.setBounds(45, 238, 930, 480);
        receiptAskPnl.setBackground(new Color(255, 255, 255));

        JLabel askLbl = new JLabel("DO YOU WANT A RECEIPT?");
        askLbl.setBounds(35, 39, 597, 73);
        askLbl.setFont(new Font("Tahoma", Font.BOLD, 40));
        askLbl.setHorizontalAlignment(SwingConstants.CENTER);

        JTextPane infoText = new JTextPane();
        infoText.setText("Skip the receipt and help reduce waste.\nEach receipt declined saves paper and ink, reducing landfill waste and chemical pollution. Join us in this small step towards a more sustainable future. Next time, just say \"No receipt, please!\"");
        infoText.setBounds(76, 146, 458, 242);
        infoText.setFont(new Font("Monospaced", Font.PLAIN, 18));
        infoText.setEditable(false);
        
        StyledDocument doc = infoText.getStyledDocument();
        SimpleAttributeSet center = new SimpleAttributeSet();
        StyleConstants.setAlignment(center, StyleConstants.ALIGN_JUSTIFIED);
        doc.setParagraphAttributes(0, doc.getLength(), center, false);

        JButton yesBtn = new JButton("YES");
        yesBtn.setBounds(712, 271, 135, 63);
        yesBtn.setFont(new Font("Tahoma", Font.BOLD, 20));
        yesBtn.setBackground(new Color(0, 128, 0));
        yesBtn.setForeground(new Color(255, 255, 255));

        JButton noBtn = new JButton("NO");
        noBtn.setBounds(712, 367, 135, 63);
        noBtn.setFont(new Font("Tahoma", Font.BOLD, 20));
        noBtn.setBackground(new Color(0, 128, 0));
        noBtn.setForeground(new Color(240, 255, 255));
        
        // ------------- ADDING COMPONENTS -------------

        bgPane.add(logoPnl);
        bgPane.add(receiptAskPnl);
        receiptAskPnl.add(askLbl);
        receiptAskPnl.add(infoText);
        receiptAskPnl.add(yesBtn);
        receiptAskPnl.add(noBtn);
        
        // ------------- EVENTS -------------

        yesBtn.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		yn = 1;
        		pin = new PIN(database, i, a, yn, dataBalance);
        		pin.setVisible(true);
        		pin.setLocationRelativeTo(null);
        		ReceiptAsk.this.dispose();
        	}
        });

        noBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
        		yn = 2;
        		pin = new PIN(database, i, a, yn, dataBalance);
        		pin.setVisible(true);
        		pin.setLocationRelativeTo(null);
        		ReceiptAsk.this.dispose();
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
