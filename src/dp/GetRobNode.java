package dp;


/**
 * @author s1mple
 * @create 2021/5/15-20:24
 */
public class GetRobNode {
    /**
     * 如果 偷 根节点,那么我们不能偷子节点也可以不偷子节点,我们取最大值即可
     * dp[0] = root.val + left.dp[0]+right.dp[0]; 这里的伪代码left.dp[0].表示的是不能偷当前节点的左子节点
     * 如果 不偷 根节点,那么我们可以偷子节点也可以不偷子节点,我们取最大值
     * dp[1] = max(left.dp[0],left.dp[1])+max(right.dp[0],right.dp[1]);
     *
     */
    public int rob(TreeNode root) {
        int[] robHelp = robHelper(root);
        //取偷根节点和不能偷根节点的最大值
        return Math.max(robHelp[1], robHelp[0]);
    }

    private int[] robHelper(TreeNode root) {
        //边界条件
        if (root == null) {
            return new int[2];
        }
        //这里left是个长度为2的一维数组,其中left[0]表示不能偷root.left节点.
        //所以能偷窃的最大金额,left[1]表示偷root.left节点所能偷窃的最大金额
        int[] left = robHelper(root.left);
        //right节点同left
        int[] right = robHelper(root.right);
        //Math.max(right[0],right[1],root.val+left[0],right[0]表示的
        //是不能偷当前节点,所以可以偷两个子节点,也可以不偷两个子节点,我们取最大值
        //root.val+left[1]+right[1]表示的是偷当前子节点,所以不能偷两个子节点
        return new int[]{
            Math.max(left[0], left[1]) + Math.max(right[0], right[1]), root.val + left[0] + right[0]};
    }
}
