package com.exercise;

/**
 * Auto player representing a player in form of a computer logic
 */
public class AutoPlayer implements Player {

	/**
	 * Plays next move and returns MoveResult class object.
	 *
	 * 1. MoveResult object contains following:
	 *  a. newWordString created by adding a new character to given input wordString.
	 *     (In some cases newWordString can be same as the given input wordString)
	 *  b. resultText giving the game status message.
	 *  c. gameOver flag indicating whether game is over or not.
	 *
	 * 2. The logic tries to get first winning word which can be completed by input from other player
	 *
	 * 3. If there is not such word found then logic tries to get longest losing word which can be
	 * completed by input from auto player
	 *
	 * 4. Based on 2 and 3 MoveResult object is set.
	 *
	 * @param wordString
	 * @return
	 */
	public MoveResult playNextMove(String wordString) {
		//Create move result
		MoveResult moveResult = new MoveResult();

		//Build subset dictionary from the word string
		Dictionary dictionary = Dictionary.buildSubsetDictionary(wordString);

		if(dictionary.size() != 0) { //If subset dictionary size is not 0
			//Find whether turn is even or not
			boolean evenTurn = (wordString.length()%2 == 1);

			//Get n-ary tree for word string
			TreeNode treeNode = new TreeNode(wordString, dictionary.listIterator());

			//Get first winning word from the tree
			String firstWinningWord = treeNode.firstWinningWord(evenTurn);

			if(null == firstWinningWord) { //No winning word from the tree
				//Get longest losing word from the tree
				String longestLosingWord = treeNode.longestLosingWord(evenTurn, "");
				if(longestLosingWord.length() == wordString.length()+1) { //longest losing word completed
					moveResult.setGameOver(true);
					moveResult.setNewWordString(longestLosingWord);
					moveResult.setResultText(String.format("%s is a word, you won", longestLosingWord));
				}
				else { //Yet to complete longest losing word
					moveResult.setGameOver(false);
					moveResult.setNewWordString(wordString+longestLosingWord.charAt(wordString.length()));
					moveResult.setResultText("Your turn, please press a valid key to enter your alphabet");
				}
			}
			else { //First winning word from tree
				if(firstWinningWord.equals(wordString)) { //First winning word equal to word string
					moveResult.setGameOver(true);
					moveResult.setNewWordString(wordString);
					moveResult.setResultText(String.format("%s is a word, you lost", wordString));
				}
				else { //First winning word not equal to word string
					moveResult.setGameOver(false);
					moveResult.setNewWordString(wordString+firstWinningWord.charAt(wordString.length()));
					moveResult.setResultText("Your turn, please press a valid key to enter your alphabet");
				}
			}
		}
		else { //No word from the word string
			moveResult.setGameOver(true);
			moveResult.setNewWordString(wordString);
			moveResult.setResultText(String.format("%s is not a word, you lost", wordString));
		}
		return moveResult;
	}

}
