package _13다형성게임_실습;

public class Unit {
	protected int maxHp;
	protected int curHp;
	protected int curDef;
	protected int damage;
	
	public void attack(Unit attackedUnit) {
		if(attackedUnit instanceof Player) {
		}
	}
}
