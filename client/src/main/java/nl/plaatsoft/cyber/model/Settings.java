package nl.plaatsoft.cyber.model;

import nl.plaatsoft.cyber.tools.Constants;

public class Settings {
	
	private int level = Constants.INIT_LEVEL;
	private String playerName = "wplaat";
	
	private int money = Constants.INIT_MONEY;
	private int bcoins = Constants.INIT_BCOIN;
	private int gold = Constants.INIT_GOLD;
	
	private int thread = Constants.INIT_THREAD;
	
	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public int getGold() {
		return gold;
	}

	public void setGold(int gold) {
		this.gold = gold;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getThread() {
		return thread;
	}

	public void setThread(int thread) {
		this.thread = thread;
	}

	public int getBcoins() {
		return bcoins;
	}

	public void setBcoins(int bcoins) {
		this.bcoins = bcoins;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
}
	
