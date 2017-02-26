package coinpurse;

public class MalayMoneyFactory extends MoneyFactory {
	private final String DEFAULT_CURRENCY = "Ringgit";
	private long serialNumber = 1000000;
	private double [] vals = {0.05, 0.10, 0.20, 0.50, 1, 2, 5, 10, 20, 50, 100};

	@Override
	public Valuable createMoney(double value) {
		if(!checkValue(value, vals)) {
			throw new IllegalArgumentException();
		}
		if(value < 1) {
			Coin c = new Coin(value, DEFAULT_CURRENCY);
			c.setDescription(value * 100, "Sen");
			return c;
		}
		else {
			BankNote note = new BankNote(value, this.DEFAULT_CURRENCY);
			note.setSerialNumber(serialNumber++);
			return note;
		}
	}

	@Override
	public String getCurrency() {
		return this.DEFAULT_CURRENCY;
	}
	
}
