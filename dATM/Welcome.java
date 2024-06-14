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
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;

public class Welcome extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel bgPane;
    private BufferedImage backgroundImage;
    private Landing login;
    
    private String[] header = {"STUDENT NUMBER", "NAME", "BALANCE", "PIN"};
	private String[][] data = {{"2300650", "MAG-USARA, KIRT ASIA", "69420.00", "172826"},
							   {"2300649", "FATAL, MOISES JR.", "42690.00", "232323"},
							   {"2300646", "FARINAS, JORICK CHRISTIAN", "10000.00", "696969"},
							   {"2300640", "ESCUZAR, EMIEL JAMES", "20000.00", "420420"},
							   {"2302745", "PEGA, JEDE ISAIAH MAXWEIL", "30000.00", "069420"}};
	
	private DefaultTableModel database = new DefaultTableModel(data, header);

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                	Welcome frame = new Welcome();
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
    public Welcome() {
        setTitle("Dangal ATM");
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
        bgPane.setLayout(null);
        
        // Custom panel for logo image
        JPanel logoPnl = new ImagePanel("C:\\Users\\Kirt Asia\\Dangal-ATM\\dATM\\img\\Dangal ATM.png");
        logoPnl.setBounds(300, 60, 400, 200);
        
        JButton welcomeBtn = new RoundedButton("Welcome!");
        welcomeBtn.setBounds(420, 320, 170, 63);
        welcomeBtn.setFont(new Font("Tahoma", Font.BOLD, 20));
        welcomeBtn.setBackground(new Color(0, 191, 255));
        welcomeBtn.setForeground(new Color(211, 211, 211));
        
        // ------------- ADDING COMPONENTS -------------

        bgPane.add(logoPnl);
        bgPane.add(welcomeBtn);
        
        // ------------- EVENTS -------------
        
        welcomeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login = new Landing(database, 0);
				login.setVisible(true);
				login.setLocationRelativeTo(null);
				Welcome.this.dispose();
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