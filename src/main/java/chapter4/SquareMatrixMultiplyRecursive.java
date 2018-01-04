package chapter4;

import java.util.Arrays;

/**
 * 分治算法，时间复杂度θ(n^3)，使用了下标技巧
 * @Author : jnu_mrc jnu_mrc1990@163.com
 * @Date : Created in 14:54 2017/11/27
 */
public class SquareMatrixMultiplyRecursive {
    public static void main(String[] args) {
        int[][] a = {{1, 1, 0, 1}, {1, 0, 1, 1}, {0, 1, 1, 1}, {0, 0, 1, 1}};
        int[][] b = {{1, 1, 0, 1}, {1, 0, 1, 1}, {0, 1, 1, 1}, {0, 0, 1, 1}};
        int[][] c = calculate(a, b);
        for (int[] ints : c) {
            System.out.println(Arrays.toString(ints));
        }

    }

    /**
     * assert a & b has same structure
     * @param a
     * @param b
     * @return
     */
    public static int[][] calculate(int[][] a, int[][] b) {
        return calculate(a, 0, 0, b, 0, 0, a.length);
    }

    private static int[][] calculate(int[][] a, int ax, int ay, int[][] b, int bx, int by, int n) {
        int[][] c = new int[n][n];
        if (n == 1) {
            c[0][0] = a[ax][ay] * b[bx][by];
        } else {
            n /= 2;
            sum(c, 0, 0, calculate(a, ax, ay, b, bx, by, n), calculate(a, ax + n, ay, b, bx, by + n, n), n);
            sum(c, n, 0, calculate(a, ax, ay, b, bx + n, by, n), calculate(a, ax + n, ay, b, bx + n, by + n, n), n);
            sum(c, 0, n, calculate(a, ax, ay + n, b, bx, by, n), calculate(a, ax + n, ay + n, b, bx, by + n, n), n);
            sum(c, n, n, calculate(a, ax, ay + n, b, bx + n, by, n), calculate(a, ax + n, ay + n, b, bx + n, by + n, n), n);
        }

        return c;
    }

    private static void sum(int[][] c, int x, int y, int[][] sub1, int[][] sub2, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                c[x + i][y + j] = sub1[i][j] + sub2[i][j];
            }
        }
    }
}
