package tree;

import 数据结构.TreeNode;

/**
 * @author s1mple
 * @create 2021/5/23-2:54
 */
public class LowestCommonAncestorDemo {

    /**
     * 递归解决
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        //如果小于等于0.说明p和q位于root的两侧,直接返回即可
        if ((root.val - p.val) * (root.val - q.val) <= 0) {
            return root;
        }
        //否则p和q位于root的同一侧,就需要往下找
        return lowestCommonAncestor2(p.val < root.val ? root.left : root.right, p, q);
    }

    /**
     * 非递归解决
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        /**
         * 如果根节点和p,q的差相乘是正数,说明这两个差值要么都是正数,要么都是负数
         * 也就是说他们肯定偶位于根节点的一侧,就继续往下找
         */
        while ((root.val - p.val) * (root.val - q.val) > 0) {
            root = p.val < root.val ? root.left : root.right;
        }
        //如果相乘的结果是负数,说明p和q位于根节点的两侧,如果等于0,说明至少有一个就是根节点
        return root;
    }
}
