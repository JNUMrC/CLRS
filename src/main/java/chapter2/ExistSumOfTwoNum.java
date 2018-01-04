package chapter2;

/**
 * 运行时间为Θ(nlogn)的算法，给定n个整数的集合S和另一整数x，确定S中是否存在两个其和刚好为x的元素。
 * @Author : jnu_mrc jnu_mrc1990@163.com
 * @Date : Created in 17:25 2017/11/22
 */
public class ExistSumOfTwoNum {

    public static void main(String[] args) {
        int[] arr = {23,1,3,56,7,41,5,8,13,43,131,65};
        System.out.println(isExist(arr,4));
        System.out.println(isExist(arr,5));
        System.out.println(isExist(arr,86));
        System.out.println(isExist(arr,174));
    }

    public static boolean isExist(int[] arr, int x){
        MergeSort2.mergeSort(arr,0,arr.length - 1);
        int end = arr.length - 1;
        for (int i = 0; i < end; i++) {
            int key = x - arr[i];
            int r = BinarySearch.binarySearch(arr,key);
            if(r != -1 && r != i){
                return true;
            }
        }
        return false;
    }
}
