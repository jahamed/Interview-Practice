import java.util.Stack;

public class MaxStack {

    static Stack<Integer> contentStack = new Stack<Integer>();
    static Stack<Integer> trackMaxStack = new Stack<Integer>();

    public static int getMax() {
        return trackMaxStack.peek();
    }

    public static void push(int x) {
        contentStack.push(x);
        if (!trackMaxStack.isEmpty() && x > getMax()) {
            trackMaxStack.push(x);
        }else if(trackMaxStack.isEmpty()) {
            trackMaxStack.push(x);
        }else {
            trackMaxStack.push(getMax());
        }
    }

    public static int pop() {
        trackMaxStack.pop();
        return contentStack.pop();
    }

    public static void main(String[] args) {
        String testInput = "test input";
        push(2);
        push(1);
        push(4);
        push(5);
        System.out.println(getMax());
    }
}