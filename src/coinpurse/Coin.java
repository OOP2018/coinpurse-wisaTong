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
		if (this.getCurrency().equals("Ringgit")) {
			if (this.getValue() < 0.1) return String.format("%.0f-%s coin", this.getValue()*100, "Sen");
			else if (this.getValue() < 1) return String.format("%.0f-%s coin", this.getValue()*10, "Sen");
		}
		return String.format("%.2f-%s coin", this.getValue(), this.getCurrency());
		
	}
}
