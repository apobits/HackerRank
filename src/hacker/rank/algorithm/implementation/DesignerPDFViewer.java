package hacker.rank.algorithm.implementation;

import java.util.Scanner;
import java.util.TreeMap;

public class DesignerPDFViewer {

    public static void main(String[] args) {

	try (Scanner scan = new Scanner(System.in)) {
	    TreeMap<Character, Integer> letters = new TreeMap<>();
	    int letter = 97;
	    for (int i = 0; i < 26; i++, letter++) {
		letters.put((char) letter, scan.nextInt());
	    }

	    int max = 0;
	    String word = scan.next();
	    for (int i = 0; i < word.length() - 1; i++) {
		if (letters.get(word.charAt(i)) > max) {
		    max = letters.get(word.charAt(i));
		}
	    }
	    System.out.println(max * word.length());
	}

    }

}
