package com.exercise;

import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 * Junit test for TreeNode
 */
public class TreeNodeTest {

	@Test
	public void treeNodeTest() {
		Dictionary subDictionary = Dictionary.buildSubsetDictionary("numb");
		TreeNode treeNode = new TreeNode("numb", subDictionary.listIterator());
		String firstWinningWord = treeNode.firstWinningWord(false);
		String longestLosingWord = treeNode.longestLosingWord(true, "numb");
		System.out.println("First winning word for numb: "+firstWinningWord);
		assertTrue("number".equals(firstWinningWord));
		System.out.println("Longest losing word for numb: "+longestLosingWord);
		assertTrue("numbfish".equals(longestLosingWord));
		//TODO add more code
	}

}
