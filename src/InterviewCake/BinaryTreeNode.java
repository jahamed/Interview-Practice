package InterviewCake;

import com.sun.source.tree.BinaryTree;

public class BinaryTreeNode {
    public int value;
    public BinaryTreeNode left;
    public BinaryTreeNode right;

    public BinaryTreeNode(int value) {
        this.value = value;
    }

    public BinaryTreeNode insertLeft(int leftValue) {
        this.left = new BinaryTreeNode(leftValue);
        return this.left;
    }

    public BinaryTreeNode insertRight(int rightValue) {
        this.right = new BinaryTreeNode(rightValue);
        return this.right;
    }

    public static Integer largest(BinaryTreeNode rootNode) {
        if (rootNode.right != null) {
            return largest(rootNode.right);
        }
        return rootNode.value;
    }

    public static Integer findSecondLargest(BinaryTreeNode rootNode) {
        // Empty tree
        if (rootNode == null) return null;

        /*
        Currently at largest. Largest has left subtree. 2nd largest is largest in left subtree
         */
        if ((rootNode.left != null) && (rootNode.right == null)) {
            return largest(rootNode.left);
        }

        /*
        At parent of largest, largest has no subtree, largest current node
         */
        if (rootNode.right != null && rootNode.right.left == null && rootNode.right.right == null) {
            return rootNode.value;
        }

        /*
        Otherwise step right
         */
        return findSecondLargest(rootNode.right);
    }
}
