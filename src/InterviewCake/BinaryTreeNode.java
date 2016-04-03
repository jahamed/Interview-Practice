package InterviewCake;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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

    public static Integer largestIterative(BinaryTreeNode rootNode) {
        BinaryTreeNode current = rootNode;
        BinaryTreeNode largest = null;

        while (current != null) {
            if (current.right == null) {
                largest = current;
            }
        }

        return largest.value;
    }

    public static Integer findSecondLargest(BinaryTreeNode rootNode) {
        // O(h) time, O(h) space
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

    public int findSecondLargestIterative(BinaryTreeNode rootNode) {
        // O(h) or O(lgn) if tree balanced, O(n) if not time, O(1) space
        if (rootNode.left == null && rootNode.right == null) {
            throw new IllegalArgumentException("Tree must have at least 2 nodes");
        }

        BinaryTreeNode current = rootNode;

        while (true) {
            // case: current is largest and has a left subtree
            // 2nd largest is the largest in that subtree
            if (current.left != null && current.right == null) {
                return largestIterative(current.left);
            }

            // case: current is parent of largest, and
            // largest has no children, so
            // current is 2nd largest
            if (current.right != null &&
                    current.right.left == null &&
                    current.right.right == null) {
                return current.value;
            }

            current = current.right;
        }
    }

    public boolean isSuperBalanced(BinaryTreeNode treeRoot) {
        // O(n) time, O(n) space for nodes, O(1) space for depth-list
        List<Integer> depths = new ArrayList<Integer>(3); // short-circuit if we find more than 2

        // store pair of node and node depth
        Stack<NodeDepthPair> nodes = new Stack<NodeDepthPair>();
        nodes.push(new NodeDepthPair(treeRoot, 0));

        while (!nodes.empty()) {
            NodeDepthPair nodeDepthPair = nodes.pop();
            BinaryTreeNode node = nodeDepthPair.node;
            int depth = nodeDepthPair.depth;

            // leaf case
            if (node.left == null && node.right == null) {
                // only care if it's a new depth
                if (!depths.contains(depth)) {
                    depths.add(depth);
                }

                /*
                Unbalanced if > 2 leaf depths || 2 leaf depths more than 1 depth apart
                */
                if((depths.size() > 2) || (depths.size() == 2 && Math.abs(depths.get(0) - depths.get(1)) > 1)) {
                    return false;
                }
            } else { // not a leaf case
                if (node.left != null) {
                    nodes.push(new NodeDepthPair(node.left, depth + 1));
                }
                if (node.right != null) {
                    nodes.push(new NodeDepthPair(node.right, depth + 1));
                }
            }
        }

        return true;
    }

    public boolean bstCheckRecursive(BinaryTreeNode root) {
        // O(n) time, O(n) space
        return bstCheckRecursive(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean bstCheckRecursive(BinaryTreeNode root, int lowerBound, int upperBound) {
        if (root == null) {
            return true;
        }

        if (root.value > upperBound || root.value < lowerBound) {
            return false;
        }

        return bstCheckRecursive(root.left, lowerBound, root.value) && bstCheckRecursive(root.right, root.value, upperBound);
    }
}

class NodeDepthPair {
    BinaryTreeNode node;
    int depth;

    public NodeDepthPair(BinaryTreeNode node, int depth) {
        this.node = node;
        this.depth = depth;
    }
}