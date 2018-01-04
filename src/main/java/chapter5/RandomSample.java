package chapter5;

import java.util.*;

/**
 * 从长度为n的数组中等概率取一部分数。
 * 
 * 算法正确性：假设某一次递归返回的S中1~n-1是机会均等的取了m-1个，
 * 那么这次返回时S是一个包含n的集合的某个确定集合概率为
 * $\frac{1}{{m-1} \choose {n-1}}*\frac{m}{n}=\frac{1}{m \choose n}$
 * （从n-1个中选了m-1个，并且又选中了m-1个中一个或直接选中了n），
 * 返回的S是一个不包含n的某个确定集合的概率为
 * $\frac{1}{m \choose {n-1}}*\frac{n-m}{n}=\frac{1}{m \choose n}$
 * （因为不包含n，所以是从n-1个中选择了m个，并且随机的时候加入了新的i即从n个中选择了除去n和已经有的m-1个中的一个）。
 * 这两个并不是互斥事件，因为返回的是很多种情况中的具体一种，包含n的返回可能很多种，
 * 不包含n的返回也有很多种，指的是其中一种相对于所有情况的概率。
 * @Author : jnu_mrc jnu_mrc1990@163.com
 * @Date : Created in 18:15 2017/12/1
 */
public class RandomSample {
    public static void main(String[] args) {
        int n = 20;
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(i,0);
        }
        for (int i = 0; i < 10000; i++) {
            List<Integer> list = randomSample(n/2, n);
            for (Integer integer : list) {
                map.put(integer,map.get(integer)+1);
            }
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey()+" : "+entry.getValue());
        }

    }
    private static Random r = new Random();

    public static List<Integer> randomSample(int m, int n){
        if(m == 0){
            return new ArrayList<>();
        }else{
            List<Integer> s = randomSample(m - 1, n - 1);
            int i = r.nextInt(n);
            if(s.indexOf(i) != -1){
                s.add(n - 1);
            }else {
                s.add(i);
            }
            return s;
        }
    }


}
