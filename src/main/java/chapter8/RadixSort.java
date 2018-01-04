package chapter8;

import java.util.Arrays;

/**
 * 子例程使用计数排序的基数排序时间复杂度为θ(n)，
 * @Author : jnu_mrc jnu_mrc1990@163.com
 * @Date : Created in 15:12 2017/12/19
 */
public class RadixSort {
    public static void main(String[] args) {
        int[] arr = {4011, 1235, 2351, 11111, 111123, 6513, 8191, 23, 491, 9281, 223, 1, 5233};
        arr = sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static int getD(int[] arr) {
        int max = 100;
        int d = 2;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                do {
                    max *= 10;
                    d++;
                } while (arr[i] > max);
            }
        }
        return d;
    }

    public static int[] sort(int[] arr) {
        int len = getD(arr);
        for (int i = 0; i < len; i++) {
            int d = (int) Math.pow(10, i);
            arr = countingSort(arr, d);
        }
        return arr;
    }

    private static int[] countingSort(int[] a, int d) {
        int maxElem = 9;
        int[] c = new int[maxElem + 1];
        for (int i = 0; i < c.length; i++) {
            c[i] = 0;
        }
        for (int i = 0; i < a.length; i++) {
            c[a[i] / d % 10] += 1;
        }
        for (int i = 1; i < c.length; i++) {
            c[i] += c[i - 1];
        }
        int[] b = new int[a.length];
        for (int i = a.length - 1; i >= 0; i--) {
            int di = a[i] / d % 10;
            b[c[di] - 1] = a[i];
            c[di] -= 1;
        }
        return b;
    }
}
