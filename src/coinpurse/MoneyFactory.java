package coinpurse;

import java.util.ResourceBundle;

/**
 * Money Factory is a factory class for creating Valuable items.
 * 
 * @author Sirasath Piyapootinun
 *
 */

public abstract class MoneyFactory {
	private static MoneyFactory factory;
	
	/**
	 * Gets the instance of MoneyFactory.
	 * 
	 * @return an object of subclass (Thai or Malay)
	 */
	public static MoneyFactory getInstance() {
		setMoneyFactory();
		return factory;
	}
	
	/**
	 * Create money by its value.
	 * 
	 * @param value is the amount of money to be created
	 * @return a Valuable object of the specified amount
	 * @throws IllegalArgumentException
	 *             if the value is not a valid amount of money
	 */
	public abstract Valuable createMoney(double value);
	
	/**
	 * Create money by its value in String.
	 * 
	 * @param value is the amount of money to be created
	 * @return a Valuable object of the specified amount
	 * @throws IllegalArgumentException
	 *             if the value is not a valid amount of money
	 */
	public Valuable createMoney(String value) {
		double val = Double.parseDouble(value);
		return createMoney(val);
		
	}
	
	/**
	 * Selects the country factory by reading in purse.properties. 
	 */
	public static MoneyFactory setMoneyFactory() {
		ResourceBundle bundle = ResourceBundle.getBundle("purse");
		String factoryclass = bundle.getString("moneyfactory");
		try {
			factory = (MoneyFactory) Class.forName(factoryclass).newInstance();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error creating MoneyFactory " +e.getMessage() );
		}
		return factory;
	}
	
	/**
	 * Check if a value is valid or not for creating.
	 * 
	 * @param value is the value to check for
	 * @return true if it is valid, false otherwise
	 */
	public boolean checkValue(double value, double [] vals) {
		for(double  v : vals) {
			if(value == v) {
				return true;
			}
		}
		return false;
	}
	
	public abstract String getCurrency();
}
