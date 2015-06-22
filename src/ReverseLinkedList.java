/**
 * Created by jahamed on 6/18/15.
 */
public class ReverseLinkedList<V> {
    public ReverseLinkedList<V> next;
    public V data;

    public ReverseLinkedList<V> reversedIterative() {
        ReverseLinkedList<V> left = null;
        ReverseLinkedList<V> curr = this;
        ReverseLinkedList<V> right;

        while (curr != null){
            right = curr.next;
            curr.next = left;
            left = curr;
            curr = right;
        }

        return left;
    }
}
