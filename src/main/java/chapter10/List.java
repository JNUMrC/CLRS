package chapter10;

/**
 * 使用了哨兵的链表
 * @Author : jnu_mrc jnu_mrc1990@163.com
 * @Date : Created in 15:40 2018/1/12
 */
public class List {
    public static void main(String[] args) {
        List list = new List();
        for (int i = 0; i < 10; i++) {
            list.insert(new Node(i));
        }
        for (int i = 0; i < 10; i+=2) {
            Node node = list.search(i);
            if(node != null){
                list.delete(node);
            }
        }
        Node x = list.nil.next;
        while(x != list.nil){
            System.out.println(x);
            x = x.next;
        }
    }
    private Node nil;

    public List() {
        nil = new Node(0);
        nil.next = nil;
        nil.prev = nil;
    }

    public Node search(int k){
        Node x = nil.next;
        nil.key = k;//这样处理就不用判断是否为nil
        while(x.key != k){
            x = x.next;
        }
        return x;
    }

    public void insert(Node x){
        x.next = nil.next;
        nil.next.prev = x;
        nil.next = x;
        x.prev = nil;
    }

    public void delete(Node x){
        x.prev.next = x.next;
        x.next.prev = x.prev;
    }

    private static class Node{
        public Node(int key) {
            this.key = key;
        }

        private Node prev;
        private int key;
        private Node next;

        @Override
        public String toString() {
            return "key="+key;
        }
    }
}
