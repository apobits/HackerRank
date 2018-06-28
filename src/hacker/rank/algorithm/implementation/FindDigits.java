/**
 * 
 */
package hacker.rank.algorithm.implementation;

import java.util.Scanner;

/**
 * @author apobits@gmail.com
 *
 */
public class FindDigits {

    private static int findDigits(Integer number) {
	String s = new String(number.toString());
	int count = 0;
	for (int i = 0; i < s.length(); i++) {
	    if (s.charAt(i) != '0' && number % Integer.valueOf(s.substring(i, i + 1)) == 0) {
		count++;
	    }
	}
	return count;
    }

    public static void main(String[] args) {

	try (Scanner scan = new Scanner(System.in)) {
	    int testCases = scan.nextInt();
	    for (int i = 0; i < testCases; i++) {
		System.out.println(findDigits(scan.nextInt()));
	    }
	}

    }

}
