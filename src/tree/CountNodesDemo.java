package tree;

import dataStructure.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author s1mple
 * @create 2021/5/22-22:53
 */
public class CountNodesDemo {
    /**
     * BFS解决
     * @param root
     * @return
     */
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int count = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            //poll方法相当于移除队列头部的元素
            TreeNode node = queue.poll();
            count++;//统计节点个数
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
        return count;
    }

    /**
     * DFS解决:直接返回 左节点个数+右节点个数 + 1
     * @param root
     * @return
     */
    public int countNodes2(TreeNode root) {
        return root == null ? 0 : countNodes2(root.left) + countNodes2(root.right) + 1;
    }
}
