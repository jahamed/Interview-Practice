import java.util.Stack;

/**
 * Created by jahamed on 6/18/15.
 */

//Implement a Queue using 2 Stacks

public class Queue2Stacks {

    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void enqueue(int x) {
        stack1.push(x);
    }

    public int dequeue() {
        int toReturn;

        if(stack1.empty()){
            toReturn = 0;
            return toReturn;
        }

        while(!stack1.empty()) {
            stack2.push(stack1.pop());
        }

        toReturn = stack2.pop();

        while(!stack2.empty()){
            stack1.push(stack2.pop());
        }

        return toReturn;
    }

    public static void main(String[] args){
        Queue2Stacks eg = new Queue2Stacks();
        eg.enqueue(1);
        eg.enqueue(3);
        eg.enqueue(5);

        System.out.println(eg.dequeue());
        System.out.println(eg.dequeue());
        System.out.println(eg.dequeue());
        System.out.println(eg.dequeue());
    }
}

