/**
 * 
 */
package hacker.rank.algorithm.implementation;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author Administrador
 *
 */
public class MigratoryBirds {

    public static void main(String[] args) throws FileNotFoundException {
	try (Scanner scan = new Scanner(new File("C:\\Users\\Administrador\\Desktop\\input04.txt"))) {
	    int[] counter = new int[5];
	    int birdsNumber = scan.nextInt();
	    for (int i = 0; i < birdsNumber; i++) {
		switch (scan.nextInt()) {
		case 1:
		    counter[0] += 1;
		    break;
		case 2:
		    counter[1] += 1;
		    break;
		case 3:
		    counter[2] += 1;
		    break;
		case 4:
		    counter[3] += 1;
		    break;
		case 5:
		    counter[4] += 1;
		    break;
		}
	    }

	    int max = 0;

	    for (int i = 0; i < 5; i++) {
		if (max < counter[i]) {
		    max = counter[i];
		}
	    }

	    for (int i = 0; i < 5; i++) {
		if (counter[i] == max) {
		    System.out.println(i + 1);
		    break;
		}
	    }
	}

    }

}
