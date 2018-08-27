package com.treasure.group.hiddentreasure.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import com.treasure.group.hiddentreasure.model.Palace;

/**
 * @author chirag
 * 
 * Entity class to keep record of player when they play or saved game
 *
 */
@Entity
@Table(name = "players")
public class Players implements Serializable {

	/**
	 * serialVersionUIDs
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "NAME")
	private String name;

	@Column(name = "GEM")
	private long gem;

	@Column(name = "Level")
	private long level;

	@Column(name = "health")
	private long health;

	@Column(name = "palace")
	@Lob
	private Palace Palace;

	public Players() {

	}

	/**
	 * @return the name
	 */
	public final String getName() {
		return name;
	}


	/**
	 * @param name
	 *            the name to set
	 */
	public final void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the gem
	 */
	public final long getGem() {
		return gem;
	}

	/**
	 * @return the level
	 */
	public final long getLevel() {
		return level;
	}

	/**
	 * @param gem
	 *            the gem to set
	 */
	public final void setGem(long gem) {
		this.gem = gem;
	}

	/**
	 * @param level
	 *            the level to set
	 */
	public final void setLevel(long level) {
		this.level = level;
	}

	/**
	 * @return the health
	 */
	public final long getHealth() {
		return health;
	}

	/**
	 * @param health
	 *            the health to set
	 */
	public final void setHealth(long health) {
		this.health = health;
	}

	/**
	 * @return the palace
	 */
	public final Palace getPalace() {
		return Palace;
	}

	/**
	 * @param palace the palace to set
	 */
	public final void setPalace(Palace palace) {
		Palace = palace;
	}

}
