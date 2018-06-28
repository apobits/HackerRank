/**
 * 
 */
package hacker.rank.algorithm.implementation;

import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * @author Administrador
 *
 */
public class BetweenTwoSets {
    public static void main(String[] args) {
	Scanner scan = new Scanner(System.in);

	int aLength = scan.nextInt();
	int bLength = scan.nextInt();

	TreeSet<Integer> a = new TreeSet<>();
	TreeSet<Integer> b = new TreeSet<>();

	for (int i = 0; i < aLength; i++) {
	    a.add(scan.nextInt());
	}

	for (int i = 0; i < bLength; i++) {
	    b.add(scan.nextInt());
	}

	scan.close();
	int count = 0;

	int max = a.last() > b.last() ? a.last() : b.last();

	for (int i = 1; i <= max; i++) {
	    boolean countFlag = true;
	    Iterator<Integer> aI = a.iterator();
	    // checks if all elements in a are factors of i
	    while (aI.hasNext()) {
		if (i % aI.next() != 0) {
		    countFlag = false;
		}
	    }
	    // checks that i is factor of all elements in b
	    Iterator<Integer> bI = b.iterator();
	    while (bI.hasNext()) {
		if (bI.next() % i != 0) {
		    countFlag = false;
		}
	    }

	    if (countFlag) {
		count++;
	    }
	}

	System.out.println(count);

    }

}
