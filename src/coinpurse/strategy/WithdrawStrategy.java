package coinpurse.strategy;

import java.util.List;

import coinpurse.Valuable;

public interface WithdrawStrategy {

	/**
	 * Find and return items from a collection whose total value and currency
	 * match the requested amount.
	 * @param amount is the amount of money to withdraw, with currency
	 * @param valuables is the contents that are available for possible withdraw.
	 * 			Must not be null, but maybe an empty list. This list will not be modify
	 * @return if solution is found, return a list containing references
	 * 			from the valuables parameter (List) whose sum equals the amount.
	 * 			if a solution is not found returns an empty list.
	 * @throws IllegalArugument exception if amount is more than 
	 * 			sum of all money in the valuables parameter.
	 */
	public List<Valuable> withdraw(Valuable amount, List<Valuable> valuables);
	
}
