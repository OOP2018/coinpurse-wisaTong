package coinpurse;

/**
 * Coins that contain value and currency.
 * @author Wisa Powthongchin
 *
 */
public class Coin extends Money {
	
	/**
	 * Create coin object that has value and currency.
	 * @param value is value of a coin obviously.
	 * @param currency is String value specify currency type.
	 */
	public Coin(double value, String currency) {
		super(value, currency);
	}
	
	/** simple toString */
	@Override
	public String toString() {
		return String.format("%.2f-%s", this.getValue(), this.getCurrency());
		
	}
}
