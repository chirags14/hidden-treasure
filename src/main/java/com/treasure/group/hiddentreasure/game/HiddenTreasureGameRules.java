package com.treasure.group.hiddentreasure.game;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.treasure.group.hiddentreasure.entity.Riddles;
import com.treasure.group.hiddentreasure.model.GameCharacter;
import com.treasure.group.hiddentreasure.model.User;
import com.treasure.group.hiddentreasure.service.impl.HiddenTreasureConsoleBasedUI;
import com.treasure.group.hiddentreasure.service.impl.HiddenTreasureRiddlesRepositoryImpl;
import com.treasure.group.hiddentreasure.utils.HiddenTreasureCommands;

/**
 * @author chirag
 * 
 * Class to setup game rules
 *
 */
@Component
public class HiddenTreasureGameRules implements GameRules {

	/**
	 * riddleRepositoryImpl
	 */
	@Autowired
	private HiddenTreasureRiddlesRepositoryImpl riddleRepositoryImpl;
	
	/**
	 * HiddenTreasureConsoleBasedUI
	 */
	@Autowired
	private HiddenTreasureConsoleBasedUI ui;
	
	/* (non-Javadoc)
	 * @see com.treasure.group.hiddentreasure.game.GameRules#apply(com.treasure.group.hiddentreasure.model.User)
	 */
	@Override
	public boolean apply(User player) {
		//Check if current room has hidden treasure
		if (player.getMap().getCurrentRoom().getOccupiedBy() == GameCharacter.TREASURE) {
			ui.displayWinMessage();
			return true;
		//If found monster in current room thn throw a riddle and validate answer	
		} else if (player.getMap().getCurrentRoom().getOccupiedBy() == GameCharacter.MONSTER) {
			ui.displayMonster();
			System.out.println();
			Optional<Riddles> riddleOption = riddleRepositoryImpl.getOne((player.getLevel()));
			System.out.println(riddleOption.get().getQuestion());
			String userAnswer = "";
			do {
				ui.displayAnswerPrompt();
				userAnswer = ui.readUserInputString();
				//if player decided to give up then end the game and display loose message
				if (userAnswer.equalsIgnoreCase(HiddenTreasureCommands.GIVEUP)) {
					double healthLost = fightMonster();
					player.modifyHealth((int) healthLost);
					player.IncLevel();
					if (player.getHealth() == 0) {
						ui.displayLooseMessage();
						return true;
					}
					break;
				//Check for help	
				} else if (userAnswer.equalsIgnoreCase(HiddenTreasureCommands.HELP)) {
					ui.printHelp();
				//If Player don't know riddle answer and willing to pay gems then provide hint	
				} else if (userAnswer.equalsIgnoreCase(HiddenTreasureCommands.PAY)) {
					if (player.getGems() == 0) {
						ui.displayNoGemsMessage();
					} else {
						player.modifyGems(-1);
						System.out.println(riddleRepositoryImpl.getRiddleHint(player.getLevel()));
					}
				//Check if provided answer is correct and provide one gem	
				} else if (riddleRepositoryImpl.checkRiddleAnswer(userAnswer, player.getLevel())) {
					player.IncLevel();
					player.modifyGems(1);
					ui.displayCorrectAnswerMessage();
					break;
				//if answer is not correct	
				} else {
					ui.displayInCorrectAnswerMessage();
				}
			} while (true);
			System.out.println(player);
		}
		return false;
	}

	/**
	 * @return
	 * 
	 * fightMonster
	 */
	private double fightMonster() {
		System.out.println("Fighting Monster...");
		return Math.random() * 25 - 40;
	}

}
