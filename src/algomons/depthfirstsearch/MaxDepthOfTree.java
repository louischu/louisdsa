package algomons.depthfirstsearch;

/**
 * Max depth of a binary tree is the longest root-to-leaf path.
 * Given a binary tree, find its max depth.
 * Here, we define the length of the path to be the number of edges on that path, not the number of nodes.
 */
public class MaxDepthOfTree {
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

    private static int dfs(Node<Integer> root) {
        // Null node adds no depth
        if (root == null) return 0;
        // num nodes in longest path of current subtree = max num nodes of its two subtrees + 1 current node
        return Math.max(dfs(root.left), dfs(root.right)) + 1;
    }

    public static int treeMaxDepth(Node<Integer> root) {
        // WRITE YOUR BRILLIANT CODE HERE
        return (root != null) ? dfs(root) - 1 : 0;
    }

    public static void main(String[] args) {

    }
}
