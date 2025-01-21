package Zombie실습;

//Boss 클래스는 보호막 shield 멤버변수를 가진다.
//공격 메소드 void attack( Unit enemy ) 
//일반공격 : 1~공격력(max) 사이의 랜덤 값을 공격력으로 사용하여 enemy의 체력 감소시킴 (출력 예 : “보스가 15 의 공격력으로 일반 공격 : 현재 Hero의 hp는 25”)
//필살기 : 25%의 확률로 1~max 사이의 공격력의 2배 만큼으로 상대를 공격하는 기능 (출력 예 : “보스가 30 의 공격력으로 필살기 공격 : 현재 Hero의 hp는 25”)
//Boss 클래스는 생성자를 가짐(현재위치, 체력,공격력, 보호막)

public class Boss extends Unit implements DrainHP, Shield, Ultimate {
	
	private int shield;
	
	Boss() {
		super("보스", 9, 300, 20, 1);
		shield = 100;
	}

	@Override
	public void attack(Unit attakcedUnit) {
		super.attack(attakcedUnit);
		DrainHP.super.drain(this);
	}

	@Override
	public int getShield() {
		return shield;
	}

	@Override
	public void setShield(int shield) {
		this.shield = shield;
	}

}
