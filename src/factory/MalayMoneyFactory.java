package factory;

import coinpurse.*;

public class MalayMoneyFactory extends MoneyFactory{
	
	private static long serial = 1000000;
	
	private static String currency = "Ringgit";
	private static double[] exist = {0.05, 0.1, 0.2, 0.5, 1, 2, 5, 10 ,20 ,50 ,100};
	
	/**
	 * Check if given value can be make into money
	 * @param value is a given value to make money
	 * @return boolean whether can be made or not.
	 */
	private static boolean check(double value) {
		for (double d : exist) {
			if (d == value) return true;
		} return false;
	}
	
	/**
	 * Create Malaysia money from given double value
	 * @param value is a double value of wanted money
	 * @return Valuable object of desired value
	 */
	@Override
	public Valuable createMoney(double value) {
		if (!check(value)) throw new IllegalArgumentException(String.format("Malaysia doesn't have %.2f Ringgit money", value));
		if (value >= 1) {
			serial++;
			return new BankNote(value, currency, serial-1);
		}
		return new Coin(value, currency);
	}
	
	
}
