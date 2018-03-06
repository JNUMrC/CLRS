package chapter12;

/**
 * 二叉树
 *
 * @Author : jnu_mrc jnu_mrc1990@163.com
 * @Date : Created in 17:37 2018/1/15
 */
public class BinaryTree<T> {
    public static void main(String[] args) {
        //用二叉树
        int[] arr = {5, 3, 1, 9, 7, 2, 8, 6, 4};
        BinaryTree<Integer> tree = new BinaryTree<>();
        for (int i = 0; i < arr.length; i++) {
            tree.insert(arr[i]);
        }
        tree.inOrderTreeWalk(tree.root);
        System.out.println();
    }

    private Node<T> root;
    private int size;

    public BinaryTree() {
    }

    public BinaryTree(Node<T> root) {
        this.root = root;
    }

    public Node<T> search(Node<T> x, T key) {
        while (x != null) {
            int r = x.key.compareTo(key);
            if (r == 0) {
                break;
            }
            if (r > 0) {
                x = x.left;
            } else {
                x = x.right;
            }
        }
        return x == null ? null : x;
    }

    public Node<T> minimum(Node<T> x) {
        while (x.left != null) {
            x = x.left;
        }
        return x;
    }

    public Node<T> maximum(Node<T> x) {
        while (x.right != null) {
            x = x.right;
        }
        return x;
    }

    public Node<T> predecessor(Node<T> x) {
        if (x.left != null) {
            return maximum(x.left);
        }
        Node<T> y = x.p;
        while (y != null && x == y.left) {
            x = y;
            y = y.p;
        }
        return y;
    }

    public Node<T> successor(Node<T> x) {
        if (x.right != null) {
            return minimum(x.right);
        }
        Node<T> y = x.p;
        while (y != null && x == y.right) {
            x = y;
            y = y.p;
        }
        return y;
    }

    public void insert(T z) {
        Node<T> y = null;
        Node<T> x = root;
        while (x != null) {
            y = x;
            if (x.key.compareTo(z) > 0) {
                x = x.left;
            } else {
                x = x.right;
            }
        }
        Node<T> newNode = new Node<T>();
        newNode.key = (Comparable<T>) z;
        newNode.p = y;
        if (y == null) {
            root = newNode;
        } else if (y.key.compareTo(z) > 0) {
            y.left = newNode;
        } else {
            y.right = newNode;
        }
    }

    private void transplant(Node<T> u, Node<T> v) {
        if (u.p == null) {
            root = v;
        } else if (u == u.p.left) {
            u.p.left = v;
        } else {
            u.p.right = v;
        }
        if (v != null) {
            v.p = u.p;
        }
    }

    public void delete(Node<T> z) {
        if (z.left == null) {
            transplant(z, z.right);
        } else if (z.right == null) {
            transplant(z, z.left);
        } else {
            Node<T> y = minimum(z.right);
            if (y.p != z) {
                transplant(y, y.right);
                y.right = z.right;
                y.right.p = y;
            }
            transplant(z, y);
            y.left = z.left;
            y.left.p = y;
        }
    }

    public void inOrderTreeWalk(Node<T> x) {
        if (x != null) {
            inOrderTreeWalk(x.left);
            System.out.print(x.key + ", ");
            inOrderTreeWalk(x.right);
        }
    }

    private static class Node<T> {
        private Comparable<T> key;
        private Node<T> p;
        private Node<T> left;
        private Node<T> right;
    }
}
