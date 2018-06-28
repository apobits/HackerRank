/**
 * 
 */
package hacker.rank.algorithm.implementation;

import java.util.Scanner;

/**
 * @author apobits@gmail.com
 *
 */
public class AppendAndDelete {

    private String canBeConvertedOld(String s, String t, int k) {
	int count = 0;
	StringBuilder sb = new StringBuilder(s);
	int length = s.length() > t.length() ? s.length() : t.length();
	for (int i = 0; i < length; i++) {
	    if (s.length() > i && t.length() > i) {
		if (t.charAt(i) != sb.charAt(i)) {
		    count += (s.length() - (i)) + (t.length() - (i));
		    break;
		}
	    } else {
		count += (s.length() - (i)) + (t.length() - (i));
		break;
	    }
	}

	if (count == k) {
	    return "Yes";
	} else {
	    return "No";
	}
    }

    private String canBeConverted(String s, String t, int k) {

	int left = Math.abs(s.length() - t.length());
	int size = s.length() < t.length() ? s.length() : t.length();
	int i = 0;

	for (i = 0; i < size; i++) {
	    if (s.charAt(i) != t.charAt(i)) {
		left += (size - i) * 2;
		break;
	    }
	}

	if (i == 0 && k != size && ((k - left) % 2 == 0 || (k - (left + 1)) % 2 == 0)) {
	    return "Yes";
	}

	if ((k - left) >= 0 && (k - left) % 2 == 0 || (((k - (left + size)) > 0 && (k - (left + size)) % 2 == 0)))
	    return "Yes";
	else
	    return "No";

    }

    public static void main(String[] args) {

	try (Scanner scan = new Scanner(System.in)) {
	    String s = scan.next();
	    String t = scan.next();
	    int k = scan.nextInt();

	    System.out.println(new AppendAndDelete().canBeConverted(s, t, k));

	}

    }

}
