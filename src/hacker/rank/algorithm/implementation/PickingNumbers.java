package hacker.rank.algorithm.implementation;

import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;

public class PickingNumbers {

    public static void main(String[] args) {

	try (Scanner scan = new Scanner(System.in)) {
	    int size = scan.nextInt();
	    int[] numbers = new int[size];
	    TreeMap<Integer, Integer> filteredNumbers = new TreeMap<>();
	    TreeSet<Integer> amounts = new TreeSet<>();
	    for (int i = 0; i < size; i++) {
		numbers[i] = scan.nextInt();
	    }

	    for (int i = 0; i < size; i++) {
		filteredNumbers.put(numbers[i], filteredNumbers.get(numbers[i]) != null ? filteredNumbers.get(numbers[i]) + 1 : 1);
	    }

	    Integer[] values = new Integer[filteredNumbers.size()];
	    values = filteredNumbers.keySet().toArray(values);

	    for (int i = 0; i < values.length; i++) {
		if (i + 1 != values.length && Math.abs(values[i] - values[i + 1]) <= 1)
		    amounts.add(filteredNumbers.get(values[i]) + filteredNumbers.get(values[i + 1]));
		else if (filteredNumbers.get(values[i]) > 1) {
		    amounts.add(filteredNumbers.get(values[i]));
		}
	    }

	    System.out.println(amounts.last());
	} catch (Exception e) {
	    e.printStackTrace();
	}
    }
}
