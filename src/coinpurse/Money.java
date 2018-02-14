package coinpurse;

public class Money implements Valuable{
	
	/** Value of monetary object*/
	private double value;
	
	/** Currency of monetary object*/
	private String currency;
	
	/**
	 * Create Valuable object with value and currency
	 * @param value is double value of the object
	 * @param currency is String value specify currency 
	 */
	public Money(double value, String currency) {
		if (value < 0) throw new IllegalArgumentException("Value cannot be negative");
		this.value = value;
		this.currency = currency;
	}
	
	/**
	 * compare two Valuable object together considering currency and value
	 * @return -1 if value of this object is less than the other one
	 *  0 if value is equal.
	 *  1 if value is more.
	 */
	public int compareTo(Valuable other) {
		if(this.getCurrency().equals(other.getCurrency())) {
			return Double.compare(this.getValue(), other.getValue());
		} 
		return this.getCurrency().compareToIgnoreCase(other.getCurrency());
	}
	
	/** get double value of this object*/
	public double getValue() {
		return value;
	}
	
	/** get currency of this object in String value*/
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
