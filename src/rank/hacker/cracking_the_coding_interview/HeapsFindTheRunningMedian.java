/**
 * 
 */
package rank.hacker.cracking_the_coding_interview;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @author apobits@gmail.com
 *
 */
public class HeapsFindTheRunningMedian {

    static class MinHeap {
	private int[] heaps;

	private int freeIndex;

	public MinHeap() {
	    heaps = new int[1000000];
	    freeIndex = 0;
	}

	void add(int number) {
	    if (heaps[heaps.length - 1] != 0) {
		resizeHeap();
	    }
	    int index = freeIndex;
	    heaps[index] = number;
	    freeIndex++;
	    if (index == 0) {
		return;
	    }
	    while (index != 0 && heaps[index - 1] > heaps[index]) {
		int temp = heaps[index - 1];
		heaps[index - 1] = heaps[index];
		heaps[index] = temp;
		index--;
	    }
	}

	int pop() {
	    if (heaps == null)
		throw new IllegalStateException();
	    int first = heaps[0];
	    int last = freeIndex - 1;
	    heaps[0] = heaps[last];
	    heaps[last] = 0;
	    int index = 0, temp = 0;
	    while (index < last - 1 && heaps[index] > heaps[index + 1]) {
		temp = heaps[index + 1];
		heaps[index + 1] = heaps[index];
		heaps[index] = temp;
		index++;
	    }

	    return first;
	}

	public void printMedian() {
	    float median = 0f;
	    if (freeIndex % 2 != 0) {
		median = (float) heaps[(freeIndex - 1) / 2];
	    } else {
		median = (float) (heaps[(freeIndex / 2) - 1] + heaps[freeIndex / 2]) / 2;
	    }
	    System.out.println(Float.valueOf(median));
	}

	void resizeHeap() {
	    int temp[] = Arrays.copyOf(heaps, heaps.length);
	    heaps = new int[heaps.length * 2];
	    heaps = Arrays.copyOf(temp, heaps.length);
	}
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
	MinHeap mh = new MinHeap();

	try (Scanner scan = new Scanner(System.in)) {
	    int n = scan.nextInt();

	    for (int i = 0; i < n; i++) {
		mh.add(scan.nextInt());
		mh.printMedian();
	    }
	}
    }
}
