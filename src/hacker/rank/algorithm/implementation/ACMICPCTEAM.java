/**
 * 
 */
package hacker.rank.algorithm.implementation;

import java.util.Scanner;
import java.util.TreeMap;

/**
 * @author aposo
 *
 */
public class ACMICPCTEAM {

	static int[] acmTeam(String[] participantsKnowledge) {
		int[] result = new int[2];
		TreeMap<Integer, Integer> results = new TreeMap<>();

		for (int i = 0; i < participantsKnowledge.length; i++) {
			for (int j = i + 1; j < participantsKnowledge.length; j++) {
				int topics = 0;
				for (int k = 0; k < participantsKnowledge[j].length(); k++) {
					if (participantsKnowledge[i].charAt(k) == '1' || participantsKnowledge[j].charAt(k) == '1') {
						topics++;
					}
				}
				if (results.containsKey(topics)) {
					results.put(topics, results.get(topics) + 1);
				} else {
					results.put(topics, 1);
				}
			}
		}

		result[0] = results.lastKey();
		result[1] = results.get(results.lastKey());
		return result;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		try (Scanner scanner = new Scanner(System.in)) {
			int participants = scanner.nextInt();
			scanner.nextLine();
			String[] participantsKnowledge = new String[participants];
			for (int i = 0; i < participants; i++) {
				participantsKnowledge[i] = scanner.nextLine();
			}
			int[] result = acmTeam(participantsKnowledge);
			System.out.println(result[0] + "\n" + result[1]);
		}
	}

}
