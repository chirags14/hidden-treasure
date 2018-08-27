package com.treasure.group.hiddentreasure.model;

import org.springframework.stereotype.Component;

import com.treasure.group.hiddentreasure.utils.HiddenTreasureConstants;

/**
 * @author chirag
 * Class for Forts room management with treasure , monsters and players
 *
 */
@Component
public class Palace extends GeoMap {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * rooms
	 */
	private Room[][] rooms = new Room[HiddenTreasureConstants.rows][HiddenTreasureConstants.columns];
	/**
	 * currentRoomX
	 */
	private Integer currentRoomX;
	/**
	 * currentRoomY
	 */
	private Integer currentRoomY;
	
	/**
	 * constructor
	 */
	public Palace() {
		// init rooms
		for (int i = 0; i < rooms.length; i++) {
			for (int j = 0; j < rooms[i].length; j++) {
				rooms[i][j] = new Room();
			}
		}
		//select a room for user randomly
		currentRoomX = (int) (Math.random() * 10);
		currentRoomY = (int) (Math.random() * 10);
		
		
		int monsters = (int) (Math.random() * 10 + 20); //20 - 30 monsters are placed in palace 
		for (int i = 0; i < monsters; i++) {
			rooms[(int) (Math.random() * 10)][(int) (Math.random() * 10)].setOccupiedBy(GameCharacter.MONSTER);
		}
		//select a room for Treasure which is different from user's room
		int treasureX = (int) (Math.random() * 10);
		int treasureY = (int) (Math.random() * 10);
		if (treasureX == currentRoomX && treasureY == currentRoomY) {
			treasureX = (int) (Math.random() * 10);
			treasureY = (int) (Math.random() * 10);
		}
		rooms[treasureX][treasureY].setOccupiedBy(GameCharacter.TREASURE);
		//at least four monsters are very near to Treasure
		rooms[treasureX][treasureY==0?treasureY+1:treasureY-1].setOccupiedBy(GameCharacter.MONSTER);
		rooms[treasureX==0?treasureX+1:treasureX-1][treasureY].setOccupiedBy(GameCharacter.MONSTER);
	}

	/* (non-Javadoc)
	 * @see com.treasure.group.hiddentreasure.model.GeoMap#print()
	 */
	@Override
	void print() {
		for (int c = 0; c < HiddenTreasureConstants.columns; c++) {
			System.out.print(" _ _ ");
		}
		System.out.println();

		for (int i = 0; i < rooms.length; i++) {
			for (int j = 0; j < rooms[i].length; j++) {
				String roomString = "|_ _|";
				if (i == currentRoomX && j == currentRoomY) {
					roomString = "|_U_|";
					rooms[i][j].setOccupiedBy(null);
				}
				System.out.print(roomString);
			}
			System.out.println();
		}
	}

	public Integer getCurrentRoomX() {
		return currentRoomX;
	}

	public Integer getCurrentRoomY() {
		return currentRoomY;
	}
	
	public Room getCurrentRoom() {
		return rooms[currentRoomX][currentRoomY];
	}

	public void IncOrDecCurrentRoomY(int i) {
		currentRoomY += i;
	}

	public void IncOrDecCurrentRoomX(int i) {
		currentRoomX += i;
	}
}
