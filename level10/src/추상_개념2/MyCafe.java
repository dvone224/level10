package 추상_개념2;

public class MyCafe extends MyBrand {

	private static int myNum = 0;
	private boolean isOnlyTakeOut;
	
	public static String getSlogan() {
		return String.format(SLOGAN, "김 카페");
	}
	

	public MyCafe( String nAME, boolean isOnlyTakeOut) {
		super(++myNum, nAME);
		this.isOnlyTakeOut = isOnlyTakeOut;
	}

	@Override
	public void takeOrder() {
		System.out.printf(" 김 카페 %s 음료를 주문했습니다\n", super.info());
		if(!isOnlyTakeOut) {
			System.out.println("매장? 포장?");
		}
	}

}
