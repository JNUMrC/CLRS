package tool;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @Author : jnu_mrc jnu_mrc1990@163.com
 * @Date : Created in 18:24 2017/12/12
 */
public class MrcTool {
    public static void main(String[] args) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < 10000; i++) {
            int n = nextInt(10, 20);
            if(map.get(n) == null){
                map.put(n,1);
            }else{
                map.put(n,map.get(n)+1);
            }
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + "   " + entry.getValue());
        }

        for (int i = 0; i < 10; i++) {
            System.out.println(fibonacci(i));
        }
    }
    public static Random r = new Random();
    public static int nextInt(int low, int high){
        return low + r.nextInt(high - low);
    }
    public static int fibonacci(int n){
        return fibonacci(0,1,n);
    }
    private static int fibonacci(int a, int b, int n){
        if(n == 0){
            return a;
        }else{
            return fibonacci(b, a+b,n-1);
        }
    }

    public static void swap(int[] arr, int a, int b) {
        int t = arr[a];
        arr[a] = arr[b];
        arr[b] = t;
    }
}
