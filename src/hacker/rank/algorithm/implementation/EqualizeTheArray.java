/**
 * 
 */
package hacker.rank.algorithm.implementation;

import java.util.TreeSet;

/**
 * @author Administrador
 *
 */
public class EqualizeTheArray {

	public static int equalizeArray(int[] arr) {

		int max = getMaximumNumberRepetition(arr);
		TreeSet<Integer> numbers = new TreeSet<>();
		int numbersToDelete = 0;

		for (int i = 0; i < arr.length; i++) {
			numbers.add(arr[i]);
			if (arr[i] != max) {
				numbersToDelete++;
			}
		}
		if (numbers.size() == arr.length) {
			return arr.length - 1;
		}
		return numbersToDelete;

	}

	private static int getMaximumNumberRepetition(int arr[]) {
		int[] count = new int[101];
		int maxIndex = 0;
		for (int i = 0; i < arr.length; i++) {
			count[arr[i]] += 1;
			if (count[maxIndex] < count[arr[i]]) {
				maxIndex = arr[i];
			}
		}
		return maxIndex;
	}

	public static void main(String[] args) {
		System.out.println(equalizeArray(new int[] { 3, 3, 2, 1, 3 }));
		System.out.println(equalizeArray(new int[] { 24, 29, 70, 43, 12, 27, 29, 24, 41, 12, 41, 43, 24, 70, 24, 100, 41, 43, 43 ,100, 29, 70, 100, 43, 41, 27, 70, 70, 59, 41, 24, 24, 29, 43, 24, 27, 70, 24, 27, 70, 24, 70, 27, 24, 43, 27 ,100, 41, 12, 70, 43, 70, 62, 12, 59, 29, 62, 41, 100, 43, 43, 59, 59, 70, 12, 27, 43, 43, 27, 27, 27, 24, 43, 43, 62, 43, 70, 29}));

	}

}
