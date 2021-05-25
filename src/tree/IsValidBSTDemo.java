package tree;

import 数据结构.TreeNode;

import java.util.Stack;

/**
 * @author s1mple
 * @create 2021/5/25-13:08
 */
public class IsValidBSTDemo {
    /**
     * 中序遍历非递归
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (pre != null && root.val <= pre.val) {
                return false;
            }
            //保存前一个访问的节点
            pre = root;
            root = root.right;
        }
        return true;
    }
    /**
     * 中序遍历递归
     *
     * @param root
     * @return
     */
   /* TreeNode prev;
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        //访问左子树
        if (!isValidBST(root.left)) {
            return false;
        }
        //访问当前节点:如果当前节点小于等于中序遍历的前一个节点直接返回false
        if (prev != null && prev.val >= root.val) {
            return false;
        }
        //访问右子树
        if (!isValidBST(root.right)) {
            return false;
        }
        return true;
    }*/

    /**
     * 递归写法
     * @param root
     * @return
     */
    /*public boolean isValidBST(TreeNode root) {
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
        *//**
         * 这里再分别以左右两个子节点分别判断
         * 左子树范围的最小值是minValue,最大值是当前节点的值,也就是root的值,因为左子树的值要比当前节点小
         * 右子树方位的最大值是maxValue,最小值是当前节点的值,也就是root的值,因为右子树的值要比当前节点大
         *//*
        return isValidBST(root.left, minValue, root.val) && isValidBST(root.right, root.val, maxValue);
    }*/

}
