package solid.liskov.example2.after;

public class Woodpecker extends Bird {

	public void fly() {
		System.out.println("I can fly");
	};

	@Override
	public void walk() {
		System.out.println("I can walk");
	};
}
