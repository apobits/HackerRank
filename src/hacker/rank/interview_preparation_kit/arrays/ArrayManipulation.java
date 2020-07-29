/**
 *
 */
package hacker.rank.interview_preparation_kit.arrays;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;
import java.util.concurrent.*;

/**
 * @author aposo
 *
 */
public class ArrayManipulation {

    private static long arrayManipulation(int n, int[][] queries) {
        long array[] = new long[n];
        long max = 0;
        for (int i = 0; i < queries.length; i++) {
            int left = queries[i][0];
            int right = queries[i][1];
            int value = queries[i][2];
            for (int j = left - 1; j < right; j++) {
                array[j] = array[j] + value;
                if (array[j] > max) {
                    max = array[j];
                }
            }
        }

        return max;

    }

    private static long arrayManipulationV1(int n, int[][] queries) {

        int mid = queries.length / 4;

        Callable<Long[]> callable1 = () -> arrayManipulationV1Imp(n, queries, 0, mid);
        Callable<Long[]> callable2 = () -> arrayManipulationV1Imp(n, queries, mid, mid * 2);
        Callable<Long[]> callable3 = () -> arrayManipulationV1Imp(n, queries, mid * 2, mid * 3);
        Callable<Long[]> callable4 = () -> arrayManipulationV1Imp(n, queries, mid * 3, queries.length);

        ExecutorService executorService = Executors.newFixedThreadPool(4);

        Future<Long[]> result1 = executorService.submit(callable1);
        Future<Long[]> result2 = executorService.submit(callable2);
        Future<Long[]> result3 = executorService.submit(callable3);
        Future<Long[]> result4 = executorService.submit(callable4);
        long result = 0;
        try {
            Long[] res1 = result1.get();
            Long[] res2 = result2.get();
            Long[] res3 = result3.get();
            Long[] res4 = result4.get();
            result = mergeAndGetMax(res1, res2, res3, res4);
        } catch (ExecutionException | InterruptedException e) {
            System.out.println(e);
        } finally {
            executorService.shutdownNow();
        }


        return result;
    }


    private static Long[] arrayManipulationV1Imp(int n, int[][] queries, int start, int end) {
        Long array[] = new Long[n];
        for (int i = start; i < end; i++) {
            int left = queries[i][0];
            int right = queries[i][1];
            int value = queries[i][2];
            for (int j = left - 1; j < right; j++) {
                array[j] = array[j] == null ? value : array[j] + value;
            }
        }

        return array;
    }

    private static long mergeAndGetMax(Long[] a, Long[] b, Long[] c, Long[] d) {
        long[] merged = new long[a.length];
        long max = 0;
        for (int i = 0; i < a.length; i++) {
            merged[i] = (a[i] == null ? 0 : a[i]) + (b[i] == null ? 0 : b[i]) + (c[i] == null ? 0 : c[i]) + (d[i] == null ? 0 : d[i]);
            if (merged[i] > max) {
                max = merged[i];
            }
        }
        return max;
    }


    /**
     * @param args
     */
    public static void main(String[] args) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get("C:\\Users\\aposo\\Desktop\\input06.txt"));
        String[] initValues = lines.get(0).split(" ");
        int queryNumber = Integer.parseInt(initValues[0]);
        int[][] queries = new int[Integer.parseInt(initValues[1])][3];

        for (int i = 1; i < lines.size(); i++) {
            String[] data = lines.get(i).split(" ");
            queries[i - 1][0] = Integer.parseInt(data[0]);
            queries[i - 1][1] = Integer.parseInt(data[1]);
            queries[i - 1][2] = Integer.parseInt(data[2]);
        }

        long start = System.nanoTime();
        System.out.println(arrayManipulation(queryNumber, queries));
        System.out.println(System.nanoTime() - start);
    }
}
