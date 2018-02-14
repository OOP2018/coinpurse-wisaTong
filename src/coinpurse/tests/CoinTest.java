package coinpurse.tests;

import static java.lang.System.out;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import coinpurse.*;

public class CoinTest {

	private static final double TOLERANCE = 1.0E-6;

	@Before
	public void setUp() throws Exception {
		out.println("running setUp");
	}

	@Test
	public void testGetValue() {
		Coin coin = new Coin(2.5, "BTC");
		assertEquals("getValue is wrong", 2.5, coin.getValue(), TOLERANCE);
	}

	@Test
	public void testGetCurrency() {
		Coin c = new Coin(1.0, "LiteCoin");
		assertEquals("LiteCoin", c.getCurrency());
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testValueNotNegative() {
		Coin worthless = new Coin(-1, "Zimbabwe Dollar");
		//fail("Should have thrown exception for value < 0");
		
	}
	
	@Test
	public void testCurrencyIsEmptyString() {
		Coin c = new Coin(999, "");
		assertNotNull(c.getCurrency());
		assertEquals("", c.getCurrency());
	}
}
