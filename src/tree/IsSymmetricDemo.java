package tree;

import 数据结构.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author s1mple
 * @create 2021/5/24-4:54
 */
public class IsSymmetricDemo {

    /**
     * 非递归解决
     * @param root
     * @return
     */
    public boolean isSymmetric2(TreeNode root) {
        //队列
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) {
            return true;
        }
        //左子节点和右子节点同时入队
        queue.add(root.left);
        queue.add(root.right);
        //如果队列不为空就继续循环遍历
        while (!queue.isEmpty()) {
            //每两个出队列
            TreeNode left = queue.poll();
            TreeNode right = queue.poll();
            //如果两个都为空继续循环遍历
            if (left == null && right == null) {
                continue;
            }
            //如果一个为空,一个不为空,说明不是对称的,直接返回false
            if (left == null || right == null) {
                return false;
            }
            //如果这两个值不相同,也不是对称的,直接返回false
            if (left.val != right.val) {
                return false;
            }
            /**
             * 这里要记住入队,他会每两个的出队
             * 左子节点的左子节点和右子节点的右子节点同时入队,因为他两会同时进行比较
             * 左子节点的右子节点和右子节点的左子节点同时入队,因为他两会同时进行比较
             */
            queue.add(left.left);
            queue.add(right.right);
            queue.add(left.right);
            queue.add(right.left);
        }
        return true;
    }

    /**
     * 递归解决
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        //从两个子节点开始判断
        return isSymmetricHelper(root.left, root.right);
    }
    private boolean isSymmetricHelper(TreeNode left, TreeNode right) {
        //如果左右子节点都为空,说明当前节点是叶子结点,返回true
        if (left == null && right == null) {
            return true;
        }
        //如果当前节点只有一个子节点或者有两个子节点,但两个子节点的值不相同,直接返回false
        if (left == null || right == null || left.val != right.val) {
            return false;
        }
        //然后左子节点的左子节点和右子节点的右子节点进行比较,左子节点的右子节点和右子节点的左子节点进行比较
        return isSymmetricHelper(left.left, right.right) && isSymmetricHelper(left.right, right.left);

    }
}
