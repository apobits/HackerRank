/**
 * 
 */
package hacker.rank.datastructures.stacks;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * @author apobits@gmail.com
 *
 */
public class MaximumElement {

	private static LinkedList<Integer> ll = new LinkedList<>();
	private static TreeSet<Integer> orderElements = new TreeSet<>();

	public static void main(String[] args) {

		try (Scanner scanner = new Scanner(System.in)) {
			int queries = scanner.nextInt();
			for (int i = 0; i < queries; i++) {
				int operation = scanner.nextInt();
				if (operation == 1) {
					int temp = scanner.nextInt();
					orderElements.add(temp);
					ll.push(temp);
				} else if (operation == 2) {
					int temp = ll.pop();
					if (!ll.contains(temp)) {
						orderElements.remove(temp);
					}
				} else if (operation == 3) {
					System.out.println(orderElements.last());
				}
			}
		}
	}

}
