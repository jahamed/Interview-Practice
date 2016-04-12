package structures;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree {
    public static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;
        TreeNode(int data) {
            this.data = data;
        }
    }

    // Recursive Solution
    public void preorder(TreeNode root) {
        if(root !=  null) {
            //Visit the node-Printing the node data
            System.out.printf("%d ",root.data);
            preorder(root.left);
            preorder(root.right);
        }
    }

    // Iterative solution
    public void preorderIter(TreeNode root) {

        if(root == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);

        while(!stack.empty()){
            TreeNode n = stack.pop();
            System.out.printf("%d ",n.data);

            if(n.right != null){
                stack.push(n.right);
            }
            if(n.left != null){
                stack.push(n.left);
            }
        }
    }

    // Recursive Solution
    public void postOrder(TreeNode root) {
        if(root !=  null) {
            postOrder(root.left);
            postOrder(root.right);
            //Visit the node by Printing the node data
            System.out.printf("%d ",root.data);
        }
    }

    // Iterative solution
    public void postorderIter( TreeNode root) {
        if( root == null ) return;

        Stack<TreeNode> s = new Stack<TreeNode>( );
        TreeNode current = root;

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
    public void inOrder(TreeNode root) {
        if(root !=  null) {
            inOrder(root.left);
            //Visit the node by Printing the node data
            System.out.printf("%d ",root.data);
            inOrder(root.right);
        }
    }

    // Iterative solution
    public void inOrderIter(TreeNode root) {

        if(root == null)
            return;

        Stack<TreeNode> s = new Stack<TreeNode>();
        TreeNode currentNode=root;

        while(!s.empty() || currentNode!=null){

            if(currentNode!=null)
            {
                s.push(currentNode);
                currentNode=currentNode.left;
            }
            else
            {
                TreeNode n=s.pop();
                System.out.printf("%d ",n.data);
                currentNode=n.right;
            }
        }
    }

    // prints in level order
    public static void levelOrderTraversal(TreeNode startNode) {
        Queue<TreeNode> queue=new LinkedList<TreeNode>();
        queue.add(startNode);
        while(!queue.isEmpty())
        {
            TreeNode tempNode=queue.poll();
            System.out.printf("%d ",tempNode.data);
            if(tempNode.left!=null)
                queue.add(tempNode.left);
            if(tempNode.right!=null)
                queue.add(tempNode.right);
        }
    }

    // print leaf nodes
    public static void printLeafNodes(TreeNode node) {

        if(node==null)
            return;

        if(node.left == null && node.right == null) {
            System.out.printf("%d ",node.data);
        }
        printLeafNodes(node.left);
        printLeafNodes(node.right);
    }

    /* To get the count of leaf nodes in a binary tree*/
    public static  int getLeafCountOfBinaryTree(TreeNode node)
    {
        if(node == null)
            return 0;
        if(node.left ==null && node.right==null)
            return 1;
        else
            return getLeafCountOfBinaryTree(node.left)+ getLeafCountOfBinaryTree(node.right);
    }

    // Prints all paths to leaf
    public static void printAllPathsToLeaf(TreeNode node, int[] path, int len) {
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

    public static TreeNode createBinaryTree() {
        TreeNode rootNode = new TreeNode(40);
        TreeNode node20 = new TreeNode(20);
        TreeNode node10 = new TreeNode(10);
        TreeNode node30 = new TreeNode(30);
        TreeNode node60 = new TreeNode(60);
        TreeNode node50 = new TreeNode(50);
        TreeNode node70 = new TreeNode(70);

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
        TreeNode rootNode=createBinaryTree();
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
