package offer;

/**
 * 树翻转
 * @author hwolf
 * @email h.wolf@qq.com
 * @date 2017/12/21.
 */
public class TreeFlip {
    public static void Mirror(TreeNode root) {
        if(root==null){
            return;
        }
        TreeNode temp;
        if (root != null) {
            temp = root.left;
            root.left = root.right;
            root.right = temp;
        }
        if (root.left!=null){
            Mirror(root.left);
        }
        if (root.right!=null){
            Mirror(root.right);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);
        TreeNode left = new TreeNode(6);
        TreeNode left1 = new TreeNode(5);
        TreeNode left2 = new TreeNode(9);
        TreeNode right = new TreeNode(10);
        TreeNode right1 = new TreeNode(7);
        TreeNode right2 = new TreeNode(11);
        root.setChild(left,right);
        left.setChild(left1,right1);
        right.setChild(left2,right2);
        Mirror(root);
    }
}
