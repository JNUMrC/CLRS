package chapter5;

import java.util.Random;

/**
 * 测试n个等概率随机0或1连续串长度
 * @Author : jnu_mrc jnu_mrc1990@163.com
 * @Date : Created in 15:28 2017/12/4
 */
public class ContinuousTest {
    public static void main(String[] args) {
        int n = 1000;
        boolean[] arr = new boolean[n];
        Random r= new Random();
        int max = 0;
        for (int j = 0; j < 100; j++) {
            for (int i = 0; i < arr.length; i++) {
                arr[i] = r.nextBoolean();
            }
            int maxCount = 0;
            boolean cur = false;
            int count = 0;
            for (int i = 0; i < arr.length; i++) {
                if(cur ^ arr[i]){
                    cur = arr[i];
                    if(maxCount < count){
                        maxCount = count;
                    }
                    count = 0;
                }else {
                    count++;
                }
            }
            System.out.println(maxCount);
            if(max < maxCount){
                max = maxCount;
            }
        }

    }
}
