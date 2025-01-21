package Zombie실습;

public interface DrainHP {
	public default void drain(Unit unit) {
		if(unit.getDamage() == 0){
			return;
		}
		int drainHP = unit.getDamage() / 2;
		unit.setHp(unit.getHp() +drainHP);
		if(unit.getHp() > unit.getMAX_HP()) {
			unit.setHp(unit.getMAX_HP());
		}
		System.out.printf("%s 이(가) %d 흡혈 %s의 체력 %d\n", unit.getName(), drainHP,unit.getName(),unit.getHp());
	}
}
