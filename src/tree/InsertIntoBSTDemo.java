package tree;

import 数据结构.TreeNode;

/**
 * @author s1mple
 * @create 2021/5/22-23:45
 */
public class InsertIntoBSTDemo {
    /**
     * 递归方式
     * @param root
     * @param val
     * @return
     */
    public TreeNode insertIntoBST2(TreeNode root, int val) {
        //如果root为空,就直接创建一个新的节点
        if (root == null) {
            return new TreeNode(val);
        }
        //如果root节点的值大于val,说明val的节点应该在root节点的左子树上
        if (root.val > val) {
            root.left = insertIntoBST(root.left, val);
        } else {
            root.right = insertIntoBST(root.right, val);
        }
        return root;
    }

    /**
     * 非递归方式
     * @param root
     * @param val
     * @return
     */
    public TreeNode insertIntoBST(TreeNode root, int val) {
        //边界条件判断
        if (root == null) {
            return new TreeNode(val);
        }
        TreeNode cur = root;
        while (true) {
            //如果当前节点cur的值大于val,说明val值应该插入到当前节点cur的右子树
            //否则就插入到cur的左子树
            if (cur.val > val) {
                //如果左子节点不为空,就继续往下找
                if (cur.left != null) {
                    cur = cur.left;
                } else {//如果左子树节点为空,就直接插入,然后在返回root节点
                    cur.left = new TreeNode(val);
                    return root;
                }
            } else {//同上
                if (cur.right != null) {
                    cur = cur.right;
                } else {
                    cur.right = new TreeNode(val);
                    return root;
                }
            }
        }
    }
}
