package dataStructure;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @author s1mple
 * @create 2021/5/22-4:51
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode() {
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                '}';
    }

    /**
     * 前序遍历
     * 访问顺序是：根节点->左子树->右子树
     * @param tree
     */
    public static void preOrder(TreeNode tree) {
        if (tree == null) {
            return;
        }
        System.out.printf(tree.val + " ");
        preOrder(tree.left);
        preOrder(tree.right);
    }

    /**
     * 前序遍历非递归写法
     * @param tree
     */
    public static void preOrder2(TreeNode tree) {
        if (tree == null) {
            return;
        }
        Stack<TreeNode> q1 = new Stack<>();
        q1.push(tree);//入栈
        while (!q1.isEmpty()) {
            TreeNode t1 = q1.pop();//出栈
            System.out.println(t1.val);
            if (t1.right != null) {
                q1.push(t1.right);
            }
            if (t1.left != null) {
                q1.push(t1.left);
            }
        }
    }

    /**
     * 中序遍历
     * 左子树->根节点->右子树
     * @param node
     */
    public static void inOrderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }
        inOrderTraversal(node.left);
        System.out.println(node.val);
        inOrderTraversal(node.right);
    }

    /**
     * 中序遍历非递归写法
     * @param node
     */
    public static void inOrderTraversal2(TreeNode node) {
        Stack<TreeNode> stack = new Stack<>();
        while (node != null || stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            if (!stack.isEmpty()) {
                node = stack.pop();
                System.out.println(node.val);
                node = node.right;
            }
        }
    }

    /**
     * 后序遍历
     * 左子树->右子树->根节点
     * @param node
     */
    public static void postOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        preOrder(node.left);
        preOrder(node.right);
        System.out.println(node.val);
    }

    /**
     * 后序遍历非递归写法
     * @param node
     */
    public static void postOrder2(TreeNode node) {
        if (node == null) {
            return;
        }
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        s1.push(node);
        while (!s1.isEmpty()) {
            node = s1.pop();
            s2.push(node);
            if (node.left != null) {
                s1.push(node.left);
            }
            if (node.right != null) {
                s1.push(node.right);
            }
        }
        while (!s2.isEmpty()) {
            System.out.println(s2.pop().val + " ");
        }
    }

    /**
     * BFS(宽度优先搜索(又称广度优先搜索))
     * 他的访问顺序是:先访问上一层,在访问下一层,一层一层的往下访问
     * @param tree
     */
    public static void levelOrder2(TreeNode tree) {
        if (tree == null) {
            return;
        }
        LinkedList<TreeNode> list = new LinkedList<>();//链表:这里我们可以把他看做队列
        list.add(tree);//相当于把数据加入到队列尾部
        while (!list.isEmpty()) {
            TreeNode node = list.poll();//poll方法相当于移除队列头部的元素
            System.out.println(node.val);
            if (node.left != null) {
                list.add(node.left);
            }
            if (node.right != null) {
                list.add(node.right);
            }
        }
    }

    /**
     * BFS递归写法
     * @param tree
     */
    public static void levelOrder(TreeNode tree) {
        int depth = depth(tree);
        for (int level = 0; level < depth; level++) {
            printLevel(tree, level);
        }
    }
    private static void printLevel(TreeNode tree, int level) {
        if (tree == null) {
            return;
        }
        if (level == 0) {
            System.out.println(" " + tree.val);
        } else {
            printLevel(tree.left, level - 1);
            printLevel(tree.right, level - 1);
        }
    }
    private static int depth(TreeNode tree) {
        if (tree == null) {
            return 0;
        }
        int leftDepth = depth(tree.left);
        int rightDepth = depth(tree.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }

    /**
     * DFS深度优先搜索
     * 访问顺序是:先访问根节点-然后左节点,一直往下,直到最后左节点没有子节点的时候
     * 后往上退一步到父节点,然后父节点的右子节点在重复上述步骤
     * @param root
     */
    public static void treeDFS2(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            System.out.println(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
    }

    /**
     * DFS(深度优先搜索)递归解法
     * @param root
     */
    public static void treeDFS(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.println(root.val);
        treeDFS(root.left);
        treeDFS(root.right);
    }
}
