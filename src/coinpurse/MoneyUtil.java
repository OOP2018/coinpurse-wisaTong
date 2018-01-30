package coinpurse;

import java.util.ArrayList;
import java.util.List;

/**
 * Utility methods for using with list of Valuable item
 * @author Wisa Powthongchin
 *
 */
public class MoneyUtil {
	
	private static ValueComparator valueComparator = new ValueComparator();
	
	/**
	 * print valuable items in list to the console
	 */
	public static void printList(List<Valuable> valuable) {
		for(Valuable v : valuable) {
			System.out.println(v);
		}
	}
	
	/**
	 * Sort valuable items in list by value !Not by currency value yet!
	 * @param valuable is a list of valuable items
	 */
	public static void sortCoins(List<Valuable> valuable) {
		java.util.Collections.sort(valuable, valueComparator);;		
	}
	
	/**
	 * Filter out every other valuable items that have different currency with given one.
	 * @param v is a list of valuable items
	 * @param currency is a given string value of currency you want to filter
	 * @return list of valuable items only with given currency
	 */
	public static List<Valuable> filterByCurrency(List<Valuable> v, String currency) {
		List<Valuable> temp = new ArrayList<>();
		for (Valuable item : v) {
			if (item.getCurrency().equals(currency)) temp.add(item);
		}
		return temp;
	}

	public static void main(String[] args) {
		
		List<Valuable> list = new ArrayList<>();
		
		list.add(new Coin(10.0, "Baht"));
		list.add(new Coin(2.0, "Baht"));
		list.add(new BankNote(5.0, "USD"));
		list.add(new BankNote(20.0, "USD"));
		list.add(new Coin(0.5, "Baht"));
		list.add(new Coin(5.0, "Baht"));
		list.add(new Coin(1.0, "Baht"));
		
		
		sortCoins(list);
		
		printList(list);
		System.out.println();
		printList(list);
		
		System.out.println();
		printList(filterByCurrency(list, "USD"));
	}
}
