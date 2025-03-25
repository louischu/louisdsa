package algomons.twopointers;

public class MiddleOfLinkedList {
    public static class Node<T> {
        public T val;
        public Node<T> next;

        public Node(T val) {
            this(val, null);
        }

        public Node(T val, Node<T> next) {
            this.val = val;
            this.next = next;
        }
    }

    public static int middleOfLinkedList(Node<Integer> head) {
        // WRITE YOUR BRILLIANT CODE HERE
        Node<Integer> slow = head;
        Node<Integer> fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

        }
        return slow.val;
    }
}
