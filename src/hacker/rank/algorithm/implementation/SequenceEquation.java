/**
 * 
 */
package hacker.rank.algorithm.implementation;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @author apobits@gmail.com
 *
 */
public class SequenceEquation {

    /**
     * @param args
     */
    public static void main(String[] args) {

	try (Scanner scan = new Scanner(System.in)) {

	    int n = scan.nextInt();
	    HashMap<Integer, Integer> map = new HashMap<>();
	    int temp = 0;

	    for (int i = 0; i < n; i++) {
		temp = scan.nextInt();
		map.put(temp, i + 1);
	    }

	    for (int i = 0; i < n; i++) {
		System.out.println(map.get(map.get(i + 1)));
	    }

	}

    }

}
