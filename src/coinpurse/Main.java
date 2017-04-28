package coinpurse;

import java.util.ResourceBundle;

/**
 * A main class to create objects and connect objects together.
 * The user interface needs a reference to coin purse.
 * 
 * @author Sirasath Piyapootinun
 */
public class Main {
	private static int capacity = 10;
	/**
     * Configure and start the application.
     * @param args not used
     */
	public static void main(String[] args) {
		
		Purse purse = new Purse(capacity);
		PurseStatusObserver observer = new PurseStatusObserver();
		PurseBalance balance = new PurseBalance();
		purse.addObserver(observer);
		purse.addObserver(balance);
		ConsoleDialog consoledialog = new ConsoleDialog(purse);
		observer.run();
		balance.run();
		consoledialog.run();
		
//		MoneyFactory factory = MoneyFactory.getInstance();
//		Valuable m = factory.createMoney(5);
//		System.out.println(m.toString());
//		Valuable m2 = factory.createMoney("1000.0");
//		System.out.println(m2.toString());
//		
//		Purse purse = new Purse(-1);
//		purse.insert(new Coin(-1, "Baht"));
		
	}
}
