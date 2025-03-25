package leetcode.linkedlist;

public class MergeTwoSortedLists {
    //Editor version
    public static ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        // maintain an unchanging reference to node ahead of the return node.
        ListNode prehead = new ListNode(-1);

        ListNode prev = prehead;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }

        // At least one of l1 and l2 can still have nodes at this point, so connect
        // the non-null list to the end of the merged list.
        prev.next = l1 == null ? l2 : l1;

        return prehead.next;
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode();
        ListNode head1 = list1;
        ListNode head2 = list2;
        ListNode result = dummy;
        while (head1 != null || head2 != null) {

            if (head1 != null && head2 != null) {
                //System.out.println("Add both");
                if (head1.val < head2.val) {
                    dummy.next = new ListNode(head1.val);
                    dummy = dummy.next;
                    head1 = head1.next;
                } else {
                    dummy.next = new ListNode(head2.val);
                    dummy = dummy.next;
                    head2 = head2.next;
                }
            } else if (head1 != null) {
                //System.out.println("Add head1");
                dummy.next = new ListNode(head1.val);
                dummy = dummy.next;
                head1 = head1.next;
            } else if (head2 != null) {
                //System.out.println("Add head2");
                dummy.next = new ListNode(head2.val);
                dummy = dummy.next;
                head2 = head2.next;
            }
        }
        //result.print("MyDummy: ");
        return result.next;
    }

    public static void main(String[] args) {
//        ListNode listNode1 = ListNode.fromArray(1, 2, 4);
//        listNode1.print("List1: ");
//        ListNode listNode2 = ListNode.fromArray(1, 3, 4);
//        listNode2.print("List2: ");
//        ListNode listNode = mergeTwoLists(listNode1, listNode2);
//        listNode.print("Merged: ");
        ListNode listNode1 = new ListNode(5);
//        listNode1.print("List1: ");
        ListNode listNode2 = ListNode.fromArray(1, 2, 4);
        //listNode2.print("List2: ");
        ListNode listNode = mergeTwoLists(listNode1, listNode2);
        listNode.print("Merged: ");
    }
}
