package com.treasure.group.hiddentreasure.service;

import java.util.List;

import com.treasure.group.hiddentreasure.entity.Players;

/**
 * @author chirag
 * 
 * Interface to hold variuos methods used by game
 *
 */
public interface HiddenTreasureUIservice {
	void printStory();
	void printInstructions();
	void displayFinishedGameMessage();
	void displayUnFinishedGameMessage();
	void hitWallMessage();
	void displayExploreError();
	String readUserInputString();
	int readUserInputInt();
	void destroy();
	void displayUsers(List<Players> users);
	void displayInvalidOptionMessage();
	void confirmUserDeletion();
	void userIntroMessage();
	void exitMessage();
	void displayWinMessage();
	void displayAnswerPrompt();
	void displayMonster();
	void displayLooseMessage();
	void displayNoGemsMessage();
	void displayCorrectAnswerMessage();
	void displayInCorrectAnswerMessage();
	void printHelp();
}
