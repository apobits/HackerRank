package hacker.rank.interview_preparation_kit.arrays;

import java.util.Arrays;

public class ArrayManipulationHolder {
    private static final long[] numbers = new long[30000];

    public static synchronized void merge(long[] a) {
        for (int i = 0; i < a.length; i++) {
            numbers[i] += a[i];
        }
    }

    public static long[] getNumbers() {
        return Arrays.copyOf(numbers, numbers.length);
    }
}
