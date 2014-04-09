package com.exercise;

/**
 * Player interface
 */
public interface Player {

	/**
	 * Plays next move
	 *
	 * @param wordString
	 * @return
	 */
	MoveResult playNextMove(String wordString);

}
