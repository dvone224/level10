package _13다형성게임_실습;

import java.util.Random;
import java.util.Scanner;

public class Utils {
	
	private static Utils instance;
	private Utils() {
		Random rd = new Random();
		Scanner sc = new Scanner(System.in);
	}
	
	public static Utils getInstance() {
		if(instance == null) instance = new Utils();
		return instance;
	}
	
	public int getDamage(Player player) {
		
		return 0;
	}
	
	public int getDamage(Monster monster) {
		return 0;
	}
}
