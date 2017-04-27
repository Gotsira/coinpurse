package coinpurse;

import java.awt.BorderLayout;
import java.awt.Font;
import java.util.Observable;
import java.util.Observer;

import javax.swing.*;

public class PurseBalance extends JFrame implements Observer {
	private JLabel label;
	
	public PurseBalance() {
	}
	
	private void initComponents() {
		label = new JLabel("0 Baht");
		label.setFont(new Font("Comic Sans MS", 1 , 23));
		label.setHorizontalAlignment(JLabel.CENTER);
		this.add(label, BorderLayout.CENTER);
		this.pack();
	}
	
	public void run() {
		initComponents();
		setVisible(true);
	}
	
	@Override
	public void update(Observable subject, Object info) {
		if(subject instanceof Purse) {
			Purse purse = (Purse) subject;
			int balance = (int) purse.getBalance();
			label.setText(balance + " Baht");
		}
	}
}
