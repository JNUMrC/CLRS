package chapter6;

/**
 * 用最大堆实现优先队列
 * @Author : jnu_mrc jnu_mrc1990@163.com
 * @Date : Created in 11:49 2017/12/15
 */
public class Queue {
    public static void main(String[] args) {
        Queue queue = new Queue();
        for (int i = 0; i < 100; i++) {
            queue.push(i);
        }
        while(!queue.isEmpty()){
            System.out.println(queue.see());
            System.out.println(queue.pop());
        }
    }
    MaxHeap h = new MaxHeap();

    public boolean isEmpty(){
        return h.size() == 0;
    }
    public void push(int key){
        h.insert(key);
    }

    public int see(){
        return h.maximum();
    }

    public int pop(){
        return h.extractMax();
    }
}
