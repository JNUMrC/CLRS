package chapter8;

import chapter5.RandomizeInPlace;
import chapter7.QuickSort;

import java.util.Arrays;

/**
 * 平均排序，k排序算法，先分k组，分别排序，再合并
 * @Author : jnu_mrc jnu_mrc1990@163.com
 * @Date : Created in 11:14 2017/12/21
 */
public class MeanSort {
    public static void main(String[] args) {
        int n = 13;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }
        System.out.println(Arrays.toString(arr));
        RandomizeInPlace.randomInPlace(arr);
        System.out.println(Arrays.toString(arr));
        sort(arr,3);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr, int k) {
        int[][] ints = new int[k][];
        int len = arr.length;
        int a = len % k;
        int l = len / k;
        for (int i = 0; i < k; i++) {
            int s = l;
            if (i < a) {
                s++;
            }
            ints[i] = new int[s];
            for (int j = 0; j < s; j++) {
                ints[i][j] = arr[i + j * k];
            }
        }
        for (int i = 0; i < k; i++) {
            QuickSort.tailRecursiveQuickSort(ints[i], 0, ints[i].length - 1);
        }
        for (int i = 0; i < k; i++) {
            int[] t = ints[i];
            for (int j = 0; j < t.length; j++) {
                arr[i + j * k] = t[j];
            }
        }
    }
}
