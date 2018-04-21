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
	public static void printList(List<? extends Valuable> valuable) {
		for(Valuable v : valuable) {
			System.out.println(v);
		}
	}
	
	/**
	 * Sort valuable items in list by value !Not by currency value yet!
	 * @param valuable is a list of valuable items
	 */
	public static void sortMoney(List<? extends Valuable> valuable) {
		java.util.Collections.sort(valuable, valueComparator);;		
	}
	
	/**
	 * Filter out every other valuable items that have different currency with given one.
	 * @param v is a list of valuable items
	 * @param currency is a given string value of currency you want to filter
	 * @return list of valuable items only with given currency
	 */
	public static <E extends Valuable> List<E> filterByCurrency(List<E> v, String currency) {
		List<E> temp = new ArrayList<>();
		for (E item : v) {
			if (item.getCurrency().equals(currency)) temp.add(item);
		}
		return temp;
	}

	/**
	 * Return the larger argument, based on sort order, using 
	 * the objects' own compareTo method for comparing.
	 * @param args one or more Comparable objects to compare.
	 * @return the argument that would be last if sorted the elements.
	 * @throws IllegalArgumentException if no arguments given.
	 */
	public static <E extends Comparable<? super E>> E max(E... args) {
		E max = args[0];
		for (E element : args) {
			max = (element.compareTo(max) > 0) ? element : max;
		}
		return max;
	}
	
	public static void main(String[] args) {
		
		List<Valuable> list = new ArrayList<>();
		
		list.add(new Coin(10.0, "Baht"));
		list.add(new Coin(2.0, "Baht"));
		list.add(new BankNote(5.0, "USD", 1234));
		list.add(new BankNote(20.0, "USD", 123));
		list.add(new Coin(0.5, "Baht"));
		list.add(new Coin(5.0, "Baht"));
		list.add(new Coin(1.0, "Baht"));
		
		System.out.println(max("dog", "zebra", "cat"));
		System.out.println(max(2,3,4));
		
		sortMoney(list);
		
		printList(list);
		System.out.println();
		printList(list);
		
		System.out.println();
		printList(filterByCurrency(list, "USD"));
	}
}
