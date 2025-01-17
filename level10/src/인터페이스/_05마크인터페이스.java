package 인터페이스;

interface Repairable {

}


class Unit{
	final int MAX_HP;
	int hp;
	
	public Unit(int hp) {
		MAX_HP = hp;
		this.hp = MAX_HP;
	}
}

class GroundUnit extends Unit{

	public GroundUnit(int hp) {
		super(hp);
		// TODO Auto-generated constructor stub
	}
	
}

class AirUnit extends Unit{

	public AirUnit(int hp) {
		super(hp);
		// TODO Auto-generated constructor stub
	}
	
}

class Tank extends GroundUnit implements Repairable{

	public Tank() {
		super(250);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return String.format("Tank (%d/%d)", hp, MAX_HP);
	}
}

class Soldier extends GroundUnit{

	public Soldier() {
		super(100);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return String.format("Soldier (%d/%d)", hp, MAX_HP);
	}
	
}

class Marine extends GroundUnit{

	public Marine() {
		super(80);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return String.format("Marine (%d/%d)", hp, MAX_HP);
	}
	
}

class Aircraft extends AirUnit implements Repairable{

	public Aircraft() {
		super(150);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return String.format("Aircraft", hp, MAX_HP);
	}
	
}

class DropShip extends AirUnit implements Repairable{

	public DropShip() {
		super(200);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return String.format("DropShip", hp, MAX_HP);
	}
	
}

class SCV extends GroundUnit implements Repairable{

	public SCV() {
		super(50);
		// TODO Auto-generated constructor stub
	}
	
	void repairUnit(Repairable repairable) {
		Unit unit =(Unit) repairable;
		
		while(unit.hp != unit.MAX_HP) {
			unit.hp++;
		} 
		
		System.out.println(unit + "수리 완료");
	}
	
	@Override
	public String toString() {
		return String.format("SCV (%d/%d)", hp, MAX_HP);
	}
	
}


public class _05마크인터페이스 {

	public static void main(String[] args) {
		Tank tank = new Tank();
		DropShip dropShip = new DropShip();
		Soldier soldier = new Soldier();
		SCV scv = new SCV();
		
		dropShip.hp -= 30;
		soldier.hp -= 40;
		tank.hp -= 100;
		System.out.println(tank);
		
		scv.repairUnit(tank);
	}
}
