package chapter2;

import java.util.Arrays;

/**
 * @Author : jnu_mrc jnu_mrc1990@163.com
 * @Date : Created in 11:34 2017/11/14
 */
public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = {2, 5, 9, 3, 7, 4, 1};
        insertionSort(arr, 0, arr.length);
        System.out.println(Arrays.toString(arr));
        arr = new int[]{2, 5, 9, 3, 7, 4, 1};
        sort1(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 基于遗忘比较算法的插入排序
     * @param arr
     */
    public static void sort1(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                compareAndExchange(arr, j, j + 1);
            }
        }
    }

    /**
     * 遗忘比较算法
     * @param arr
     * @param i
     * @param j
     */
    private static void compareAndExchange(int[] arr, int i, int j) {
        if (arr[i] > arr[j]) {
            int t = arr[i];
            arr[i] = arr[j];
            arr[j] = t;
        }
    }

    public static void sort(int[] arr) {
        insertionSort(arr, 0, arr.length);
    }

    /**
     * INSERTION-SORT(A)
     * for j = 2 to A.length
     * key = A[j]
     * //Insert A[j] into the sorted sequence A[1..j-1]
     * i = j - 1
     * while i > 0 and A[i] > key
     * A[i + 1] = A[i]
     * i = i - 1
     * A[i + 1] = key
     *
     * @param arr   the array to be sorted
     * @param start start index
     * @param end   end index (not include)
     */
    public static void insertionSort(int[] arr, int start, int end) {
        for (int j = start + 1; j < end; j++) {
            int key = arr[j];
            int i = j - 1;
            while (i != start - 1 && arr[i] > key) {
                arr[i + 1] = arr[i];
                i--;
            }
            arr[i + 1] = key;
        }
    }
}
