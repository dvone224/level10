package Zombie실습;

public class Zombie extends Unit implements DrainHP{

	Zombie() {
		super("좀비",5, 100, 10, 1);
	}

	
	@Override
	public void attack(Unit attakcedUnit) {
		super.attack(attakcedUnit);
		DrainHP.super.drain(this);
		
	}
	
}
