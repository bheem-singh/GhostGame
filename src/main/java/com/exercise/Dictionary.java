package com.exercise;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.NoSuchElementException;

/**
 * Stores words
 */
public class Dictionary {

	/*
	 * File containing the words
	 *
	 * Assumption is that file WORD.LST contains words in ascending order
	 */
	private static final String WORDS_FILE = "word.lst";

	/*
	 * Minimum length of word in the game
	 */
	private static final int MIN_WORD_LENGTH = 5;

	/*
	 * list of words from file
	 */
    private static final LinkedList<String> FILE_WORDS_LIST = buildFullWordList(WORDS_FILE);

    /*
     * List of words in the dictionary
     */
    private LinkedList<String> wordList = new LinkedList<String>();

	/**
	 * Return list of words read from the file
	 *
	 * @param fileName
	 * @return
	 */
    private static LinkedList<String> buildFullWordList(String fileName) {
		LinkedList<String> list = new LinkedList<String>();
		try {
			BufferedReader reader =
					new BufferedReader(
							new InputStreamReader(Dictionary.class.getResourceAsStream(fileName)));
			String word = null;
			while ((word = reader.readLine()) != null) {
				String lastWord = null;
				if (word.length() >= MIN_WORD_LENGTH) { //Word should be of defined minimum length
					try {
						lastWord = list.getLast();
					}
					catch (NoSuchElementException e) {
						//Do nothing
					}
					if ((lastWord == null) || !word.startsWith(lastWord)) { //Word shouldn't start with last word
						list.addLast(word);
					}
				}
			}
	    }
	    catch (FileNotFoundException fileNotFoundException) {
	    	fileNotFoundException.printStackTrace();
	    }
	    catch (IOException ioException) {
	    	ioException.printStackTrace();
	    }
		return list;
	}

    /**
     * Returns a dictionary containing word list which is subset of the full list
     * and all words start with the supplied wordString
     *
     * @param wordString
     * @return
     */
	public static Dictionary buildSubsetDictionary(String wordString) {
		Dictionary dictionary = new Dictionary();
		ListIterator<String> iterator = FILE_WORDS_LIST.listIterator(0);
		String word = null;
	    while (iterator.hasNext()) {
	    	if ((word = iterator.next()).startsWith(wordString)) {
		        dictionary.wordList.addLast(word);
	    	}
	    }
		return dictionary;
	}

	/**
	 * Returns list iterator
	 *
	 * @return
	 */
	public ListIterator<String> listIterator() {
		return wordList.listIterator(0);
    }

	/**
	 * Returns size of the words
	 *
	 * @return
	 */
	public long size() {
		return wordList.size();
	}

}
