package com.treasure.group.hiddentreasure.service;

import com.treasure.group.hiddentreasure.entity.Players;

public interface HiddenTreasureUserManagement {

	public Players selectUser();
	public Players addUser();
	public void saveUser(Players player);
}
