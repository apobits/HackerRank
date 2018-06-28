/**
 * 
 */
package hacker.rank.algorithm.implementation;

import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * @author apobits@gmail.com
 *
 */
public class NonDivisibleSubset {

    public static int getSubset(int x[], int k) {
	TreeMap<Integer, Integer> optionals = new TreeMap<>();
	TreeSet<Integer> subset = new TreeSet<>();
	int max = 0;
	for (int i = 0; i < x.length; i++) {
	    int count = 0;
	    for (int j = 0; j < x.length; j++) {
		if (i != j && ((x[i] + x[j]) % k != 0)) {
		    count++;
		}
	    }
	    optionals.put(count, x[i]);
	}
	max = optionals.get(optionals.lastKey());
	TreeSet<Integer> e = new TreeSet<>();
	e.add(max);
	for (int i = 0; i < x.length; i++) {
	    int count = 0;
	    for (int j = 0; j < x.length; j++) {
		if (i != j && ((x[i] + x[j]) % k != 0)) {
		    count++;
		}
	    }
	    if (count == optionals.lastKey()) {
		e.add(x[i]);
	    }
	}

	while (!e.isEmpty()) {
	    int value = e.pollFirst();
	    for (int i = 0; i < x.length; i++) {
		TreeSet<Integer> temp = new TreeSet<>();
		temp.add(value);
		for (int j = 0; j < x.length; j++) {
		    if (i != j && x[j] != value && (x[j] + value) % k != 0 && canAdd(temp, x[j], k)) {
			temp.add(x[j]);
		    }
		}
		subset.add(temp.size());
	    }
	}

	return subset.size() != 0 ? subset.last() : 1;
    }

    private static boolean canAdd(TreeSet<Integer> values, int number, int k) {
	Iterator<Integer> iterator = values.iterator();
	while (iterator.hasNext()) {
	    int temp = iterator.next();
	    if ((temp + number) % k == 0) {
		return false;
	    }
	}
	return true;
    }

    public static void main(String[] args) {
	try (Scanner scan = new Scanner(System.in)) {
	    int n = scan.nextInt();
	    int k = scan.nextInt();
	    int x[] = new int[n];
	    for (int i = 0; i < n; i++) {
		x[i] = scan.nextInt();
	    }
	    System.out.println(getSubset(x, k));
	}

    }

}
