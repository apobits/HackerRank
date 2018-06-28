/**
 * 
 */
package hacker.rank.algorithm.implementation;

import java.util.Scanner;
import java.util.TreeSet;

/**
 * @author apobits@gmail.com
 *
 */
public class CutTheSticks {

    private static void process(int[] x, int lower) {
	while (true) {
	    TreeSet<Integer> same = new TreeSet<>();
	    TreeSet<Integer> available = new TreeSet<>();
	    int count = 0;
	    for (int i = 0; i < x.length; i++) {
		// deducts the lower value
		if (x[i] > 0) {
		    x[i] -= lower;
		    count++;
		    same.add(x[i]);
		    if (x[i] != 0) {
			available.add(x[i]);
		    }
		}
	    }
	    if (same.size() <= 1) {
		System.out.println(count);
		return;
	    }
	    lower = available.first();
	    System.out.println(count);
	}
    }

    public static void main(String[] args) {
	try (Scanner scan = new Scanner(System.in)) {
	    int n = scan.nextInt();
	    int x[] = new int[n];
	    int lower = 1000;
	    for (int i = 0; i < n; i++) {
		x[i] = scan.nextInt();
		if (x[i] < lower) {
		    lower = x[i];
		}
	    }
	    process(x, lower);
	}
    }

}
