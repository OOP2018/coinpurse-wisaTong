package coinpurse;

import java.util.Comparator;

public class ValueComparator implements Comparator<Valuable> {

	@Override
	public int compare(Valuable a, Valuable b) {
		if (a.getValue() < b.getValue()) return -1;
		else if (a.getValue() > b.getValue()) return 1;
		return 0;
	}
	
}
