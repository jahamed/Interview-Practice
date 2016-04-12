package InterviewCake;

public class LinkedListNode {
    public String value;
    public LinkedListNode next;

    public LinkedListNode(String value) {
        this.value = value;
    }

    public void deleteNode(LinkedListNode nodeToDelete) {
        // O(1) time, O(1) space
        // get the input node's next node, the one we want to skip to
        LinkedListNode nextNode = nodeToDelete.next;

        if (nextNode != null) {

            // replace the input node's value and pointer with the next
            // node's value and pointer. the previous node now effectively
            // skips over the input node
            nodeToDelete.value = nextNode.value;
            nodeToDelete.next  = nextNode.next;

        } else {

            // eep, we're trying to delete the last node!
            throw new IllegalArgumentException("Can't delete the last node with this method!");
        }
    }

    public boolean checkCycle(LinkedListNode firstNode) {
        // O(n) time, O(1) space
        // Utilizes 1 fast and 1 slow runner, if the fast runner catches up to the slow runner there is a cycle
        // start both runners at the beginning
        LinkedListNode slowRunner = firstNode;
        LinkedListNode fastRunner = firstNode;

        // until we hit the end of the list
        while (fastRunner != null && fastRunner.next != null) {
            slowRunner = slowRunner.next;
            fastRunner = fastRunner.next.next;

            // case: fastRunner is about to "lap" slowRunner
            if (fastRunner == slowRunner) {
                return true;
            }
        }

        // case: fastRunner hit the end of the list
        return false;
    }

    public LinkedListNode reverseInPlace(LinkedListNode headOfList) {
        LinkedListNode current = headOfList;
        LinkedListNode previous = null;
        LinkedListNode nextNode = null;

        // until we have 'fallen off' the end of the list
        while (current != null) {

            // copy a pointer to the next element
            // before we overwrite current.next
            nextNode = current.next;

            // reverse the 'next' pointer
            current.next = previous;

            // step forward in the list
            previous = current;
            current = nextNode;
        }

        return previous;
    }

    public static void main(String[] args){
        LinkedListNode a = new LinkedListNode("A");
        LinkedListNode b = new LinkedListNode("B");
        LinkedListNode c = new LinkedListNode("C");

        a.next = b;
        b.next = c;
    }
}
