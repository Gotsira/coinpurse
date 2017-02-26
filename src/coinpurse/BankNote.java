package coinpurse;

/**
 * A bank note with monetary value and currency.
 * 
 * @author Sirasath Piyapootinun
 *
 */
public class BankNote extends AbstractValuable {
	
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
		super(value);
	}
	
	/**
	 * Initialize a new BankNote by the value and currency. The serial
	 * number will be set to the new serial number.
	 * 
	 * @param value is the value of the bank note.
	 * @param currency is the currency of the bank note.
	 */
	public BankNote(double value, String currency) {
		super(value, currency);
		this.serialNumber = this.nextSerialNumber;
		this.nextSerialNumber++;
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
	 * Sets the serial number of the bank note.
	 * @param serialNumber is the serial number of the bank note.
	 */
	public void setSerialNumber(long serialNumber) {
		this.serialNumber = serialNumber;
	}
	
	/** 
     * Returns a String describing the bank note.
     * 
     * @return a string describing the bank note.
     */
	public String toString() {
		return String.format("%.0f %s note [%d]", this.value, this.currency, this.serialNumber);
	}
}
