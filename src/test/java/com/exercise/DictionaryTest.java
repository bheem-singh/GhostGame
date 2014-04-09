package com.exercise;

import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 * Junit test for Dictionary
 */
public class DictionaryTest {

	@Test
	public void subsetDictionaryTest() {
		Dictionary subDictionary = Dictionary.buildSubsetDictionary("numb");
		System.out.println("Subdictionary size for numb: "+subDictionary.size());
		assertTrue(10 == subDictionary.size());
		//TODO add more code
	}


}
