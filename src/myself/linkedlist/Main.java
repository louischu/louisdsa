package myself.linkedlist;

public class Main {
    public static void main(String[] args) {
        ListNode listNode = ListNode.fromArray(1, 2, 3, 4, 5, 6, 7);
        listNode.print("ORIGIN: ");
        ListNode cloneList = listNode.deepCopy();
        cloneList.print("PRINT: ");
        ListNode reversed = reverse(cloneList);
        reversed.print("REVERSED: ");
        listNode.appendLast(8);
        listNode.print("AFTER REVERSED: ");
        ListNode afterInsert = insertAt(1, 100, listNode);
        afterInsert.print("Insert: ");

    }

    public static ListNode insertAt(int position, int value, ListNode listNode) {
        int count = 0;
        ListNode curr = listNode;
        if (position == 0) {
            ListNode newNode = new ListNode(value);
            newNode.next = listNode;
            listNode = newNode;
            return listNode;
        }
        while (curr != null) {
            //System.out.println("Value: " + (count) + ", Value: " + curr.val);
            if ((count + 1) == position) {
                ListNode newNode = new ListNode(value);
                ListNode temp = curr.next;
                curr.next = newNode;
                newNode.next = temp;
            }
            curr = curr.next;
            count++;
        }
        if (count < position) {
            //do nothing
        }
        return listNode;
    }

    public static void appendEnd(int value, ListNode listNode) {
        ListNode temp = listNode;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = new ListNode(value);
    }

    public static ListNode reverse(ListNode listNode) {
        ListNode prev = null;
        ListNode next = null;
        ListNode curr = listNode;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
