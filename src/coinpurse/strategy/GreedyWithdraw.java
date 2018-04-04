package coinpurse.strategy;

import java.util.ArrayList;
import java.util.List;

import coinpurse.Valuable;
import coinpurse.ValueComparator;

public class GreedyWithdraw implements WithdrawStrategy {

	private static final ValueComparator comparator = new  ValueComparator();
	
	@Override
	public List<Valuable> withdraw(Valuable amount, List<Valuable> list) {
		double value = amount.getValue();
		
		if (value > sum(list)) 
			throw new IllegalArgumentException("You can't withdraw more than what you have");
		if (amount == null)
			throw new IllegalArgumentException("Argument cannot be null");
		List<Valuable> withdraw = new ArrayList<>();
		List<Valuable> temp = filterCurrency(amount, list);
		
		if (value > 0 && temp.size() > 0) {
			java.util.Collections.sort(temp, comparator);
			
			for (int i = temp.size() - 1; value != 0; i--) {
				if (value - temp.get(i).getValue() >= 0) {
					value -= temp.get(i).getValue();
					withdraw.add(temp.get(i));
				}
				
				if (value == 0) return withdraw;
				else if (i == 0) break;
			}
		}
		
		list.clear();
		return list; //return empty list if no solution found
	}
	
	private double sum(List<Valuable> list) {
		double sum = 0.0;
		for (Valuable val : list) sum+= val.getValue();
		return sum;
	}
	
	/**
	 * Filtered valuable object with the same currency
	 * with the same as given object.
	 * @return filtered list of Valuable object
	 */
	private List<Valuable> filterCurrency(Valuable hmm ,List<Valuable> list) {
		List<Valuable> filtered = new ArrayList<>();
		for (Valuable val : list) {
			if (val.getCurrency().equals(hmm.getCurrency())) filtered.add(val);
		} return filtered;
	}

}
