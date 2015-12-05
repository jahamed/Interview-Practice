package structures;

public class SingleLinkedList<V> {
    private Node<V> head;
    private Node<V> tail;

    public void add(V value) {
        Node<V> node = new Node<V>();
        node.value = value;

        if (head == null) {
            head = node;
            tail = node;
        }else {
            tail.next = node;
            tail = node;
        }
    }

    public void reverseListRecursive() {
        this.head = reverseListRecursiveHelper(this.head);
    }

    public Node<V> reverseListRecursiveHelper(Node<V> head) {
        //Reverse 0 elements
        if (head == null) {
            return null;
        }

        //Reverse 1 element
        if (head.next == null) {
            return head;
        }

        Node next = head.next;
        head.next = null;

        //Reverse remaining nodes
        Node<V> reversedRest = reverseListRecursiveHelper(next);

        //Join lists
        next.next = head;

        return reversedRest;
    }

    public void printList() {
        Node currNode = head;
        while (currNode != null) {
            System.out.println(currNode.value);
            currNode = currNode.next;
        }
    }

    public static void main(String[] args) {
        SingleLinkedList<Integer> test = new SingleLinkedList<Integer>();
        test.add(1);
        test.add(2);
        test.add(3);
        test.add(4);
        System.out.println("List: ");
        test.printList();
        test.reverseListRecursive();
        System.out.println("List Reversed: ");
        test.printList();
    }
}

class Node<V> {
    public V value;
    public Node<V> next;
}