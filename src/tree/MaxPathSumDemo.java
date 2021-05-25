package tree;

import 数据结构.TreeNode;

/**
 * @author s1mple
 * @create 2021/5/25-19:45
 */
public class MaxPathSumDemo {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(5);
        root.right = new TreeNode(10);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(7);
        root.right.right = new TreeNode(12);
        root.right.left = new TreeNode(22);
        MaxPathSumDemo sumDemo = new MaxPathSumDemo();
         int sum = sumDemo.maxPathSum(root);
        System.out.println(sum);
    }


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
