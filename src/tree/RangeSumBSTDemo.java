package tree;

import 数据结构.TreeNode;

/**
 * @author s1mple
 * @create 2021/5/22-6:33
 */
public class RangeSumBSTDemo {
    int res = 0;
    public int rangeSumBST(TreeNode root, int low, int high) {
        inOrderTraversal(root, low, high);
        return res;
    }

    private void inOrderTraversal(TreeNode root, int low, int high) {
        if (root == null) {
            return;
        }
        inOrderTraversal(root.left, low, high);
        //如果当前节点的值在[low,hight]之间,就累加
        if (root.val >= low && root.val <= high) {
            res += root.val;
        }
        inOrderTraversal(root.right, low, high);
    }

}
