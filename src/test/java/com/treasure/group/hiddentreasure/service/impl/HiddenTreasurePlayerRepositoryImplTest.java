package com.treasure.group.hiddentreasure.service.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.treasure.group.hiddentreasure.entity.Players;
import com.treasure.group.hiddentreasure.model.Palace;
import com.treasure.group.hiddentreasure.repository.HiddenTreasurePlayersRepository;
import com.treasure.group.hiddentreasure.service.HiddenTreasureUIservice;

@RunWith(MockitoJUnitRunner.class)
public class HiddenTreasurePlayerRepositoryImplTest {
	
	
	@InjectMocks
	private HiddenTreasurePlayerRepositoryImpl hiddenTreasurePlayerRepositoryImpl ;
	
	@Mock
	private HiddenTreasurePlayersRepository playersRepository;
	
	@Mock
	private HiddenTreasureUIservice ui;

	@Mock
	private Palace map;

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSelectPlayers() {
		Players player = hiddenTreasurePlayerRepositoryImpl.selectPlayers();
		assertNotNull(player);
	}

	@Test
	public void testAddPlayer() {
		//Players player = new Players();
		Players player = hiddenTreasurePlayerRepositoryImpl.addPlayer();
		assertEquals(player.getLevel(), 1L);
		assertEquals(player.getHealth(), 100);
		assertEquals(player.getGem(), 0);
	}

	@Test
	public void testSavePlayer() {
		Players player = hiddenTreasurePlayerRepositoryImpl.addPlayer();
		hiddenTreasurePlayerRepositoryImpl.savePlayer(player);
		assertTrue(true);
	}

}
