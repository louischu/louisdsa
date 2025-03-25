package leetcode.linkedlist;

public class CycleLinkedList {
    public static void main(String[] args) {

    }

    public static boolean hasCycle(ListNode head) {
        boolean ret = false;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast != null && slow == fast) {
                return true;
            }
        }
        return ret;
    }

}
