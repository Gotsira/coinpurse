package coinpurse;

import java.util.ResourceBundle;

public abstract class MoneyFactory {
	private static MoneyFactory factory;
	
	public static MoneyFactory getInstance() {
		setMoneyFactory();
		return factory;
	}
	
	public abstract Valuable createMoney(double value);
	
	public Valuable createMoney(String value) {
		double val = Double.parseDouble(value);
		return createMoney(val);
		
	}
	
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
