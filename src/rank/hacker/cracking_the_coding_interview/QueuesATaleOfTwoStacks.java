/**
 * 
 */
package rank.hacker.cracking_the_coding_interview;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author apobits@gmail.com
 *
 */
public class QueuesATaleOfTwoStacks {

    /**
     * @param args
     */
    public static void main(String[] args) {

	// try (Scanner scan = new Scanner(System.in)) {
	// LinkedList<Integer> ll = new LinkedList<>();
	// int q = scan.nextInt();
	// for (int i = 0; i < q; i++) {
	// int temp = scan.nextInt();
	// if (temp == 1) {
	// ll.add(scan.nextInt());
	// } else if (temp == 2) {
	// ll.removeFirst();
	// } else if (temp == 3) {
	// System.out.println(ll.peek());
	// }
	// }
	// }

	try (Scanner scan = new Scanner(System.in)) {
	    Stack<Integer> stack1 = new Stack<>();
	    int q = scan.nextInt();
	    for (int i = 0; i < q; i++) {
		int temp = scan.nextInt();
		if (temp == 1) {
		    stack1.push(scan.nextInt());
		} else if (temp == 2) {
		    stack1.remove(0);
		} else if (temp == 3) {
		    System.out.println(stack1.get(0));
		}
	    }
	}

    }

}
