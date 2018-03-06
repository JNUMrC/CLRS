package chapter10;

/**
 * 无限分支树。
 *
 * @Author : jnu_mrc jnu_mrc1990@163.com
 * @Date : Created in 16:55 2018/1/12
 */
public class Tree {


    public static void dfs(Node node) {
        System.out.println("key=" + node.key);
        Node child = node.firstChild;
        if (child != null) {
            dfs(child);
        }
        Node brother = node.nextBrother;
        if (brother != null) {
            dfs(brother);
        }
    }

    public static void bfs(Node node) {
        System.out.println("key=" + node.key);
        Node brother = node.nextBrother;
        if (brother != null) {
            bfs(brother);
        }
        Node child = node.firstChild;
        if (child != null) {
            bfs(child);
        }
    }

    private Node root = new Node();

    public Tree() {

    }

    private static class Node {
        private Node p = null;
        private int key;
        private Node firstChild = null;
        private Node nextBrother = null;
    }
}
