/**
 * 
 */
package hacker.rank.algorithm.implementation;

import java.util.Scanner;

/**
 * @author Administrador
 *
 */
public class CountingValleys {

    public static void main(String[] args) {

	try (Scanner scan = new Scanner(System.in)) {

	    int n = scan.nextInt();
	    String step = scan.next();
	    char[] steps = step.toCharArray();
	    boolean flag = false;
	    int count = 0, actualStep = 0;

	    for (int i = 0; i < n; i++) {
		if (actualStep == 0 && flag) {
		    count++;
		    flag = false;
		}

		if (steps[i] == 'U') {
		    actualStep++;
		} else if (steps[i] == 'D') {
		    if (actualStep == 0) {
			flag = true;
		    }
		    actualStep--;
		}
	    }
	    if (actualStep == 0 && flag) {
		count++;
	    }
	    System.out.println(count);
	}

    }

}
