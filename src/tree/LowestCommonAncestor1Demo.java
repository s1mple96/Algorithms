package tree;

import dataStructure.TreeNode;

import java.util.*;

/**
 * @author s1mple
 * @create 2021/5/23-3:15
 */
public class LowestCommonAncestor1Demo {
    /**
     * 递归写法
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        //如果left为空,说明这两个节点在root节点的右子树上,我们只需要返回右子树查找的结果即可
        if (left == null) {
            return right;
        }
        //同上
        if (right == null) {
            return left;
        }
        //如果left和right都不为空,说明这两个节点一个在root的左子树上,一个在root的右子树上
        //我们只需要返回cur节点即可
        return root;
    }

    /**
     * 非递归写法
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        //记录遍历到的每个节点的父节点
        Map<TreeNode, TreeNode> parent = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        parent.put(root, null);//根节点没有父节点,所以为空
        queue.add(root);
        //直到两个节点都找到为止
        while (!parent.containsKey(p) || !parent.containsKey(q)) {
            //队列是一边进一边出,这里poll方法是出队
            TreeNode node = queue.poll();
            if (node.left != null) {
                //左子节点不为空,记录下他的父节点
                parent.put(node.left, node);
                //左子节点不为空,把他加入到队列中
                queue.add(node.left);
            }
            //右节点同上
            if (node.right != null) {
                parent.put(node.right, node);
                queue.add(node.right);
            }
        }
        Set<TreeNode> ancestors = new HashSet<>();
        //记录下p和他的祖先节点,从p节点开始一直到根节点
        while (p != null) {
            ancestors.add(p);
            p = parent.get(p);
        }
        //查看p和他的祖先节点是否包含q节点,如果不包含再看是否包含q的父节点
        while (!ancestors.contains(q)) {
            q = parent.get(q);
        }
        return q;
    }
}
