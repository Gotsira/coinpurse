package coinpurse.strategy;

import java.util.ArrayList;
import java.util.List;

import coinpurse.Valuable;

public class RecursiveWithdraw implements WithdrawStrategy {

	@Override
	public List<Valuable> withdraw(double amount, List<Valuable> money) {
		if (amount == 0) {
			return new ArrayList<Valuable>();
		}
		if (money.isEmpty()) {
			return null;
		}
		Valuable val = money.get(0);
		List<Valuable> keep;
		List<Valuable> sub = money.subList(1, money.size());
		if (amount >= val.getValue()) {
			if ((keep = withdraw(amount - val.getValue(), sub)) != null) {
				keep.add(val);
			}
			else if(keep == null) {
				keep = withdraw(amount, sub);				
			}
			return keep;
		}
		return null;
	}

}
