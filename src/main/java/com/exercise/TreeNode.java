package com.exercise;

import java.util.HashMap;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Map;

/**
 * Class representing n-ary tree node (and n-ary tree) for a string
 */
public class TreeNode {

	/*
	 * Node string
	 */
	private String nodeString;

	/*
	 * Child nodes
	 */
	private Map<String, TreeNode> childNodes = new HashMap<String, TreeNode>();

	/**
	 * Constructor to create a tree from a string and word list iterator
	 *
	 * @param nodeString
	 * @param iterator
	 */
	public TreeNode(String nodeString, ListIterator<String> iterator) {
		this.nodeString = nodeString;
		if(iterator.hasNext()) {
			String nextString = iterator.next();
			if(!nextString.equals(this.nodeString)) {
				addChild(new TreeNode(nextString));
			}
		}
		while (iterator.hasNext()) {
			addChild(new TreeNode(iterator.next()));
		}
	}

	/**
	 * Constructor to create a tree node from string
	 *
	 * @param nodeString
	 */
	public TreeNode(String nodeString) {
		this.nodeString = nodeString;
	}

	/**
	 * Returns whether node is leaf (terminal) or not
	 *
	 * @return
	 */
	public boolean isLeafNode() {
	  return childNodes.isEmpty();
	}

	/**
	 * Returns first winning word from given node
	 * (First winning word is a word which puts a player in a winning position)
	 *
	 * @param evenTurn
	 * @return
	 */
	public String firstWinningWord(boolean evenTurn) {
		String word = null;
	    if (isLeafNode() && nodeString.length() % 2 == (evenTurn?1:0)) {
	    	//Node is a leaf node and
	    	//string length is odd number for even turn/string length is even for odd turn
	    	word = nodeString;
	    }
	    else { //Look into child nodes for first winning word
	      Iterator<String> keyIterator = childNodes.keySet().iterator();
	      while ((word == null) && (keyIterator.hasNext()))
	        word = childNodes.get(keyIterator.next()).firstWinningWord(evenTurn);
	    }
	    return word;
	}

	/**
	 * Returns longest losing word
	 * (Longest losing word is a word which gives maximum turns to a player before
	 *  eventually losing game)
	 *
	 * @param evenTurn
	 * @param longestLosingWord
	 * @return
	 */
	public String longestLosingWord(boolean evenTurn, String longestLosingWord) {
		if (isLeafNode() && nodeString.length()%2 == (evenTurn?0:1)
			       && (nodeString.length() > longestLosingWord.length())) {
			//Leaf node and length is even for even turn/length is odd for odd turn
			    	longestLosingWord = nodeString;
		}
		Iterator<String> keyIterator = childNodes.keySet().iterator();
		TreeNode child = null;
		while (keyIterator.hasNext()) { //Look into child nodes for longest losing word
			child = childNodes.get(keyIterator.next());
		    longestLosingWord = child.longestLosingWord(evenTurn, longestLosingWord);

		}
		return longestLosingWord;
	}



	/**
	 * Adds a child node
	 *
	 * @param nodec
	 */
	private void addChild(TreeNode node) {
		if (node.nodeString.length() == (nodeString.length() + 1)) {
			  childNodes.put(node.nodeString, node);
		}
		else {
			String key = node.nodeString.substring(0, nodeString.length() + 1);
			TreeNode child = childNodes.get(key);
			if (child == null) {
				child = new TreeNode(key);
				childNodes.put(key, child);
			}
			child.addChild(node);
		}
	}


}
