package chapter4;

import java.util.Arrays;

/**
 * strassen算法 时间复杂度为θ(n^(lg7))
 * @Author : jnu_mrc jnu_mrc1990@163.com
 * @Date : Created in 10:51 2017/11/28
 */
public class SquareMatrixMultiplyStrassen {
    public static void main(String[] args) {
        int[][] a = {{1, 1, 0, 1}, {1, 0, 1, 1}, {0, 1, 1, 1}, {0, 0, 1, 1}};
        int[][] b = {{1, 1, 0, 1}, {1, 0, 1, 1}, {0, 1, 1, 1}, {0, 0, 1, 1}};
        int[][] c = calculate(a, b);
        for (int[] ints : c) {
            System.out.println(Arrays.toString(ints));
        }
    }

    public static int[][] calculate(int[][] a, int[][] b) {
        return calculate(a, 0, 0, b, 0, 0, a.length);
    }

    private static int[][] calculate(int[][] a, int ax, int ay, int[][] b, int bx, int by, int n) {
        int[][] c = new int[n][n];
        if (n == 1) {
            c[0][0] = a[ax][ay] * b[bx][by];
        } else {
            n = n / 2;
            //求S
            int[][][] s = new int[10][n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    int axi = ax + i;
                    int ayj = ay + j;
                    int bxi = bx + i;
                    int byj = by + j;
                    s[0][i][j] = b[bxi + n][byj] - b[bxi + n][byj + n];//S1 = B12 - B22
                    s[1][i][j] = a[axi][ayj] + a[axi + n][ayj];//S2 = A11 + A12
                    s[2][i][j] = a[axi][ayj + n] + a[axi + n][ayj + n];//S3 = A21 + A22
                    s[3][i][j] = b[bxi][byj + n] - b[bxi][byj];//S4 = B21 - B11
                    s[4][i][j] = a[axi][ayj] + a[axi + n][ayj + n];//S5 = A11 + A22
                    s[5][i][j] = b[bxi][byj] + b[bxi + n][byj + n];//S6 = B11 + B22
                    s[6][i][j] = a[axi + n][ayj] - a[axi + n][ayj + n];//S7 = A12 - A22
                    s[7][i][j] = b[bxi][byj + n] + b[bxi + n][byj + n];//S8  =B21 + B22
                    s[8][i][j] = a[axi][ayj] - a[axi][ayj + n];//S9 = A11 - A21
                    s[9][i][j] = b[bxi][byj] + b[bxi + n][byj];//S10 = B11 + B12
                }
            }
            //求P
            int[][][] p = new int[7][n][n];
            p[0] = calculate(a, ax, ay, s[0], 0, 0, n);//P1 = A11 * S1
            p[1] = calculate(s[1], 0, 0, b, bx + n, by + n, n);//P2 = S2 * B22
            p[2] = calculate(s[2], 0, 0, b, bx, by, n);//P3 = S3 * B11
            p[3] = calculate(a, ax + n, ay + n, s[3], 0, 0, n);//P4 = A22 * S4
            p[4] = calculate(s[4], 0, 0, s[5], 0, 0, n);//P5 = S5 * S6
            p[5] = calculate(s[6], 0, 0, s[7], 0, 0, n);//P6 = S7 * S8
            p[6] = calculate(s[8], 0, 0, s[9], 0, 0, n);//P7 = S9 * S10
            //求C
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    c[i][j] = p[4][i][j] + p[3][i][j] - p[1][i][j] + p[5][i][j];//C11 = P5 + P4 - P2 + P6
                    c[i + n][j] = p[0][i][j] + p[1][i][j];//C12 = P1 + P2
                    c[i][j + n] = p[2][i][j] + p[3][i][j];//C21 = P3 + P4
                    c[i + n][j + n] = p[4][i][j] + p[0][i][j] - p[2][i][j] - p[6][i][j];//C22 = P5 + P1 - P3 - P7
                }
            }
        }
        return c;
    }
}
