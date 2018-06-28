/**
 * 
 */
package hacker.rank.algorithm.implementation;

import java.util.Scanner;

/**
 * @author Administrador
 *
 */
public class CatsAndAMouse {

    public static void main(String[] args) {
	try (Scanner scan = new Scanner(System.in)) {
	    int queries = scan.nextInt();
	    int cat1 = 0, cat2 = 0, mouse = 0, cd1 = 0, cd2 = 0;
	    String message;
	    for (int i = 0; i < queries; i++) {
		cat1 = scan.nextInt();
		cat2 = scan.nextInt();
		mouse = scan.nextInt();
		message = "";
		cd1 = Math.abs(cat1 - mouse);
		cd2 = Math.abs(cat2 - mouse);
		if (cd1 == cd2) {
		    message = "Mouse C";
		} else if (cd1 < cd2) {
		    message = "Cat A";
		} else {
		    message = "Cat B";
		}
		System.out.println(message);
	    }
	}
    }

}
