/**
 * 
 */
package hacker.rank.algorithm.implementation;

import java.util.Scanner;

/**
 * @author Administrador
 *
 */
public class Kangaroo {

    /**
     * @param args
     */
    public static void main(String[] args) {
	Scanner scan = new Scanner(System.in);
	int x1 = scan.nextInt();
	int v1 = scan.nextInt();
	int x2 = scan.nextInt();
	int v2 = scan.nextInt();
	scan.close();

	if (v1 < v2) {
	    System.out.println("NO");
	} else if ((v1 - v2 != 0) && ((x1 - x2) % (v1 - v2)) == 0) {
	    System.out.println("YES");
	} else {
	    System.out.println("NO");
	}
    }

}
