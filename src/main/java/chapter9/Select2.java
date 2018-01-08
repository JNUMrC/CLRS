package chapter9;

import java.util.Arrays;

/**
 * @Author : jnu_mrc jnu_mrc1990@163.com
 * @Date : Created in 18:17 2018/1/8
 */
public class Select2 {
    public static void main(String[] args) {
        int[] arr = new int[]{7, 3, 6, 1, 9, 8, 2, 5, 4};
        System.out.println(Arrays.toString(select(arr, 0, arr.length - 1, 4)));
    }


    public static int[] select(int[] arr, int p, int r, int i) {
        int[] a = new int[i];
        int n = r - p + 1;
        int m = n / 2;
        if (i >= m) {
            int x = Select.select(arr, p, r, i);
            int index = 0;
            for (int j = p; j <= r; j++) {
                if (arr[j] < x) {
                    a[index++] = arr[j];
                }
            }
            for (int j = index; j < a.length; j++) {
                a[j] = x;
            }
        } else {
            int[] x1 = select(arr, p, m - 1, i);
            int[] x2 = select(arr, m, r, i);
            int[] t = new int[i << 1];
            for (int j = 0; j < i; j++) {
                t[j] = x1[j];
            }
            for (int j = 0; j < i; j++) {
                t[j + i] = x2[j];
            }
            a = select(t, 0, t.length - 1, i);

        }
        return a;
    }
}
