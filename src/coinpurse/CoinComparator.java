package coinpurse;

import java.util.Comparator;

/**
 * CoinComparator class implements Comparator to override the 
 * compare method.
 * 
 * @author Sirasath Piyapootinun
 *
 */

public class CoinComparator implements Comparator<Valuable>{
	
	/**
	 * Compares the currency between two coin. Return -1 currency of
	 * o1 comes first, 1 if the currency of o2 comes first, and 0 if
	 * they are the same.
	 * 
	 * @param o1
	 * 		is the first object to compare.
	 * @param o2 
	 * 		is the second object to compare.
	 * 
	 * @return -1 if the currency of o1 comes first.
	 * 			0 if they are the same.
	 * 			1 if the currency of o2 comes first.
	 * 	
	 */
	@Override
	public int compare(Valuable o1, Valuable o2) {
		return o1.getCurrency().compareToIgnoreCase(o2.getCurrency());
	}
}
