package coinpurse;

/**
 * A main class to create objects and connect objects together.
 * The user interface needs a reference to coin purse.
 * 
 * @author Sirasath Piyapootinun
 */
public class Main {
	private static int capacity = 20;
	/**
     * Configure and start the application.
     * @param args not used
     */
	public static void main(String[] args) {
		Purse purse = new Purse(capacity);
		ConsoleDialog consoledialog = new ConsoleDialog(purse);
		consoledialog.run();
	}
}
