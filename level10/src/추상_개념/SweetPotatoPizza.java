package 추상_개념;

public class SweetPotatoPizza extends Pizza {

	SweetPotatoPizza(int price, String brand) {
		super(price, brand, "고구마 피자");
		// TODO Auto-generated constructor stub
	}

	@Override
	void putTopping() {
		System.out.println("파인애플 토핑");
	}


}
