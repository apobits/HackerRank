/**
 * 
 */
package rank.hacker.cracking_the_coding_interview;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author apobits@gmail.com
 *
 */
public class TreesIsThisABinarySearchTree {

    static class Node {
	int data;
	Node left;
	Node right;

	public Node(int data) {
	    this.data = data;
	}
    }

    // binary tree traversing
    public static void checkBSTUtil(Node node, List<Integer> numbers) {

	if (node == null) {
	    return;
	}

	if (node.left != null)
	    checkBSTUtil(node.left, numbers);

	numbers.add(node.data);

	if (node.right != null)
	    checkBSTUtil(node.right, numbers);

    }

    public static boolean checkBST(Node node) {

	List<Integer> numbers = new ArrayList<>();
	checkBSTUtil(node, numbers);
	Iterator<Integer> it = numbers.iterator();
	int temp = 0;
	while (it.hasNext()) {
	    int temp1 = it.next();
	    if (temp >= temp1)
		return false;
	    else
		temp = temp1;
	}

	return true;
    }

    public static void main(String[] args) {
	// creates root
	Node node = new Node(4);

	// creates left side
	node.left = new Node(2);
	node.left.left = new Node(1);
	node.left.right = new Node(3);

	// creates right side
	node.right = new Node(6);
	node.right.left = new Node(5);
	node.right.right = new Node(7);

	System.out.println(checkBST(node));

    }

}
