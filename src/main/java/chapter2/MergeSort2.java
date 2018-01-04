package chapter2;

import java.util.Arrays;

/**
 * 不用哨兵，当L或R所有元素被复制回A就立刻停止
 * @Author : jnu_mrc jnu_mrc1990@163.com
 * @Date : Created in 15:29 2017/11/16
 */
public class MergeSort2 {
    public static void main(String[] args) {
        int[] arr = {4,1,292,13,4,56,6,45,2,2,3,1,23,15,16,7,8,667,556,43,345,2,7,32,4,8,2,5,6};
        mergeSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
    //threshold value
    private static int k = 10;
    public static void mergeSort(int[] arr, int a, int b){
        if( a == b){
            return;
        }

        if(b - a < k){
            //do insert sort
            InsertionSort.insertionSort(arr,a,b + 1);
        }else{
            int m = (a + b) / 2;
            mergeSort(arr, a, m);
            mergeSort(arr, m + 1, b);
            merge(arr, a, m, b);
        }
    }

    /**
     * merge left and right and sorted them
     * @param arr
     * @param a merge start index
     * @param k merge mid index
     * @param b merge end index (include this one)
     */
    private static void merge(int[] arr, int a, int k, int b){
        int leftLength = k - a + 1;
        int rightLength = b - k;
        int[] left = new int[leftLength];
        int[] right = new int[rightLength];
        for (int i = 0; i < leftLength; i++) {
            left[i] = arr[a + i];
        }
        for (int i = 0; i < rightLength; i++) {
            right[i] = arr[k + i + 1];
        }
        int m = 0,n = 0;
        for (int i = a; i <= b; i++) {
            if(m == leftLength){
                for (int j = i; j <= b; j++) {
                    arr[j] = right[n++];
                }
                break;
            }else if(n == rightLength){
                for (int j = i; j <= b; j++) {
                    arr[j] = left[m++];
                }
                break;
            }
            if(left[m] <= right[n]){
                arr[i] = left[m++];
            }else{
                arr[i] = right[n++];
            }
        }
    }
}
