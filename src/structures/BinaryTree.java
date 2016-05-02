package structures;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree {
    public static class Node {
        int data;
        Node left;
        Node right;
        Node(int data) {
            this.data = data;
        }
    }

    private Node root;

    public BinaryTree() {
        // Empty Tree
    }

    public Node findNode(int key) {
        // Finds the node with given key, or returns null otherwise.
        if(root == null) { // Empty Tree
            return null;
        }

        Node curr = root;
        while (curr != null) {
            if (curr.data == key) {
                return curr;
            }else if (key < curr.data) {
                curr = curr.left;
            }else { // key > curr.data
                curr = curr.right;
            }
        }
        return null; // didn't find a match
    }

    // Recursive Solution
    // preOrder visit order is node, left, right
    public void preorder(Node root) {
        if(root !=  null) {
            System.out.printf("%d ",root.data);
            preorder(root.left);
            preorder(root.right);
        }
    }

    // Iterative solution
    public void preorderIter(Node root) {
        if (root == null) {
            return;
        }

        Stack<Node> stack = new Stack<Node>();
        stack.push(root);

        while (!stack.empty()){
            Node n = stack.pop();
            System.out.printf("%d ",n.data);

            // add right node to the stack first, so the left node is the first one to get popped
            if (n.right != null){
                stack.push(n.right);
            }
            if (n.left != null){
                stack.push(n.left);
            }
        }
    }

    // Recursive Solution
    // postOrder is left, right, node
    public void postOrder(Node root) {
        if(root !=  null) {
            postOrder(root.left);
            postOrder(root.right);
            System.out.printf("%d ",root.data);
        }
    }

    // Iterative solution
    public void postorderIter( Node root) {
        if( root == null ) return;

        Stack<Node> s = new Stack<Node>( );
        Node current = root;

        while( true ) {

            if( current != null ) {
                if( current.right != null )
                    s.push( current.right );
                s.push( current );
                current = current.left;
                continue;
            }

            if( s.isEmpty( ) )
                return;
            current = s.pop( );

            if( current.right != null && ! s.isEmpty( ) && current.right == s.peek( ) ) {
                s.pop( );
                s.push( current );
                current = current.right;
            } else {
                System.out.print( current.data + " " );
                current = null;
            }
        }
    }

    // Recursive Solution
    public void inOrder(Node root) {
        if(root !=  null) {
            inOrder(root.left);
            System.out.printf("%d ",root.data);
            inOrder(root.right);
        }
    }

    // Iterative solution
    public void inOrderIter(Node root) {

        if(root == null)
            return;

        Stack<Node> s = new Stack<Node>();
        Node currentNode=root;

        while(!s.empty() || currentNode!=null){

            if(currentNode!=null)
            {
                s.push(currentNode);
                currentNode=currentNode.left;
            }
            else
            {
                Node n=s.pop();
                System.out.printf("%d ",n.data);
                currentNode=n.right;
            }
        }
    }

    // Prints level-order traversal, BFS
    public static void levelOrderTraversal(Node startNode) {
        Queue<Node> queue=new LinkedList<Node>();
        queue.add(startNode);
        while(!queue.isEmpty())
        {
            Node tempNode=queue.poll();
            System.out.printf("%d ",tempNode.data);
            if(tempNode.left!=null)
                queue.add(tempNode.left);
            if(tempNode.right!=null)
                queue.add(tempNode.right);
        }
    }

    // print leaf nodes
    public static void printLeafNodes(Node node) {
        if (node == null)
            return;

        // check if curr node is a leaf node and then call recursive calls after
        if (node.left == null && node.right == null) {
            System.out.printf("%d ", node.data);
        }

        printLeafNodes(node.left);
        printLeafNodes(node.right);
    }

    /* To get the count of leaf nodes in a binary tree*/
    public static  int getLeafCountOfBinaryTree(Node node)
    {
        if(node == null)
            return 0;
        if(node.left ==null && node.right==null)
            return 1;
        else
            return getLeafCountOfBinaryTree(node.left)+ getLeafCountOfBinaryTree(node.right);
    }

    // Prints all paths to leaf
    public static void printAllPathsToLeaf(Node node, int[] path, int len) {
        if ( node == null )
            return;

        // storing data in array
        path[len] = node.data;
        len++;

        if(node.left == null && node.right == null) {
            // leaf node is reached
            // printArray(path,len);
            return;
        }

        printAllPathsToLeaf(node.left, path, len);
        printAllPathsToLeaf(node.right, path, len);
    }

    public static Node createBinaryTree() {
        Node rootNode = new Node(40);
        Node node20 = new Node(20);
        Node node10 = new Node(10);
        Node node30 = new Node(30);
        Node node60 = new Node(60);
        Node node50 = new Node(50);
        Node node70 = new Node(70);

        rootNode.left=node20;
        rootNode.right=node60;

        node20.left=node10;
        node20.right=node30;

        node60.left=node50;
        node60.right=node70;

        return rootNode;
    }

    public static void main(String[] args) {
        BinaryTree bi=new BinaryTree();
        // Creating a binary tree
        Node rootNode=createBinaryTree();
        System.out.println("Using Recursive solution:");

        bi.preorder(rootNode);

        System.out.println();
        System.out.println("-------------------------");
        System.out.println("Using Iterative solution:");

        bi.preorderIter(rootNode);

        System.out.println("\nPrinting Leaf Nodes");
        printLeafNodes(rootNode);
    }

}
