/**
 * 
 */
package hacker.rank.algorithm.implementation;

import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.TreeSet;

public class ClimbingTheLeaderboard {

    private static void printRank(int score, TreeSet<Integer> scores) {
	try {
	    while (score > scores.last()) {
		scores.pollLast();
	    }
	    if (scores.last() != score)
		System.out.println(scores.size() + 1);
	    else
		System.out.println(scores.size());
	} catch (NoSuchElementException e) {
	    System.out.println(1);
	}

    }

    public static void main(String[] args) {

	try (Scanner scan = new Scanner(System.in)) {
	    int n = scan.nextInt() + 1;
	    TreeSet<Integer> scores = new TreeSet<>((t, r) -> r - t);

	    for (int i = 0; i < n - 1; i++) {
		scores.add(scan.nextInt());
	    }
	    int m = scan.nextInt();
	    for (int i = 0; i < m; i++) {
		printRank(scan.nextInt(), scores);
	    }

	}

    }

}
