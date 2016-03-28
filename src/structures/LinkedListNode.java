package structures;

import java.util.LinkedList;

public class LinkedListNode {
    public int value;
    public LinkedListNode next;

    public LinkedListNode(int value) {
        this.value = value;
    }

    public static boolean detectCycle(LinkedListNode head) {
        LinkedListNode slowRunner = head;
        LinkedListNode fastRunner = head;

        while(fastRunner != null && fastRunner.next != null) {
            slowRunner = slowRunner.next;
            fastRunner = fastRunner.next.next;

            if (fastRunner == slowRunner) {
                return true;
            }
        }

        return false;
    }

    public static LinkedListNode reverse(LinkedListNode head) {
        LinkedListNode curr = head;
        LinkedListNode prev = null;
        LinkedListNode next = null;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;

            //step forward
            prev = curr;
            curr = next;
        }

        return prev;
    }

    public static void printList(LinkedListNode head) {
        StringBuffer toPrint = new StringBuffer();
        LinkedListNode curr = head;

        while(curr != null) {
            toPrint.append(curr.value);
            curr = curr.next;
        }

        System.out.println(toPrint);
    }

    public static void main(String[] args) {
        LinkedListNode a = new LinkedListNode(1);
        LinkedListNode b = new LinkedListNode(2);
        LinkedListNode c = new LinkedListNode(3);
        LinkedListNode d = new LinkedListNode(4);

        a.next = b;
        b.next = c;
        c.next = d;

        System.out.println(detectCycle(a));
        printList(reverse(a));
    }
}

