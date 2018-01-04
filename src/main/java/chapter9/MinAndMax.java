package chapter9;

/**
 * 同时得出最小值和最大值，比较次数为3(n/2)次（忽略掉初始的差异）
 * @Author : jnu_mrc jnu_mrc1990@163.com
 * @Date : Created in 15:22 2017/12/21
 */
public class MinAndMax {
    public static void main(String[] args) {
        int[] arr = new int[]{3,5,1,6,7,9,2,4,8};
        minAndMax(arr);
    }

    public static void minAndMax(int[] arr) {
        int len = arr.length;
        int min, max;
        //根据奇偶情况设置初始值
        if (len % 2 == 0) {
            if (arr[0] > arr[1]) {
                min = arr[1];
                max = arr[0];
            } else {
                min = arr[0];
                max = arr[1];
            }
        } else {
            min = max = arr[0];
        }
        //对余下值判断得出结果
        for (int i = len - 1; i > 1; i -= 2) {
            int a = arr[i];
            int b = arr[i - 1];
            if (a > b) {
                if (a > max) {
                    max = a;
                }
                if (b < min) {
                    min = b;
                }
            } else {
                if (b > max) {
                    max = b;
                }
                if (a < min) {
                    min = a;
                }
            }
        }
        System.out.println("max=" + max + ", min=" + min);
    }
}