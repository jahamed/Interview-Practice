package CTCI;

import CTCI.CtCILibrary.AssortedMethods;
import CTCI.CtCILibrary.LinkedListNode;

import java.util.HashSet;

public class LinkedList {

    // 2.1 - Delete duplicate values/nodes from list
    public static void deleteDuplicates(LinkedListNode n) {
        HashSet<Integer> dupSet = new HashSet<Integer>();
        LinkedListNode prev = null;

        while (n != null) {
            if (dupSet.contains(n.data)) {
                prev.next = n.next;
            } else {
                dupSet.add(n.data);
                prev = n;
            }
            n = n.next;
        }
    }

    // 2.2 - Return nth to last element in list
    public static LinkedListNode nthToLast(LinkedListNode head, int n) {
        // use double pointer method
        // get p1 n units into the list and then move both pointers at the same pace until p1 hits a wall
        LinkedListNode p1 = head;
        LinkedListNode p2 = head;

        // move p1 n units into the list
        for (int i = 0; i < n; i++) {
            if (p1 == null) return null; // fell off list
            p1 = p1.next;
        }

        // move both pointers until p1 is null
        while (p1 != null){
            p1 = p1.next;
            p2 = p2.next;
        }

        return p2;
    }

    // 2.3 - Delete a node only pointer to that node
    public static boolean deleteNode(LinkedListNode n) {
        // copy next node's data into this node and delete that node
        if (n == null || n.next == null) return false; // can not delete last node

        n.data = n.next.data;
        n.next = n.next.next;
        return true;
    }

    public static void main(String[] args) {
        // 2.1 - Delete duplicates
//        LinkedListNode first = new LinkedListNode(0, null, null); //AssortedMethods.randomLinkedList(1000, 0, 2);
//        LinkedListNode head = first;
//        LinkedListNode second = first;
//        for (int i = 1; i < 8; i++) {
//            second = new LinkedListNode(i % 2, null, null);
//            first.setNext(second);
//            second.setPrevious(first);
//            first = second;
//        }
//        System.out.println(head.printForward());
//        deleteDuplicates(head);
//        System.out.println(head.printForward());

        // 2.2 - nth to last element in list
//        int[] array = {0, 1, 2, 3};
//        LinkedListNode head = AssortedMethods.createLinkedListFromArray(array);
//        for (int i = 0; i <= array.length + 1; i++) {
//            LinkedListNode node = nthToLast(head, i);
//            String nodeValue = node == null ? "null" : "" + node.data;
//            System.out.println(i + ": " + nodeValue);
//        }

        // 2.3 - Delete node in middle area of list
//        LinkedListNode head = AssortedMethods.randomLinkedList(10, 0, 10);
//        System.out.println(head.printForward());
//        deleteNode(head.next.next.next.next); // delete node 4
//        System.out.println(head.printForward());
    }
}
