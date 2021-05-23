package tree;

import 数据结构.TreeNode;

/**
 * @author s1mple
 * @create 2021/5/22-20:39
 */
public class IsBalancedDemo {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        //分别计算左子树和右子树的高度
        int left = depth(root.left);
        int right = depth(root.right);
        //这两个子树的高度不能超过1,并且他的两个子树也必须满足平衡二叉树
        return Math.abs(left - right) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    /**
     * 计算树种节点的高度
     * @param root
     * @return
     */
    public int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(depth(root.left), depth(root.right)) + 1;
    }
}
