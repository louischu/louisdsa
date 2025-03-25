package leetcode.linkedlist;

public class AddTwoNumbers {
    public static void main(String[] args) {
        System.out.println(10 / 10);
        ListNode listNode1 = ListNode.fromArray(2, 4, 3);
        ListNode listNode2 = ListNode.fromArray(5, 6, 4);
        ListNode twoSums = addTwoNumbers(listNode1, listNode2);
        twoSums.print("S1: ");
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head1 = l1;
        ListNode head2 = l2;
        int total = 0;
        int carry = 0;
        ListNode dummy = new ListNode();
        ListNode result = dummy;
        while (head1 != null || head2 != null || carry != 0) {
            total = carry;
            if (head1 != null) {
                total += head1.val;
                head1 = head1.next;
            }
            if (head2 != null) {
                total += head2.val;
                head2 = head2.next;
            }

            int num = total % 10;
            carry = total / 10;

            dummy.next = new ListNode(num);
            dummy = dummy.next;
        }
        return result.next;
    }

}
