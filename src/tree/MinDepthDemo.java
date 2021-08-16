package tree;

import dataStructure.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author s1mple
 * @create 2021/5/25-4:37
 */
public class MinDepthDemo {
    /**
     * BFS解法
     * @param root
     * @return
     */
    public int minDepth(TreeNode root) {
        if (root == null)
            return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);//入队
        int level = 0;
        while (!queue.isEmpty()) {
            level++;
            int levelCount = queue.size();
            for (int i = 0; i < levelCount; i++) {
                TreeNode node = queue.poll();
                //如果当前node节点的左右子树都为空,直接返回false即可
                if (node.left==null&&node.right==null)
                    return level;
                if (node.left!=null)
                    queue.add(node.left);
                if (node.right!=null)
                    queue.add(node.right);
            }
        }
        return -1;
    }

    /**
     * 递归写法
     * @param root
     * @return
     */
    public int minDepth2(TreeNode root) {
        if (root==null)
            return 0;
        //左子树的最小深度
        int left = minDepth2(root.left);
        //右子树的最小深度
        int right = minDepth2(root.right);
        /**
         * 如果left和right都为0,我们返回1即可
         * 如果left和right只有一个为0,说明他只有一个子节点,我们只需要返回它另一个子节点的最小深度+1即可
         * 如果left和right都不为0,说明他有两个子节点,我们只要返回最小深度的+1即可
         */
        return (left == 0 || right == 0) ? left + right + 1 : Math.min(left, right) + 1;
    }
}
