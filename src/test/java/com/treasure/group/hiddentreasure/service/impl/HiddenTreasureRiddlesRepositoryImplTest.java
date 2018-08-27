package com.treasure.group.hiddentreasure.service.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Optional;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.treasure.group.hiddentreasure.entity.Riddles;
import com.treasure.group.hiddentreasure.repository.HiddenTreasureRiddlesRepository;

@RunWith(MockitoJUnitRunner.class)
public class HiddenTreasureRiddlesRepositoryImplTest {

	@InjectMocks
	private HiddenTreasureRiddlesRepositoryImpl hiddenTreasureRiddlesRepositoryImpl;

	@Mock
	private HiddenTreasureRiddlesRepository hiddenTreasureRiddlesRepository ;
	

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetOne() {
		Riddles riddles = new Riddles();
		riddles.setLevel(1L);
		riddles.setQuestion("I get wet when drying. I get dirty when wiping. What am I?");
		riddles.setAnswer("Towel");
		Mockito.when(hiddenTreasureRiddlesRepositoryImpl.getOne(1L)).thenReturn(Optional.of(riddles));
		Optional<Riddles> riddleoptional = hiddenTreasureRiddlesRepositoryImpl.getOne(1L);
		assertNotNull(riddleoptional.get());
		Riddles riddles1 = riddleoptional.get();
		assertEquals(1L, riddles1.getLevel());
		assertEquals("I get wet when drying. I get dirty when wiping. What am I?", riddles1.getQuestion());
		assertEquals("Towel", riddles1.getAnswer());
	}

	@Test
	public void testGetRiddleHint() {
		Riddles riddles = new Riddles();
		riddles.setLevel(1L);
		riddles.setQuestion("I get wet when drying. I get dirty when wiping. What am I?");
		riddles.setAnswer("Towel");
		Mockito.when(hiddenTreasureRiddlesRepositoryImpl.getOne(1L)).thenReturn(Optional.of(riddles));
		assertEquals("_ o _ e _ ", hiddenTreasureRiddlesRepositoryImpl.getRiddleHint(1L));
	}

	@Test
	public void testCheckRiddleAnswer() {
		Riddles riddles = new Riddles();
		riddles.setLevel(1L);
		riddles.setQuestion("I get wet when drying. I get dirty when wiping. What am I?");
		riddles.setAnswer("Towel");
		Mockito.when(hiddenTreasureRiddlesRepositoryImpl.getOne(1L)).thenReturn(Optional.of(riddles));
		assertTrue(hiddenTreasureRiddlesRepositoryImpl.checkRiddleAnswer("Towel", 1L));
	}

}
