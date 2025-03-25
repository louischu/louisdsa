package algomons;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class ReveseList {
    public static void main(String[] args) {
        List<Integer> builtList = new LinkedList<>(Arrays.asList(1, 4, 5, 7, 8));
        Collections.reverse(builtList);
        System.out.println("List: " + builtList);
        ListNode myList = new ListNode(3, new ListNode(4, new ListNode(6, new ListNode(1))));
        ListNode newList = reverseList(myList);
        ListNode head = newList;
        while (head != null) {
            System.out.println("X: " + head.val);
            head = head.next;
        }
    }

    static ListNode reverseList(ListNode list) {
        ListNode curr = list;
        ListNode dummy = new ListNode();
        while (curr != null) {
            System.out.println("********");
            ListNode temp = curr.next;
            System.out.println("temp.next: " + (temp != null ? temp.val : "NULL"));
            curr.next = dummy.next;
            System.out.println("curr.next: " + (curr.next != null ? curr.next.val : "NULL"));
            dummy.next = curr;
            System.out.println("dummy.next: " + dummy.next.val);

            curr = temp;
        }
        return dummy.next;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}