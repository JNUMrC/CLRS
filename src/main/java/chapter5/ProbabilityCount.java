package chapter5;

import tool.MrcTool;

import java.util.Random;

/**
 * 概率计数法（损失精度）：针对一个单调递增序列f(count) = n
 * @Author : jnu_mrc jnu_mrc1990@163.com
 * @Date : Created in 10:12 2017/12/13
 */
public class ProbabilityCount {
    public static void main(String[] args) {

        for (int i = 0; i < 20; i++) {
            int[] arr = {1,11,12,19,200,201,222,2333,2451,8888,10000,20000,50000,90000,200000};
            ProbabilityCount c = new ProbabilityCount();
            for (int j = 0; j < arr.length-1; j++) {
                c.increament(arr[j],arr[j+1]);
            }
            System.out.println(arr[c.count]+" "+arr.length);
        }
        System.out.println("------------------------------");
        for (int j = 0; j < 20; j++) {
            ProbabilityCount count = new ProbabilityCount();
            for (int i = 0; i < 34; i++) {
                count.increament(MrcTool.fibonacci(i), MrcTool.fibonacci(i + 1));
            }
            System.out.println(MrcTool.fibonacci(count.count));
        }
        System.out.println("------------------------------");
        for (int i = 0; i < 20; i++) {
            ProbabilityCount count = new ProbabilityCount();
            for (int j = 0; j < 34; j++) {
                count.increament(j, j + 1);
            }
            System.out.println(count.count);
        }
        System.out.println("------------------------------");
        for (int i = 0; i < 20; i++) {
            ProbabilityCount count = new ProbabilityCount();
            for (int j = 0; j < 34; j++) {
                count.increament((int) Math.pow(2, j - 1), (int) Math.pow(2, j));
            }
            System.out.println((int) Math.pow(2, count.count));
        }

    }

    private int count = 0;

    public boolean increament(int current, int next) {
        if (next <= current) {
            count++;
            return true;
        }
        final Random r = MrcTool.r;
        double v = r.nextDouble();
        double p = 1d / (next - current);
        if (v <= p) {
            count++;
            return true;
        }
        return false;
    }
}
