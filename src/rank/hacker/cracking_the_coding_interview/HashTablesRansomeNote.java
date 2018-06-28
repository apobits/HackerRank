/**
 * 
 */
package rank.hacker.cracking_the_coding_interview;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author apobits@gmail.com
 *
 */
public class HashTablesRansomeNote {

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

	public boolean get(R obj) {
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

    /**
     * @param args
     */
    public static void main(String[] args) {

	try (Scanner scan = new Scanner(System.in)) {
	    int m = scan.nextInt();
	    int n = scan.nextInt();

	    HashImp<String> magazine = new HashImp<>(m);

	    for (int i = 0; i < m; i++) {
		magazine.put(scan.next());
	    }

	    for (int i = 0; i < n; i++) {
		if (magazine.remove(scan.next()) == null) {
		    System.out.println("No");
		    return;
		}
	    }

	    System.out.println("Yes");

	}

    }

}
