package hacker.rank.algorithm.implementation;

import java.util.Scanner;

public class UtopianTree {

    public static void main(String[] args) {

	try (Scanner scan = new Scanner(System.in)) {
	    int t = scan.nextInt();
	    for (int i = 0; i < t; i++) {
		int size = 1;
		int cycles = scan.nextInt();
		for (int j = 1; j <= cycles; j++) {
		    if (j % 2 != 0) {
			size *= 2;
		    } else {
			size += 1;
		    }
		}
		System.out.println(size);
	    }
	}

    }

}
