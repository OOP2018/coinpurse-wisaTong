package coinpurse;

/**
 * Coins that contain value and currency.
 * @author Wisa Powthongchin
 *
 */
public class Coin implements Comparable<Coin> {

	private double value;
	private String currency;
	
	/**
	 * Create coin object that has value and currency.
	 * @param value is value of a coin obviously.
	 * @param currency is String value specify currency type.
	 */
	public Coin(double value, String currency) {
		if (value < 0) throw new IllegalArgumentException("Value cannot be negative");
		this.value = value;
		this.currency = currency;
	}
	
	/** 
	 * Get value of a coin.
	 * @return value of a coin in double.
	 */
	public double getValue() {
		return value;
	}
	
	/**
	 * Get currency type of coin.
	 * @return String value of currency type.
	 */
	public String getCurrency() {
		return currency;
	}
	
	/**
	 * Compare this coin to other coin object.
	 */
	public int compareTo(Coin coin) {
		if (this.getValue() < coin.getValue()) return -1;
		else if (this.getValue() > coin.getValue()) return 1;
		return 0;
	}
	
	/** Ordinary equals method */
	@Override
	public boolean equals(Object obj) {
		if (obj == null) return false;
		if (obj.getClass() != this.getClass()) return false;
		
		Coin other = (Coin) obj;
		
		return this.getCurrency() == other.getCurrency() && this.getValue() == other.getValue();
	}
	
	@Override
	public String toString() {
		return String.format("%.2f-%s", value, currency);
		
	}
}
