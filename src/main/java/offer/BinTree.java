package offer;

import java.util.Stack;

/**
 * @author hwolf
 * @email h.wolf@qq.com
 * @date 2018/3/8.
 */
public class BinTree {
    protected BTNode root;

    public BinTree(BTNode root) {
        this.root = root;
    }

    public BTNode getRoot() {
        return root;
    }

    /**
     * 构造树
     */
    public static BTNode init() {
        BTNode a = new BTNode('A');
        BTNode b = new BTNode('B', null, a);
        BTNode c = new BTNode('C');
        BTNode d = new BTNode('D', b, c);
        BTNode e = new BTNode('E');
        BTNode f = new BTNode('F', e, null);
        BTNode g = new BTNode('G', null, f);
        BTNode h = new BTNode('H', d, g);
        // root
        return h;
    }

    /**
     * 访问节点
     */
    public static void visit(BTNode p) {
        System.out.print(p.getKey() + " ");
    }

    public static void preVisit(BTNode root) {
        if (root == null) {
            return;
        }
        visit(root);
        preVisit(root.getLeft());
        preVisit(root.getRight());
    }

    public static void midVisit(BTNode root) {
        if (root == null) {
            return;
        }
        midVisit(root.getLeft());
        visit(root);
        midVisit(root.getRight());
    }

    public static void postOrder(BTNode root) {
        if (root == null) {
            return;
        }
        postOrder(root.getLeft());
        postOrder(root.getRight());
        visit(root);
    }

    /**
     * 非递归实现先序遍历
     *
     * @param root
     */
    public static void iterativePreOrder(BTNode root) {
        if (root == null) {
            return;
        }
        Stack<BTNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            root = stack.pop();
            visit(root);
            if (root.getRight() != null) {
                stack.push(root.getRight());
            }
            if (root.getLeft() != null) {
                stack.push(root.getLeft());
            }
        }
    }

    /**
     * 非递归中序遍历
     *
     * @param root
     */
    public static void iterativeInOrder(BTNode root) {
        Stack<BTNode> stack = new Stack<>();
        while (root != null) {
            // 右子树入栈
            while (root != null) {
                if (root.getRight() != null) {
                    stack.push(root.getRight());
                }
                // 中间节点入栈
                stack.push(root);
                // 左子树为null结束，左子树不为null继续放
                root = root.getLeft();
            }
            // 开始遍历叶子节点，左边在最上面
            root = stack.pop();

            while (!stack.isEmpty() && root.getRight() == null) {
                visit(root);
                root = stack.pop();
            }
            // 有右子树，访问根节点
            visit(root);
            if (!stack.isEmpty()) {
                root = stack.pop();
            } else {
                root = null;
            }
        }
    }

//    public static void pre(BTNode root) {
//        if (root == null) {
//            return;
//        }
//        Stack<BTNode> stack = new Stack<>();
//        while (root != null || !stack.isEmpty()) {
//            while (root != null) {
//                visit(root);
//                stack.push(root);
//                root = root.getLeft();
//            }
//            root = stack.pop().getRight();
//        }
//
//    }

    public static void iterativeInOrder1(BTNode root) {
        if (root == null) {
            return;
        }
        Stack<BTNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.getLeft();
            }
            if (!stack.isEmpty()) {
                root = stack.pop();
                visit(root);
                root = root.getRight();
            }
        }
    }

//    public static void mid(BTNode root) {
//        if (root == null) {
//            return;
//        }
//        Stack<BTNode> stack = new Stack<>();
//        stack.push(root);
//        while (root != null) {
//            for (; root.getRight() != null; root = root.getRight()) {
//                stack.push(root);
//            }
//
//        }
//    }

    /**
     * 非递归实现后序遍历
     *
     * @param root
     */
    public static void iterativePostOrder(BTNode root) {
        if (root == null) {
            return;
        }
        Stack<BTNode> stack = new Stack<>();
        BTNode temp = root;
        // 先放入根节点
        stack.push(root);
        while (!stack.isEmpty()) {
            // 左入，先找到最左边节点
            while (root.getLeft() != null) {
                stack.push(root);
                root = root.getLeft();
            }
            // 处理根节点，右子树已经访问过，或没有右子树
            while (root != null && (root.getRight() == null || root.getRight() == temp)) {
                // 先访问左子树，或者是根节点
                visit(root);
                // 保存根节点，或者上个
                temp = root;
                if (stack.isEmpty()) {
                    return;
                }
                // 查看根，如果根节点没有右子树，或者就是自己，继续向上
                root = stack.pop();
            }
            // 放回根
            stack.push(root);
            // 如果为null表示又右子树处理完，否则压入右子树，并查看是否有左子树
            root = root.getRight();
        }
    }

    public static void pre(BTNode root) {
        if (root == null) {
            return;
        }
        Stack<BTNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                visit(root);
                stack.push(root);
                root = root.getLeft();
            }
            if (!stack.isEmpty()) {
                root = stack.pop();
                root = root.getRight();
            }
        }
    }



    public static void main(String[] args) {
        BinTree tree = new BinTree(init());
        System.out.print("　In-Order:");
        iterativeInOrder(tree.getRoot());
        System.out.println();
        System.out.print("　In-Order:");
        iterativeInOrder1(tree.getRoot());
        System.out.println();
        System.out.println("Pre");
        pre(tree.getRoot());
        System.out.println();
        System.out.println("Pre");
        preVisit(tree.getRoot());
        System.out.println();
        System.out.println("Pre");
        postOrder(tree.getRoot());
        System.out.println();
        System.out.println("Pre");
    }
}
