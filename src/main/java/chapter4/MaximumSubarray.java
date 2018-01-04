package chapter4;

import java.util.Arrays;

/**
 * 最大子数组问题
 * @Author : jnu_mrc jnu_mrc1990@163.com
 * @Date : Created in 13:53 2017/11/23
 */
public class MaximumSubarray {
    /**
     * 测试结果：当数组较小时（size<100），暴力算法反而快过分治算法
     * @param args
     */
    public static void main(String[] args) {
        int[] arr = {3, 1, -5, 2, 4, 66, 2, -1, 10, 3, -10, 2,3, 1, -5, 2, 4, 66, 2, -1, 10, 3, -10, 2,3, 1, -5, 2, 4, 66, 2, -1, 10, 3, -10, 2,3, 1, -5, 2, 4, 66, 2, -1, 10, 3, -10, 2,3, 1, -5, 2, 4, 66, 2, -1, 10, 3, -10, 2,3, 1, -5, 2, 4, 66, 2, -1, 10, 3, -10, 2,
                3, 1, -5, 2, 4, 66, 2, -1, 10, 3, -10, 2,3, 1, -5, 2, 4, 66, 2, -1, 10, 3, -10, 2,3, 1, -5, 2, 4, 66, 2, -1, 10, 3, -10, 2,3, 1, -5, 2, 4, 66, 2, -1, 10, 3, -10, 2,3, 1, -5, 2, 4, 66, 2, -1, 10, 3, -10, 2,3, 1, -5, 2, 4, 66, 2, -1, 10, 3, -10, 2,
                3, 1, -5, 2, 4, 66, 2, -1, 10, 3, -10, 2,3, 1, -5, 2, 4, 66, 2, -1, 10, 3, -10, 2,3, 1, -5, 2, 4, 66, 2, -1, 10, 3, -10, 2,3, 1, -5, 2, 4, 66, 2, -1, 10, 3, -10, 2,3, 1, -5, 2, 4, 66, 2, -1, 10, 3, -10, 2,3, 1, -5, 2, 4, 66, 2, -1, 10, 3, -10, 2,
                3, 1, -5, 2, 4, 66, 2, -1, 10, 3, -10, 2,3, 1, -5, 2, 4, 66, 2, -1, 10, 3, -10, 2,3, 1, -5, 2, 4, 66, 2, -1, 10, 3, -10, 2,3, 1, -5, 2, 4, 66, 2, -1, 10, 3, -10, 2,3, 1, -5, 2, 4, 66, 2, -1, 10, 3, -10, 2,3, 1, -5, 2, 4, 66, 2, -1, 10, 3, -10, 2,
                3, 1, -5, 2, 4, 66, 2, -1, 10, 3, -10, 2,3, 1, -5, 2, 4, 66, 2, -1, 10, 3, -10, 2,3, 1, -5, 2, 4, 66, 2, -1, 10, 3, -10, 2,3, 1, -5, 2, 4, 66, 2, -1, 10, 3, -10, 2,3, 1, -5, 2, 4, 66, 2, -1, 10, 3, -10, 2,3, 1, -5, 2, 4, 66, 2, -1, 10, 3, -10, 2};
        long t1 = System.nanoTime();
        System.out.println(Arrays.toString(findMaximumSubarray(arr, 0, arr.length - 1)));
        long t2 = System.nanoTime();
        System.out.println(Arrays.toString(forceFindMaximumSubArray(arr)));
        long t3 = System.nanoTime();
        System.out.println(t2 - t1);
        System.out.println(t3 - t2);
    }

    /**
     * 时间复杂度为θ(n^2)的暴力求解算法
     * @param arr
     * @return
     */
    public static int[] forceFindMaximumSubArray(int[] arr) {
        int maxLeft = 0;
        int maxRight = 0;
        int maxSum = 0;
        for (int i = 0; i < arr.length; i++) {
            int subMax = Integer.MIN_VALUE;
            int subMaxRight = 0;
            int sum = 0;
            for (int j = i; j < arr.length; j++) {
                sum += arr[j];
                if (sum > subMax) {
                    subMax = sum;
                    subMaxRight = j;
                }
            }
            if (subMax > maxSum) {
                maxSum = subMax;
                maxLeft = i;
                maxRight = subMaxRight;
            }
        }
        return new int[]{maxLeft, maxRight, maxSum};
    }

    /**
     * 时间复杂度为θ(nlgn)的分治算法
     * 子数组必然属于左子数组的子数组或右子数组的子数组或一部分属于左子数组另一部分属于右子数组。
     * 最大子数组必然是A[low...mid]、A[mid+1...high]中最大子数组
     * 或当low≤i≤mid≤j≤high时，最大子数组A[i...j]三者中一个，递归求解可得。
     * @param arr
     * @param low
     * @param high
     * @return
     */
    public static int[] findMaximumSubarray(int[] arr, int low, int high) {
        if (high == low) {
            return new int[]{low, high, arr[low]};
        }
        int mid = (low + high) / 2;
        int[] left = findMaximumSubarray(arr, low, mid);
        int[] right = findMaximumSubarray(arr, mid + 1, high);
        int[] cross = findMaxCrossingSubarray(arr, low, mid, high);
        if (left[2] >= right[2] && left[2] >= cross[2]) {
            return left;
        } else if (right[2] >= left[2] && right[2] >= cross[2]) {
            return right;
        } else {
            return cross;
        }
    }

    private static int[] findMaxCrossingSubarray(int[] arr, int low, int mid, int high) {
        int leftSum = Integer.MIN_VALUE;
        int maxLeft = 0;
        int sum = 0;
        for (int i = mid; i >= low; i--) {
            sum += arr[i];
            if (sum > leftSum) {
                leftSum = sum;
                maxLeft = i;
            }
        }
        int rightSum = Integer.MIN_VALUE;
        int maxRight = 0;
        sum = 0;
        for (int i = mid + 1; i <= high; i++) {
            sum += arr[i];
            if (sum > rightSum) {
                rightSum = sum;
                maxRight = i;
            }
        }
        return new int[]{maxLeft, maxRight, leftSum + rightSum};
    }
}
