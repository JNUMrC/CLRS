package chapter5;

/**
 * 生日悖论问题，使用指示器随机变量
 * E[X] = {k \choose 2}\frac1n
 * @Author : jnu_mrc jnu_mrc1990@163.com
 * @Date : Created in 18:49 2017/12/12
 */
public class BirthdayParadox {
    public static void main(String[] args) {
        System.out.println(atLeastNum(2));
        System.out.println(atLeastNum(3));
    }

    /**
     * 最少N人使得k个人的生日在同一天的期望大于1
     * @param k the number of people have same birthday
     * @return the least number of people that bring a high probability
     */
    public static int atLeastNum(int k) {
        int n = 1;
        int t = 2;
        for (int i = 0; i < k - 1; i++) {
            n *= 365;
            n *= t++;
        }
        int assumption = 10;
        while (true) {
            int m = 1;
            for (int i = 0; i < k; i++) {
                m *= assumption - i;
            }
            if (m > n) {
                break;
            }
            assumption++;
        }
        return assumption;
    }
}
