package chapter6;

import java.util.LinkedList;

/**
 * 合并k个有序链表 时间复杂度为：nlgk
 * @Author : jnu_mrc jnu_mrc1990@163.com
 * @Date : Created in 14:23 2017/12/15
 */
public class MergeLinkedList {
    public static void main(String[] args) {
        LinkedList<Integer>[] arr = new LinkedList[10];
        for (int i = 0; i < 10; i++) {
            LinkedList<Integer> l = new LinkedList<>();
            for (int j = 0; j < 10; j++) {
                l.add(i*10+j);
            }
            arr[i] = l;
        }
        LinkedList<Integer> merge = merge(arr);
        for (Integer integer : merge) {
            System.out.print(integer+", ");
        }
    }
    public static LinkedList<Integer> merge(LinkedList<Integer>[] arr){
        HeapItem_[] items = new HeapItem_[arr.length];
        for (int i = 0; i < items.length; i++) {
            items[i] = new HeapItem_(arr[i]);
        }
        MinHeap1 h = new MinHeap1(items);
        LinkedList<Integer> result = new LinkedList<>();
        while (h.size > 0){
            HeapItem_ minimum = (HeapItem_) h.minimum();
            int size = minimum.l.size();
            if(size > 0){
                Integer pop = minimum.l.pop();
                result.add(pop);
                if(size == 1){
                    h.extractMin();
                }else {
                    minimum.key = minimum.l.peek();
                    h.minHeapify(0);
                }
            }else{
                h.extractMin();
            }
        }
        return result;
    }

    private static class HeapItem_ extends HeapItem{
        private LinkedList<Integer> l;
        public HeapItem_(LinkedList<Integer> l) {
            this.l = l;
            this.key = l.peek();
        }
    }

    private static class MinHeap1{
        private HeapItem[] arr;
        private int size;

        public MinHeap1(HeapItem[] arr) {
            this.arr = arr;
            size = arr.length;
            build();
        }

        public HeapItem minimum(){
            return arr[0];
        }

        public HeapItem extractMin(){
            HeapItem min = arr[0];
            arr[0] = arr[--size];
            minHeapify(0);
            return min;
        }
        private void build(){
            for (int i = size / 2 - 1; i >= 0; i--) {
                minHeapify(i);
            }
        }

        public void minHeapify(int i){
            int l = HeapUtil.left(i);
            int r = HeapUtil.right(i);
            int lowest = i;
            if(l < size && arr[l].key < arr[lowest].key){
                lowest = l;
            }
            if(r < size && arr[r].key < arr[lowest].key){
                lowest = r;
            }
            if(lowest != i){
                HeapItem t = arr[i];
                arr[i] = arr[lowest];
                arr[lowest] = t;
                minHeapify(lowest);
            }
        }

    }
}
