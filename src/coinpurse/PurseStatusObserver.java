package coinpurse;

import java.awt.BorderLayout;
import java.awt.Font;
import java.util.Observable;
import java.util.Observer;

import javax.swing.*;

public class PurseStatusObserver extends JFrame implements Observer {
	private JLabel label;
	private JProgressBar bar;
	
	public PurseStatusObserver() {
	}
	
	private void initComponents() {
		label = new JLabel("EMPTY");
		bar = new JProgressBar(0, 10);
		label.setFont(new Font("Comic Sans MS", 1 , 23));
		label.setHorizontalAlignment(JLabel.CENTER);
		this.add(label, BorderLayout.CENTER);
		this.add(bar, BorderLayout.SOUTH);
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
			bar.setMaximum(purse.getCapacity());
			int current = purse.count();
			bar.setValue(current);
			if(current == 0) {
				label.setText("EMPTY");
			}
			else if(current < purse.getCapacity()) {
				label.setText(current + "");
			}
			else {
				label.setText("FULL");
			}
		}
	}
}
