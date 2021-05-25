package tree;

import 数据结构.TreeNode;

/**
 * @author s1mple
 * @create 2021/5/25-19:45
 */
public class MaxPathSumDemo {
    private int maxValue = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxPathSumHelper(root);
        return maxValue;
    }

    public int maxPathSumHelper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        //左子节点的值
        int left = maxPathSumHelper(root.left);
        //右子节点的值
        int right = maxPathSumHelper(root.right);
        //第四种情况
        int cur = root.val + Math.max(0, left) + Math.max(0, right);
        //第1,2,3三种情况,返回当前的值加上左右子节点的最大值即可,如果左右子节点都小于0,还不如不选
        int res = root.val + Math.max(0, Math.max(left, right));
        //记录最大value值
        maxValue = Math.max(maxValue, Math.max(cur, res));
        return res;
    }
}
