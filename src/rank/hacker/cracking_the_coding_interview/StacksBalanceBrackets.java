/**
 * 
 */
package rank.hacker.cracking_the_coding_interview;

import java.util.Scanner;

/**
 * @author apobits@gmail.com
 *
 */
public class StacksBalanceBrackets {

    public static void main(String[] args) {

	try (Scanner scan = new Scanner(System.in)) {
	    int n = scan.nextInt();

	    for (int i = 0; i < n; i++) {
		String s = scan.next();
		do {
		    int length = s.length();
		    s = s.replace("{}", "");
		    s = s.replace("[]", "");
		    s = s.replace("()", "");
		    if (length == s.length()) {
			break;
		    }
		} while (s.length() != 0);
		if (s.length() == 0) {
		    System.out.println("YES");
		} else {
		    System.out.println("NO");
		}
	    }
	}
    }
}
