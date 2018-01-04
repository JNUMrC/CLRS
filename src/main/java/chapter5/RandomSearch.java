package chapter5;

import tool.MrcTool;

import java.util.HashSet;
import java.util.Set;

/**
 * 随机搜索，次数的期望是size
 *
 * @Author : jnu_mrc jnu_mrc1990@163.com
 * @Date : Created in 15:03 2017/12/13
 */
public class RandomSearch {
    private static int sum = 0;

    public static void main(String[] args) {
        int[] arr = {4, 1, 2, 7, 3};
        sum = 0;
        for (int i = 0; i < 1000000; i++) {
            indexOf(2, arr);
        }
        System.out.println(sum / 1000000d);
    }

    public static int indexOf(int target, int[] arr) {
        int len = arr.length;
        Set<Integer> set = new HashSet<>();
        int count = 0;
        int idx;
        do {
            count++;
            idx = MrcTool.r.nextInt(len);
            if(set.size() >= len){
                break;
            }else {
                set.add(idx);
            }
        } while (arr[idx] != target);
        sum += count;
        return idx;
    }
}
