package chapter10;

/**
 * 基于栈的队列
 * @Author : jnu_mrc jnu_mrc1990@163.com
 * @Date : Created in 17:26 2018/1/11
 */
public class QueueBaseStack {
    public static void main(String[] args) {
        QueueBaseStack qbs = new QueueBaseStack(10);
        for (int i = 0; i < 5; i++) {
            qbs.enqueue(i);
        }
        while (!qbs.empty()){
            System.out.println(qbs.dequeue());
        }
    }
    private Stack a;
    private Stack b;
    public QueueBaseStack(int n) {
        a = new Stack(n);
        b = new Stack(n);
    }
    public boolean empty(){
        return a.empty() && b.empty();
    }
    public void enqueue(int x) {
        a.push(x);
    }

    public int dequeue() {
        if(b.empty()){
            while(!a.empty()){
                b.push(a.pop());
            }
        }
        if(b.empty()){
            throw new RuntimeException();
        }
        return b.pop();
    }
}
