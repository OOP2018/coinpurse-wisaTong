package factory;

import coinpurse.*;

public class ThaiMoneyFactory extends MoneyFactory {

	private static long serial = 1000000;
	
	private static String currency = "Baht";
	private static double[] exist = {1,2,5,10,20,50,100,500,1000};
	
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
	 * Create Thai money from given double value
	 * @param value is a double value of wanted money
	 * @return Valuable object of desired value
	 */
	@Override
	public Valuable createMoney(double value) {
		if (!check(value)) throw new IllegalArgumentException(String.format("Thai doesn't have %.2f Baht money", value));
		if (value >= 20) return new BankNote(value, currency, serial++);
		return new Coin(value, currency);
	}
}
