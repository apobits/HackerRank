/**
 * 
 */
package hacker.rank.algorithm.implementation;

import java.util.Scanner;

/**
 * @author Administrador
 *
 */
public class BreakingTheRecords {

    public static void main(String[] args) {
	int maxRecord = 0, minRecord = 0, maxCount = 0, minCount = 0, temp = 0;
	try (Scanner scan = new Scanner(System.in)) {
	    int scores = scan.nextInt();

	    for (int i = 0; i < scores; i++) {
		temp = scan.nextInt();
		if (i == 0) {
		    minRecord = temp;
		    maxRecord = temp;
		}
		if (temp > maxRecord) {
		    maxCount++;
		    maxRecord = temp;
		} else if (temp < minRecord) {
		    minCount++;
		    minRecord = temp;
		}
	    }
	}
	System.out.println(maxCount + " " + minCount);
    }
}
