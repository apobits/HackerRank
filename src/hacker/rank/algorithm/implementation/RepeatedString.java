/**
 * 
 */
package hacker.rank.algorithm.implementation;

/**
 * @author apobits@gmail.com
 *
 */
public class RepeatedString {

    public static long getCount(String s, long length) {
	long count = length / s.length();
	long wordCount = 0;
	String left = s.substring(0, (int) (length - (count * s.length())));

	for (int i = 0; i < s.length(); i++) {
	    if (s.charAt(i) == 'a') {
		wordCount++;
	    }
	}

	wordCount *= count;

	for (int i = 0; i < left.length(); i++) {
	    if (s.charAt(i) == 'a') {
		wordCount++;
	    }
	}

	return wordCount;

    }

    public static void main(String[] args) {

	System.out.println(getCount("abcac", 10));

    }

}
