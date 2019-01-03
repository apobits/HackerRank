/**
 * 
 */
package hacker.rank.interview_preparation_kit.arrays;

/**
 * @author aposo
 *
 */
public class ArrayManipulation {

	static long arrayManipulation(int n, int[][] queries) {
		long array[] = new long[n];
		long max = 0;
		for (int i = 0; i < queries.length; i++) {
			int left = queries[i][0];
			int right = queries[i][1];
			int value = queries[i][2];
			for (int j = left - 1; j < right; j++) {
				array[j] = array[j] + value;
				if (array[j] > max) {
					max = array[j];
				}
			}
		}

		return max;

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(arrayManipulation(10, new int[][] { { 1, 5, 3 }, { 4, 8, 7 }, { 6, 9, 1 } }));
	}

}
