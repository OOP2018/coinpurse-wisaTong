package coinpurse;

import java.util.ArrayList;
import java.util.List;

public class MoneyUtil {
	
	public static void printCoins(List<Coin> coins) {
		for(Coin coin : coins) {
			System.out.println(coin);
		}
	}
	
	public static void sortCoins(List<Coin> coins) {
		java.util.Collections.sort(coins);		
	}
	
	public static List<Coin> filterByCurrency(List<Coin> coins, String currency) {
		List<Coin> temp = new ArrayList<>();
		for (Coin c : coins) {
			if (c.getCurrency().equals(currency)) temp.add(c);
		}
		return temp;
	}

	public static void main(String[] args) {
		
		List<Coin> coins = new ArrayList<>();
		
		coins.add(new Coin(10.0, "Baht"));
		coins.add(new Coin(2.0, "Baht"));
		coins.add(new Coin(5.0, "USD"));
		coins.add(new Coin(20.0, "USD"));
		coins.add(new Coin(0.5, "Baht"));
		coins.add(new Coin(5.0, "Baht"));
		coins.add(new Coin(1.0, "Baht"));
		
		sortCoins(coins);
		
		printCoins(coins);
		System.out.println();
		printCoins(coins);
		
		System.out.println();
		printCoins(filterByCurrency(coins, "USD"));
	}
}
