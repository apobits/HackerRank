/**
 *
 */
package rank.hacker.cracking_the_coding_interview;

/**
 * @author apobits@gmail.com
 *
 */
public class MergeSort {

    public static void main(String args[]) {
        int[] x = {5, 2, 1, 3, 4, 5, 2, 1, 3, 4};
        MergeSort ms = new MergeSort();
        CounterWrapper counter = ms.new CounterWrapper();
        ms.mergeSort(x, counter);
        System.out.println(counter.count + 1);
    }

    public void mergeSort(int[] x, CounterWrapper counter) {
        mergeSort(x, 0, x.length - 1, counter);
    }

    private void mergeSort(int[] x, int left, int right, CounterWrapper counter) {
        if (left >= right) {
            return;
        }

        int half = ((right + left) / 2);

        mergeSort(x, left, half, counter);
        mergeSort(x, half + 1, right, counter);
        mergeHalves(x, left, right, counter);
    }

    private void mergeHalves(int[] x, int left, int right, CounterWrapper counter) {
        int[] temp = new int[x.length];
        int half = (right + left) / 2;

        int leftStart = left;
        int leftEnd = half;

        int rightStart = leftEnd + 1;
        int size = right - leftStart + 1;

        int tempIndex = leftStart;

        while (leftStart <= leftEnd && rightStart <= right) {
            if (x[leftStart] <= x[rightStart]) {
                temp[tempIndex++] = x[leftStart];
                leftStart++;
            } else {
                temp[tempIndex++] = x[rightStart];
                rightStart++;
                counter.count++;
            }
        }

        // passes what´s left from left side
        System.arraycopy(x, leftStart, temp, tempIndex, leftEnd - leftStart + 1);

        // passes what´s left from right side
        System.arraycopy(x, rightStart, temp, tempIndex, right - rightStart + 1);

        // copies elements in temp from left to x from left
        System.arraycopy(temp, left, x, left, size);

    }

    class CounterWrapper {

        int count = 0;
    }

}
