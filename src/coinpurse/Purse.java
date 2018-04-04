package coinpurse;

import java.util.ArrayList;
import java.util.List;

import coinpurse.strategy.GreedyWithdraw;
import coinpurse.strategy.RecursionWithdraw;
import coinpurse.strategy.WithdrawStrategy;


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
     * Strategy for withdrawing valuables
     */
    private WithdrawStrategy strat;
    
    /** 
     *  Create a purse with a specified capacity.
     *  @param capacity is maximum number of valuable objects you can put in purse.
     */
    public Purse( int capacity ) {
    	this.capacity = capacity;
    	strat = new RecursionWithdraw();
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
     * same as wtihdraw(Valuable amount) but with default currecy "Baht"
     * @param amount is a double value of money want to withdraw
     * @return array of Valuable objects for money withdrawn, 
	 *    or null if cannot withdraw requested amount.
     */
    public Valuable[] withdraw( double amount ) {
    	return withdraw(new Money(amount, "Baht"));
	}
    
    /**  
     *  Withdraw the requested amount of money with same currency as
     *  given valuable object.
     *  Return an array of valuable items withdrawn from purse,
     *  or return null if cannot withdraw the amount requested.
     *  @param amount is the amount to withdraw
     *  @return array of Valuable objects for money withdrawn, 
	 *    or null if cannot withdraw requested amount.
     */
    public Valuable[] withdraw(Valuable amount) {
    	List<Valuable> list = strat.withdraw(amount, money);
    	remove(list);
    	
    	Valuable[] removed = new Valuable[list.size()];
    	list.toArray(removed);
    	return removed;
    }
    
    /**
     * Remove set of valuable items from purse.
     * This method is reserved for inner use only.
     * @param remove Array of valuable item you want to remove from purse.
     */
    private void remove(List<Valuable> remove) {
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
