/**
 * 
 */
package rank.hacker.cracking_the_coding_interview;

import java.util.LinkedList;

/**
 * @author apobits@gmail.com
 *
 */
public class LinkedListDetectACycle {

    static class Node {
	int data;
	Node next;

	public Node(int data) {
	    this.data = data;
	}
    }

    static class HashImp<R> {

	private LinkedList<R>[] data;

	@SuppressWarnings("unchecked")
	public HashImp(int size) {
	    data = new LinkedList[size];
	}

	public void put(R obj) {
	    int index = obj.hashCode() % data.length;
	    if (data[index] == null) {
		data[index] = new LinkedList<>();
		data[index].add(obj);
	    } else
		data[index].add(obj);
	}

	public boolean contains(R obj) {
	    int index = obj.hashCode() % data.length;
	    if (data[index] == null)
		return false;
	    return data[index].contains(obj);
	}

	public R remove(R obj) {
	    int index = obj.hashCode() % data.length;
	    if (data[index] == null) {
		return null;
	    } else
		return data[index].poll();
	}
    }

    static boolean hasCycle(Node head) {
	HashImp<Node> temp = new HashImp<>(100);
	if (head == null)
	    return false;
	while (head.next != null) {

	    if (temp.contains(head)) {
		return true;
	    } else {
		temp.put(head);
		head = head.next;
	    }

	}
	return false;
    }

//    static boolean hasCycle(Node head) {
//	if (head == null) {
//	    return false;
//	}
//
//	while (head.next != null)
//	    if (head.next == head) {
//		return true;
//	    } else {
//		head = head.next;
//	    }
//	return false;
//
//    }

    public static void main(String[] args) {
	Node node = new Node(1);
	Node node2 = new Node(2);
	node.next = node2;
	node.next.next = new Node(3);
	Node node4 = new Node(4);
	node.next.next.next = node4;
//	node.next.next.next.next = node2;

	System.out.println(hasCycle(node));
    }

}
