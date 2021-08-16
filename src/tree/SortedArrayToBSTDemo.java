package tree;

import dataStructure.TreeNode;

/**
 * 递归的方式,每次取中间值作为当前节点即可
 * @author s1mple
 * @create 2021/5/22-21:03
 */
public class SortedArrayToBSTDemo {
    public TreeNode sortedArrayToBST(int[] num) {
        //边界条件判断
        if (num.length == 0) {
            return null;
        }
        return sortedArrayToBST(num, 0, num.length - 1);
    }

    /**
     * @param num
     * @param start 表示数组开始的位置
     * @param end   表示数组结束的位置
     * @return
     */
    public TreeNode sortedArrayToBST(int[] num, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) >> 1;
        //取中间值作为当前节点
        TreeNode root = new TreeNode(num[mid]);
        //然后递归的方式,中间值之前的是当前节点左子树的所有节点
        root.left = sortedArrayToBST(num, start, mid - 1);
        //中间之后的是当前节点的右子树的所有节点
        root.right = sortedArrayToBST(num, mid + 1, end);
        return root;
    }
}
