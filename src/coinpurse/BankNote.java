package coinpurse;

/**
 * BankNotes that contain value, currency, and unique serial number.
 * @author Wisa Powthongchin
 *
 */
public class BankNote implements Valuable {

	
	private double value;
	private String currency;
	private long serialNumber;
	
	static long startingSerial = 1000000;
	
	/**
	 * Create new BankNote object with given value and currency.
	 * Set serialNumber starting from 1000000, every time a new BankNote
	 * is created increment serialNumber by 1.
	 * @param value is a value of BankNote
	 * @param currency is a String value for currency of banknote
	 */
	public BankNote(double value, String currency) {
		this.value = value;
		this.currency= currency;
		this.serialNumber = startingSerial;
		startingSerial++;
	}
	
	/** 
	 * Get value of a banknote.
	 * @return value of a banknote in double.
	 */
	@Override
	public double getValue() {
		return this.value;
	}

	/** 
	 * Get currency of a banknote.
	 * @return String value of a banknote.
	 */
	@Override
	public String getCurrency() {
		return this.currency;
	}
	
	/**
	 * get serialNumber of banknote
	 * @return long value of serial number.
	 */
	public long getSerial() {
		return this.serialNumber;
	}
	
	/**
	 * Equals method checking value and currency of two banknotes.
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj == null) return false;
		if (this.getClass() != obj.getClass()) return false;
		
		BankNote other = (BankNote) obj;
		return this.getValue() == other.getValue() && this.getCurrency().equals(other.getCurrency());
	}
	
	/** Simple toString */
	public String toString() {
		return String.format("%.2f-%s note [%d]", value,currency,serialNumber);
	}
	
}
