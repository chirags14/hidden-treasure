package com.treasure.group.hiddentreasure.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author chirag
 * Entity class to hold riddles
 *
 */
@Entity
@Table(name = "riddles")
public class Riddles implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="LEVEL")
	private long level;
	
	@Column(name="QUESTION",length=1000)
	private String question ;
	
	@Column(name="ANSWER",length=500)
	private String answer;
	
	public Riddles() {
		
	}

	/**
	 * @return the level
	 */
	public final long getLevel() {
		return level;
	}

	/**
	 * @return the question
	 */
	public final String getQuestion() {
		return question;
	}

	/**
	 * @return the answer
	 */
	public final String getAnswer() {
		return answer;
	}

	/**
	 * @param level the level to set
	 */
	public final void setLevel(long level) {
		this.level = level;
	}

	/**
	 * @param question the question to set
	 */
	public final void setQuestion(String question) {
		this.question = question;
	}

	/**
	 * @param answer the answer to set
	 */
	public final void setAnswer(String answer) {
		this.answer = answer;
	}
	
	

}
