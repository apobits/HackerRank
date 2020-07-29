package hacker.rank.interview_preparation_kit.arrays;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class ArrayManipulation2 extends RecursiveAction {

    static class Holder {
        private long[] numbers;

        public Holder(int size) {
            this.numbers = new long[size];
        }

        public synchronized void merge(long[] a) {
            for (int i = 0; i < a.length; i++) {
                numbers[i] += a[i];
            }
        }
    }

    private int start, end, threshold, size;
    private int[][] queries;
    private Holder holder;

    public ArrayManipulation2(int start, int end, int threshold, int[][] queries, Holder holder, int size) {
        this.start = start;
        this.end = end;
        this.threshold = threshold;
        this.queries = queries;
        this.holder = holder;
        this.size = size;
    }


    @Override
    protected void compute() {
        if ((end - start) < threshold) {
            long array[] = new long[size];
            for (int i = start; i < end; i++) {
                int left = queries[i][0];
                int right = queries[i][1];
                int value = queries[i][2];
                for (int j = left - 1; j < right; j++) {
                    array[j] += value;
                }
            }
            holder.merge(array);
        } else {
            int middle = (start + end) / 2;
            ArrayManipulation2 arrayManipulation21 = new ArrayManipulation2(start, middle, threshold, queries, holder, size);
            ArrayManipulation2 arrayManipulation22 = new ArrayManipulation2(middle, end, threshold, queries, holder, size);
            invokeAll(arrayManipulation21, arrayManipulation22);
        }
    }

    private static long max(long[] a) {
        long max = 0;
        for (int i = 0; i < a.length; i++) {
            if (max < a[i]) {
                max = a[i];
            }
        }
        return max;
    }


    public static void main(String args[]) throws IOException {

        List<String> lines = Files.readAllLines(Paths.get("C:\\Users\\aposo\\Desktop\\input06.txt"));
        String[] initValues = lines.get(0).split(" ");
        int size = Integer.parseInt(initValues[0]);
        int[][] queries = new int[Integer.parseInt(initValues[1])][3];

        for (int i = 1; i < lines.size(); i++) {
            String[] data = lines.get(i).split(" ");
            queries[i - 1][0] = Integer.parseInt(data[0]);
            queries[i - 1][1] = Integer.parseInt(data[1]);
            queries[i - 1][2] = Integer.parseInt(data[2]);
        }

        ForkJoinPool forkJoinPool = new ForkJoinPool(12);
        long start = System.nanoTime();
        Holder holder = new Holder(size);
        ArrayManipulation2 arrayManipulation2 = new ArrayManipulation2(0, queries.length, 30000, queries, holder, size);
        forkJoinPool.invoke(arrayManipulation2);
        System.out.println(max(holder.numbers));
        System.out.println("Level of parallelism: " + forkJoinPool.getParallelism());
        System.out.println("Execution Time: " + (System.nanoTime() - start));
    }

}
