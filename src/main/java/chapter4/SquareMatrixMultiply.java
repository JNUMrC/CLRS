package chapter4;

import java.util.Arrays;

/**
 * 朴素算法，时间复杂度θ(n^3)
 * @Author : jnu_mrc jnu_mrc1990@163.com
 * @Date : Created in 10:06 2017/11/27
 */
public class SquareMatrixMultiply {
    public static void main(String[] args) {
        int[][] a = {{1, 1}, {1, 0}};
        int[][] b = {{1, 1}, {1, 0}};
        int[][] c = a;
        for (int i = 0; i < 3; i++) {
            c = calculate(c, b);
        }
        for (int[] ints : c) {
            System.out.println(Arrays.toString(ints));
        }
    }

    private static int[][] calculate(int[][] a, int[][] b) {
        int n = a.length;
        int[][] c = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int v = 0;
                for (int k = 0; k < n; k++) {
                    v += a[i][k] * b[k][j];
                }
                c[i][j] = v;
            }
        }
        return c;
    }
}
