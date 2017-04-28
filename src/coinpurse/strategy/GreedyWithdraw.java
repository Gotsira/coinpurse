package coinpurse.strategy;

import java.util.ArrayList;
import java.util.List;

import coinpurse.Valuable;

public class GreedyWithdraw implements WithdrawStrategy {

	@Override
	public List<Valuable> withdraw(double amount, List<Valuable> money) {
		if ( amount < 0 ) {	
				return null;
			}
			List<Valuable> save = new ArrayList<Valuable>();
			for(int i = money.size() - 1; i >= 0; i--) {
				if(money.get(i).getValue() <= amount) {
					save.add(money.get(i));
					amount -= money.get(i).getValue();
					money.remove(i);
				}
			}
			if(amount > 0) {
				money.addAll(save);
				return null;
			}
			return save;
	}

}
