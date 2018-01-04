package chapter6;

import tool.MrcTool;

import java.util.Arrays;

/**
 * 最大堆
 * @Author : jnu_mrc jnu_mrc1990@163.com
 * @Date : Created in 18:58 2017/12/14
 */
public class MaxHeap {
    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        MaxHeap h = new MaxHeap(a);
        System.out.println(Arrays.toString(h.arr));
        System.out.println(h.maximum());
        System.out.println(h.extractMax());
        System.out.println(Arrays.toString(h.arr));
        h.insert(10);
        System.out.println(Arrays.toString(h.arr));
        h.insert(11);
        System.out.println(Arrays.toString(h.arr));
        h.insert(12);
        System.out.println(Arrays.toString(h.arr));
        System.out.println(h.extractMax());
        System.out.println(Arrays.toString(h.arr));

        while(h.size > 0){
            System.out.println(h.delete(h.size / 2));
            System.out.println(Arrays.toString(h.arr));
            h.extractMax();
            System.out.println(Arrays.toString(h.arr));
        }
    }

    private int[] arr;
    private int size;

    public int delete(int i){
        int v = arr[i];
        MrcTool.swap(arr,i,--size);
        arr[size] = Integer.MIN_VALUE;
        HeapUtil.maxHeapify(arr,i,size);
        return v;
    }

    public int size(){
        return size;
    }
    public MaxHeap(){
        this.arr = new int[64];
        size = 0;
    }

    public MaxHeap(int[] arr) {
        this.arr = arr;
        size = arr.length;
        build();
    }

    public void build() {
        final int[] arr = this.arr;
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            HeapUtil.maxHeapify(arr, i, size);
        }
    }

    public int maximum() {
        return arr[0];
    }

    public void increaseKey(int i, int key) {
        if (key < arr[i]) {
            throw new IllegalArgumentException("new key is smaller than current key");
        }
        arr[i] = key;
        while (i > 0 && arr[HeapUtil.parent(i)] < arr[i]) {
            MrcTool.swap(arr, i, HeapUtil.parent(i));
            i = HeapUtil.parent(i);
        }

    }

    public void insert(int key) {
        if (size == arr.length) {
            arr = Arrays.copyOf(arr, size * 2);
            for (int i = size; i < arr.length; i++) {
                arr[i] = Integer.MIN_VALUE;
            }
        }
        arr[size] = Integer.MIN_VALUE;
        increaseKey(size, key);
        size++;
    }

    public int extractMax() {
        if (size < 1) {
            throw new UnsupportedOperationException("heap overflow");
        }
        if (arr.length > 64 && arr.length / size > 2) {
            arr = Arrays.copyOf(arr, arr.length / 2);
        }
        int max = arr[0];
        arr[0] = arr[--size];
        arr[size] = Integer.MIN_VALUE;
        HeapUtil.maxHeapify(arr, 0, size);
        return max;
    }

}
