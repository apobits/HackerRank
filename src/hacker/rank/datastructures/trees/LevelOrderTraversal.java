/**
 * 
 */
package hacker.rank.datastructures.trees;

import java.util.Scanner;

/**
 * @author aposo
 *
 */
public class LevelOrderTraversal {

	public static void levelOrder(Node root) {
		System.out.print(root.data + " ");
		levelOrderHelper(root);

	}

	private static void levelOrderHelper(Node root) {
		if (root != null) {
			if (root.left != null) {
				System.out.print(root.left.data + " ");
			}
			if (root.right != null) {
				System.out.print(root.right.data + " ");
			}
			levelOrderHelper(root.left);
			levelOrderHelper(root.right);
		}

	}

	public static Node insert(Node root, int data) {
		if (root == null) {
			return new Node(data);
		} else {
			Node cur;
			if (data <= root.data) {
				cur = insert(root.left, data);
				root.left = cur;
			} else {
				cur = insert(root.right, data);
				root.right = cur;
			}
			return root;
		}
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		Node root = null;
		while (t-- > 0) {
			int data = scan.nextInt();
			root = insert(root, data);
		}
		scan.close();
		levelOrder(root);

	}

	static class Node {
		Node left;
		Node right;
		int data;

		Node(int data) {
			this.data = data;
			left = null;
			right = null;
		}
	}

}
