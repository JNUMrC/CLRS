package chapter9;

/**
 * 找到两个同大小有序数组的中位数
 * 最坏情况时间复杂度为θ(lgn)
 * @Author : jnu_mrc jnu_mrc1990@163.com
 * @Date : Created in 11:56 2018/1/8
 */
public class FindMid {
    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 3, 5, 7, 8, 9};
        int[] b = new int[]{4, 6, 12, 14, 16, 18, 20};
        System.out.println(find(a, 0, a.length - 1, b, 0, b.length - 1));
    }


    public static int find(int[] a, int sa, int ea, int[] b, int sb, int eb) {
        if (sa == ea) {
            return a[sa] <= b[sb] ? a[sa] : b[sb];
        }
        int ma = (sa + ea) / 2;
        int mb = (sb + eb) / 2;
        int va = a[ma];
        int vb = b[mb];
        if (va <= vb) {
            if (b[mb - 1] > va) {
                return find(a, ma + 1, ea, b, sb, (ea - sa) % 2 == 1 ? mb : mb - 1);
            }
            return va;
        } else {
            if (a[ma - 1] > vb) {
                return find(a, sa, (ea - sa) % 2 == 1 ? ma : ma - 1, b, mb + 1, eb);
            }
            return vb;
        }
    }
}
