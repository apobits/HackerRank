/**
 * 
 */
package hacker.rank.algorithm.implementation;

import java.util.Scanner;

/**
 * @author apobits@gmail.com
 *
 */
public class ViralAdvertising {

    /**
     * @param args
     */
    public static void main(String[] args) {

	try (Scanner scan = new Scanner(System.in)) {
	    int days = scan.nextInt();
	    int m = 5;
	    int likes = 0;
	    int temp = 0;
	    for (int i = 0; i < days; i++) {
		temp = Math.floorDiv(m, 2);
		likes += temp;
		m = (temp * 3);
	    }
	    System.out.println(likes);
	}

    }

}
