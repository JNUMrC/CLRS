package chapter8;

import chapter2.InsertionSort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 桶排序
 * @Author : jnu_mrc jnu_mrc1990@163.com
 * @Date : Created in 16:08 2017/12/19
 */
public class BucketSort {
    public static void main(String[] args) {
        System.out.println(Math.pow(0.79,5)*Math.pow(0.2,5));
        int[] arr = {53,12,64,39,92,4,47,81,55,40};
        arr = sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 假设输入为一百内（不到100）的数，需要通用则需要修改放入桶的代码
     * @param arr
     * @return
     */
    public static int[] sort(int[] arr) {
        int n = 10;
        int len = arr.length;
        List<Integer>[] b = new List[n];
        for (int i = 0; i < n; i++) {
            b[i] = new ArrayList<>();
        }
        for (int i = 0; i < len; i++) {
            b[arr[i] / 10].add(arr[i]);
        }
        int[] r = new int[len];
        int idx = 0;
        for (int i = 0; i < n; i++) {
            List<Integer> l = b[i];
            int size = l.size();
            if (size != 0) {
                int[] a = new int[size];
                for (int j = 0; j < size; j++) {
                    a[j] = l.get(j);
                }
                InsertionSort.sort(a);
                for (int k : a) {
                    r[idx++] = k;
                }
            }
        }
        return r;
    }
}
