package hacker.rank.algorithm.implementation;

import java.util.Scanner;

public class AngryProfessor {

	public static void main(String[] args) {
		try (Scanner scan = new Scanner(System.in)) {
			int t = scan.nextInt();
			for (int i = 0; i < t; i++) {
				int s = scan.nextInt();
				int threshold = scan.nextInt();
				int temp = 0;
				for (int j = 0; j < s; j++) {
					int h = scan.nextInt();
					if (h <= 0) {
						temp++;
					}
				}
				if (temp >= threshold) {
					System.out.println("NO");
				} else {
					System.out.println("YES");
				}
			}

		}

	}

}
