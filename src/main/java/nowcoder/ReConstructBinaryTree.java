package nowcoder;

import offer.TreeNode;

import java.util.Arrays;

/**
 * @author hwolf
 * @email h.wolf@qq.com
 * @date 2018/1/4.
 */
public class ReConstructBinaryTree {
    /**
     * 思路：找根，构建新数组，左右子树递归
     * @param pre
     * @param in
     * @return
     */
    public TreeNode reConstructBinaryTree(int [] pre, int [] in) {
        if (in.length==0){
            return null;
        }
        // 初始根
        int rootIndex = 0;
        // 因为都不含重复数字，所以直接在中序遍历中顺序查找就可以了
        for (int i = 0; i < in.length; i++) {
            if (in[i]==pre[rootIndex]){
                // 也就是前序遍历中左子树的边界，右子树的起始
                rootIndex=i;
                break;
            }
        }
        // 存储节点
        TreeNode rootNode = new TreeNode(in[rootIndex]);
        int[] preLeft = Arrays.copyOfRange(pre,1,rootIndex+1);
        int[] inLeft = Arrays.copyOf(in,rootIndex);
        int[] preRight = Arrays.copyOfRange(pre,rootIndex+1,pre.length);
        int[] inRight = Arrays.copyOfRange(in,rootIndex+1,in.length);
        if(preLeft.length>=1){
            // 添加左节点
            TreeNode leftNode = new TreeNode(preLeft[0]);
            rootNode.setLeft(leftNode);
            // 左子树处理
            reConstructBinaryTree(preLeft,inLeft);
        }

        if (preRight.length>=1){
            // 添加右节点
            TreeNode rightNode = new TreeNode(preRight[preRight.length-1]);
            rootNode.setRight(rightNode);
            // 右子树处理
            reConstructBinaryTree(preRight,inRight);
        }

        return rootNode;
    }
    public TreeNode printTreeNode(TreeNode treeNode){
        if (treeNode.getRight()==null&&treeNode.getLeft()==null){
            System.out.println(treeNode.getVal());
            return treeNode;
        }
        if (treeNode.getLeft()!=null){
            System.out.println(treeNode.getVal());
           printTreeNode(treeNode.getLeft());
        }
        if (treeNode.getRight()!=null){
            System.out.println(treeNode.getVal());
            printTreeNode(treeNode.getRight());
        }
        return treeNode;

    }

//    private TreeNode reConstructBinaryTree(int [] pre,int startPre,int endPre,int [] in,int startIn,int endIn) {
//        if (startPre > endPre || startIn > endIn){
//            return null;
//        }
//        TreeNode root = new TreeNode(pre[startPre]);
//
//        for (int i = startIn; i <= endIn; i++){
//            // 中序遍历的结果和前序遍历的递归值对比
//            if (in[i] == pre[startPre]) {
//                root.left = reConstructBinaryTree(pre, startPre + 1, startPre + i - startIn, in, startIn, i - 1);
//                root.right = reConstructBinaryTree(pre, i - startIn + startPre + 1, endPre, in, i + 1, endIn);
//                break;
//            }
//        }
//        return root;
//    }
    public static void main(String[] args) {
        int[] pre = {1,2,4,7,3,5,6,8};
        int[] in = {4,7,2,1,5,3,8,6};
        TreeNode node = new ReConstructBinaryTree().reConstructBinaryTree(pre,in);
        new ReConstructBinaryTree().printTreeNode(node);
    }
}
