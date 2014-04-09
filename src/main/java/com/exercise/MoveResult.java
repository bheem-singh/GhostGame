package com.exercise;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Result of the move
 */
@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "gameResponse")
public class MoveResult implements Serializable {

	private static final long serialVersionUID = 1L;

	/*
	 * Game over flag
	 */
	@XmlElement(name = "gameOver")
	private boolean gameOver;

	/*
	 * Move result text
	 */
	@XmlElement(name = "resultText")
	private String resultText;

	/*
	 * New word string after the move
	 */
	@XmlElement(name ="newWordString")
	private String newWordString;

	//Getters and setters:

	public boolean isGameOver() {
		return gameOver;
	}

	public void setGameOver(boolean gameOver) {
		this.gameOver = gameOver;
	}

	public String getResultText() {
		return resultText;
	}

	public void setResultText(String resultText) {
		this.resultText = resultText;
	}

	public String getNewWordString() {
		return newWordString;
	}

	public void setNewWordString(String newWordString) {
		this.newWordString = newWordString;
	}





}
