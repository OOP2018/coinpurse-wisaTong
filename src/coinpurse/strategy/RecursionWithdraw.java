package coinpurse.strategy;

import java.util.ArrayList;
import java.util.List;

import coinpurse.*;

public class RecursionWithdraw implements WithdrawStrategy {

	public List<Valuable> withdraw(Valuable amount, List<Valuable> valuables) {

		List<Valuable> filtered = filterCurrency(amount, valuables);
		double withdraw = amount.getValue();
		
		if (withdraw > sumList(valuables)) throw new IllegalArgumentException("You cannot withdraw more than what you have");
		if (sumList(filtered) == withdraw) return filtered;
		
		List<Valuable> solution = new ArrayList<>();
		withdrawHelper(withdraw, solution, filtered);
		
		if (solution.size() == 0) return solution;
		return solution;
	}

	private void withdrawHelper(double amount, List<Valuable> chosen, List<Valuable> list) {
		double sum = sumList(chosen);
		if (amount - sum == 0) return;
		for (int i = 0; i < list.size(); i++) {
			//choose
			Valuable choose = list.get(i);
			chosen.add(choose);
			list.remove(choose);
			//explore
			withdrawHelper(amount, chosen, list);
			if (amount - (sum = sumList(chosen)) == 0) return;
			//un-choose
			list.add(choose);
			chosen.remove(chosen.size() - 1);
		}
	}

	/**
	 * Filtered valuable object with the same currency with the same as given
	 * object.
	 * 
	 * @return filtered list of Valuable object
	 */
	private List<Valuable> filterCurrency(Valuable hmm, List<Valuable> list) {
		List<Valuable> filtered = new ArrayList<>();
		for (Valuable val : list) {
			if (val.getCurrency().equals(hmm.getCurrency()))
				filtered.add(val);
		}
		return filtered;
	}

	/** sum all the Valuables object's value in list */
	private double sumList(List<Valuable> list) {
		double sum = 0.0;
		for (Valuable v : list) {
			sum += v.getValue();
		}
		return sum;
	}
}
