package com.exercise;

import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 * Junit test for AutoPlayer
 */
public class AutoPlayerTest {

	@Test
	public void autoPlayerTest() {
		Player player = new AutoPlayer();
		MoveResult result = player.playNextMove("numbness");
		System.out.println("Result for numbness: ");
		System.out.println("Is game over: "+result.isGameOver());
		System.out.println("New word string: "+result.getNewWordString());
		System.out.println("Result text: "+result.getResultText());
		assertTrue(true == result.isGameOver());
		assertTrue("numbness".equals(result.getNewWordString()));
		assertTrue("numbness is a word, you lost".equals(result.getResultText()));
		//TODO add more code
	}

}
