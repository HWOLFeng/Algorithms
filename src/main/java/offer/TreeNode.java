package offer;

/**
 * @author hwolf
 * @email h.wolf@qq.com
 * @date 2017/12/21.
 */
public class TreeNode {
        int val = 0;
        offer.TreeNode left = null;
        offer.TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }

        public void setChild(offer.TreeNode left, offer.TreeNode right) {
            this.left = left;
            this.right = right;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }
}
