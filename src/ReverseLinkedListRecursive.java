/**
 * Created by jahamed on 6/22/15.
 */
public class ReverseLinkedListRecursive<V> {

    public ReverseLinkedListRecursive<V> next;
    public V data;

    public ReverseLinkedListRecursive<V> reversed() {
        return this.reversedRecursive(null);
    }

    private ReverseLinkedListRecursive<V> reversedRecursive(ReverseLinkedListRecursive<V> newNext){
        ReverseLinkedListRecursive<V> oldNext = this.next;
        this.next = newNext;

        if(oldNext == null){
            return this;
        }

        return oldNext.reversedRecursive(this);
    }
}
