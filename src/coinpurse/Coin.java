package coinpurse;

/**
 * Coin represents coinage (money) with a fixed value and
 * currency.
 * 
 * @author Sirasath Piyapootinun
 *
 */
public class Coin implements Comparable<Coin>, Valuable {
	public static final String DEFAULT_CURRENCY = "Baht";
    /** Value of the coin. */
	private double value;
	/** The currency, of course. */
	private String currency;
	
	/**
     * A coin with given value using the default currency.
     * 
     * @param value 
     * 		is the value of the coin.
     */
	public Coin(double value) {
		this.value = value;
		this.currency = DEFAULT_CURRENCY;
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
		this.value = value;
		this.currency = currency;
	}
	
	/**
	 * Gets the value of the coin.
	 * 
	 * @return the value of the coin.
	 */
	public double getValue() {
		return this.value;
	}
	
	/**
	 * Gets the currency of the coin.
	 * 
	 * @return the currency of the coin.
	 */
	public String getCurrency() {
		return this.currency;
	}
	
	/**
	 * Test whether the two coins are equal or not.
	 * They are equal if they have the same value and
	 * currency.
	 * 
	 * @param arg 
	 * 		is the coin to compare.
	 * @return true if the two coins are equals, false otherwise.
	 */
	public boolean equals(Object arg) {
		if(arg == null) {
			return false;
		}
		if(arg.getClass() != this.getClass()) {
			return false;
		}
		Coin other = (Coin) arg;
		if(other.currency.equals(this.currency) && other.value == this.value) {
			return true;
		}
		return false;
	}
	
	/**
	 * Compare this coin with another coin. Return -1 if this coin 
	 * has lesser value than the comparing coin, 0 if they are equal,
	 * and 1 if this coin is greater.
	 * 
	 * @param c
	 * 		is the Coin object to compare with.
	 * @return -1 if this coin has lesser value.
	 * 			1 is this coin is greater.
	 * 			0 if they are equal.
	 */
	public int compareTo(Coin c) {
		if(c == null) {
			return -1;
		}
		return (int) Math.signum(this.value - c.value);
	}
	
	/**
	 * Get a String that describes this Coin.
	 * 
	 * @return a String that describes the coin's value and currency.
	 */
	public String toString() {
		return this.value + "-" + this.currency;
	}
}
