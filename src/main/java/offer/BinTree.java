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
        // 先放入根节点
        BTNode temp = root;
        stack.push(root);
        while (!stack.isEmpty()) {
            while (root.getLeft() != null) {
                stack.push(root);
                root = root.getLeft();
            }
            while (root != null && (root.getRight() == null || root.getRight() == temp)) {
                visit(root);
                temp = root;
                if (stack.isEmpty()) {
                    return;
                }
                root = stack.pop();
            }
            stack.push(root);
            // 如果为null表示又子树处理完
            root = root.getRight();
        }
    }

    public static void main(String[] args) {
        BinTree tree = new BinTree(init());
        System.out.print("　In-Order:");
        iterativeInOrder(tree.getRoot());
        System.out.println();
        System.out.print("　In-Order:");
        midVisit(tree.getRoot());
    }
}
