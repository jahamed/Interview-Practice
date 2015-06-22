/**
 * Created by jahamed on 6/22/15.
 */
public class BSTHeight {
    public class BSTNode {
        int value;
        BSTNode left;
        BSTNode right;
    }

    public int getHeight(BSTNode node) {
        if (node == null){
            return 0;
        }else {
            return 1 + Math.max(getHeight(node.left), getHeight(node.right));
        }
    }
}
