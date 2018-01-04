package chapter5;

/**
 * 取前k个人的最高分，从第k+1个人开始，雇佣第一个大于最高分的
 * 如果后 n - k个人没有比前k个人的最高分更高的，则返回最后一个人
 * 可以证明k=n/e时，可以获得最好的选到最高分的概率1/e。
 * @Author : jnu_mrc jnu_mrc1990@163.com
 * @Date : Created in 17:23 2017/12/12
 */
public class OnLineMaximum {
    public static void main(String[] args) {
        int count = 0;
        int n = 1000;
        for (int i = 0; i < n; i++) {
            int size = 100;
            int[] score = new int[size];
            for (int j = 0; j < size; j++) {
                score[j] = j;
            }
            RandomizeInPlace.randomInPlace(score);
            int max = onLineMaximum(score);
            boolean isMax = isMax(max,score);
            if(isMax){
                count++;
            }
//            System.out.println(Arrays.toString(score) + ", max="+max+", isMax="+isMax);
        }
        System.out.println(count);
        System.out.println(n / Math.E);
    }

    private static boolean isMax(int index, int[] arr){
        int t = arr[index];
        for (int i = 0; i < arr.length; i++) {
            if(i != index && arr[i] > t){
                return false;
            }
        }
        return true;
    }

    public static int onLineMaximum(int[] score){
        int n = score.length;
        int k = (int) (n / Math.E);
        int bestScore = Integer.MIN_VALUE;
        for (int i = 0; i < k; i++) {
            if(score[i] > bestScore){
                bestScore = score[i];
            }
        }
        for (int i = k + 1; i < n; i++) {
            if(score[i] > bestScore){
                return i;
            }
        }
        return n - 1;
    }
}
