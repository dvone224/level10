package 추상_개념;

public class PineApplePizza extends Pizza {

	PineApplePizza(int price, String brand) {
		super(price, brand, "파인애플 피자");
		// TODO Auto-generated constructor stub
	}

	@Override
	void putTopping() {
		System.out.println("파인애플 토핑");
	}

}
