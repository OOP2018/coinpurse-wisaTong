package factory;

import coinpurse.Valuable;

public abstract class MoneyFactory {

	private static MoneyFactory instance;
	
	protected MoneyFactory() {};
	
	/**
	 * Create an instance of MoneyFactory
	 * @return if there is no instance create one instance of
	 * MoneyFactory default one is Thai
	 */
	public static MoneyFactory getInstance() {
		if (instance == null) {
			instance = new ThaiMoneyFactory();
		}
		return instance;
	}
	
	/**
	 * Create Valuable object from given string
	 * @param value is a String specify value of Valuable object wanted
	 * @return Valuable object
	 */
	public Valuable createMoney(String value) {
		double parsed = 0;
		try {
			parsed = Double.parseDouble(value);
		} catch (IllegalArgumentException ex){
			System.out.println(ex.getMessage());
			throw new IllegalArgumentException();
		}
		return createMoney(parsed);
	}
	
	/** Create Valuable object with given value */
	public abstract Valuable createMoney(double value);
	
	/** Change factory instance */
	public static void setFactory(MoneyFactory f) {
		instance = f;
	}
}
