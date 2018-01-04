package chapter6;

import tool.MrcTool;

import java.util.Arrays;

/**
 * @Author : jnu_mrc jnu_mrc1990@163.com
 * @Date : Created in 10:32 2017/12/14
 */
public class HeapUtil {
    public static void main(String[] args) {
        int[] arr = {36, 25, 10, 22, 18, 11, 6};
        maxHeapifyLoop(arr, 2);
        System.out.println(Arrays.toString(arr));
        arr = new int[]{36, 25, 10, 22, 18, 11, 6};
        maxHeapify(arr, 2);
        System.out.println(Arrays.toString(arr));
        arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19};
//        buildMaxHeap(arr);
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
//        buildMinHeap(arr);
//        System.out.println(Arrays.toString(arr));
    }

    public static void heapSort(int[] arr) {
        buildMaxHeap(arr);
        int t = 0;
        for (int i = arr.length - 1; i > 0; i--) {
            MrcTool.swap(arr, i, 0);
            maxHeapify(arr, 0, arr.length - ++t);
        }
    }

    public static void maxHeapify(int[] arr, int i) {
        maxHeapify(arr, i, arr.length);
    }

    public static int maximum(int[] arr){
        return arr[0];
    }


    /**
     * n=arr.length / 2
     * 刚好是最后一个非叶结点
     *
     * @param arr
     */
    public static void buildMaxHeap(int[] arr) {
        for (int i = arr.length / 2; i >= 0; i--) {
            maxHeapify(arr, i);
        }
    }

    public static void buildMinHeap(int[] arr) {
        for (int i = arr.length / 2; i >= 0; i--) {
            minHeapify(arr, i);
        }
    }

    public static void maxHeapifyLoop(int[] arr, int i) {
        final int max = arr.length;
        while (true) {
            int largest = i;
            final int l = left(largest);
            final int r = right(largest);
            if (l < max && arr[l] > arr[largest]) {
                largest = l;
            }
            if (r < max && arr[r] > arr[largest]) {
                largest = r;
            }
            if (largest != i) {
                MrcTool.swap(arr, i, largest);
            } else {
                break;
            }
        }
    }

    public static void minHeapify(int[] arr, int i, int max){
        int l = left(i);
        int r = right(i);
        int lowest = i;
        if (l < max && arr[l] < arr[lowest]) {
            lowest = l;
        }
        if (r < max && arr[r] < arr[lowest]) {
            lowest = r;
        }
        if (lowest != i) {
            MrcTool.swap(arr, i, lowest);
            minHeapify(arr, lowest);
        }
    }

    public static void maxHeapify(int[] arr, int i, int max) {
        final int l = left(i);
        final int r = right(i);
        int largest = i;
        if (l < max && arr[l] > arr[largest]) {
            largest = l;
        }
        if (r < max && arr[r] > arr[largest]) {
            largest = r;
        }
        if (largest != i) {
            MrcTool.swap(arr, i, largest);
            maxHeapify(arr, largest,max);
        }
    }

    public static void minHeapify(int[] arr, int i) {
        int max = arr.length;
        int l = left(i);
        int r = right(i);
        int lowest = i;
        if (l < max && arr[l] < arr[lowest]) {
            lowest = l;
        }
        if (r < max && arr[r] < arr[lowest]) {
            lowest = r;
        }
        if (lowest != i) {
            MrcTool.swap(arr, i, lowest);
            minHeapify(arr, lowest);
        }
    }


    public static int parent(int i) {
        return (i + 1) / 2 - 1;
    }

    public static int left(int i) {
        return i * 2 + 1;
    }

    public static int right(int i) {
        return i * 2 + 2;
    }

}
