package com.treasure.group.hiddentreasure.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.treasure.group.hiddentreasure.entity.Riddles;
import com.treasure.group.hiddentreasure.repository.HiddenTreasureRiddlesRepository;

/**
 * @author chirag
 * 
 * Repository for Riddle
 *
 */
@Component
public class HiddenTreasureRiddlesRepositoryImpl {
	
	/**
	 * riddleRepository
	 */
	@Autowired
	HiddenTreasureRiddlesRepository riddleRepository ;
	
	/**
	 * @param id
	 * @return
	 * Get riddle by id
	 */
	public Optional<Riddles> getOne(Long id) {
		return riddleRepository.findById(id);
	}
	
	/**
	 * @param level
	 * @return
	 * If player decided to give gem , then provide  hint with answer such as W_T_R
	 */
	public String getRiddleHint(long level) {
		Optional<Riddles> riddle =  riddleRepository.findById(level);
		StringBuilder hint = new StringBuilder();
		
		for (int i = 0; i < riddle.get().getAnswer().length(); i++) {
			int seed = i+riddle.get().getAnswer().length();
			if ((((int)Math.random()*100)+seed)%2==0) {
				hint.append(riddle.get().getAnswer().charAt(i)+" ");
			} else {
				hint.append("_ ");
			}
		}
		return hint.toString();
	}
	
	
	/**
	 * @param answer
	 * @param level
	 * @return
	 * 
	 * Check Player answer
	 */
	public boolean checkRiddleAnswer(String answer, long level) {
		Optional<Riddles> riddle = riddleRepository.findById(level);
		return answer.equalsIgnoreCase(riddle.get().getAnswer());
	}
}
