package chapter5;

import java.util.Arrays;
import java.util.Random;

/**
 * 生成优先级数组来随机排序
 * generate a priority num array to sort the input array.
 * 时间复杂度θ(nlgn)
 * @Author : jnu_mrc jnu_mrc1990@163.com
 * @Date : Created in 10:55 2017/11/29
 */
public class PermuteBySorting {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            int[] arr = {1,2,3,4,5,6,7,8,9};
            permute(arr);
            System.out.println(Arrays.toString(arr));
        }
    }

    public static void permute(int[] arr){
        int n = arr.length;
        int[] p = new int[n];
        Random r = new Random();
        int bound = (int) Math.pow(n,3);
        for (int i = 0; i < n; i++) {
            p[i] = r.nextInt(bound);
        }
        sort(arr, p);
    }

    /**
     * 用注释部分替换掉swap部分代码则是准确根据优先级数组去打乱，但是所需要的时间更多。
     * 可以证明这样写也是可以让任意某种可能情况出现的概率为1/(n!)。因为数组P里面已经做到随机，
     * for-loop中arr[i]将与前0~i个元素等概率随机交换，这与randomize-in-place算法是一样的。
     * @param arr
     * @param p
     */
    private static void sort(int[] arr, int[] p) {
//        System.out.println(Arrays.toString(p));
        for (int i = 1; i < arr.length; i++) {
            int key = p[i];
//            int t = arr[i];
            int j = i - 1;
            while (j >= 0 && p[j] > key){
                p[j+1] = p[j];
//                arr[j+1] = arr[j];
                j--;
            }
            p[j+1] = key;
//            arr[j+1] = t;
            int temp = arr[i];
            arr[i] = arr[j+1];
            arr[j+1] = temp;
        }
//        System.out.println(Arrays.toString(arr));
    }

}
