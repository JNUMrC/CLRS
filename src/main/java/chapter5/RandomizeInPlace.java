package chapter5;

import tool.MrcTool;

import java.util.Arrays;

/**
 * θ(n)的数组随机打乱算法
 * RANDOMIZE-IN-PLACE(A)
 * n = A.length
 * for i = 1 to n
 *     swap A[i] with A[RANDOM(i,n)]
 * @Author : jnu_mrc jnu_mrc1990@163.com
 * @Date : Created in 11:58 2017/12/1
 */
public class RandomizeInPlace {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9};
        for (int i = 0; i < 9; i++) {
            randomInPlace(arr);
            System.out.println(Arrays.toString(arr));
        }
    }
    public static void randomInPlace(int[] arr){
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int idx = MrcTool.nextInt(i,n);
            int temp = arr[i];
            arr[i] = arr[idx];
            arr[idx] = temp;
        }
    }

}
