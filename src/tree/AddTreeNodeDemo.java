package tree;

import 数据结构.TreeNode;

/**
 * @author s1mple
 * @create 2021/5/25-19:25
 */
public class AddTreeNodeDemo {
    public static void addTreeNode(TreeNode root, int data) {
        TreeNode node = new TreeNode(data);
        TreeNode p = root;
        while (true) {
            /**
             * 如果要插入的节点data比节点p的值小,就往p节点的
             * 左子节点找,否则往p的右子节点找
             */
            if (p.val > data) {
                //如果p的左子节点为空,直接放进去
                if (p.left == null) {
                    p.left = node;
                    break;
                } else {
                    p = p.left;
                }
            } else {
                if (p.right == null) {
                    p.right = node;
                    break;
                } else {
                    p = p.right;
                }
            }
        }
    }

    public TreeNode bstFromPreorder(int[] preorder) {
        TreeNode root = new TreeNode();
        root.val = preorder[0];
        for (int i = 1; i < preorder.length; i++) {
            addTreeNode(root, preorder[i]);
        }
        return root;
    }
}
