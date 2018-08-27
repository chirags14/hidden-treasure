package com.treasure.group.hiddentreasure;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.treasure.group.hiddentreasure.entity.Players;
import com.treasure.group.hiddentreasure.game.HiddenTreasureGameRules;
import com.treasure.group.hiddentreasure.model.Palace;
import com.treasure.group.hiddentreasure.model.User;
import com.treasure.group.hiddentreasure.service.HiddenTreasureUIservice;
import com.treasure.group.hiddentreasure.service.impl.HiddenTreasureConsoleBasedUI;
import com.treasure.group.hiddentreasure.service.impl.HiddenTreasurePlayerRepositoryImpl;
import com.treasure.group.hiddentreasure.utils.HiddenTreasureConstants;

/**
 * @author chirag
 * 
 * Game starter 
 *
 */
@Component
public class HiddenTreasureGameStarter {
	
	/**
	 * userManageCLI
	 */
	@Autowired
	private HiddenTreasurePlayerRepositoryImpl userManageCLI;

	/**
	 * gameRules
	 */
	@Autowired
	private HiddenTreasureGameRules gameRules;

	/**
	 * user
	 */
	@Autowired
	private User user;

	/**
	 * 
	 */
	private void startGame() {
		HiddenTreasureUIservice ui = new HiddenTreasureConsoleBasedUI();
		//Display introductory message for Hidden Treasure game 
		ui.printStory();
		//Create Player or check if existing player has already saved game
		Players player = userManageCLI.selectPlayers();
		user = new User(player.getName(), player.getLevel(), player.getGem(), player.getHealth(), player.getPalace(),player.getSkills());
		user.setUI(ui);
		boolean gotResult = false;
		System.out.println(HiddenTreasureConstants.ANSI_PURPLE +"Let's go!! ");
		while (!gotResult) {
			if (user.explore()) { // returns true if user wants to quit
				break;
			}
			gotResult = gameRules.apply(user);
		}
		if (gotResult) {
			user.setMap(new Palace());
			user.modifyHealth(100 - user.getHealth());
			ui.displayFinishedGameMessage();
		} else {
			ui.displayUnFinishedGameMessage();
		}
		userManageCLI.savePlayer(player);
	}

	/**
	 * init method to start game
	 */
	@PostConstruct
	private void init() {
		startGame();
	}

}
