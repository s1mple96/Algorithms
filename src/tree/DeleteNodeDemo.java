package tree;

import dataStructure.TreeNode;

/**
 * @author s1mple
 * @create 2021/5/25-16:25
 */
public class DeleteNodeDemo {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        //通过递归的方式要先找到要删除的节点
        if (key < root.val) {
            //要删除的节点在左子树上
            root.left = deleteNode(root.left, key);
        } else if (key > root.val) {
            //要删除的节点在右子树上
            root.right = deleteNode(root.right, key);
        } else {
            //找到了要删除的节点
            //如果左子树为空,我们需要返回右子树即可
            if (root.left == null) {
                return root.right;
            }
            //如果右子树为空,我们需要返回左子树即可
            if (root.right == null) {
                return root.left;
            }
            /**
             * 说明两个子节点都不为空,我们可以找左子树的最大值
             * 也可以找右子树的最小值替换
             */
            //这里是用左子树的最大值替换
            TreeNode maxNode = findMax(root.left);
            root.val = maxNode.val;
            root.left = deleteNode(root.left, root.val);
        }
        return root;
    }

    /**
     * 找左子树的最大值
     * @param node
     * @return
     */
    private TreeNode findMax(TreeNode node) {
        while (node.right != null) {
            node = node.right;
        }
        return node;
    }
}
