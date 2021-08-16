package tree;

import dataStructure.TreeNode;

/**
 * @author s1mple
 * @create 2021/5/22-6:33
 */
public class RangeSumBSTDemo {

    /**
     * 这题的条件是二叉搜索树,二叉搜索树的特点是:
     * 左子树的所有节点都比当前节点值小
     * 右子树的所有节点都比当前节点值大
     * <p>
     * 优化解法:
     * 如果当前节点小于low,那么他的左子树的所有节点肯定也都小于low,我们没必要在遍历了.
     * 如果当前节点大于high,那么他的右子树的所有节点肯定也都大于high,也可以放弃
     */

    public int rangeSumBST(TreeNode root, int low, int high) {
        //递归边界条件判断
        if (root == null) {
            return 0;
        }
        //当前节点以及他的右子树的值都太大了,不要了.
        if (root.val > high) {
            return rangeSumBST(root.left, low, high);
        }
        //当前节点一级他的左子树的值都太小了,也不要了
        if (root.val < low) {
            return rangeSumBST(root.right, low, high);
        }
        //如果当前节点值在[low,high]之间,就留下
        return root.val + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high);
    }


    /*int res = 0;
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
    }*/

}
