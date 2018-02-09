package coinpurse;

public interface Valuable extends Comparable<Valuable> {

	public double getValue();
	
	public String getCurrency();
}
