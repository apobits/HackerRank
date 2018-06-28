/**
 * 
 */
package rank.hacker.cracking_the_coding_interview;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @author apobits@gmail.com
 *
 */
public class TriesContacts {

    static class Node {

	HashMap<Character, Node> nodes;

	boolean isCompleteWord;

	int count;

	public Node() {
	    nodes = new HashMap<>();
	    count = 0;
	}

    }

//    static class Max {
//	int count = 0;
//
//    }

    public static void add(String word, Node node) {
	for (int i = 0; i < word.length(); i++) {
	    char index = word.charAt(i);
	    if (!node.nodes.containsKey(index)) {
		node.nodes.put(index, new Node());
		node = node.nodes.get(index);
	    } else {
		node = node.nodes.get(index);
	    }
	    node.count++;
	}
	node.isCompleteWord = true;
    }

    public static Node find(String word, Node node) {
	for (int i = 0; i < word.length(); i++) {
	    if (node.nodes.containsKey(word.charAt(i))) {
		node = node.nodes.get(word.charAt(i));
	    } else {
		return null;
	    }
	}

	return node;
    }

    // traverse tree
    // public static void countWords(Node node, Max max) {
    // if (node == null)
    // return;
    //
    // if (node.isCompleteWord)
    // max.count++;
    //
    // for (Node x : node.nodes.values()) {
    // if (!x.nodes.isEmpty()) {
    // countWords(x, max);
    // } else {
    // max.count++;
    // }
    // }
    //
    // }

    /**
     * @param args
     */
    public static void main(String[] args) {
	try (Scanner scan = new Scanner(System.in)) {
	    int n = scan.nextInt();
	    Node node = new Node();

	    for (int i = 0; i < n; i++) {
		switch (scan.next()) {
		case "add":
		    add(scan.next(), node);
		    break;
		case "find": {
		    Node tempNode = find(scan.next(), node);
		    System.out.println(tempNode == null ? 0 : tempNode.count);
		}
		    break;
		}
	    }
	}
    }
}
