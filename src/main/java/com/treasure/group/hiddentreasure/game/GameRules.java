package com.treasure.group.hiddentreasure.game;

import com.treasure.group.hiddentreasure.model.User;

/**
 * @author chirag
 * Interface to hold game rules method anytime you can setup new game rules here
 *
 */
public interface GameRules {

	boolean apply(User player);
	
}
