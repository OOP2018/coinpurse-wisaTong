package coinpurse;

public class Money implements Valuable{
	
	private double value;
	private String currency;
	
	public Money(double value, String currency) {
		if (value < 0) throw new IllegalArgumentException("Value cannot be negative");
		this.value = value;
		this.currency = currency;
	}
	
	public int compareTo(Valuable other) {
		if(this.getCurrency().equals(other.getCurrency())) {
			return Double.compare(this.getValue(), other.getValue());
		} 
		return this.getCurrency().compareToIgnoreCase(other.getCurrency());
	}
	
	public double getValue() {
		return value;
	}
	
	public String getCurrency() {
		return currency;
	}

	/**
	 * Equals method checking value and currency of two banknotes.
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj == null) return false;
		if (this.getClass() != obj.getClass()) return false;
		
		Valuable other = (Valuable) obj;
		return this.getValue() == other.getValue() && this.getCurrency().equals(other.getCurrency());
	}
}
