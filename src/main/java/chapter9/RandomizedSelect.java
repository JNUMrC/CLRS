package chapter9;

import chapter7.QuickSort;

/**
 * 得到第i小的数，利用了partition方法的性质
 * @Author : jnu_mrc jnu_mrc1990@163.com
 * @Date : Created in 15:23 2018/1/2
 */
public class RandomizedSelect {
    public static void main(String[] args) {
        int[] arr = {3, 1, 8, 4, 9, 5, 2, 6, 7};
        System.out.println(select(arr, 0, arr.length - 1, 6));
        System.out.println(recursiveSelect(arr, 0, arr.length - 1, 5));
    }

    public static int select(int[] arr, int p, int r, int i) {
        if (p == r) {
            return arr[p];
        }
        int q = QuickSort.randomizedPartition(arr, p, r);
        int k = q - p + 1;
        if (i == k) {
            return arr[q];
        } else if (i < k) {
            return select(arr, p, q - 1, i);
        } else {
            return select(arr, q + 1, r, i - k);
        }
    }

    public static int recursiveSelect(int[] arr, int p, int r, int i) {
        while (p != r) {
            int q = QuickSort.randomizedPartition(arr, p, r);
            int k = q - p + 1;
            if (i == k) {
                return arr[q];
            } else if (i < k) {
                r = q - 1;
            } else {
                p = q + 1;
                i -= k;
            }
        }
        return arr[p];
    }
}
