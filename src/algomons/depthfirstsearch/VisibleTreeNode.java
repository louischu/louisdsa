package algomons.depthfirstsearch;

public class VisibleTreeNode {
    public static class Node<T> {
        public T val;
        public Node<T> left;
        public Node<T> right;

        public Node(T val) {
            this(val, null, null);
        }

        public Node(T val, Node<T> left, Node<T> right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static int dfs(Node<Integer> node, int max) {
        if (node != null) {
            int total = 0;
            if (node.val >= max) {
                total++;
            }
            total += dfs(node.left, Math.max(max, node.val));
            total += dfs(node.right, Math.max(max, node.val));
            return total;
        } else {
            return 0;
        }
    }

    public static int visibleTreeNode(Node<Integer> root) {
        // WRITE YOUR BRILLIANT CODE HERE
        return dfs(root, 0);
    }

    public static void main(String[] args) {

    }
}
