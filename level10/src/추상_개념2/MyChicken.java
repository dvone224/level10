package 추상_개념2;

public class MyChicken extends MyBrand{
	
	private static int myNum = 0;
	
	public static String getSlogan() {
		return String.format(SLOGAN, "김 치");
	}

	public MyChicken(String nAME) {
		super(++myNum, nAME);
	}

	@Override
	public void takeOrder() {
		System.out.printf("김 치 %s 치킨을 주문했습니다 \n", super.info());
		
	}

}
