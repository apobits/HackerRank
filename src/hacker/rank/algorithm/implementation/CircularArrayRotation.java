/**
 * 
 */
package hacker.rank.algorithm.implementation;

import java.util.Scanner;

/**
 * @author apobits@gmail.com
 *
 */
public class CircularArrayRotation {

    /**
     * @param args
     */
    public static void main(String[] args) {

	try (Scanner scan = new Scanner(System.in)) {

	    int n = scan.nextInt();
	    int k = scan.nextInt();
	    int q = scan.nextInt();
	    int a[] = new int[n];
	    for (int i = 0; i < n; i++) {
		a[i] = scan.nextInt();
	    }

	    for (int i = 0; i < q; i++) {
		int temp = scan.nextInt();
		int index = (n - (k % n)) + temp;
		if (index >= n) {
		    index -= n;
		}
		System.out.println(a[index]);
	    }

	}

    }

}
