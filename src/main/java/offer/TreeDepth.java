package offer;


/**
 * 计算树的深度
 *
 * @author hwolf
 * @email h.wolf@qq.com
 * @date 2017/12/21.
 */
public class TreeDepth {
    //    public int treeDepth(TreeNode root) {
//        if(root == null){
//            return 0;
//        }
//        return Math.max(1+treeDepth(root.left),1+treeDepth(root.right));
//    }
    public int treeDepth(TreeNode treeNode) {
        if (treeNode == null) {
            return 0;
        }
        return Math.max(treeDepth(treeNode.getLeft()) + 1, treeDepth(treeNode.getRight()) + 1);
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);
        TreeNode left = new TreeNode(6);
        TreeNode left1 = new TreeNode(5);
        TreeNode left2 = new TreeNode(9);
        TreeNode right = new TreeNode(10);
        TreeNode right1 = new TreeNode(7);
        TreeNode right2 = new TreeNode(11);
        root.setChild(left, right);
        left.setChild(left1, right1);
        right.setChild(left2, right2);
        System.out.println(new TreeDepth().treeDepth(root));
    }
}
