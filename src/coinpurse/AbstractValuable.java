package coinpurse;

public abstract class AbstractValuable implements Valuable {
	protected static final String DEFAULT_CURRENCY = "Baht";
	double value;
	String currency;
	String description;
	
	/**
	 * Constructs a AbstractValuable with a value and currency;
	 * 
	 * @param value is the value of this item
	 * @param currency the currency of this item
	 */
	public AbstractValuable(double value, String currency) {
		this.value = value;
		this.currency = currency;
	}
	
	/**
	 * Constructs a AbstractValuable with a value and a default currency;
	 * 
	 * @param value is the value of this item
	 */
	public AbstractValuable(double value) {
		this(value, DEFAULT_CURRENCY);
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
		Valuable other = (Valuable) arg;
		if(other.getCurrency().equals(this.getCurrency()) && other.getValue() == this.getValue()) {
			return true;
		}
		return false;
	}
	/**
	 * Compares this Valuable with another by its value and currency.
	 * 
	 * @param val is the to Valuable to compare.
	 * @return 1 if this object is lesser.
	 * 		   0 if they are equal.
	 * 		   -1 if this object is larger.
	 */
	public int compareTo(Valuable val) {
		if(val == null) {
			return -1;
		}
		return (int) Math.signum(this.getValue() - val.getValue());
	}

	/**
	 * Gets the value of the coin.
	 * 
	 * @return the value of the coin.
	 */
	@Override
	public double getValue() {
		return value;
	}
	
	/**
	 * Gets the currency of the coin.
	 * 
	 * @return the currency of the coin.
	 */
	@Override
	public String getCurrency() {
		return currency;
	}
	
}