package 추상_개념;

public class BulgogiPizza extends Pizza {

	BulgogiPizza(int price, String brand) {
		super(price, brand, "불고기 피자");
		// TODO Auto-generated constructor stub
	}

	@Override
	void putTopping() {
		System.out.println("파인애플 토핑");
	}


}
