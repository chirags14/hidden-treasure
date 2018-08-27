package com.treasure.group.hiddentreasure.service.impl;

import java.util.List;
import java.util.Scanner;

import org.springframework.stereotype.Component;

import com.treasure.group.hiddentreasure.entity.Players;
import com.treasure.group.hiddentreasure.service.HiddenTreasureUIservice;
import com.treasure.group.hiddentreasure.utils.HiddenTreasureConstants;

/**
 * @author chirag
 * 
 *         Class provided instruction messages for game , such as add, delete players
 *         as well as if player has won/loose game
 *
 */
@Component
public class HiddenTreasureConsoleBasedUI implements HiddenTreasureUIservice {
	

	Scanner scan = new Scanner(System.in);

	@Override
	public void printStory() {
		System.out.println(HiddenTreasureConstants.ANSI_YELLOW +"================================================================================= \n");
		System.out.println( HiddenTreasureConstants.ANSI_BLUE +"^^^^^^^^^^^^^^^^^^THE AMER FORT ( A Land Of Mysterious Treasure )^^^^^^^^^^^^^^^^ \n");
		System.out.println(HiddenTreasureConstants.ANSI_YELLOW + "================================================================================= \n");
		System.out.println(HiddenTreasureConstants.ANSI_RED +HiddenTreasureConstants.BOLD+"You are going to enter a fort.\n" +HiddenTreasureConstants.ANSI_RED +HiddenTreasureConstants.BOLD+ "There are so many rooms in this fort.\n"
				+HiddenTreasureConstants.ANSI_RED +HiddenTreasureConstants.BOLD+ "There is a huge Treasure locked up in one of those rooms, surrounded by monsters\n"
				+HiddenTreasureConstants.ANSI_RED +HiddenTreasureConstants.BOLD+"Navigate to Treasure with N,E,W,S keys\n"
				+HiddenTreasureConstants.ANSI_RED +HiddenTreasureConstants.BOLD+ "Answer riddles asked by monster to pass each monster\n"
				+HiddenTreasureConstants.ANSI_RED +HiddenTreasureConstants.BOLD+ "So, by all means, the treasure lays hidden in the fort and you might stand a fair chance of getting lucky Today :)");
		System.out.println("\n--------------------------------------\n");
		System.out.flush();
	}

	@Override
	public void printInstructions() {
		System.out.println("\nWhich direction do you want to move?\n" + "NORTH(N/n) , EAST(E/e),WEST(W/w),SOUTH(S/s)\n"
				+ "Type Quit/Q/q to exit");

	}

	@Override
	public void displayFinishedGameMessage() {
		System.out.println("Thanks for playing.Play again to solve harder riddles.");
	}

	@Override
	public void displayUnFinishedGameMessage() {
		System.out.println("Your game will be saved.You can resume the game by selecting same user");
	}

	@Override
	public void hitWallMessage() {
		System.out.println("Ouch!You hit a wall.Choose Different direction");
	}

	@Override
	public void displayExploreError() {
		System.err.println("Invalid input.Only N/E/W/S/Q are allowed");
	}

	@Override
	public String readUserInputString() {
		String input = scan.nextLine();
		return input;
	}

	@Override
	public int readUserInputInt() {
		int input = scan.nextInt();
		scan.nextLine();// takes care of \n character after number
		return input;
	}

	@Override
	public void destroy() {
		scan.close();
	}

	@Override
	public void displayUsers(List<Players> users) {
		printHeader();
		int i = 0;
		for (Players user : users) {
			System.out.println(++i + ")   " + user.getName() + "\t" + user.getGem() + "\t" + user.getHealth() + "\t" + user.getSkills());
		}
		System.out.println(++i + ")   Create New User");
		System.out.println(++i + ")   Delete A User");
		System.out.flush();
	}

	private void printHeader() {
		System.out.println(HiddenTreasureConstants.ANSI_YELLOW + HiddenTreasureConstants.BOLD + "Select a user from the following");
		System.out.println(HiddenTreasureConstants.ANSI_RED +"----------------------------------------------------------------");
		System.out.println(HiddenTreasureConstants.ANSI_YELLOW + HiddenTreasureConstants.BOLD + "\tName\tGems\tHealth\tSkills");
		System.out.println(HiddenTreasureConstants.ANSI_RED+ "----------------------------------------------------------------");
		System.out.flush();
	}

	@Override
	public void displayInvalidOptionMessage() {
		System.out.println("Invalid option.Try again");
	}

	@Override
	public void confirmUserDeletion() {
		System.out.println("To confirm deletion - enter the name of user.To cancel - enter #cancel");
	}

	@Override
	public void userIntroMessage() {
		System.out.println(HiddenTreasureConstants.ANSI_CYAN + "Let's get introduced");
		System.out.println(HiddenTreasureConstants.ANSI_CYAN +HiddenTreasureConstants.BOLD + "What should I call you?");
	}

	@Override
	public void exitMessage() {
		System.out.println("Goodbye!");
	}

	@Override
	public void displayWinMessage() {
		System.out.println(HiddenTreasureConstants.ANSI_BLUE_BACKGROUND + HiddenTreasureConstants.ANSI_RED + HiddenTreasureConstants.BOLD + "Wow !!!! You have just discovered hidden Treasure. You won!! \n");
		System.out.println(HiddenTreasureConstants.ANSI_CYAN_BACKGROUND + HiddenTreasureConstants.ANSI_RED + HiddenTreasureConstants.BOLD + "################### \n");
		System.out.println(HiddenTreasureConstants.ANSI_CYAN_BACKGROUND + HiddenTreasureConstants.ANSI_RED + HiddenTreasureConstants.BOLD +"#                 # \n");
		System.out.println(HiddenTreasureConstants.ANSI_CYAN_BACKGROUND + HiddenTreasureConstants.ANSI_RED + HiddenTreasureConstants.BOLD +"#                 # \n");
		System.out.println(HiddenTreasureConstants.ANSI_CYAN_BACKGROUND + HiddenTreasureConstants.ANSI_RED + HiddenTreasureConstants.BOLD +"#                 # \n");
		System.out.println(HiddenTreasureConstants.ANSI_CYAN_BACKGROUND + HiddenTreasureConstants.ANSI_RED + HiddenTreasureConstants.BOLD +"#      $$$$       # \n");
		System.out.println(HiddenTreasureConstants.ANSI_CYAN_BACKGROUND + HiddenTreasureConstants.ANSI_RED + HiddenTreasureConstants.BOLD +"#                 # \n");
		System.out.println(HiddenTreasureConstants.ANSI_CYAN_BACKGROUND + HiddenTreasureConstants.ANSI_RED + HiddenTreasureConstants.BOLD +"#                 # \n");
		System.out.println(HiddenTreasureConstants.ANSI_CYAN_BACKGROUND + HiddenTreasureConstants.ANSI_RED + HiddenTreasureConstants.BOLD +"#                 # \n");
		System.out.println(HiddenTreasureConstants.ANSI_CYAN_BACKGROUND + HiddenTreasureConstants.ANSI_RED + HiddenTreasureConstants.BOLD +"################### \n");

	}

	@Override
	public void displayAnswerPrompt() {
		System.out.print(HiddenTreasureConstants.ANSI_RED_BACKGROUND + HiddenTreasureConstants.ANSI_CYAN + "\nEnter #help for available commands.Type your Answer/Command:");
		System.out.flush();
	}

	@Override
	public void displayMonster() {
		System.out.println(HiddenTreasureConstants.ANSI_RED_BACKGROUND + HiddenTreasureConstants.ANSI_CYAN + "There is monster in this room.Answer the following riddle to impress it");
	}

	@Override
	public void displayLooseMessage() {
		System.out.println(HiddenTreasureConstants.ANSI_RED_BACKGROUND + HiddenTreasureConstants.ANSI_CYAN + "You died.You lost the game  \n");
	}

	@Override
	public void displayNoGemsMessage() {
		System.out.println(HiddenTreasureConstants.ANSI_RED_BACKGROUND + HiddenTreasureConstants.ANSI_CYAN + "You have no Gems.You can fight by typing #giveup if you cannot answer  \n");
	}

	@Override
	public void displayCorrectAnswerMessage() {
		System.out.println(HiddenTreasureConstants.ANSI_BLACK_BACKGROUND + HiddenTreasureConstants.ANSI_CYAN + "Correct Answer! Monster gave you one gem \n");
	}

	@Override
	public void displayInCorrectAnswerMessage() {
		System.out.println(HiddenTreasureConstants.ANSI_BLACK_BACKGROUND + "Wrong Answer! Try again  \n");
	}

	@Override
	public void printHelp() {
		System.out.println(HiddenTreasureConstants.ANSI_BLACK_BACKGROUND + HiddenTreasureConstants.ANSI_CYAN + "You have to answer monster riddle.\n" + "If you answer correctly you will get gems.\n"
				+ "It will give you hints if you pay gems by typing '#pay' \n"
				+ "You can type '#giveup' to fight the monster\n");
	}

	@Override
	public String readAboutPlayer() {
		System.out.println(HiddenTreasureConstants.ANSI_CYAN +HiddenTreasureConstants.BOLD + "Tell Something About Your Skills ?");
		String input = scan.nextLine();
		return input;
	}
}
