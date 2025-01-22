package _13다형성게임_실습;

import java.util.ArrayList;

public class PlayerDAO {
	private ArrayList<Player> playerList;
	private Utils utils;
	
	PlayerDAO(){
		playerList = new ArrayList<Player>();
		utils = Utils.getInstance();
	}
	
	
	
}
