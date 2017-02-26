package coinpurse;

/**
 * Valuable interface for getting value and currency
 * of the money.
 * 
 * @author Sirasath Piyapootinun
 *
 */
public interface Valuable extends Comparable<Valuable>{
	
	/**
	 * Get the monetary value of this object in its
	 * specified or default currency.
	 * 
	 * @return the value of this object.
	 */
	public double getValue();
	
	/**
	 * Get the monetary currency of this object in its 
	 * specified value.
	 * 
	 * @return the currency of this object.
	 */
	public String getCurrency();
}
