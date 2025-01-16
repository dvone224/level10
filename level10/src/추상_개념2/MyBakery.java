package 추상_개념2;

public class MyBakery extends MyBrand{
	
	public static String getSlogan() {
		return String.format(SLOGAN, "김 빵");
	}
	
	private static int myNum = 0;

	private boolean isHandmade;
	
	public MyBakery(String nAME, boolean isHandmade) {
		super(++myNum, nAME);
		this.isHandmade = isHandmade;
	}

	@Override
	public void takeOrder() {
		System.out.printf(" 김 빵 %s 빵을 주문했습니다\n", super.info() + (isHandmade ? " 수제" : ""));
	}

}
