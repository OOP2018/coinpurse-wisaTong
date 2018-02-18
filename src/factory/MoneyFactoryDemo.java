package factory;

public class MoneyFactoryDemo {

	public static void main(String[] args) {
		
		MoneyFactory one = MoneyFactory.getInstance();
		System.out.println("Create Factory one");
		MoneyFactory two = MoneyFactory.getInstance();
		System.out.println("Create Factory two");
		
		System.out.println("Is the same factory?");
		if (one == two) System.out.println("Yes, is the same factory");
		
		System.out.println("Creating Thai money");
		System.out.println("Create: " + one.createMoney("10"));
		System.out.println("Create: " + one.createMoney("500"));
		System.out.println("Create: " + one.createMoney("100"));

		
		MoneyFactory.setFactory(new MalayMoneyFactory());
		one = MoneyFactory.getInstance();
		System.out.println("Relocate Malaysia");
		System.out.println("Create: " + one.createMoney("0.5"));
		System.out.println("Create: " + one.createMoney("50"));
		System.out.println("Create: " + one.createMoney("5"));

	}
}
