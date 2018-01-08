package chapter7;

import chapter9.RandomizedSelect;
import tool.MrcTool;

import java.util.Arrays;

/**
 * 快排
 * @Author : jnu_mrc jnu_mrc1990@163.com
 * @Date : Created in 15:56 2017/12/18
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = new int[]{3, 9, 1, 4, 7, 2, 5, 8, 6};
        tailRecursiveQuickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
        arr = new int[]{3, 9, 1, 4, 7, 2, 5, 8, 6};
        worstCaseQuickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
        arr = new int[]{3, 9, 1, 4, 7, 2, 5, 8, 6};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 尾递归快排
     */
    public static void tailRecursiveQuickSort(int[] arr, int p, int r) {
        while (p < r) {
            int q = randomizedPartition(arr, p, r);
            tailRecursiveQuickSort(arr, p, q - 1);
            p = q + 1;
        }
    }

    /**
     * 最坏情况仍保持时间复杂度为θ(nlgn)的快排算法，使用了尾递归。
     * 并不说明他比另外的实现更好，因为其常数项会较大，在平均输入下没有必要用这个算法。
     */
    public static void worstCaseQuickSort(int[] arr, int p, int r){
        while (p < r){
            int i = (r - p + 1) / 2;
            int pivot = RandomizedSelect.select(arr,p,r,i);
            int q = partition(arr,p,r,pivot);
            worstCaseQuickSort(arr,p,q-1);
            p = q + 1;
        }
    }

    /**
     * 随机化快排，输入无关，期望时间复杂度θ(nlgn)
     */
    public static void quickSort(int[] arr, int p, int r) {
        if (p < r) {
            int q = randomizedPartition(arr, p, r);
            quickSort(arr, p, q - 1);
            quickSort(arr, q + 1, r);
        }
    }

    /**
     * 随机化的partition方法
     */
    public static int randomizedPartition(int[] arr, int p, int r) {
        int i = MrcTool.nextInt(p, r);
        int a = MrcTool.nextInt(p, r);
        int b = MrcTool.nextInt(p, r);
        if ((a - b) * (b - i) > 0) {
            i = b;
        } else if ((b - a) * (a - i) > 0) {
            i = a;
        }
        swap(arr, r, i);
        return partition(arr, p, r);
    }

    public static int partition(int[] arr, int p, int r, int pivot) {
        for (int i = p; i <= r; i++) {
            if(arr[i] == pivot){
                swap(arr,r,i);
                break;
            }
        }
        return partition(arr, p, r);
    }

    public static int partition(int[] arr, int p, int r) {
        int x = arr[r];
        int i = p - 1;
        for (int j = p; j < r; j++) {
            if (arr[j] <= x) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, r);
        return i + 1;
    }

    private static void swap(int[] arr, int a, int b) {
        int t = arr[a];
        arr[a] = arr[b];
        arr[b] = t;
    }
}
