package com.cosmogama.anagram;

import com.cosmogama.anagram.AnagramUtil;

import junit.framework.TestCase;

/**
 * Tests the Anagram algorithm
 * 
 * @author Tony
 *
 */
public class AnagramTest extends TestCase {

	private AnagramUtil anagramUtil = new AnagramUtil();
	
	public void testNullStrings() throws Exception {
		String str1 = "";
		assertTrue(anagramUtil.isAnagram(null, null));
		assertFalse(anagramUtil.isAnagram(str1.toCharArray(), null));
		assertFalse(anagramUtil.isAnagram(null, str1.toCharArray()));
	}
	
	public void testEmptyStrings() throws Exception {
		String str1 = "";
		String str2 = "";
		String str3 = "a";
		assertTrue(anagramUtil.isAnagram(str1.toCharArray(), str2.toCharArray()));
		assertFalse(anagramUtil.isAnagram(str1.toCharArray(), str3.toCharArray()));
	}

	public void testSingleCharacter() throws Exception {
		String str1 = "a";
		String str2 = "a";
		String str3 = "b";
		assertTrue(anagramUtil.isAnagram(str1.toCharArray(), str1.toCharArray()));
		assertTrue(anagramUtil.isAnagram(str1.toCharArray(), str2.toCharArray()));
		assertTrue(anagramUtil.isAnagram(str2.toCharArray(), str1.toCharArray()));
		assertFalse(anagramUtil.isAnagram(str2.toCharArray(), str3.toCharArray()));
		assertFalse(anagramUtil.isAnagram(str3.toCharArray(), str2.toCharArray()));
	}
	
	public void testTwoCharacters() throws Exception {
		String str1 = "a";
		String str2 = "ab";
		String str3 = "ba";
		assertTrue(anagramUtil.isAnagram(str2.toCharArray(), str2.toCharArray()));
		assertTrue(anagramUtil.isAnagram(str2.toCharArray(), str3.toCharArray()));
		assertTrue(anagramUtil.isAnagram(str3.toCharArray(), str2.toCharArray()));
		assertFalse(anagramUtil.isAnagram(str1.toCharArray(), str2.toCharArray()));
		assertFalse(anagramUtil.isAnagram(str2.toCharArray(), str1.toCharArray()));
	}
	
	public void testMissingCharacters() throws Exception {
		String str1 = "ab";
		String str2 = "ac";
		String str3 = "bc";
		assertFalse(anagramUtil.isAnagram(str1.toCharArray(), str2.toCharArray()));
		assertFalse(anagramUtil.isAnagram(str1.toCharArray(), str3.toCharArray()));
		assertFalse(anagramUtil.isAnagram(str2.toCharArray(), str3.toCharArray()));
	}
	
	public void testUnsupportedCharacters() throws Exception {
		String str1 = "ab";
		String str2 = "a.b";
		String str3 = "b a";
		assertTrue(anagramUtil.isAnagram(str1.toCharArray(), str2.toCharArray()));
		assertTrue(anagramUtil.isAnagram(str1.toCharArray(), str3.toCharArray()));
		assertTrue(anagramUtil.isAnagram(str2.toCharArray(), str3.toCharArray()));
	}
	
	public void testCaseInsensitive() throws Exception {
		String str1 = "ab";
		String str2 = "aB";
		String str3 = "Ba";
		String str4 = "BA";
		assertTrue(anagramUtil.isAnagram(str1.toCharArray(), str2.toCharArray()));
		assertTrue(anagramUtil.isAnagram(str1.toCharArray(), str3.toCharArray()));
		assertTrue(anagramUtil.isAnagram(str1.toCharArray(), str4.toCharArray()));
	}
	
	public void testLongStrings() throws Exception {
		String str1 = "'That's one small step for a man; one giant leap for mankind.' Neil Armstrong";
		String str2 = "thin man ran... makes a large stride... left planet... pins flag on moon... on to Mars";
		assertTrue(anagramUtil.isAnagram(str1.toCharArray(), str2.toCharArray()));
	}

}
