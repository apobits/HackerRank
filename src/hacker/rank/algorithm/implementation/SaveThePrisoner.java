/**
 * 
 */
package hacker.rank.algorithm.implementation;

import java.util.Scanner;

/**
 * @author apobits@gmail.com
 *
 */
public class SaveThePrisoner {

    /**
     * @param args
     */
    public static void main(String[] args) {

	try (Scanner scan = new Scanner(System.in)) {
	    long init = System.currentTimeMillis();
	    int t = scan.nextInt();
	    int n = 0, m = 0, s = 0;
	    for (int i = 0; i < t; i++) {
		n = scan.nextInt();
		m = scan.nextInt();
		s = scan.nextInt();
		if ((((m + s) - 1) % n == 0)) {
		    System.out.println(n);
		} else {
		    System.out.println(((m + s) - 1) % n);
		}

	    }
	    System.out.println("miliseconds " + (System.currentTimeMillis() - init));
	}

    }

}
