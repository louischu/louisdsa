package leetcode.linkedlist;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public void print(String message) {
        ListNode temp = this;
        while (temp != null) {
            System.out.println(message + temp.val);
            temp = temp.next;
        }
    }

    public void appendLast(int value) {
        ListNode temp = this;
        while (temp.next != null) {

            temp = temp.next;
        }
        temp.next = new ListNode(value);

    }

    public static ListNode fromArray(int... arr) {
        ListNode head = new ListNode(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            head.appendLast(arr[i]);
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode listNode = ListNode.fromArray(1, 2, 3, 4, 6);
        listNode.print("Hello:");
    }
}
