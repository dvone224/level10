package Zombie실습;

public class Hero extends Unit {

	private int count;

	Hero() {
		super("히어로", 1, 200, 30, 5);
		count = 2;
		// TODO Auto-generated constructor stub
	}

	public int getCount() {
		return count;
	}

	public void potion() {
		count -= 1;
		System.out.println("체력 100 회복");
		this.setHp(this.getHp() + 100);
	}

	@Override
	public void attack(Unit attakcedUnit) {
		super.attack(attakcedUnit);
	}
}
