/**
 * 
 */
package hacker.rank.algorithm.implementation;

import java.util.Scanner;

/**
 * @author apobits@gmail.com
 *
 */
public class SherlockAndSquares {

    public static void main(String[] args) {
	long initTime = System.currentTimeMillis();
	try (Scanner scan = new Scanner(System.in)) {
	    int tests = scan.nextInt();
	    for (int i = 0; i < tests; i++) {
		int start = scan.nextInt();
		int end = scan.nextInt();
		double startSqr = 0, endSqr;
		while (!String.valueOf(Math.sqrt(start)).matches("\\d+.0")) {
		    start++;
		}

		while (!String.valueOf(Math.sqrt(end)).matches("\\d+.0")) {
		    end--;
		}
		startSqr = Math.sqrt(start);
		endSqr = Math.sqrt(end);

		System.out.println((int) (endSqr - startSqr) + 1);
	    }
	}
	System.out.println(System.currentTimeMillis() - initTime);
    }
}
