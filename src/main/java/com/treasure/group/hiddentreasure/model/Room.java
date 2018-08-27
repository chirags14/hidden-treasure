package com.treasure.group.hiddentreasure.model;

import java.io.Serializable;

import org.springframework.stereotype.Component;

@Component
public class Room implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public GameCharacter getOccupiedBy() {
		return occupiedBy;
	}

	public void setOccupiedBy(GameCharacter you) {
		this.occupiedBy = you;
	}

	GameCharacter occupiedBy;
}
