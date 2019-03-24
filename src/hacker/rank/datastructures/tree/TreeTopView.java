/**
 * 
 */
package hacker.rank.datastructures.tree;

import java.util.Scanner;

/**
 * @author apobits@gmail.com
 *
 */
public class TreeTopView {

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

	/*
	 * 
	 * class Node int data; Node left; Node right;
	 */
	public static void topView(Node root) {
		printTopViewV1(root);
	}

	static void printTopViewV1(Node node) {
		if (node != null) {
			printTopViewV1Left(node.left);
			System.out.print(node.data + " ");
			printTopViewV1Right(node.right);
		}
	}

	static void printTopViewV1Left(Node node) {
		if (node != null) {
			printTopViewV1Left(node.left);
			System.out.print(node.data + " ");
		}
	}

	static void printTopViewV1Right(Node node) {
		if (node != null) {
			System.out.print(node.data + " ");
			printTopViewV1Right(node.right);
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
		topView(root);
	}

}
