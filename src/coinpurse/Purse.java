package coinpurse;

import java.util.ArrayList;
import java.util.List;


/**
 *  A coin purse contains coins.
 *  You can insert coins, withdraw money, check the balance,
 *  and check if the purse is full.
 *  
 *  @author Wisa Powthongchin
 */
public class Purse {
    /** Collection of objects in the purse. */
    private List<Valuable> money;
    
    /**
     * Comparator for sorting Valuable objects.
     */
    private ValueComparator valueComparator = new ValueComparator();
	
    /** Capacity is maximum number of items the purse can hold.
     *  Capacity is set when the purse is created and cannot be changed.
     */
    private final int capacity;
    
    /** 
     *  Create a purse with a specified capacity.
     *  @param capacity is maximum number of valuable objects you can put in purse.
     */
    public Purse( int capacity ) {
    	this.capacity = capacity;
    	money = new ArrayList<>(capacity);
    }

    /**
     * Count and return the number of valuable in the purse.
     * This is the number of valuable, not their value.
     * @return the number of valuable in the purse
     */
    public int count() { return money.size(); }
    
    /** 
     *  Get the total value of all items in the purse.
     *  @return the total value of items in the purse.
     */
    public double getBalance() {
    	double balance = 0;
    	
    	for (Valuable valuable : money) {
    		balance += valuable.getValue();
    	}
		return balance; 
	}

    
    /**
     * Return the capacity of the purse.
     * @return the capacity
     */
    public int getCapacity() { 
		return capacity; 
	}
    
    /** 
     *  Test whether the purse is full.
     *  The purse is full if number of items in purse equals
     *  or greater than the purse capacity.
     *  @return true if purse is full.
     */
    public boolean isFull() {
    	if(count() >= this.getCapacity()) return true;
        return false;
    }

    /** 
     * Insert a valuable item into the purse.
     * The valuable item is only inserted if the purse has space for it
     * and the valuable item has positive value.
     * @param valuable is a valuable object to insert into purse
     * @return true if valuable item inserted, false if can't insert
     */
    public boolean insert( Valuable valuable ) {
    	if(!isFull() && valuable.getValue() > 0) {
    		money.add(valuable);
    		return true;
    	}
        return false;
    }
    
    /**  
     *  Withdraw the requested amount of money.
     *  Return an array of valuable items withdrawn from purse,
     *  or return null if cannot withdraw the amount requested.
     *  @param amount is the amount to withdraw
     *  @return array of Valuable objects for money withdrawn, 
	 *    or null if cannot withdraw requested amount.
     */
    public Valuable[] withdraw( double amount ) {
    	if (amount > 0 && amount <= this.getBalance() && this.getBalance() != 0) {
    		java.util.Collections.sort(money, valueComparator);
    		
    		List<Valuable> withdraw = new ArrayList<>();
    		
    		for (int i = money.size(); amount != 0; i--) {
    			if (amount - money.get(i-1).getValue() >= 0) {
    				amount -= money.get(i-1).getValue();
    				withdraw.add(money.get(i-1));
    			}
    			if (i-1 == 0 && amount != 0) return null;
    		}
    		
    		Valuable[] toRemove = new Valuable[withdraw.size()];
    		withdraw.toArray(toRemove);
    		this.remove(toRemove);
    		
    		return toRemove;
    	}
    	
        return null;
	}
    
    /**
     * same as withdraw( double amount ) but withdraw the amount with
     * the same currency as Valuable parameter
     * @param Valuable object to withdraw
     * @return array of Valuable objects for money withdrawn, 
	 * or null if cannot withdraw requested amount. 
     */
    public Valuable[] withdraw(Valuable amount) {
    	double value = amount.getValue();
    	if(amount == null) return null;
    	if (value > 0 && value <= this.getBalance() && this.getBalance() != 0) {
    		java.util.Collections.sort(money, valueComparator);
    		
    		List<Valuable> withdraw = new ArrayList<>();
    		List<Valuable> temp = new ArrayList<>();
    		final String currency = amount.getCurrency();
			
    		for (Valuable valuable : money) {
    			if(valuable.getCurrency().equals(currency)) {
    				temp.add(valuable);
    			}
			}

    		for (int i = temp.size()-1; value != 0; i--) {
    			if (value - temp.get(i).getValue() >= 0) {
    				value -= temp.get(i).getValue();
    				withdraw.add(temp.get(i));
    			}
    			if (i == 0 && value != 0) return null;
    		}
    		
    		Valuable[] toRemove = new Valuable[withdraw.size()];
    		withdraw.toArray(toRemove);
    		this.remove(toRemove);
    		
    		return toRemove;
    	}
    	
        return null;
    }
    
    /**
     * Remove set of valuable items from purse.
     * This method is reserved for inner use only.
     * @param remove Array of valuable item you want to remove from purse.
     */
    private void remove(Valuable[] remove) {
    	for (Valuable valuable : remove) {
    		money.remove(valuable);
    	}
    }
    
    /**
     * 
     * @return List of all items in the purse.
     */
    private List<Valuable> getItemList() {
    	return money;
    }
  
    /** 
     * toString returns a string description of the purse contents.
     * It can return whatever is a useful description.
     */
    public String toString() {
    	return money.toString();
    }
    
}
