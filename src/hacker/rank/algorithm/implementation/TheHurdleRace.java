package hacker.rank.algorithm.implementation;

import java.util.Scanner;

public class TheHurdleRace {

    public static void main(String args[]) {
	try (Scanner scan = new Scanner(System.in)) {

	    int n = scan.nextInt();
	    int k = scan.nextInt();
	    int temp = 0;
	    int beverages = 0;

	    for (int i = 0; i < n; i++) {
		temp = scan.nextInt();
		if (k < temp) {
		    beverages += temp - k;
		    k = temp;
		}
	    }
	    System.out.println(beverages);
	}
    }

}
