package com.treasure.group.hiddentreasure.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.treasure.group.hiddentreasure.service.HiddenTreasureUIservice;
import com.treasure.group.hiddentreasure.utils.HiddenTreasureConstants;

/**
 * @author chirag
 * 
 *         Class to hold current users data while playing game
 *
 */
@Component
public class User {
	/**
	 * name
	 */
	private String name;

	/**
	 * map
	 */
	@Autowired
	private Palace map;

	/**
	 * level
	 */
	private long level;

	/**
	 * gems
	 */
	private long gems;

	/**
	 * health
	 */
	private long health;

	/**
	 * health
	 */
	public String userSkills;

	/**
	 * ui
	 */
	private HiddenTreasureUIservice ui;

	@Override
	public String toString() {
		return this.getName() + "'s Health : " + this.getHealth() + " Gems: " + this.getGems();
	}

	public User(String name, long level, long gems, long health, Palace palace ,String skills) {
		this.name = name;
		this.level = level;
		this.gems = gems;
		this.health = health;
		this.map = palace;
		this.userSkills=skills;
	}

	public User(String name) {
		this.name = name;
		this.level = 1;
		this.gems = 0;
		this.health = 100;
		this.map = new Palace();
	}

	/**
	 * @return Method responsible to actually drive the hidden treasure game
	 */
	public boolean explore() {
		map.print();
		ui.printInstructions();
		String cmd = ui.readUserInputString();
		if (cmd.equalsIgnoreCase("QUIT") || cmd.equalsIgnoreCase("Q")) {
			return true;
		} else {
			switch (cmd.toUpperCase()) {
			case "NORTH":
			case "N":
				moveNorth();
				break;
			case "SOUTH":
			case "S":
				moveSouth();
				break;
			case "WEST":
			case "W":
				moveWest();
				break;
			case "EAST":
			case "E":
				moveEast();
				break;
			default:
				ui.displayExploreError();
			}
		}

		System.out.flush();
		return false;
	}

	private void moveNorth() {
		if (map.getCurrentRoomX() == 0) {
			ui.hitWallMessage();
		} else {
			map.IncOrDecCurrentRoomX(-1);
		}

	}

	private void moveSouth() {
		if (map.getCurrentRoomX() == HiddenTreasureConstants.rows - 1) {
			ui.hitWallMessage();
		} else {
			map.IncOrDecCurrentRoomX(1);
		}

	}

	private void moveWest() {
		if (map.getCurrentRoomY() == 0) {
			ui.hitWallMessage();
		} else {
			map.IncOrDecCurrentRoomY(-1);
		}

	}

	private void moveEast() {
		if (map.getCurrentRoomY() == HiddenTreasureConstants.columns - 1) {
			ui.hitWallMessage();
		} else {
			map.IncOrDecCurrentRoomY(1);
		}
	}

	public void modifyHealth(long delta) {
		health += delta;
		if (health < 0)
			health = 0;
	}

	public void modifyGems(long number) {
		gems += number;
	}

	public String getName() {
		return name;
	}

	public Palace getMap() {
		return map;
	}

	public void setMap(Palace map) {
		this.map = map;
	}

	public long getLevel() {
		return level;
	}

	public void IncLevel() {
		this.level++;
	}

	public long getGems() {
		return gems;
	}

	public long getHealth() {
		return health;
	}

	public void setUI(HiddenTreasureUIservice ui) {
		this.ui = ui;
	}

	public User() {
	}

}
