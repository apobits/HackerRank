/**
 * 
 */
package rank.hacker.cracking_the_coding_interview;

/**
 * @author apobits@gmail.com
 *
 */
public class QuickSort {

    public void quickSort(int[] x, int minPos, int maxPos) {

	if (minPos >= maxPos) {
	    return;
	}
	int pivot = (maxPos + minPos) / 2;
	int index = processQuickSort(x, minPos, maxPos, pivot);
	quickSort(x, minPos, index - 1);
	quickSort(x, index, maxPos);
    }

    private int processQuickSort(int[] x, int minPos, int maxPos, int pivot) {
	while (minPos < maxPos) {
	    while (x[minPos] < x[pivot]) {
		minPos++;
	    }

	    while (x[maxPos] > x[pivot]) {
		maxPos--;
	    }

	    if (minPos <= maxPos) {
		int temp = x[minPos];
		x[minPos++] = x[maxPos];
		x[maxPos--] = temp;
	    }
	}
	return minPos;
    }

    public static void main(String[] args) {

	int x[] = new int[] { 10, 3, 9, 4 };
	QuickSort qs = new QuickSort();
	qs.quickSort(x, 0, x.length - 1);

    }

}
