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

	private JFrame frame;
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
		
		JPanel logoPanel = new ImagePanel("C:\\Users\\Kirt Asia\\Dangal-ATM\\dATM\\img\\Dangal ATM Dashboard.png");
		logoPanel.setBounds(90, 15, 250, 100);
		getContentPane().add(logoPanel);
		
		JLabel terminal = new JLabel("TERMINAL");
		terminal.setFont(new Font("Calisto MT", Font.PLAIN, 12));
		terminal.setBounds(26, 132, 106, 17);
		getContentPane().add(terminal);
		
		JLabel sequence = new JLabel("SEQUENCE");
		sequence.setFont(new Font("Calisto MT", Font.PLAIN, 12));
		sequence.setBounds(26, 152, 106, 17);
		getContentPane().add(sequence);
		
		JLabel business_date = new JLabel("BUSINESS DATE");
		business_date.setFont(new Font("Calisto MT", Font.PLAIN, 12));
		business_date.setBounds(26, 192, 106, 17);
		getContentPane().add(business_date);
		
		JLabel date_time = new JLabel("DATE & TIME");
		date_time.setFont(new Font("Calisto MT", Font.PLAIN, 12));
		date_time.setBounds(26, 172, 106, 17);
		getContentPane().add(date_time);
		
		JLabel debit = new JLabel("DEBIT");
		debit.setFont(new Font("Calisto MT", Font.PLAIN, 12));
		debit.setBounds(26, 232, 106, 17);
		getContentPane().add(debit);
		
		JLabel card_num = new JLabel("CARD NUMBER");
		card_num.setFont(new Font("Calisto MT", Font.PLAIN, 12));
		card_num.setBounds(26, 212, 106, 17);
		getContentPane().add(card_num);
		
		JLabel accountLbl = new JLabel("ACCOUNT");
		accountLbl.setFont(new Font("Calisto MT", Font.PLAIN, 12));
		accountLbl.setBounds(26, 269, 106, 17);
		getContentPane().add(accountLbl);
		
		JLabel transaction = new JLabel("TRANSACTION");
		transaction.setFont(new Font("Calisto MT", Font.PLAIN, 12));
		transaction.setBounds(26, 249, 106, 17);
		getContentPane().add(transaction);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(364, 331, -319, -45);
		getContentPane().add(lblNewLabel_1);
		
		JLabel divider_1 = new JLabel("-------------------------------------");
		divider_1.setFont(new Font("Tahoma", Font.PLAIN, 27));
		divider_1.setBounds(26, 281, 375, 17);
		getContentPane().add(divider_1);
		
		JLabel tvr = new JLabel("TVR");
		tvr.setFont(new Font("Calisto MT", Font.PLAIN, 12));
		tvr.setBounds(26, 465, 106, 17);
		getContentPane().add(tvr);
		
		JLabel tc = new JLabel("TC");
		tc.setFont(new Font("Calisto MT", Font.PLAIN, 12));
		tc.setBounds(26, 445, 106, 17);
		getContentPane().add(tc);
		
		JLabel tsi = new JLabel("TSI");
		tsi.setFont(new Font("Calisto MT", Font.PLAIN, 12));
		tsi.setBounds(26, 425, 106, 17);
		getContentPane().add(tsi);
		
		JLabel owner = new JLabel("OWNER");
		owner.setFont(new Font("Calisto MT", Font.PLAIN, 12));
		owner.setBounds(26, 408, 106, 17);
		getContentPane().add(owner);
		
		JLabel atm_fee_paid_to = new JLabel("ATM FEE PAID TO:");
		atm_fee_paid_to.setFont(new Font("Calisto MT", Font.PLAIN, 12));
		atm_fee_paid_to.setBounds(26, 388, 142, 17);
		getContentPane().add(atm_fee_paid_to);
		
		JLabel ledger_amount = new JLabel("LEDGER AMOUNT");
		ledger_amount.setFont(new Font("Calisto MT", Font.PLAIN, 12));
		ledger_amount.setBounds(26, 368, 131, 17);
		getContentPane().add(ledger_amount);
		
		JLabel total_amount = new JLabel("TOTAL AMOUNT");
		total_amount.setFont(new Font("Calisto MT", Font.PLAIN, 12));
		total_amount.setBounds(26, 348, 131, 17);
		getContentPane().add(total_amount);
		
		JLabel atmfee = new JLabel("ATM FEE");
		atmfee.setFont(new Font("Calisto MT", Font.PLAIN, 12));
		atmfee.setBounds(26, 328, 106, 17);
		getContentPane().add(atmfee);
		
		JLabel dispensed_amount = new JLabel("DISPENSED AMOUNT");
		dispensed_amount.setFont(new Font("Calisto MT", Font.PLAIN, 12));
		dispensed_amount.setBounds(26, 308, 142, 17);
		getContentPane().add(dispensed_amount);
		
		JLabel divider_2 = new JLabel("-------------------------------------");
		divider_2.setFont(new Font("Tahoma", Font.PLAIN, 27));
		divider_2.setBounds(26, 481, 375, 17);
		getContentPane().add(divider_2);
		
		JLabel approved = new JLabel("APPROVED");
		approved.setFont(new Font("Calisto MT", Font.PLAIN, 12));
		approved.setBounds(26, 500, 106, 17);
		getContentPane().add(approved);
		
		JLabel thankyou = new JLabel("THANK YOU!");
		thankyou.setFont(new Font("Calisto MT", Font.PLAIN, 12));
		thankyou.setBounds(26, 525, 106, 17);
		getContentPane().add(thankyou);
		
		JLabel terVal = new JLabel("0");
		terVal.setFont(new Font("Calisto MT", Font.PLAIN, 12));
		terVal.setBounds(295, 132, 106, 17);
		getContentPane().add(terVal);
		
		JLabel seqVal = new JLabel("0");
		seqVal.setFont(new Font("Calisto MT", Font.PLAIN, 12));
		seqVal.setBounds(295, 152, 106, 17);
		getContentPane().add(seqVal);
		
		JLabel d_tVal = new JLabel("0");
		d_tVal.setFont(new Font("Calisto MT", Font.PLAIN, 12));
		d_tVal.setBounds(295, 172, 106, 17);
		getContentPane().add(d_tVal);
		
		JLabel bdateVal = new JLabel("0");
		bdateVal.setFont(new Font("Calisto MT", Font.PLAIN, 12));
		bdateVal.setBounds(295, 192, 106, 17);
		getContentPane().add(bdateVal);
		
		JLabel cardnumVal = new JLabel("0");
		cardnumVal.setFont(new Font("Calisto MT", Font.PLAIN, 12));
		cardnumVal.setBounds(295, 212, 106, 17);
		getContentPane().add(cardnumVal);
		
		JLabel debVal = new JLabel("0");
		debVal.setFont(new Font("Calisto MT", Font.PLAIN, 12));
		debVal.setBounds(295, 232, 106, 17);
		getContentPane().add(debVal);
		
		JLabel tranVal = new JLabel("0");
		tranVal.setFont(new Font("Calisto MT", Font.PLAIN, 12));
		tranVal.setBounds(295, 249, 131, 17);
		getContentPane().add(tranVal);
		
		JLabel accVal = new JLabel("0");
		accVal.setFont(new Font("Calisto MT", Font.PLAIN, 12));
		accVal.setBounds(295, 269, 106, 17);
		getContentPane().add(accVal);
		
		JLabel disVal = new JLabel("0");
		disVal.setFont(new Font("Calisto MT", Font.PLAIN, 12));
		disVal.setBounds(295, 308, 142, 17);
		getContentPane().add(disVal);
		
		JLabel feeVal = new JLabel("0");
		feeVal.setFont(new Font("Calisto MT", Font.PLAIN, 12));
		feeVal.setBounds(295, 328, 106, 17);
		getContentPane().add(feeVal);
		
		JLabel ttlVal = new JLabel("0");
		ttlVal.setFont(new Font("Calisto MT", Font.PLAIN, 12));
		ttlVal.setBounds(295, 348, 131, 17);
		getContentPane().add(ttlVal);
		
		JLabel ldgVal = new JLabel("0");
		ldgVal.setFont(new Font("Calisto MT", Font.PLAIN, 12));
		ldgVal.setBounds(295, 368, 131, 17);
		getContentPane().add(ldgVal);
		
		JLabel feepaidVal = new JLabel("0");
		feepaidVal.setFont(new Font("Calisto MT", Font.PLAIN, 12));
		feepaidVal.setBounds(295, 388, 142, 17);
		getContentPane().add(feepaidVal);
		
		JLabel ownerVal = new JLabel("0");
		ownerVal.setFont(new Font("Calisto MT", Font.PLAIN, 12));
		ownerVal.setBounds(295, 408, 106, 17);
		getContentPane().add(ownerVal);
		
		JLabel tsiVal = new JLabel("0");
		tsiVal.setFont(new Font("Calisto MT", Font.PLAIN, 12));
		tsiVal.setBounds(295, 425, 106, 17);
		getContentPane().add(tsiVal);
		
		JLabel tcVal = new JLabel("0");
		tcVal.setFont(new Font("Calisto MT", Font.PLAIN, 12));
		tcVal.setBounds(295, 445, 106, 17);
		getContentPane().add(tcVal);
		
		JLabel tvrVal = new JLabel("0");
		tvrVal.setFont(new Font("Calisto MT", Font.PLAIN, 12));
		tvrVal.setBounds(295, 465, 106, 17);
		getContentPane().add(tvrVal);
		
		JLabel equal_1 = new JLabel("=");
		equal_1.setHorizontalAlignment(SwingConstants.CENTER);
		equal_1.setFont(new Font("Calisto MT", Font.PLAIN, 12));
		equal_1.setBounds(189, 132, 60, 17);
		getContentPane().add(equal_1);
		
		JLabel equal_2 = new JLabel("=");
		equal_2.setHorizontalAlignment(SwingConstants.CENTER);
		equal_2.setFont(new Font("Calisto MT", Font.PLAIN, 12));
		equal_2.setBounds(189, 152, 60, 17);
		getContentPane().add(equal_2);
		
		JLabel equal_3 = new JLabel("=");
		equal_3.setHorizontalAlignment(SwingConstants.CENTER);
		equal_3.setFont(new Font("Calisto MT", Font.PLAIN, 12));
		equal_3.setBounds(189, 172, 60, 17);
		getContentPane().add(equal_3);
		
		JLabel equal_4 = new JLabel("=");
		equal_4.setHorizontalAlignment(SwingConstants.CENTER);
		equal_4.setFont(new Font("Calisto MT", Font.PLAIN, 12));
		equal_4.setBounds(189, 192, 60, 17);
		getContentPane().add(equal_4);
		
		JLabel equal_5 = new JLabel("=");
		equal_5.setHorizontalAlignment(SwingConstants.CENTER);
		equal_5.setFont(new Font("Calisto MT", Font.PLAIN, 12));
		equal_5.setBounds(189, 212, 60, 17);
		getContentPane().add(equal_5);
		
		JLabel equal_6 = new JLabel("=");
		equal_6.setHorizontalAlignment(SwingConstants.CENTER);
		equal_6.setFont(new Font("Calisto MT", Font.PLAIN, 12));
		equal_6.setBounds(189, 232, 60, 17);
		getContentPane().add(equal_6);
		
		JLabel equal_7 = new JLabel("=");
		equal_7.setHorizontalAlignment(SwingConstants.CENTER);
		equal_7.setFont(new Font("Calisto MT", Font.PLAIN, 12));
		equal_7.setBounds(189, 249, 60, 17);
		getContentPane().add(equal_7);
		
		JLabel equal_8 = new JLabel("=");
		equal_8.setHorizontalAlignment(SwingConstants.CENTER);
		equal_8.setFont(new Font("Calisto MT", Font.PLAIN, 12));
		equal_8.setBounds(189, 269, 60, 17);
		getContentPane().add(equal_8);
		
		JLabel equal_17 = new JLabel("=");
		equal_17.setHorizontalAlignment(SwingConstants.CENTER);
		equal_17.setFont(new Font("Calisto MT", Font.PLAIN, 12));
		equal_17.setBounds(189, 465, 60, 17);
		getContentPane().add(equal_17);
		
		JLabel equal_16 = new JLabel("=");
		equal_16.setHorizontalAlignment(SwingConstants.CENTER);
		equal_16.setFont(new Font("Calisto MT", Font.PLAIN, 12));
		equal_16.setBounds(189, 445, 60, 17);
		getContentPane().add(equal_16);
		
		JLabel equal_15 = new JLabel("=");
		equal_15.setHorizontalAlignment(SwingConstants.CENTER);
		equal_15.setFont(new Font("Calisto MT", Font.PLAIN, 12));
		equal_15.setBounds(189, 425, 60, 17);
		getContentPane().add(equal_15);
		
		JLabel equal_14 = new JLabel("=");
		equal_14.setHorizontalAlignment(SwingConstants.CENTER);
		equal_14.setFont(new Font("Calisto MT", Font.PLAIN, 12));
		equal_14.setBounds(189, 408, 60, 17);
		getContentPane().add(equal_14);
		
		JLabel equal_13 = new JLabel("=");
		equal_13.setHorizontalAlignment(SwingConstants.CENTER);
		equal_13.setFont(new Font("Calisto MT", Font.PLAIN, 12));
		equal_13.setBounds(189, 388, 60, 17);
		getContentPane().add(equal_13);
		
		JLabel equal_11 = new JLabel("=");
		equal_11.setHorizontalAlignment(SwingConstants.CENTER);
		equal_11.setFont(new Font("Calisto MT", Font.PLAIN, 12));
		equal_11.setBounds(189, 348, 60, 17);
		getContentPane().add(equal_11);
		
		JLabel equal_12 = new JLabel("=");
		equal_12.setHorizontalAlignment(SwingConstants.CENTER);
		equal_12.setFont(new Font("Calisto MT", Font.PLAIN, 12));
		equal_12.setBounds(189, 368, 60, 17);
		getContentPane().add(equal_12);
		
		JLabel equal_9 = new JLabel("=");
		equal_9.setHorizontalAlignment(SwingConstants.CENTER);
		equal_9.setFont(new Font("Calisto MT", Font.PLAIN, 12));
		equal_9.setBounds(189, 308, 60, 17);
		getContentPane().add(equal_9);
		
		JLabel equal_10 = new JLabel("=");
		equal_10.setHorizontalAlignment(SwingConstants.CENTER);	
		equal_10.setFont(new Font("Calisto MT", Font.PLAIN, 12));
		equal_10.setBounds(189, 328, 60, 17);
		getContentPane().add(equal_10);
		
		ImageIcon imageLabel = new ImageIcon("C:\\Users\\Kirt Asia\\Dangal-ATM\\dATM\\img\\Dangal ATM Dashboard.png");
		
		
		// Updating
		terVal.setText(Integer.toString((int) (Math.random() * 100)));	
		seqVal.setText((Integer.toString((int) (Math.random() * 10))));
		
		Date currentDate = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String formattedDate = dateFormat.format(currentDate);
		d_tVal.setText(formattedDate);
		bdateVal.setText(formattedDate.substring(0, 10));
		String b = (String)database.getValueAt(i, 0);
		cardnumVal.setText(b.charAt(0) + "****" + b.substring(5,7));
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
	