package chapter10;

/**
 * 栈
 * @Author : jnu_mrc jnu_mrc1990@163.com
 * @Date : Created in 14:13 2018/1/9
 */
public class Stack {
    public static void main(String[] args) {
        Stack stack = new Stack(10);
        for (int i = 0; i < 10; i++) {
            stack.push(i << 1);
        }
        while (!stack.empty()) {
            System.out.println(stack.pop());
        }
    }

    private int[] arr;
    private int top = -1;

    public Stack(int n) {
        arr = new int[n];
    }

    public boolean empty() {
        return top < 0;
    }

    public void push(int x) {
        if (top == arr.length) {
            throw new ArrayIndexOutOfBoundsException(top);
        }
        arr[++top] = x;
    }

    public int pop() {
        if (empty()) {
            throw new ArrayIndexOutOfBoundsException(top);
        }
        return arr[top--];
    }
}
