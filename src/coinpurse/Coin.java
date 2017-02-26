package coinpurse;

/**
 * Coin represents coinage (money) with a fixed value and
 * currency.
 * 
 * @author Sirasath Piyapootinun
 *
 */
public class Coin extends AbstractValuable { 
	private double printvalue;
	private String printcurrency;
	
	/**
     * A coin with given value using the default currency.
     * 
     * @param value 
     * 		is the value of the coin.
     */
	public Coin(double value) {
		super(value);
		this.printcurrency = DEFAULT_CURRENCY;
		this.printvalue = value;
	}
	
	  /**
     * A coin with given value and currency.
     * 
     * @param value
     * 		is the value of the coin.
     * @param currency
     * 		is the currency of the coin.
     */
	public Coin(double value, String currency) {
		super(value, currency);
		this.printcurrency = currency;
		this.printvalue = value;
	}

	
//	/**
//	 * Compare this coin with another coin. Return -1 if this coin 
//	 * has lesser value than the comparing coin, 0 if they are equal,
//	 * and 1 if this coin is greater.
//	 * 
//	 * @param c
//	 * 		is the Coin object to compare with.
//	 * @return -1 if this coin has lesser value.
//	 * 			1 is this coin is greater.
//	 * 			0 if they are equal.
//	 */
//	public int compareTo(Coin c) {
//		if(c == null) {
//			return -1;
//		}
//		return (int) Math.signum(this.value - c.value);
//	}
	
	/**
	 * Sets the currency and value of the coin.
	 * 
	 * @param value is the value of the coin.
	 * @param currency is the currency of the coin.
	 */
	public void setDescription(double value, String currency) {
		this.printcurrency = currency;
		this.printvalue = value;
	}
	
	/**
	 * Get a String that describes this Coin.
	 * 
	 * @return a String that describes the coin's value and currency.
	 */
	public String toString() {
		return String.format("%.0f-%s coin", printvalue, printcurrency);
	}
}
