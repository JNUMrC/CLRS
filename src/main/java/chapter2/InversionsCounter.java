package chapter2;

/**
 * 通过修改归并算法求数组中的逆序对
 * 在merge的时候L和R里面都已经经过排序，所以合并之前遍历L中元素，记录R中小于该元素的元素的数量。
 * @Author : jnu_mrc jnu_mrc1990@163.com
 * @Date : Created in 18:46 2017/11/22
 */
public class InversionsCounter {
    public static void main(String[] args) {
        int[] arr = {34,2,1,4,5,3};
        System.out.println(count(arr));
    }

    public static int count(int[] arr){
        return mergeSort(arr,0,arr.length - 1);
    }

    private static int merge(int[] arr, int p, int q, int r){
        int n1 = q - p + 1;
        int n2 = r - q;
        int[] left = new int[n1+1];
        int[] right = new int[n2+1];
        int count = 0;
        for (int i = 0; i < n1; i++) {
            left[i] = arr[p + i];
        }
        for (int i = 0; i < n2; i++) {
            right[i] = arr[q + i + 1];
        }

        for (int i = 0; i < n1; i++) {
            int x = left[i];
            for (int j = 0; j < n2; j++) {
                if(right[j] >= x){
                    break;
                }
                count++;
            }
        }
        left[n1] = Integer.MAX_VALUE;
        right[n2] = Integer.MAX_VALUE;
        int a = 0,b = 0;
        for (int i = p; i <= r; i++) {
            if(left[a] <= right[b]){
                arr[i] = left[a++];
            }else{
                arr[i] = right[b++];
            }
        }
        return count;
    }

    public static int mergeSort(int[] arr, int p, int r){
        int count = 0;
        if(p < r){
            int q = (p + r) / 2;
            count += mergeSort(arr,p,q);
            count += mergeSort(arr,q + 1,r);
            count += merge(arr,p,q,r);
        }
        return count;
    }
}
