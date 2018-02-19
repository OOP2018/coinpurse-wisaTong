package coinpurse;

import java.util.Comparator;

/**
 * Class responsible for comparator logic to sort by value and currency
 * @author Wisa Powthongchin
 *
 */
public class ValueComparator implements Comparator<Valuable> {

	/**
	 * Compare two Valuable object considering currency and value
	 */
	@Override
	public int compare(Valuable a, Valuable b) {
		if(a.getCurrency().equals(b.getCurrency())) {
			return (int) (a.getValue() - b.getValue());
		} else return a.getCurrency().compareTo(b.getCurrency());
	}
	
}
