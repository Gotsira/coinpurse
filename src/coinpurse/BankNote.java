package coinpurse;

/**
 * A bank note with monetary value and currency.
 * 
 * @author Sirasath Piyapootinun
 *
 */
public class BankNote implements Valuable{
	private static final String DEFAULT_CURRENCY = "Baht";
	/** The currecy of the bank note. */
	private String currency;
	/** Value of the bank note. */
	private double value;
	/** The serial number of the bank note. */
	private long serialNumber;
	/** The next serial number of the bank note. */
	private static long nextSerialNumber = 1000000;
	
	/**
	 * Initialize a new BankNote by the value. The currency will be 
	 * set to default currency which is Baht and the serial number 
	 * will be set to new serial number.
	 * 
	 * @param value is the value of the bank note.
	 */
	public BankNote(double value) {
		this(value, DEFAULT_CURRENCY);
	}
	
	/**
	 * Initialize a new BankNote by the value and currency. The serial
	 * number will be set to the new serial number.
	 * 
	 * @param value is the value of the bank note.
	 * @param currency is the currency of the bank note.
	 */
	public BankNote(double value, String currency) {
		this.value = value;
		this.currency = currency;
		this.serialNumber = this.nextSerialNumber;
		this.nextSerialNumber++;
	}
	
	/**
	 * Gets the currency of the bank note.
	 * 
	 * @return the currency of the bank note.
	 */
	public String getCurrency() {
		return this.currency;
	}
	
	/**
	 * Gets the value of the bank note.
	 * 
	 * @return the value of the bank note.
	 */
	public double getValue() {
		return this.value;
	}
	
	/**
	 * Gets the serial number of the bank note,
	 * 
	 * @return the serial number of the bank note.
	 */
	public long getSerialNumber() {
		return this.serialNumber;
	}
	
	/**
	 * Compares this note with another object. Return 
	 * true if they are equal, false if not.
	 * 
	 * @param obj is the object to e compare with this note.
	 *            
	 * @return true if the notes are equal, false if vice versa.
	 */
	public boolean equals(Object obj) {
		if(obj == null) {
			return false;
		}
		if(obj.getClass() != this.getClass()) {
			return false;
		}
		BankNote other = (BankNote) obj;
		if(other.currency.equals(this.currency) && other.value == this.value) {
			return true;
		}
		return false;
	}
	
	/** 
     * Returns a String describing the bank note.
     * 
     * @return a string describing the bank note.
     */
	public String toString() {
		return this.value + "-" + this.currency + " note [" + this.serialNumber + "]";
	}
}
