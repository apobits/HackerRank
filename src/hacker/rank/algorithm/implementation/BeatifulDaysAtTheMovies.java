package hacker.rank.algorithm.implementation;

import java.util.Scanner;

public class BeatifulDaysAtTheMovies {

    public static int reverseNumber(int number) {
	String numberS = String.valueOf(number);
	int size = numberS.length();
	StringBuffer sb = new StringBuffer();
	while (size > 0) {
	    sb.append(numberS.charAt(size - 1));
	    size--;
	}
	return Integer.valueOf(sb.toString());
    }

    public static void main(String args[]) {
	try (Scanner scan = new Scanner(System.in)) {
	    int i = scan.nextInt();
	    int j = scan.nextInt();
	    int k = scan.nextInt();
	    int count = 0;
	    for (int x = i; x <= j; x++) {
		if (Math.abs(x - reverseNumber(x)) % k == 0) {
		    count++;
		}
	    }
	    System.out.println(count);
	}
    }

}
