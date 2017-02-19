package coinpurse;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Comparator;
import java.util.HashMap;

/**
 * Some monetary objects utility methods for practice using Lists and Comparator.
 * 
 * @author Sirasath Piyapootinun
 */
public class CoinUtil {

	/**
	 * Method that examines all the coins in a List and returns
	 * only the coins that have a currency that matches the parameter value.
	 * @param moneylist is a List of monetary objects. This list is not modified.
	 * @param currency is the currency we want. Must not be null.
	 * @return a new List containing only the elements from coinlist
	 *     that have the requested currency.  
	 */
	public static List<Valuable> filterByCurrency(final List<? extends Valuable> moneylist, String currency) {
		List<Valuable> keep = new ArrayList<>();
		for(Valuable c: moneylist) {
			if(c.getCurrency().equals(currency)) {
				keep.add(c);
			}
		}
		return keep;
	}
	

	/**
	 * Method to sort a list of coins by currency.
	 * On return, the list (coins) will be ordered by currency.
	 * @param money is a List of monetary objects we want to sort. 
	 *
	 */
	public static void sortByCurrency(List<? extends Valuable> money) {
		Collections.sort(money, new CoinComparator());
	}
	
	/**
	 * Sum coins by currency and print the sum for each currency.
	 * Print one line for the sum of each currency.
	 *
	 *@param vals is the list of monetary objects we want to add.	
	 */
	public static void sumByCurrency(List<? extends Valuable> vals) {
		Map<String, Double> store = new HashMap<String, Double>();
		for(Valuable val: vals) {
			store.put(val.getCurrency(), store.getOrDefault(val.getCurrency(), 0.0) + val.getValue());
		}
		for(Map.Entry<String, Double> entry: store.entrySet()) {
			System.out.println(entry.getValue() + " " + entry.getKey());
		}
//		sortByCurrency(coins);
//		double sum = 0;
//		String currency = coins.get(0).getCurrency();
//		for(Valuable c: coins) {
//			if(c.getCurrency().equals(currency)) {
//				sum += c.getValue();
//			}
//			else {
//				System.out.println(sum + " " + currency);
//				sum = c.getValue();
//				currency = c.getCurrency();
//			}
//		}
//		System.out.println(sum + " " + currency);
	}
	
	/**
	 * This method contains some code to test the above methods.
	 * @param args not used
	 */
	public static void main(String[] args) {
		String currency = "Rupee";
		System.out.println("Filter coins by currency of "+currency);
		List<Valuable> coins = makeInternationalCoins();
		int size = coins.size();
		System.out.print(" INPUT: "); printList(coins," ");
		List<Valuable> rupees = filterByCurrency(coins, currency);
		System.out.print("RESULT: "); printList(rupees," ");
		if (coins.size() != size) System.out.println("Error: you changed the original list.");
		
		System.out.println("\nSort coins by currency");
		coins = makeInternationalCoins();
		System.out.print(" INPUT: "); printList(coins," ");
		sortByCurrency(coins);
		System.out.print("RESULT: "); printList(coins," ");
		
		System.out.println("\nSum coins by currency");
		coins = makeInternationalCoins();
		System.out.print("coins= "); printList(coins," ");
		sumByCurrency(coins);
		
	}
	
	/** Make a list of coins containing different currencies. */
	public static List<Valuable> makeInternationalCoins( ) {
		List<Valuable> money = new ArrayList<Valuable>();
		money.addAll( makeValuable("Baht", 0.25, 1.0, 2.0, 5.0, 10.0, 10.0) );
		money.addAll( makeValuable("Ringgit", 2.0, 50.0, 1.0, 5.0) );
		money.addAll( makeValuable("Rupee", 0.5, 0.5, 10.0, 1.0) );
		// randomize the elements
		Collections.shuffle(money);
		return money;
	}
	
	/** Make a list of coins using given values. */ 
	public static List<Valuable> makeValuable(String currency, double ... values) {
		List<Valuable> list = new ArrayList<Valuable>();
		for(double value : values) {
			if(value < 20) {
				list.add(new Coin(value,currency));
			}
			else {
				list.add(new BankNote(value, currency));
			}
		}
		return list;
	}
	
	/** Print the list on the console, on one line. */
	public static void printList(List items, String separator) {
		Iterator iter = items.iterator();
		while( iter.hasNext() ) { 
			System.out.print(iter.next());
			if (iter.hasNext()) System.out.print(separator);
			
		}
		System.out.println(); // end the line
	}
}
