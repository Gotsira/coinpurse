package coinpurse;

public class ThaiMoneyFactory extends MoneyFactory {
	private final String DEFAULT_CURRENCY = "Baht";
	private long serialNumber = 1000000;
	private double [] vals = {0.25, 0.5, 1.0, 2.0, 5.0, 10.0, 20.0, 50.0, 100.0, 500.0, 1000.0};
	
	@Override
	public Valuable createMoney(double value) throws IllegalArgumentException {
		if(!checkValue(value, vals)) {
			throw new IllegalArgumentException();
		}
		if(value <= 10) {
			Coin c = new Coin(value, DEFAULT_CURRENCY);
			if(value < 1) {
				c.setDescription(value*100, "Satang");
			}
			return c;
		}
		else {
			BankNote note = new BankNote(value);
			note.setSerialNumber(serialNumber++);
			return note;
		}
	}
	
	@Override
	public String getCurrency() {
		return DEFAULT_CURRENCY;
	}
}
