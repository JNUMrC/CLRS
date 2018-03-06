package chapter10;

/**
 * 双端队列
 * @Author : jnu_mrc jnu_mrc1990@163.com
 * @Date : Created in 18:00 2018/1/10
 */
public class Deque {
    public static void main(String[] args) {
        Deque deque = new Deque(10);
        for (int i = 0; i < 5; i++) {
            if(deque.isFull()){
                break;
            }
            deque.addFirst(i+1);
            if(deque.isFull()){
                break;
            }
            deque.addLast((i+1)<<1);
        }
        while (!deque.isEmpty()){
            System.out.println(deque.removeFirst());
        }
    }
    private int[] arr;
    private int head = 0;
    private int tail = 0;
    private int size = 0;
    public Deque(int n) {
        arr = new int[n];
    }
    public boolean isEmpty(){
        return size == 0;
    }
    public boolean isFull(){
        return size == arr.length;
    }
    public void addFirst(int x){
        if(head == 0){
            head = arr.length - 1;
        }else {
            head--;
        }
        arr[head] = x;
        size++;
    }
    public int removeFirst(){
        int x = arr[head];
        if(head == arr.length - 1){
            head = 0;
        }else {
            head++;
        }
        size--;
        return x;
    }
    public void addLast(int x){
        arr[tail] = x;
        if(tail == arr.length - 1){
            tail = 0;
        }else {
            tail++;
        }
        size++;
    }

    public int removeLast(){
        if(tail == 0){
            tail = arr.length - 1;
        }else {
            tail--;
        }
        size--;
        return arr[tail];
    }
}
