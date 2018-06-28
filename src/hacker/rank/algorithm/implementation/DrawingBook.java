/**
 * 
 */
package hacker.rank.algorithm.implementation;

import java.util.Scanner;

/**
 * @author Administrador
 *
 */
public class DrawingBook {

    public static void main(String[] args) {
	try (Scanner scan = new Scanner(System.in)) {
	    int n = scan.nextInt();
	    int p = scan.nextInt();
	    if (p == 1 || p == n) {
		System.out.println(0);
		return;
	    }
	    int front = p % 2 == 0 ? p / 2 : (p - 1) / 2;
	    int back = p % 2 == 0 ? (n - p) / 2 : ((n - p) + 1) / 2;
	    if (front < back) {
		System.out.println(front);
	    } else {
		System.out.println(back);
	    }
	}

    }

}
