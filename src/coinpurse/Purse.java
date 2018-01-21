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
    private List<Coin> money;
	
    /** Capacity is maximum number of items the purse can hold.
     *  Capacity is set when the purse is created and cannot be changed.
     */
    private final int capacity;
    
    /** 
     *  Create a purse with a specified capacity.
     *  @param capacity is maximum number of coins you can put in purse.
     */
    public Purse( int capacity ) {
    	this.capacity = capacity;
    	money = new ArrayList<Coin>(capacity);
    }

    /**
     * Count and return the number of coins in the purse.
     * This is the number of coins, not their value.
     * @return the number of coins in the purse
     */
    public int count() { return money.size(); }
    
    /** 
     *  Get the total value of all items in the purse.
     *  @return the total value of items in the purse.
     */
    public double getBalance() {
    	double balance = 0;
    	
    	for (Coin coin : money) {
    		balance += coin.getValue();
    	}
		return balance; 
	}

    
    /**
     * Return the capacity of the coin purse.
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
     * Insert a coin into the purse.
     * The coin is only inserted if the purse has space for it
     * and the coin has positive value.  No worthless coins!
     * @param coin is a Coin object to insert into purse
     * @return true if coin inserted, false if can't insert
     */
    public boolean insert( Coin coin ) {
    	if(!isFull() && coin.getValue() > 0) {
    		money.add(coin);
    		return true;
    	}
        return false;
    }
    
    /**  
     *  Withdraw the requested amount of money.
     *  Return an array of Coins withdrawn from purse,
     *  or return null if cannot withdraw the amount requested.
     *  @param amount is the amount to withdraw
     *  @return array of Coin objects for money withdrawn, 
	 *    or null if cannot withdraw requested amount.
     */
    public Coin[] withdraw( double amount ) {
    	if (amount > 0 && amount <= this.getBalance() && this.getBalance() != 0) {
    		java.util.Collections.sort(money);
    		
    		Purse withdraw = new Purse(this.getCapacity());
    		
    		for (int i = money.size(); withdraw.getBalance() != amount; i--) {
    			double possibility = withdraw.getBalance() + money.get(i-1).getValue();
    			if (possibility <= amount) withdraw.insert(money.get(i-1));
    			if (i-1 == 0 && withdraw.getBalance() != amount) return null;
    		}
    		
    		Coin[] toRemove = new Coin[withdraw.getCoinList().size()];
    		withdraw.getCoinList().toArray(toRemove);
    		this.remove(toRemove);
    		
    		return toRemove;
    	}
    	
        return null;
	}
    
    /**
     * Remove set of coins from purse.
     * This method is reserved for inner use only.
     * @param remove Array of coins you want to remove from purse.
     */
    private void remove(Coin[] remove) {
    	for (Coin coin : remove) {
    		money.remove(coin);
    	}
    }
    
    /**
     * 
     * @return List of all Coin in the purse.
     */
    private List<Coin> getCoinList() {
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
