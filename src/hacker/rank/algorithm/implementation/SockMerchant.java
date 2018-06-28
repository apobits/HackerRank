/**
 * 
 */
package hacker.rank.algorithm.implementation;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Administrador
 *
 */
public class SockMerchant {

    public static void main(String[] args) {
	try (Scanner scan = new Scanner(System.in)) {
	    int n = scan.nextInt();
	    int[] c = new int[n];
	    for (int i = 0; i < n; i++) {
		c[i] = scan.nextInt();
	    }
	    Arrays.sort(c);
	    int pairsNumber = 0;

	    for (int i = 0; i < n; i++) {
		if (i + 1 < n && c[i] == c[i + 1]) {
		    pairsNumber++;
		    i += 1;
		}
	    }

	    System.out.println(pairsNumber);
	}
    }

}
