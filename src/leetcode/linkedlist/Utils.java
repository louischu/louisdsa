package leetcode.linkedlist;

public class Utils {
    public static void print(String message, ListNode root) {
        ListNode temp = root;
        while (temp != null) {
            System.out.println(message + temp.val);
            temp = temp.next;
        }
    }
}
