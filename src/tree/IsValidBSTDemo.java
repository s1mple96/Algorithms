package tree;

import 数据结构.TreeNode;

/**
 * @author s1mple
 * @create 2021/5/25-13:08
 */
public class IsValidBSTDemo {

    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidBST(TreeNode root, long minValue, long maxValue) {
        if (root == null) {
            return true;
        }
        //每个节点如果超过这个范围,直接返回false
        if (root.val >= maxValue || root.val <= minValue) {
            return false;
        }
        /**
         * 这里再分别以左右两个子节点分别判断
         * 左子树范围的最小值是minValue,最大值是当前节点的值,也就是root的值,因为左子树的值要比当前节点小
         * 右子树方位的最大值是maxValue,最小值是当前节点的值,也就是root的值,因为右子树的值要比当前节点大
         */
        return isValidBST(root.left, minValue, root.val) && isValidBST(root.right, root.val, maxValue);
    }

}
