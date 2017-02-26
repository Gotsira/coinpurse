package coinpurse;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *  A purse contains coins and bank notes. You can insert coins or
 *  bank notes, withdraw them, check its balance or even whether the
 *  purse is full or not. During the withdraw process, the purse decides
 *  which coin or bank note to remove.
 *  
 *  @author Sirasath Piyapootinun
 */
public class Purse {
    /** Collection of objects in the purse. */
	List<Valuable> money = new ArrayList<Valuable>();
    	
    /** Capacity is maximum number of monetary objects the purse can hold.
     *  Capacity is set when the purse is created and cannot be changed.
     */
    private final int capacity;
    private double balance;
    
    /** 
     *  Create a purse with a specified capacity.
     *  @param capacity is maximum number of coins you can put in purse.
     */
    public Purse( int capacity ) {
    	this.capacity = capacity;
    }

    /**
     * Count and return the number of coins in the purse.
     * This is the number of coins, not their value.
     * @return the number of coins in the purse.
     */
    public int count() { 
    	return money.size();
    }
    
    /** 
     *  Get the total value of all items in the purse.
     *  @return the total value of items in the purse.
     */
    public double getBalance() {
    	double keep = 0;
    	for(Valuable coin : money) {
    		keep += coin.getValue();
    	}
    	return keep;
    }
    
 
    
    /**
     * Return the capacity of the coin purse.
     * @return the capacity of the purse.
     */
    public int getCapacity() { 
    	return this.capacity; 
    }
    
    /** 
     *  Test whether the purse is full.
     *  The purse is full if number of items in purse equals
     *  or greater than the purse capacity.
     *  @return true if purse is full.
     */
    public boolean isFull() {
        if(money.size() == this.capacity) {
        	return true;
        }
        return false;
    }

    /** 
     * Insert a coin into the purse.
     * The coin is only inserted if the purse has space for it
     * and the coin has positive value.  No worthless coins!
     * @param val is a monetary object to insert into purse
     * @return true if monetary object is inserted, false if can't insert
     */
    public boolean insert( Valuable val ) {
        if(isFull() || val.getValue() <= 0) {
        	return false;
        }
        money.add(val);
        money.sort(new CoinsComparator());
        return true;
    }
    
    /**  
     *  Withdraw the requested amount of money.
     *  Return an array of monetary objects	 withdrawn from purse,
     *  or return null if cannot withdraw the amount requested.
     *  @param amount is the amount to withdraw
     *  @return array of monetary objects for money withdrawn, 
	 *    or null if cannot withdraw requested amount.
     */
    public Valuable[] withdraw( double amount ) {
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
		Valuable [] array = new Valuable[save.size()];
		save.toArray(array);
		return array;
	}
  
    /** 
     * Returns a String describing what is in the purse.
     * 
     * @return a string describing what is in the purse.
     */
    public String toString() {
        //TODO complete this
//    	int coin = 0;
//    	int banknotes = 0;
//    	double coinBalance = 0;
//    	double bankBalance = 0;
//    	for(int i = 0; i < money.size(); i++) {
//    		if(money.get(i).getValue() < 20) {
//    			coinBalance += money.get(i).getValue();
//    			coin++;
//    		}
//    		else {
//    			bankBalance += money.get(i).getValue();
//    			banknotes++;
//    		}
//    	}
//    	return coin + " coins with value " + coinBalance + "\n" 
//    		   + banknotes + " banknotes with value " + bankBalance;
    		return count() + " items with value " + this.getBalance();
    }
}

/**
 * This class will compare two valuables based on their values and 
 * sort them out based on the results.
 * 
 * @author Sirasath Piyapootinun
 *
 */
class CoinsComparator implements Comparator<Valuable> {
	
	/**
	 * @param o1 is the first valuable to compare.
	 * @param o2 is the second valuable to compare.
	 * 
	 * @return -1 if the first valuable's currency is come first.
	 * 		    0 if they are the same.
	 *          1 if the second valuable's currency is come first.
	 */
	@Override
	public int compare(Valuable o1, Valuable o2) {
		return (int) Math.signum(o1.getValue() - o2.getValue());
	}
}