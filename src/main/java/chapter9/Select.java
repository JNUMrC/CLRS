package chapter9;

import chapter2.InsertionSort;
import chapter7.QuickSort;

import java.util.Arrays;

/**
 * @Author : jnu_mrc jnu_mrc1990@163.com
 * @Date : Created in 9:46 2018/1/3
 */
public class Select {
    public static void main(String[] args) {
        int[] arr = {3, 1, 9, 4, 7, 8, 6, 2, 5};
        System.out.println(select(arr, 0, arr.length - 1, 6));


        arr = new int[]{7, 3, 6, 1, 9, 8, 2, 5, 4};
        System.out.println(select(arr,0,3,2));
        arr = new int[]{7, 3, 6, 1, 9, 8, 2, 5, 4};
        System.out.println(select(arr,4,8,2));
    }

    public static int select(int[] arr, int p, int r, int i) {
        if (p == r) {
            return arr[p];
        }
        int pivot = getPivot(arr, p, r);
        int q = QuickSort.partition(arr, p, r, pivot);
        int k = q - p + 1;
        if (k == i) {
            return arr[q];
        } else if (k < i) {
            return select(arr, q + 1, r, i - k);
        } else {
            return select(arr, p, q - 1, i);
        }
    }

    private static int getPivot(int[] arr, int p, int r) {
        if (r == p) {
            return arr[r];
        }
        int n = r - p + 1;
        int len = n / 5;
        for (int i = 0; i < len; i++) {
            int start = 5 * i + p;
            InsertionSort.insertionSort(arr, start, start + 5);
        }
        int a = n % 5;
        if (a != 0) {
            int start = p + n - a;
            InsertionSort.insertionSort(arr, start, n);
        }
        int[] t;
        if (a == 0) {
            t = new int[len];
        } else {
            t = new int[len + 1];
        }
        for (int i = 0; i < len; i++) {
            t[i] = arr[i * 5 + 2];
        }
        if (a != 0) {
            t[len] = arr[n - a / 2 - 1];
        }
        return getPivot(t, 0, t.length - 1);
    }

}
