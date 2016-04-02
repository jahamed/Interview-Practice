// This is the text editor interface. 
// Anything you type or change here will be seen by the other person in real time.

import java.util.Stack;

public class queueStack<K> {

    public Stack<K> stack1 = new Stack<K>();
    public Stack<K> stack2 = new Stack<K>();

    public void enqueue(K input) {
        stack1.push(input);
    }

    public K dequeue() {
        if (stack2.peek() == null) {
            while (stack1.peek() !=null) {
                K x = stack1.pop();
                stack2.push(x);
            }
            return stack2.pop();
        }else {
            return stack2.pop();
        }
    }

    public static void main(String[] args) {
        queueStack<String> test = new queueStack<String>();
        test.enqueue("1");
        test.enqueue("2");
        System.out.println(test.dequeue());
    }
}