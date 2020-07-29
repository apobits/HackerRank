package hacker.rank.datastructures.heap;

import java.util.Arrays;
import java.util.Scanner;

public class QHEAP1 {

    public static void main(String[] args) {
        Heap heap = new Heap(100000);
        try (Scanner scanner = new Scanner(System.in)) {
            int queries = scanner.nextInt();

            for (int i = 0; i < queries; i++) {
                switch (scanner.nextInt()) {
                    case 1:
                        heap.add(scanner.nextInt());
                        break;
                    case 2:
                        heap.delete(scanner.nextInt());
                        break;
                    case 3:
                        System.out.println(heap.peek());
                        break;
                }
            }
        }
    }

    static class Heap {

        private int[] array;

        private int size;

        private int capacity;

        public Heap(int capacity) {
            this.capacity = capacity;
            array = new int[capacity];
        }

        public int peek() {
            return array[0];
        }

        public void add(int element) {
            ensureCapacity();
            array[size++] = element;
            heapifyUp();
        }

        public void delete(int element) {
            int index = 0;
            while (array[index++] != element)
                ;
            swap(index - 1, --size);
            array[size] = 0;
            heapifyDown(index - 1);
        }

        public int pop() {
            int value = array[0];
            array[0] = 0;
            swap(0, --size);
            heapifyDown(0);
            return value;
        }

        private void heapifyUp() {
            int tempIndex = size - 1;
            int parentIndex = 0;
            while (array[(parentIndex = getParentIndex(tempIndex))] > array[tempIndex]) {
                swap(parentIndex, tempIndex);
                tempIndex = parentIndex;
            }
        }

        private void heapifyDown(int index) {
            int parentIndex = index;
            int leftIndex = 0, rightIndex = 0;
            while (hasLeftIndex(parentIndex)) {
                int lowerValueIndex = 0;
                leftIndex = getLeftIndex(parentIndex);
                if (hasRightIndex(parentIndex)) {
                    rightIndex = getRightIndex(parentIndex);
                    lowerValueIndex = array[leftIndex] > array[rightIndex] ? rightIndex : leftIndex;
                } else {
                    lowerValueIndex = leftIndex;
                }

                if (array[parentIndex] > array[lowerValueIndex]) {
                    swap(lowerValueIndex, parentIndex);
                    parentIndex = lowerValueIndex;
                } else {
                    break;
                }
            }
        }

        private int getParentIndex(int index) {
            if (index == 0) {
                return 0;
            }
            return (index - 1) / 2;
        }

        private int getLeftIndex(int index) {
            int tempIndex = index * 2 + 1;
            return tempIndex >= size ? index : tempIndex;
        }

        private int getRightIndex(int index) {
            int tempIndex = index * 2 + 2;
            return tempIndex >= size ? index : tempIndex;
        }

        private void swap(int index1, int index2) {
            int value = array[index2];
            array[index2] = array[index1];
            array[index1] = value;
        }

        private boolean hasLeftIndex(int index) {
            if ((index * 2 + 1) > size - 1) {
                return false;
            }
            return true;
        }

        private boolean hasRightIndex(int index) {
            if ((index * 2 + 2) > size - 1) {
                return false;
            }
            return true;
        }

        private void ensureCapacity() {
            if (size == capacity) {
                array = Arrays.copyOf(array, capacity * 2);
            }
        }
    }

}
