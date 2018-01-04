package chapter8;

import java.util.Arrays;

/**
 * 计数排序
 * @Author : jnu_mrc jnu_mrc1990@163.com
 * @Date : Created in 11:08 2017/12/19
 */
public class CountingSort {
    public static void main(String[] args) {
        int[] a = new int[]{4,1,9,7,2,5,6,2,3};
        int[] b = sort(a, 9);
        System.out.println(Arrays.toString(b));
    }

    public static int[] sort(int[] a, int maxElem) {
        int[] c = new int[maxElem + 1];
        for (int i = 0; i < c.length; i++) {
            c[i] = 0;
        }
        for (int i = 0; i < a.length; i++) {
            c[a[i]] += 1;
        }
        for (int i = 1; i < c.length; i++) {
            c[i] += c[i - 1];
        }
        int[] b = new int[a.length];
        for (int i = a.length - 1; i >= 0; i--) {
            b[c[a[i]] - 1] = a[i];
            c[a[i]] -= 1;
        }
        return b;
    }
}
