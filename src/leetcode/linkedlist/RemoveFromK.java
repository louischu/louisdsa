package leetcode.linkedlist;

public class RemoveFromK {
    public static void main(String[] args) {
//        ListNode listNode = ListNode.fromArray(1, 2, 3, 4, 5, 6, 7);
//        removeNthFromEnd(listNode, 3);
//        listNode.print("After REMOVE: ");

//        ListNode listNode = ListNode.fromArray(1);
//        ListNode removed = removeNthFromEnd(listNode, 1);
//        Utils.print("AFTER REMOVE: ", removed);

        ListNode listNode = ListNode.fromArray(1, 2);
        ListNode removed = removeNthFromEnd(listNode, 2);
        Utils.print("AFTER REMOVE: ", removed);
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode ret = new ListNode();
        ret.next = head;
        ListNode fast = head;
        ListNode after = head;

        for (int i = 0; i < n; i++) {
            if (fast != null) {
                fast = fast.next;
            }
        }
        ListNode beforeFound = null;
        int length = n;
        while (fast != null & after != null) {
            beforeFound = after;
            fast = fast.next;
            after = after.next;
            length++;
        }
        ListNode afterFound = after.next;
        if (n == 1 && length == 1) {
            ret.next = null;
        } else if (length == n) {
            ret.next = afterFound;
        } else {
            beforeFound.next = afterFound;
        }

        return ret.next;
    }
}
