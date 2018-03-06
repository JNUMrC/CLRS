package chapter10;

/**
 * 队列
 * @Author : jnu_mrc jnu_mrc1990@163.com
 * @Date : Created in 14:49 2018/1/9
 */
public class Queue {
    public static void main(String[] args) {
        Queue queue = new Queue(10);
        int x=  1;
        while (!queue.isFull()){
            queue.enqueue(x++);
        }
        while (!queue.isEmpty()){
            System.out.println(queue.dequeue());
        }
    }
    private int[] arr;
    private int head = 0;
    private int tail = 0;
    private int size = 0;
    public Queue(int n) {
        arr = new int[n];
    }

    public boolean isEmpty(){
        return size == 0;
    }
    public boolean isFull(){
        return size == arr.length;
    }
    public void enqueue(int x){
        arr[tail] = x;
        if(tail == arr.length - 1){
            tail = 0;
        }else {
            tail++;
        }
        size++;
    }
    public int dequeue(){
        int x = arr[head];
        if(head == arr.length - 1){
            head = 0;
        }else {
            head++;
        }
        size--;
        return x;
    }
}
