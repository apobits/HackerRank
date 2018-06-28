/**
 * 
 */
package hacker.rank.algorithm.implementation;

import java.util.Scanner;

/**
 * @author Administrador
 *
 */
public class BonAppetit {

    public static void main(String[] args) {

	try (Scanner scan = new Scanner(System.in)) {
	    int n = scan.nextInt();
	    int k = scan.nextInt();
	    int[] cost = new int[n];
	    int total = 0;
	    // get the cost of each food
	    for (int i = 0; i < n; i++) {
		cost[i] = scan.nextInt();
		total += cost[i];
	    }

	    int b = scan.nextInt();

	    int notShared = k == 0 ? 0 : cost[k];

	    if ((notShared == 0) && ((total / 2) == b)) {
		System.out.println("Bon Appetit");
	    } else if ((notShared != 0) && (((total / 2) - notShared/2) == b)) {
		System.out.println("Bon Appetit");
	    } else {
		System.out.println(b - ((total/2)-(notShared/2)));
	    }

	}

    }

}
