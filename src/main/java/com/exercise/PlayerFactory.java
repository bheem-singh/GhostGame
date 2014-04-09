package com.exercise;

/**
 * Player factory
 */
public class PlayerFactory {

	/**
	 * Returns a player instance
	 */
	public static Player getPlayerInstance() {
		//Return AutoPlayer class instance
		return new AutoPlayer();
	}

}
