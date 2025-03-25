package leetcode.linkedlist;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/copy-list-with-random-pointer/description/?envType=study-plan-v2&envId=top-interview-150
 */
//Input: head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
//Output: [[7,null],[13,0],[11,4],[10,2],[1,0]]
public class CopyListRandomPointer {
    public static void main(String[] args) {
        Node node = build();
        print(node, "ORG:");
        //System.out.println("AllPOS: " + allPosition(node));
        Node copyList = copyRandomList2(node);
        print(copyList, "COPY:");
    }

    public static Node build() {

        Node node1 = new Node(7);
        Node node2 = new Node(13);
        Node node3 = new Node(11);
        Node node4 = new Node(10);
        Node node5 = new Node(1);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        node2.random = node1;
        node3.random = node5;
        node4.random = node3;
        node5.random = node1;

        return node1;
    }

    public static void print(Node head, String msg) {
        Node curr = head;
        int i = 0;
        while (curr != null) {
            Node random = curr.random;
            int valRandom = random != null ? random.val : -1;
            System.out.println(msg + ": " + curr.val + ", rand: " + valRandom);
            curr = curr.next;
        }

    }

    public static Map<Node, Integer> allPosition(Node head) {
        Node curr = head;
        int i = 0;
        Map<Node, Integer> retVal = new HashMap<>();
        while (curr != null) {
            retVal.put(curr, i);
            i++;
            curr = curr.next;
        }
        return retVal;
    }

    //User version
    public static Node copyRandomList2(Node head) {
        Map<Node, Node> copyMap = new HashMap<>();
        Node curr = head;
        while (curr != null) {
            copyMap.put(curr, new Node(curr.val));
            curr = curr.next;
        }

        curr = head;
        while (curr != null) {
            Node node = copyMap.get(curr);
            node.next = copyMap.get(curr.next);
            node.random = copyMap.get(curr.random);
            curr = curr.next;
        }
        return copyMap.get(head);
    }

    //My first version, seem not goot
    public static Node copyRandomList(Node head) {
        Map<Node, Integer> allPos = allPosition(head);
        Node curr = head;
        Node temp = new Node(0);
        Node dummy = temp;

        int count = 0;
        Map<Integer, Integer> randomMap = new HashMap<>();
        while (curr != null) {
            Node random = curr.random;
            randomMap.put(count, allPos.getOrDefault(random, -1));
            count++;
            curr = curr.next;
        }
        curr = head;
        count = 0;
        Map<Integer, Node> nodeFromPosMap = new HashMap<>();
        while (curr != null) {
            Node newNode = new Node(curr.val);
            temp.next = newNode;
            nodeFromPosMap.put(count, newNode);
            temp = temp.next;
            curr = curr.next;
            count++;
        }
        //System.out.println("NODE FROM POST MAP: " + nodeFromPosMap);
        curr = dummy.next;
        count = 0;
        while (curr != null) {
            //System.out.println("COUNT: " + count + ", Random: " + randomMap.get(count) + ", Node: " + nodeFromPosMap.get(count));
            if (randomMap.get(count) != -1) {
                curr.random = nodeFromPosMap.get(count);
            }
            curr = curr.next;
            count++;
        }

        return dummy.next;
    }


}

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("[");
        sb.append("").append(val);
        sb.append(']');
        return sb.toString();
    }
}