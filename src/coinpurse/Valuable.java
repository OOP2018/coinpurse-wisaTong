package coinpurse;

/**
 * Valuable interface for basic method of future object.
 * @author Wisa Powthongchin
 *
 */
public interface Valuable extends Comparable<Valuable> {

	/** get double value of monetary object*/
	public double getValue();
	
	/** get String value for currency */
	public String getCurrency();
}
