/**
 * 
 */
package rank.hacker.cracking_the_coding_interview;

import java.util.Scanner;

/**
 * @author apobits@gmail.com
 *
 */
public class BubbleSort {

    private int[] bubbleSort(int[] a) {
	boolean isSorted = false;
	int lastSortedIndex = a.length - 1, swaps = 0;
	while (!isSorted) {
	    isSorted = true;
	    for (int i = 0; i < lastSortedIndex; i++) {
		if (a[i] > a[i + 1]) {
		    int temp = a[i];
		    a[i] = a[i + 1];
		    a[i + 1] = temp;
		    isSorted = false;
		    swaps++;
		}
	    }
	}

	System.out.println("Array is sorted in " + swaps + " swaps.");
	System.out.println("First Element: " + a[0]);
	System.out.println("Last Element: " + a[a.length - 1]);
	return a;
    }

    public static void main(String[] args) {

	try (Scanner scan = new Scanner(System.in)) {
	    int n = scan.nextInt();
	    int[] a = new int[n];
	    for (int i = 0; i < n; i++) {
		a[i] = scan.nextInt();
	    }
	    new BubbleSort().bubbleSort(a);
	}

    }

}
