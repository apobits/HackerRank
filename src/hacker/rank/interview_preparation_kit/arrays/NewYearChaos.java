/**
 * 
 */
package hacker.rank.interview_preparation_kit.arrays;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @author aposo
 *
 */
public class NewYearChaos {

	static void minimumBribes(int[] q) {
		try {
			boolean flag = false;
			int bribes = 0;
			HashMap<Integer, Integer> bribeCounter = new HashMap<>();
			while (!flag) {
				int j = 0;
				for (int i = 0; i < q.length - 1; i++) {
					if (q[i] > q[i + 1]) {
						j++;
						if (bribeCounter.containsKey(q[i])) {
							if (bribeCounter.get(q[i]) > 1) {
								throw new Exception("Too chaotic");
							}
							bribeCounter.put(q[i], bribeCounter.get(q[i]) + 1);
						} else {
							bribeCounter.put(q[i], 1);
						}
						bribes++;
						int temp = q[i];
						q[i] = q[i + 1];
						q[i + 1] = temp;
					}
				}
				if (j == 0) {
					flag = true;
				}
			}
			System.out.println(bribes);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		try (Scanner scanner = new Scanner(System.in)) {

			int testCases = scanner.nextInt();

			for (int i = 0; i < testCases; i++) {
				int people = scanner.nextInt();
				int queue[] = new int[people];
				for (int j = 0; j < people; j++) {
					queue[j] = scanner.nextInt();
				}
				minimumBribes(queue);
			}
		}

	}

}
