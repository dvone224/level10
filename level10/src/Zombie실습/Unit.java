package Zombie실습;

import java.util.Random;

//유닛은 전부 이동가능하며 pos는 현재 위치를 나타낸다 
//맵은 ~10까지 존재하며 한칸씩 이동 가능하다
//유닛들은 전부 attack 메서드를 구현한다 

public class Unit {
	private String name;
	private int pos;
	private int hp;
	private final int MAX_HP;
	private int power;
	private Random rd;
	private int damage;
	private int str;
	private boolean death;

	Unit(String name, int pos, int hp, int power, int str) {
		this.name = name;
		this.pos = pos;
		this.hp = hp;
		this.MAX_HP = hp;
		this.power = power;
		this.str = str;
		rd = new Random();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPos() {
		return pos;
	}

	public void setPos(int pos) {
		this.pos = pos;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}

	public Random getRd() {
		return rd;
	}

	public void setRd(Random rd) {
		this.rd = rd;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public int getStr() {
		return str;
	}

	public void setStr(int str) {
		this.str = str;
	}

	public boolean isDeath() {
		return death;
	}

	public void setDeath(boolean death) {
		this.death = death;
	}

	public int getMAX_HP() {
		return MAX_HP;
	}

	public void attack(Unit attakcedUnit) {
		int rdDamage = rd.nextInt(power) + str;
		damage = rdDamage;
		if (attakcedUnit instanceof Ultimate && rd.nextInt(4) == 0) {
			System.out.println("필살기 사용 대미지 2배 증가");
			damage *= 2;
		}
		if (attakcedUnit instanceof Shield && ((Shield) attakcedUnit).getShield() != 0) {
			Shield shieldUnit = ((Shield) attakcedUnit);
			shieldUnit.setShield(shieldUnit.getShield() - damage);
			System.out.printf("%s 이(가) 쉴드에 %d 대미지 공격 %s의 ", name, damage, attakcedUnit.name);
			if (shieldUnit.getShield() >= 0) {
				System.out.printf("남은 쉴드 %d\n", shieldUnit.getShield());
				damage = 0;
				return;
			} else {
				damage = shieldUnit.getShield() * -1;
				shieldUnit.setShield(0);
				System.out.printf("쉴드 파괴 남은 대미지 %d\n", damage);
			}

		}
		attakcedUnit.hp -= damage;
		if (attakcedUnit.hp <= 0) {
			attakcedUnit.hp = 0;
			attakcedUnit.death = true;
		}
		System.out.printf("%s 이(가) %d 대미지 공격 %s의 체력 %d\n", name, damage, attakcedUnit.name, attakcedUnit.hp);
	}

}
