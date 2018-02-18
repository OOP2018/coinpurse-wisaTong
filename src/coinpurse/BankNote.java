package coinpurse;

/**
 * BankNotes that contain value, currency, and unique serial number.
 * @author Wisa Powthongchin
 *
 */
public class BankNote extends Money {

	private long serialNumber;
	
	/**
	 * Create new BankNote object with given value and currency.
	 * Set serialNumber starting from 1000000, every time a new BankNote
	 * is created increment serialNumber by 1.
	 * @param value is a value of BankNote
	 * @param currency is a String value for currency of banknote
	 */
	public BankNote(double value, String currency, long serial) {
		super(value, currency);
		this.serialNumber = serial;
	}
	
	/**
	 * get serialNumber of banknote
	 * @return long value of serial number.
	 */
	public long getSerial() {
		return this.serialNumber;
	}
	
	/** Simple toString */
	public String toString() {
		return String.format("%.2f-%s note [%d]", this.getValue(), this.getCurrency(), serialNumber);
	}
	
}
