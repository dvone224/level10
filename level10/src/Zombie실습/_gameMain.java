package Zombie실습;

import java.util.ArrayList;
import java.util.Scanner;

public class _gameMain {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		Hero hero = new Hero();
		ArrayList<Unit> unitList = new ArrayList<Unit>();
		unitList.add(new Zombie());
		unitList.add(new Boss());
		int enemyNum = 0;

		int pos = hero.getPos();
		while (true) {
			System.out.println("현재 위치 = " + pos);

			System.out.print("앞으로 이동하기(1),종료하기(2) ");

			int move = sc.nextInt();

			if (move == 1) {
				hero.setPos(++pos);

				if (hero.getPos() == unitList.get(enemyNum).getPos()) {
					Unit enemy = unitList.get(enemyNum);
					System.out.printf("%s를 만났습니다. 공격모드로 바뀝니다.\n", enemy.getName());
					while (true) {
						enemy.attack(hero);
						System.out.println();
						if (hero.getHp() <= 0) {
							break;
						}
						System.out.print("공격하기(1),포션마시기(2): ");
						int sel = sc.nextInt();
						if (sel == 1) {
							hero.attack(enemy);
							System.out.println();
						}
						if (sel == 2) {
							if (hero.getCount() > 0) {
								hero.potion();
							} else {
								System.out.println("포션이 없습니다.");
							}
						}
						if (enemy.getHp() <= 0) {
							System.out.printf("%s를 이겼습니다\n", enemy.getName());
							if (unitList.size() - 1 != enemyNum)
								enemyNum++;
							break;
						}
						
					}
				}
				if (hero.getPos() == 10) {
					System.out.println("게임에서 승리했습니다. 종료합니다.");
					break;
				}
				if (hero.getHp() <= 0) {
					System.out.println("히어로가 죽었습니다. 종료합니다.");
					break;
				}
			} else if (move == 2) {
				break;
			}
		}
		sc.close();

	}
}
