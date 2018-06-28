/**
 * 
 */
package hacker.rank.algorithm.implementation;

import java.util.Scanner;

/**
 * @author apobits@gmail.com
 *
 */
public class JumpingOnTheClouds_Revisited {

    static int cloudCost(int cloud) {
	if (cloud == 0) {
	    return 1;
	} else {
	    return 3;
	}
    }

    /**
     * @param args
     */
    public static void main(String[] args) {

	try (Scanner scan = new Scanner(System.in)) {

	    int clouds = scan.nextInt();
	    int jump = scan.nextInt();
	    int cloud[] = new int[clouds];
	    for (int i = 0; i < clouds; i++) {
		cloud[i] = scan.nextInt();
	    }
	    int i = 0;
	    int e = 100;
	    do {

		// process jump
		if (i + jump > clouds - 1) {
		    i = ((i + jump) - clouds);
		} else {
		    i += jump;
		}

		// process energy
		e -= cloudCost(cloud[i]);
	    } while (i != 0);

	    System.out.println(e);
	}

    }

}
