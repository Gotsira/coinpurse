package coinpurse;

import java.awt.Font;
import java.util.Observable;
import java.util.Observer;

import javax.swing.*;

public class PurseObserver extends JFrame implements Observer {
	private JTextArea textarea;
	
	public PurseObserver() {
	}
	
	private void initComponents() {
		textarea = new JTextArea(5,40);
		textarea.setFont(new Font(Font.DIALOG, Font.PLAIN, 24));
		JScrollPane scrollPane = new JScrollPane(textarea);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		this.add(scrollPane);
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
			double balance = purse.getBalance();
			textarea.append("Balance is: " + balance + "\n");
		}
	}
}
