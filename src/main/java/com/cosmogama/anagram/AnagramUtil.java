package com.cosmogama.anagram;

import org.springframework.stereotype.Component;


/**
 * Contains helper methods to operate on Anagrams.
 * 
 * @Author Tony Myers
 */
@Component
public class AnagramUtil {
	
	/**
	 * Returns true if the two given character sequences are anagrams of each other.
	 * 
	 * Algorithm has a worst runtime of O(n) and a space efficiency of O(n). 
	 * 
	 * @param str1 character sequence 1 to compare
	 * @param str2 character sequence 2 to compare
	 * @return true if the two given character sequences are anagrams of each other.
	 */
	public boolean isAnagram(char[] chars1, char[] chars2){
		
		// just in case
		if( chars1 == null && chars2 == null ){
			return true;
		}
		
		// one is null and the other is not
		if( chars1 == null || chars2 == null ){
			return false;
		}
		
		return countsAreAnagrams(calculateCounts(chars1), calculateCounts(chars2));
	}
	
	/**
	 * Takes a character sequence of arbitrary character ordering and
	 * returns the counts of each character observed.
	 * 
	 * Algorithm has a worst runtime of O(n) and a space efficiency of O(n).
	 * 
	 * Different solution comparison:
	 * using integer arrays - has a worst runtime of O(n)
	 * using a hashmap of character to count - has a worst runtime of O(n^2) 
	 *   because hashmaps have a worst search of O(n) and must be search 
	 *   n times when looping over each character.
	 * 
	 * @param str character sequence to calculate the counts
	 * @return 	array of integers where the indices represent
	 * 			the character and the value represents the 
	 * 			number of times that character is present in the character sequence.
	 */
	public int[] calculateCounts(char[] chars){
		
		final int NUM_LETTERS = 26;
		final int UPPERCASE_MIN = 65; // uppercase ascii characters range from 65 to 90
		final int UPPERCASE_MAX = 90; // uppercase ascii characters range from 65 to 90
		final int LOWERCASE_MIN = 97; // lowercase ascii characters range from 97 to 122
		final int LOWERCASE_MAX = 122; // lowercase ascii characters range from 97 to 122
		final int UPPERCASE_LOWERCASE_OFFSET = LOWERCASE_MIN - UPPERCASE_MIN;
				
		// counts to return
		int[] counts = new int[NUM_LETTERS]; // java automatically zero-fills integer arrays

		for(char c : chars){ // O(n) to loop through characters
			
			if( c =='\n' ){
				break;
			}
			
			// O(1) convert character from uppercase to lowercase
			if( c >= UPPERCASE_MIN && c <= UPPERCASE_MAX ){
				c += UPPERCASE_LOWERCASE_OFFSET;
			}
			
			// O(1) reject non-alpha characters
			if( c < LOWERCASE_MIN || c > LOWERCASE_MAX ){
				continue;
			}
			
			int index = c - LOWERCASE_MIN; // O(1)
			
			counts[index]++; // O(1)
		}
		
		return counts;
	}

	/**
	 * Determines if two character counts arrays are the same, ie have the same counts for each charater.
	 * 
	 * I would consider this to be a constant runtime O(1) because as 'n' grows, the performance of this method will stay static
	 * because the number of characters in the English language is fixed.
	 * 
	 * @param counts1 previously calculated character counts for character sequence 1
	 * @param counts2 previously calculated character counts for character sequence 2
	 * @return true if the two counts arrays are the same, false otherwise.
	 */
	public boolean countsAreAnagrams(int[] counts1, int[] counts2){
		for(int i=0; i<counts1.length; i++){
			if( counts1[i] != counts2[i] ){ // O(1)
				return false;
			}
		}
		
		return true;
	}
}
