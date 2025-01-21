package 다형성실습;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Random;

interface Damageable {
	void attack( Unit attackedUnit);

}

interface Flyable {

}

interface Repairable {
	public default void repair(Unit unit) {
		Random rd = new Random();
		int repair = rd.nextInt(5) + 1;
		int repairHP = (int) (unit.MAX_HP * (0.1 * repair));
		System.out.printf("%s (이)가 %d 회복 했습니다\n", unit, repairHP);
		unit.hp += repairHP;
		if (unit.hp > unit.MAX_HP) {
			unit.hp = unit.MAX_HP;
		}
		System.out.printf("%s 의 현재 체력 (%d/%d)\n", unit.NAME, unit.hp, unit.MAX_HP);
	}

}

class Unit {
	final String NAME;
	final int MAX_HP;
	int hp;
	boolean death;

	Unit(String name, int maxHp) {
		NAME = name;
		MAX_HP = maxHp;
		hp = MAX_HP;
	}

	public void attacked(int damage) {
		hp -= damage;
		if (hp <= 0) {
			hp = 0;
			death = true;
		}
	}

	@Override
	public String toString() {
		return NAME;
	}

}

class AttackUnit extends Unit implements Damageable {

	int damage;

	AttackUnit(String name, int maxHp, int damage) {
		super(name, maxHp);
		this.damage = damage;
	}

	@Override
	public void attack(Unit attackedUnit) {
		if (attackedUnit.death)
			return;
		System.out.printf("%s (이)가 %s 을(를) 공격\n", this, attackedUnit);
		System.out.printf("%s (이)가 %s 에게 %d 의 대미지를 입힘\n", this, attackedUnit, damage);
		attackedUnit.attacked(damage);
		System.out.printf("%s의 현재 체력 (%d/%d)\n", attackedUnit.NAME, attackedUnit.hp, attackedUnit.MAX_HP);
	}

}

class SCV extends AttackUnit implements Repairable {
	SCV() {
		super("SCV", 60, 5);
	}
}

class SiegeTank extends AttackUnit implements Repairable {
	SiegeTank() {
		super("시즈 탱크", 150, 30);
	}
}

class Marine extends AttackUnit {
	Marine() {
		super("마린", 40, 6);
	}
}

class Battlecruiser extends AttackUnit implements Flyable, Repairable {
	Battlecruiser() {
		super("배틀크루저", 500, 25);
	}

}

class ScienceVessel extends Unit implements Flyable, Repairable {
	ScienceVessel() {
		super("사이언스 배슬", 200);
	}

}

class Ultralisk extends AttackUnit {
	Ultralisk() {
		super("울트라리스크", 400, 20);
	}
}

class Guardian extends AttackUnit implements Flyable {
	Guardian() {
		super("가디언", 150, 20);
	}
}

class Dragoon extends AttackUnit {
	Dragoon() {
		super("드라군", 180, 20);
	}
}

class Scout extends AttackUnit implements Flyable {
	Scout() {
		super("스카웃", 250, 8);
	}
}

class Reaver extends AttackUnit {
	Reaver() {
		super("리버", 180, 100);
	}
}

public class _02스타크래프트 {
	public static void main(String[] args) {

		Random rd = new Random();
		String[] units = {"SCV","SiegeTank","Marine","Battlecruiser","ScienceVessel","Ultralisk"};
		String packageName = _02스타크래프트.class.getPackageName() + "."; 
		try {
			Class<?> clazz = Class.forName(packageName + units[0]);
			System.out.println(clazz.getDeclaredConstructor());
			Object obj = clazz.getDeclaredConstructor().newInstance(); // new SCV();
			Unit unit = (Unit) obj;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ArrayList<Unit> unitList = new ArrayList<Unit>();
		unitList.add(new SCV());
		unitList.add(new SiegeTank());
		unitList.add(new Marine());
		unitList.add(new Battlecruiser());
		unitList.add(new ScienceVessel());
		unitList.add(new Ultralisk());
		unitList.add(new Guardian());
		unitList.add(new Dragoon());
		unitList.add(new Scout());
		unitList.add(new Reaver());

//		int rdIdx1 = 0;
//		int rdIdx2 = 0;
//		while (unitList.size() != 1) {
//			while (true) {
//				rdIdx1 = rd.nextInt(unitList.size());
//				rdIdx2 = rd.nextInt(unitList.size());
//				if (rdIdx1 == rdIdx2) {
//					continue;
//				}
//				break;
//			}
//
//			Unit unit1 = unitList.get(rdIdx1);
//			if (unit1 instanceof Repairable && rd.nextInt(5) == 0) {
//				((Repairable) unit1).repair(unit1);
//			}
//			if (!(unit1 instanceof Damageable)) {
//				System.out.println(unit1 + " 은(는) 공격할 수 없음");
//				System.out.println("---------------------");
//				continue;
//			}
//			Unit unit2 = unitList.get(rdIdx2);
//			((AttackUnit) unit1).attack(unit2);
//			if (unit2.death) {
//				System.out.println(unit2.NAME + " 사망");
//				unitList.remove(rdIdx2);
//			}
//			System.out.println("---------------------");
//
//		}
//		System.out.println(unitList.get(0) + " 승리!");

	}
}