package dATM;

import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import java.util.Date;

public class Receipt extends JFrame {
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
					Receipt frame = new Receipt(new DefaultTableModel(), 0, new String());
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
	public Receipt(DefaultTableModel database, int i, String a) {
		this.database = database;
		this.i = i;
		this.a = a;
		
		setSize(450, 609);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JPanel logoPnl = new ImagePanel("C:\\Users\\Kirt Asia\\Dangal-ATM\\dATM\\img\\Dangal ATM Dashboard.png");
		logoPnl.setBounds(90, 15, 250, 100);
		
		JLabel terminal = new JLabel("TERMINAL");
		terminal.setBounds(26, 132, 106, 17);
		terminal.setFont(new Font("Calisto MT", Font.PLAIN, 12));
		
		JLabel sequence = new JLabel("SEQUENCE");
		sequence.setBounds(26, 152, 106, 17);
		sequence.setFont(new Font("Calisto MT", Font.PLAIN, 12));
		
		JLabel businessDate = new JLabel("BUSINESS DATE");
		businessDate.setBounds(26, 192, 106, 17);
		businessDate.setFont(new Font("Calisto MT", Font.PLAIN, 12));
		
		JLabel dateTime = new JLabel("DATE & TIME");
		dateTime.setBounds(26, 172, 106, 17);
		dateTime.setFont(new Font("Calisto MT", Font.PLAIN, 12));
		
		JLabel debit = new JLabel("DEBIT");
		debit.setBounds(26, 232, 106, 17);
		debit.setFont(new Font("Calisto MT", Font.PLAIN, 12));
		
		JLabel cardNum = new JLabel("CARD NUMBER");
		cardNum.setBounds(26, 212, 106, 17);
		cardNum.setFont(new Font("Calisto MT", Font.PLAIN, 12));
		
		JLabel accountLbl = new JLabel("ACCOUNT");
		accountLbl.setBounds(26, 269, 106, 17);
		accountLbl.setFont(new Font("Calisto MT", Font.PLAIN, 12));
		
		JLabel transaction = new JLabel("TRANSACTION");
		transaction.setBounds(26, 249, 106, 17);
		transaction.setFont(new Font("Calisto MT", Font.PLAIN, 12));
		
		JLabel divider1 = new JLabel("-------------------------------------");
		divider1.setBounds(26, 281, 375, 17);
		divider1.setFont(new Font("Tahoma", Font.PLAIN, 27));
		
		JLabel tvr = new JLabel("TVR");
		tvr.setBounds(26, 465, 106, 17);
		tvr.setFont(new Font("Calisto MT", Font.PLAIN, 12));
		
		JLabel tc = new JLabel("TC");
		tc.setBounds(26, 445, 106, 17);
		tc.setFont(new Font("Calisto MT", Font.PLAIN, 12));
		
		JLabel tsi = new JLabel("TSI");
		tsi.setBounds(26, 425, 106, 17);
		tsi.setFont(new Font("Calisto MT", Font.PLAIN, 12));
		
		JLabel owner = new JLabel("OWNER");
		owner.setBounds(26, 408, 106, 17);
		owner.setFont(new Font("Calisto MT", Font.PLAIN, 12));
		
		JLabel atmFeePaidTo = new JLabel("ATM FEE PAID TO:");
		atmFeePaidTo.setBounds(26, 388, 142, 17);
		atmFeePaidTo.setFont(new Font("Calisto MT", Font.PLAIN, 12));
		
		JLabel ledgerAmount = new JLabel("LEDGER AMOUNT");
		ledgerAmount.setBounds(26, 368, 131, 17);
		ledgerAmount.setFont(new Font("Calisto MT", Font.PLAIN, 12));
		
		JLabel totalAmount = new JLabel("TOTAL AMOUNT");
		totalAmount.setBounds(26, 348, 131, 17);
		totalAmount.setFont(new Font("Calisto MT", Font.PLAIN, 12));
		
		JLabel atmFee = new JLabel("ATM FEE");
		atmFee.setBounds(26, 328, 106, 17);
		atmFee.setFont(new Font("Calisto MT", Font.PLAIN, 12));
		
		JLabel dispensedAmount = new JLabel("DISPENSED AMOUNT");
		dispensedAmount.setBounds(26, 308, 142, 17);
		dispensedAmount.setFont(new Font("Calisto MT", Font.PLAIN, 12));
		
		JLabel divider2 = new JLabel("-------------------------------------");
		divider2.setBounds(26, 481, 375, 17);
		divider2.setFont(new Font("Tahoma", Font.PLAIN, 27));
		
		JLabel approved = new JLabel("APPROVED");
		approved.setBounds(26, 500, 106, 17);
		approved.setFont(new Font("Calisto MT", Font.PLAIN, 12));
		
		JLabel thankYou = new JLabel("THANK YOU!");
		thankYou.setBounds(26, 525, 106, 17);
		thankYou.setFont(new Font("Calisto MT", Font.PLAIN, 12));
		
		JLabel terVal = new JLabel("0");
		terVal.setBounds(295, 132, 106, 17);
		terVal.setFont(new Font("Calisto MT", Font.PLAIN, 12));
		
		JLabel seqVal = new JLabel("0");
		seqVal.setBounds(295, 152, 106, 17);
		seqVal.setFont(new Font("Calisto MT", Font.PLAIN, 12));
		
		JLabel dtVal = new JLabel("0");
		dtVal.setBounds(295, 172, 106, 17);
		dtVal.setFont(new Font("Calisto MT", Font.PLAIN, 12));
		
		JLabel bdateVal = new JLabel("0");
		bdateVal.setBounds(295, 192, 106, 17);
		bdateVal.setFont(new Font("Calisto MT", Font.PLAIN, 12));
		
		JLabel cardNumVal = new JLabel("0");
		cardNumVal.setBounds(295, 212, 106, 17);
		cardNumVal.setFont(new Font("Calisto MT", Font.PLAIN, 12));
		
		JLabel debVal = new JLabel("0");
		debVal.setBounds(295, 232, 106, 17);
		debVal.setFont(new Font("Calisto MT", Font.PLAIN, 12));
		
		JLabel tranVal = new JLabel("0");
		tranVal.setBounds(295, 249, 131, 17);
		tranVal.setFont(new Font("Calisto MT", Font.PLAIN, 12));
		
		JLabel accVal = new JLabel("0");
		accVal.setBounds(295, 269, 106, 17);
		accVal.setFont(new Font("Calisto MT", Font.PLAIN, 12));
		
		JLabel disVal = new JLabel("0");
		disVal.setBounds(295, 308, 142, 17);
		disVal.setFont(new Font("Calisto MT", Font.PLAIN, 12));
		
		JLabel feeVal = new JLabel("0");
		feeVal.setBounds(295, 328, 106, 17);
		feeVal.setFont(new Font("Calisto MT", Font.PLAIN, 12));
		
		JLabel ttlVal = new JLabel("0");
		ttlVal.setBounds(295, 348, 131, 17);
		ttlVal.setFont(new Font("Calisto MT", Font.PLAIN, 12));
		
		JLabel ldgVal = new JLabel("0");
		ldgVal.setBounds(295, 368, 131, 17);
		ldgVal.setFont(new Font("Calisto MT", Font.PLAIN, 12));
		
		JLabel feePaidVal = new JLabel("0");
		feePaidVal.setBounds(295, 388, 142, 17);
		feePaidVal.setFont(new Font("Calisto MT", Font.PLAIN, 12));
		
		JLabel ownerVal = new JLabel("0");
		ownerVal.setBounds(295, 408, 106, 17);
		ownerVal.setFont(new Font("Calisto MT", Font.PLAIN, 12));
		
		JLabel tsiVal = new JLabel("0");
		tsiVal.setBounds(295, 425, 106, 17);
		tsiVal.setFont(new Font("Calisto MT", Font.PLAIN, 12));
		
		JLabel tcVal = new JLabel("0");
		tcVal.setBounds(295, 445, 106, 17);
		tcVal.setFont(new Font("Calisto MT", Font.PLAIN, 12));
		
		JLabel tvrVal = new JLabel("0");
		tvrVal.setBounds(295, 465, 106, 17);
		tvrVal.setFont(new Font("Calisto MT", Font.PLAIN, 12));
		
		JLabel equal_1 = new JLabel("=");
		equal_1.setHorizontalAlignment(SwingConstants.CENTER);
		equal_1.setFont(new Font("Calisto MT", Font.PLAIN, 12));
		equal_1.setBounds(189, 132, 60, 17);
		
		JLabel equal_2 = new JLabel("=");
		equal_2.setHorizontalAlignment(SwingConstants.CENTER);
		equal_2.setFont(new Font("Calisto MT", Font.PLAIN, 12));
		equal_2.setBounds(189, 152, 60, 17);
		
		JLabel equal_3 = new JLabel("=");
		equal_3.setHorizontalAlignment(SwingConstants.CENTER);
		equal_3.setFont(new Font("Calisto MT", Font.PLAIN, 12));
		equal_3.setBounds(189, 172, 60, 17);
		
		JLabel equal_4 = new JLabel("=");
		equal_4.setHorizontalAlignment(SwingConstants.CENTER);
		equal_4.setFont(new Font("Calisto MT", Font.PLAIN, 12));
		equal_4.setBounds(189, 192, 60, 17);
		
		JLabel equal_5 = new JLabel("=");
		equal_5.setHorizontalAlignment(SwingConstants.CENTER);
		equal_5.setFont(new Font("Calisto MT", Font.PLAIN, 12));
		equal_5.setBounds(189, 212, 60, 17);
		
		JLabel equal_6 = new JLabel("=");
		equal_6.setHorizontalAlignment(SwingConstants.CENTER);
		equal_6.setFont(new Font("Calisto MT", Font.PLAIN, 12));
		equal_6.setBounds(189, 232, 60, 17);
		
		JLabel equal_7 = new JLabel("=");
		equal_7.setHorizontalAlignment(SwingConstants.CENTER);
		equal_7.setFont(new Font("Calisto MT", Font.PLAIN, 12));
		equal_7.setBounds(189, 249, 60, 17);
		
		JLabel equal_8 = new JLabel("=");
		equal_8.setHorizontalAlignment(SwingConstants.CENTER);
		equal_8.setFont(new Font("Calisto MT", Font.PLAIN, 12));
		equal_8.setBounds(189, 269, 60, 17);
		
		JLabel equal_17 = new JLabel("=");
		equal_17.setHorizontalAlignment(SwingConstants.CENTER);
		equal_17.setFont(new Font("Calisto MT", Font.PLAIN, 12));
		equal_17.setBounds(189, 465, 60, 17);
		
		JLabel equal_16 = new JLabel("=");
		equal_16.setHorizontalAlignment(SwingConstants.CENTER);
		equal_16.setFont(new Font("Calisto MT", Font.PLAIN, 12));
		equal_16.setBounds(189, 445, 60, 17);
		
		JLabel equal_15 = new JLabel("=");
		equal_15.setHorizontalAlignment(SwingConstants.CENTER);
		equal_15.setFont(new Font("Calisto MT", Font.PLAIN, 12));
		equal_15.setBounds(189, 425, 60, 17);
		
		JLabel equal_14 = new JLabel("=");
		equal_14.setHorizontalAlignment(SwingConstants.CENTER);
		equal_14.setFont(new Font("Calisto MT", Font.PLAIN, 12));
		equal_14.setBounds(189, 408, 60, 17);
		
		JLabel equal_13 = new JLabel("=");
		equal_13.setHorizontalAlignment(SwingConstants.CENTER);
		equal_13.setFont(new Font("Calisto MT", Font.PLAIN, 12));
		equal_13.setBounds(189, 388, 60, 17);
		
		JLabel equal_11 = new JLabel("=");
		equal_11.setHorizontalAlignment(SwingConstants.CENTER);
		equal_11.setFont(new Font("Calisto MT", Font.PLAIN, 12));
		equal_11.setBounds(189, 348, 60, 17);
		
		JLabel equal_12 = new JLabel("=");
		equal_12.setHorizontalAlignment(SwingConstants.CENTER);
		equal_12.setFont(new Font("Calisto MT", Font.PLAIN, 12));
		equal_12.setBounds(189, 368, 60, 17);
		
		JLabel equal_9 = new JLabel("=");
		equal_9.setHorizontalAlignment(SwingConstants.CENTER);
		equal_9.setFont(new Font("Calisto MT", Font.PLAIN, 12));
		equal_9.setBounds(189, 308, 60, 17);
		
		JLabel equal_10 = new JLabel("=");
		equal_10.setHorizontalAlignment(SwingConstants.CENTER);	
		equal_10.setFont(new Font("Calisto MT", Font.PLAIN, 12));
		equal_10.setBounds(189, 328, 60, 17);
		
		ImageIcon imageLabel = new ImageIcon("C:\\Users\\Kirt Asia\\Dangal-ATM\\dATM\\img\\Dangal ATM Dashboard.png");
		
		// ------------- ADDING COMPONENTS -------------

		getContentPane().add(logoPnl);
		getContentPane().add(terminal);
		getContentPane().add(sequence);
		getContentPane().add(businessDate);
		getContentPane().add(dateTime);
		getContentPane().add(debit);
		getContentPane().add(cardNum);
		getContentPane().add(accountLbl);
		getContentPane().add(transaction);
		getContentPane().add(divider1);
		getContentPane().add(tvr);
		getContentPane().add(tc);
		getContentPane().add(tsi);
		getContentPane().add(owner);
		getContentPane().add(atmFeePaidTo);
		getContentPane().add(ledgerAmount);
		getContentPane().add(totalAmount);
		getContentPane().add(atmFee);
		getContentPane().add(dispensedAmount);
		getContentPane().add(divider2);
		getContentPane().add(approved);
		getContentPane().add(thankYou);
		getContentPane().add(terVal);
		getContentPane().add(seqVal);
		getContentPane().add(dtVal);
		getContentPane().add(bdateVal);
		getContentPane().add(cardNumVal);
		getContentPane().add(debVal);
		getContentPane().add(tranVal);
		getContentPane().add(accVal);
		getContentPane().add(disVal);
		getContentPane().add(feeVal);
		getContentPane().add(ttlVal);
		getContentPane().add(ldgVal);
		getContentPane().add(feePaidVal);
		getContentPane().add(ownerVal);
		getContentPane().add(tsiVal);
		getContentPane().add(tcVal);
		getContentPane().add(tvrVal);
		getContentPane().add(equal_1);
		getContentPane().add(equal_2);
		getContentPane().add(equal_3);
		getContentPane().add(equal_4);
		getContentPane().add(equal_5);
		getContentPane().add(equal_6);
		getContentPane().add(equal_7);
		getContentPane().add(equal_8);
		getContentPane().add(equal_9);
		getContentPane().add(equal_10);
		getContentPane().add(equal_11);
		getContentPane().add(equal_12);
		getContentPane().add(equal_13);
		getContentPane().add(equal_14);
		getContentPane().add(equal_15);
		getContentPane().add(equal_16);
		getContentPane().add(equal_17);
		
		// ------------- UPDATING -------------
		
		terVal.setText(Integer.toString((int) (Math.random() * 100)));
		
		seqVal.setText((Integer.toString((int) (Math.random() * 10))));
		
		Date currentDate = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String formattedDate = dateFormat.format(currentDate);
		dtVal.setText(formattedDate);
		
		bdateVal.setText(formattedDate.substring(0, 10));
		
		String b = (String)database.getValueAt(i, 0);
		cardNumVal.setText(b.charAt(0) + "****" + b.substring(5,7));
		
		debVal.setText(Integer.toString((int) (Math.random() * 10000000)));
		
		tranVal.setText(a);
		
	}
	
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
	