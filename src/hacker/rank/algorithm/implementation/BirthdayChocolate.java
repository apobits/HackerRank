/**
 * 
 */
package hacker.rank.algorithm.implementation;

import java.util.Scanner;

/**
 * @author Administrador
 *
 */
public class BirthdayChocolate {

    public static void main(String[] args) {
	try (Scanner scan = new Scanner(System.in)) {
	    int squaresLength = scan.nextInt();
	    int[] squares = new int[squaresLength];
	    for (int i = 0; i < squaresLength; i++) {
		squares[i] = scan.nextInt();
	    }
	    int day = scan.nextInt();
	    int month = scan.nextInt();
	    int count = 0, countTemp;
	    for (int i = 0; i < squaresLength; i++) {
		if (i + month <= squaresLength) {
		    countTemp = 0;
		    for (int j = i; j < month + i; j++) {
			countTemp += squares[j];
		    }
		    if (countTemp == day)
			count++;
		}
	    }
	    System.out.println(count);
	}
    }
}
