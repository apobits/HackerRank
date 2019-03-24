/**
 * 
 */
package hacker.rank.interview_preparation_kit.arrays;

/**
 * @author apobits@gmail.com
 *
 */
public class MinimumSwapsTwo {

	private static int sortAscending(int[] numbers) {
		System.out.println(numbers[0] + " " + numbers[1] + " " + numbers[2] + " " + numbers[3] + " " + numbers[4] + " "
				+ numbers[5] + " " + numbers[6] + " " + numbers[7] + " " + numbers[8] + " " + numbers[9]);

		int result = 0;

		for (int i = 0; i < numbers.length - 1; i++) {

			if (numbers[i] > numbers[i + 1]) {
				for (int j = i + 1; j < numbers.length; j++) {
					if (j == numbers.length - 1) {
						break;
					}
					if (numbers[i] > numbers[j + 1] && numbers[j] > numbers[j + 1]) {
						int temp = numbers[j + 1];
						numbers[j + 1] = numbers[i];
						numbers[i] = temp;
						return 1;
					}
				}
				int temp = numbers[i + 1];
				numbers[i + 1] = numbers[i];
				numbers[i] = temp;
				return 1;
			}
		}

		return result;
	}

	static int minimumSwaps(int[] numbers) {
		int counter = 0;
		while (sortAscending(numbers) != 0) {
			counter++;
		}
		return counter;
	}

	public static void main(String[] args) {

		int[] numbers = new int[] { 3, 7, 6, 9, 1, 8, 10, 4, 2, 5 };

		System.out.println(minimumSwaps(numbers));
	}

}
