/**
 * 
 */
package rank.hacker.cracking_the_coding_interview;

import java.util.Scanner;

import rank.hacker.cracking_the_coding_interview.MergeSort.CounterWrapper;

/**
 * @author apobits@gmail.com
 *
 */
public class MergeSortCountingInversions {

    public static void printInversions(int[] x) {
	MergeSort ms = new MergeSort();
	CounterWrapper counter = ms.new CounterWrapper();
	ms.mergeSort(x, counter);
	System.out.println(counter.count == 0 ? 0 : counter.count + 1);
    }

    public static void main(String[] args) {

	try (Scanner scan = new Scanner(System.in)) {
	    int arraysNumber = scan.nextInt();

	    for (int i = 0; i < arraysNumber; i++) {
		int arraySize = scan.nextInt();
		int[] arrayTemp = new int[arraySize];
		for (int j = 0; j < arraySize; j++) {
		    arrayTemp[j] = scan.nextInt();
		}
		printInversions(arrayTemp);
	    }
	}

    }

}
