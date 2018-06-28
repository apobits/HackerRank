/**
 * 
 */
package hacker.rank.algorithm.implementation;

import java.util.Scanner;

/**
 * @author Administrador
 *
 */
public class DivisibleSumPairs {

    public static void main(String[] args) {
	try (Scanner scan = new Scanner(System.in)) {
	    int count = 0;
	    int n = scan.nextInt();
	    int k = scan.nextInt();
	    int[] a = new int[n];

	    for (int i = 0; i < n; i++) {
		a[i] = scan.nextInt();
	    }

	    for (int i = 0; i < n; i++) {
		for (int j = i + 1; j < n; j++) {
		    if (((a[i] + a[j]) % k == 0)) {
			count++;
		    }
		}
	    }
	    System.out.println(count);
	}
    }

}
