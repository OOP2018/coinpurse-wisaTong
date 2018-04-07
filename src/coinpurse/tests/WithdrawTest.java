package coinpurse.tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import coinpurse.*;
import coinpurse.strategy.*;

public class WithdrawTest {

	/** Tolerance */
	private static final double TOL = 1.0E-6;
	
	/** Default currency for this test */
	private static final String currency = "Baht";
	
	private WithdrawStrategy strat;
	private static List<Valuable> list;
	
	/**
	 * Make coin with default currency with given value
	 * @param value is a value for coin.
	 */
	public static Coin mkCoin(double value) {
		return new Coin(value, currency);
	}
	
	/**
	 * Create and add coins to the list.
	 * @param args is value of coins wanted.
	 */
	private static void addToList(double... args) {
		for(double val : args) list.add(mkCoin(val));
	}
	
	@Before
	public void setUp() throws Exception {
		strat = new RecursionWithdraw();
		list = new ArrayList<>();
	}

	@Test
	public void testOrdinaryWithdraw() {
		addToList(5, 5, 2, 2);
		List<Valuable> temp = strat.withdraw(mkCoin(12), list);
		assertEquals(3, temp.size());
	}
	
	@Test
	public void testWithdrawNothing() {
		//from empty list
		list.clear();
		assertEquals(0, strat.withdraw(mkCoin(0), list).size());
		//from not empty list
		addToList(5, 2 , 2 ,2);
		assertEquals(0, strat.withdraw(mkCoin(0), list).size());
	}
	
	@Test
	public void testWithdrawEverything() {
		addToList(5, 2, 2, 2);
		List<Valuable> temp = strat.withdraw(mkCoin(11), list);
		System.out.println(temp);
		assertTrue(temp.size() == list.size());
		
		//another test to be sure
		list.clear();
		addToList(5, 5, 5, 5);
		temp = strat.withdraw(mkCoin(20), list);
		assertTrue(list.equals(temp));
	}
	
	@Test (expected =  IllegalArgumentException.class)
	public void testOverWithdraw() {
		addToList(1, 2, 3, 4);
		List<Valuable> temp = strat.withdraw(mkCoin(11), list); //should throw exception
	}
	
	@Test
	public void testImpossibleWithdraw() {
		addToList(5, 10);
		List<Valuable> temp = strat.withdraw(mkCoin(1), list); //should return empty list
		assertTrue(temp.size() == 0);
	}
	
	@Test
	public void testWithdrawDifferentCurrency() {
		//Add default money with default currency "Baht"
		addToList(5, 5, 10);
		List<Valuable> temp= strat.withdraw(new Coin(10, "BTC"), list); //should return empty list
		assertTrue(temp.size() == 0);
	}
}
