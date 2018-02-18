package coinpurse.tests;

import static java.lang.System.out;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import coinpurse.*;
import factory.*;

import factory.MoneyFactory;

public class MoneyFactoryTest {

	private static MoneyFactory def = MoneyFactory.getInstance();
	
	@Before
	public void setUp() throws Exception {
		out.println("running setUp");
	}
	
	@Test
	public void testSingleton() {
		MoneyFactory one = MoneyFactory.getInstance();
		MoneyFactory two = MoneyFactory.getInstance();
		assertTrue(one == two);
	}
	
	@Test
	public void testChangeFactoryLocation() {
		MoneyFactory thai = MoneyFactory.getInstance();
		MoneyFactory.setFactory(new MalayMoneyFactory());
		MoneyFactory malai = MoneyFactory.getInstance();
		assertFalse(thai == malai);
	}
	
	@Test
	public void testCreateThaiMoney() {
		assertTrue(def.createMoney("10").equals(new Coin(10,"Baht")));
		assertTrue(def.createMoney("20").equals(new BankNote(20, "Baht", 1)));
	}
	
	@Test
	public void testCreateMalaiMoney() {
		MoneyFactory.setFactory(new MalayMoneyFactory());
		def = MoneyFactory.getInstance();
		assertTrue(def.createMoney("0.05").equals(new Coin(0.05, "Ringgit")));
		assertTrue(def.createMoney("1").equals(new BankNote(1, "Ringgit", 1)));
		
	}
}
