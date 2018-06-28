package hacker.rank.algorithm.implementation;

import java.util.Scanner;
import java.util.TreeSet;

public class ElectronicShop {

    public static void main(String[] args) {

	try (Scanner scan = new Scanner(System.in)) {
	    int s = scan.nextInt();
	    int n = scan.nextInt();
	    int m = scan.nextInt();
	    int nn[] = new int[n];
	    int mm[] = new int[m];

	    for (int i = 0; i < n; i++) {
		nn[i] = scan.nextInt();
	    }

	    for (int i = 0; i < m; i++) {
		mm[i] = scan.nextInt();
	    }
	    TreeSet<Integer> amounts = new TreeSet<>();
	    for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
		    amounts.add(nn[i] + mm[j]);
		}
	    }
	    Integer temp;
	    while ((temp = amounts.pollLast()) != null) {
		if (temp <= s) {
		    System.out.println(temp);
		    return;
		}
	    }
	    System.out.println(-1);
	}
    }

}
