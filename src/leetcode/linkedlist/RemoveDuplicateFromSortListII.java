package leetcode.linkedlist;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

//Given the head of a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list. Return the linked list sorted as well.
//Input: head = [1,2,3,3,4,4,5]
//Output: [1,2,5]
//Input: head = [1,1,1,2,3]
//Output: [2,3]
public class RemoveDuplicateFromSortListII {
    public static void main(String[] args) {
//        ListNode listNode = ListNode.fromArray(1, 2, 3, 3, 4, 4, 5);
//        ListNode deleted = deleteDuplicates1(listNode);
//        Utils.print("DELETED: ", deleted);

        ListNode listNode = ListNode.fromArray(-3, -1, 0, 0, 0, 3, 3);
        ListNode deleted = deleteDuplicates0(listNode);
        Utils.print("DELETED: ", deleted);
    }

    //op2: Editor version
    public static ListNode deleteDuplicates0(ListNode head) {
        // Sentinel
        ListNode sentinel = new ListNode(0, head);

        // predecessor = the last node
        // before the sublist of duplicates
        ListNode pred = sentinel;

        while (head != null) {
            // If it's a beginning of the duplicates sublist
            // skip all duplicates
            if (head.next != null && head.val == head.next.val) {
                // Move till the end of the duplicates sublist
                while (head.next != null && head.val == head.next.val) {
                    head = head.next;
                }

                // Skip all duplicates
                pred.next = head.next;
                // otherwise, move predecessor
            } else {
                pred = pred.next;
            }

            // move forward
            head = head.next;
        }
        return sentinel.next;
    }

    //Op3: My version two pointers
    public static ListNode deleteDuplicates3(ListNode head) {
        ListNode res = new ListNode(0, head);
        ListNode temp = head;
        ListNode jumpNode = head;
        while (temp != null) {
            if (temp.next != null && temp.next.val == temp.val) {
                while (temp.next != null && temp.next.val == temp.val) {
                    
                }
            }
            temp = temp.next;
        }

        return res.next;
    }

    //Op1: using hashmap
    public static ListNode deleteDuplicates1(ListNode head) {
        Map<Integer, Integer> seenMap = new HashMap<>();

        ListNode temp = head;
        Map<Integer, ListNode> dataMap = new LinkedHashMap<>();
        while (temp != null) {
            seenMap.put(temp.val, seenMap.getOrDefault(temp.val, 0) + 1);
            if (seenMap.get(temp.val) > 1) {
                dataMap.remove(temp.val);
            } else {
                dataMap.put(temp.val, temp);
            }
            temp = temp.next;
        }
        ListNode dummy = new ListNode();
        ListNode ret = dummy;
        for (ListNode node : dataMap.values()) {
            dummy.next = node;
            node.next = null;
            dummy = dummy.next;
        }
        return ret.next;
    }
}
