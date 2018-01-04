package chapter8;

import tool.MrcTool;

/**
 * 水壶问题：n个红色壶和n个蓝色壶，每个壶都有与之不同颜色的容量相同的壶。
 * 不允许同颜色比较，可以不同颜色比较大小。求将其排序的算法。
 * Ο(nlgn)的算法，类似快排。先随机从红色取一个壶，然后从蓝色中找出一个相同的壶，再分别PARTITION，再利用分治得出结果。
 *
 * @Author : jnu_mrc jnu_mrc1990@163.com
 * @Date : Created in 14:07 2017/12/20
 */
public class KettleProblem {
    public static void main(String[] args) {
        //数组大小
        int n = 10;
        RedKettle[] red = new RedKettle[n];
        BlueKettle[] blue = new BlueKettle[n];
        for (int i = 0; i < n; i++) {
            red[i] = new RedKettle(i);
            blue[i] = new BlueKettle(i);
        }
        //使用θ(n)的随机算法打乱顺序
        for (int i = 0; i < n; i++) {
            swap(red, i, MrcTool.nextInt(i, n));
            swap(blue, i, MrcTool.nextInt(i, n));
        }
        //输出排序前顺序
        System.out.println("before");
        System.out.print("red : ");
        for (int i = 0; i < n; i++) {
            System.out.printf(red[i].key + ", ");
        }
        System.out.println();
        System.out.print("blue: ");
        for (int i = 0; i < n; i++) {
            System.out.printf(blue[i].key + ", ");
        }
        System.out.println();
        //调用排序主方法
        sort(red, blue, 0, n - 1);
        //输出排序后结果
        System.out.println("after");
        System.out.print("red : ");
        for (int i = 0; i < n; i++) {
            System.out.printf(red[i].key + ", ");
        }
        System.out.println();
        System.out.print("blue: ");
        for (int i = 0; i < n; i++) {
            System.out.printf(blue[i].key + ", ");
        }
        System.out.println();
    }

    public static void sort(RedKettle[] red, BlueKettle[] blue, int p, int r) {
        //这里使用循环优化第二次递归调用（也许聪明的编译器也会帮你做这件事）
        while (p < r) {
            //generate a random pivot
            int rn = MrcTool.nextInt(p, r + 1);
            Kettle rk = red[rn];
            int bn = r;
            //find an equal elem from the other set
            for (int i = p; i < r; i++) {
                if (rk.compare(blue[i]) == 0) {
                    bn = i;
                    break;
                }
            }
            swap(red, r, rn);
            swap(blue, r, bn);
            //order will change after one partition execute
            rk = red[r];
            Kettle bk = blue[r];
            int q = partition(red, p, r, bk);
            partition(blue, p, r, rk);
            //sort the two part
            sort(red, blue, p, q - 1);
            p = q + 1;
        }
    }

    private static int partition(Kettle[] k, int p, int r, Kettle x) {
        int i = p - 1;
        for (int j = p; j < r; j++) {
            if (k[j].compare(x) <= 0) {
                i++;
                swap(k, i, j);
            }
        }
        swap(k, i + 1, r);
        return i + 1;
    }

    private static void swap(Kettle[] k, int a, int b) {
        Kettle t = k[a];
        k[a] = k[b];
        k[b] = t;
    }


    private static class Kettle {
        protected String type;
        protected int key;

        protected int compare(Kettle k) {
            if (this.type.equals(k.type)) {
                throw new UnsupportedOperationException();
            }
            return this.key - k.key;
        }
    }

    private static class RedKettle extends Kettle {
        public RedKettle(int key) {
            type = "red";
            this.key = key;
        }
    }

    private static class BlueKettle extends Kettle {
        public BlueKettle(int key) {
            type = "blue";
            this.key = key;
        }
    }
}
