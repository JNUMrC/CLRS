package chapter6;

import tool.MrcTool;

import java.util.Arrays;

/**
 * 最小堆
 * @Author : jnu_mrc jnu_mrc1990@163.com
 * @Date : Created in 10:48 2017/12/15
 */
public class MinHeap {
    private int[] arr;
    private int size;

    public MinHeap(int[] arr) {
        this.arr = arr;
        size = arr.length;
        build();
    }

    private void build(){
        for (int i = size / 2 - 1; i >= 0; i--) {
            HeapUtil.minHeapify(arr,i,size);
            System.out.println(" ~~"+Arrays.toString(arr));
        }
    }
    public int minimum(){
        return arr[0];
    }

    public int extractMin(){
        if(size < 1){
            throw new UnsupportedOperationException("heap overflow");
        }
        int min = arr[0];
        arr[0] = arr[--size];
        HeapUtil.minHeapify(arr,0);
        return min;
    }

    public void decreaseKey(int i, int key){
        if(key > arr[i]){
            throw new IllegalArgumentException("new key is bigger than current key");
        }
        arr[i] = key;
        while(i > 0 && arr[HeapUtil.parent(i)] > arr[i]){
            MrcTool.swap(arr,i, HeapUtil.parent(i));
            i = HeapUtil.parent(i);
        }
    }

    public void insert(int key){
        arr[size] = Integer.MAX_VALUE;
        decreaseKey(size,key);
        size++;
    }

    public static void main(String[] args) {
        int[] a = new int[]{8,7,6,5,4,3,2,1};
        MinHeap h = new MinHeap(a);
        System.out.println(Arrays.toString(h.arr));

    }
}
