package coinpurse;

public class Coin implements Comparable<Coin> {

	private double value;
	private String currency;
	
	public Coin(double value, String currency) {
		if (value < 0) throw new IllegalArgumentException("Value cannot be negative");
		this.value = value;
		this.currency = currency;
	}
	
	public double getValue() {
		return value;
	}
	
	public String getCurrency() {
		return currency;
	}
	
	public int compareTo(Coin coin) {
		if (this.getValue() < coin.getValue()) return -1;
		else if (this.getValue() > coin.getValue()) return 1;
		return 0;
	}
	
	@Override
	public String toString() {
		return String.format("%.2f-%s", value, currency);
		
	}
}
