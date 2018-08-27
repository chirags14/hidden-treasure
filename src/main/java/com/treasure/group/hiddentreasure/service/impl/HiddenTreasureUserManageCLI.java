package com.treasure.group.hiddentreasure.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.treasure.group.hiddentreasure.entity.Players;
import com.treasure.group.hiddentreasure.model.Palace;
import com.treasure.group.hiddentreasure.repository.HiddenTreasurePlayersRepository;
import com.treasure.group.hiddentreasure.service.HiddenTreasureUIservice;

/**
 * @author chirag
 * Repository to add/del players
 *
 */
@Component
public class HiddenTreasureUserManageCLI {

	/**
	 * usersRepositorys
	 */
	@Autowired
	private HiddenTreasurePlayersRepository playersRepository;

	/**
	 * HiddenTreasureUIservice
	 */
	@Autowired
	private HiddenTreasureUIservice ui;

	/**
	 * map
	 */
	@Autowired
	private Palace map;

	/**
	 * @return
	 * Method to select player
	 */
	public Players selectPlayers() {
		List<Players> users = playersRepository.findAll();
		if (users != null && users.size() > 0) {
			ui.displayUsers(users);

			int selected = ui.readUserInputInt();
			if (selected > 0 && selected <= users.size()) {
				return users.get(selected - 1);
			} else if (selected == users.size() + 2) {
				try {
					deletePlayer();
					
				}catch (Exception ex) {
					System.out.println("Unable to delete user ! User may not exists !!");
				}
				return selectPlayers();
			} else if (selected == users.size() + 1) {
				return addPlayer();
			} else {
				ui.displayInvalidOptionMessage();
			}
		}
		return addPlayer();
	}

	/**
	 * Method to delete player
	 */
	private void deletePlayer() {
		ui.confirmUserDeletion();
		String name = ui.readUserInputString();
		playersRepository.deleteById(name);
	}

	/**
	 * @return
	 * Method to add new player
	 */
	public Players addPlayer() {
		ui.userIntroMessage();
		String name = ui.readUserInputString();
		Players selectedUser = new Players();
		selectedUser.setName(name);
		selectedUser.setHealth(100);
		selectedUser.setGem(0);
		selectedUser.setLevel(1);
		selectedUser.setPalace(map);
		playersRepository.save(selectedUser);
		return selectedUser;
	}

	/**
	 * @param player
	 * Method to dave player
	 */
	public void savePlayer(Players player) {
		playersRepository.save(player);
		ui.exitMessage();
	}

}
