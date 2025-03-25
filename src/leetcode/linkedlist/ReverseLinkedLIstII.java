package leetcode.linkedlist;

/**
 * Given the head of a singly linked list and two integers left and right where left <= right, reverse the nodes of the list from position left to position right, and return the reversed list.
 * Input: head = [1,2,3,4,5], left = 2, right = 4
 * Output: [1,4,3,2,5]
 */
public class ReverseLinkedLIstII {
    public static void main(String[] args) {
        //ListNode listNode = ListNode.fromArray(1, 2, 3, 4, 5, 6, 7);
        ListNode listNode = ListNode.fromArray(3, 5);
        //ListNode listNode = ListNode.fromArray(1, 2, 3, 4, 5);//2,4
        //listNode.print("OR: ");
        //listNode.print("OR: ");
        ListNode reversedII = reverseBetween(listNode, 1, 2);
        reversedII.print("Re:");
//        ListNode listNode2 = ListNode.fromArray(10, 11);
//        ListNode join = join(listNode, listNode2);
//        join.print("JOIN: ");
    }

    //Userversion
    public ListNode reverseBetweenUser(ListNode head, int left, int right) {
        if (head == null || left == right) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;

        for (int i = 0; i < left - 1; i++) {
            prev = prev.next;
        }

        ListNode cur = prev.next;

        for (int i = 0; i < right - left; i++) {
            ListNode temp = cur.next;
            cur.next = temp.next;
            temp.next = prev.next;
            prev.next = temp;
        }

        return dummy.next;
    }

    public static ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right && left == 1) {
            return head;
        }
        int count = 1;
        ListNode current = head;
        ListNode prev = null;
        ListNode next = null;
        ListNode nodeLeft = new ListNode();
        ListNode nodeRight = new ListNode();

        ListNode nodeLeftDummy = nodeLeft;
        ListNode nodeRightDummy = nodeRight;

        while (current != null) {
            if (count >= left & count <= right) {
                next = current.next;
                current.next = prev;
                prev = current;
                current = next;
            } else {
                if (count < left) {
                    nodeLeft.next = new ListNode(current.val);
                    nodeLeft = nodeLeft.next;
                }
                if (count > right) {
                    nodeRight.next = new ListNode(current.val);
                    nodeRight = nodeRight.next;
                }
                current = current.next;
            }
            count++;
        }
        //nodeLeftDummy.next.print("LEFT: ");
        //nodeRightDummy.next.print("RIGHT: ");
//        prev.print("PREV: ");
//        System.out.println("nodeLeftDummy: " + nodeLeftDummy.next);
//        System.out.println("nodeRightDummy: " + nodeRightDummy.next);
//        System.out.println("PREV: " + prev);
        ListNode ret = null;
        if (nodeLeftDummy.next != null && nodeRightDummy.next != null) {
            ListNode join1 = join(nodeLeftDummy.next, prev);
            ret = join(join1, nodeRightDummy.next);
        } else if (nodeLeftDummy.next == null && nodeRightDummy.next != null) {

            ret = join(prev, nodeRightDummy.next);
        } else if (nodeLeftDummy.next != null && nodeRightDummy.next == null) {
            ret = join(nodeLeftDummy.next, prev);
        } else {
            ret = prev;
        }

        return ret;
    }

    public static ListNode join(ListNode head1, ListNode head2) {

        ListNode curr_odd = head1;
        ListNode curr_even = head2;
        ListNode prev = null;

        while (curr_odd != null) {
            prev = curr_odd;
            curr_odd = curr_odd.next;
        }
        prev.next = curr_even;

        return head1;
    }
}
