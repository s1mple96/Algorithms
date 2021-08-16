package tree;

import dataStructure.TreeNode;

/**
 * @author s1mple
 * @create 2021/5/25-5:12
 */
public class MaxDepthDemo {
    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
    /*public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        int count = 0;
        while (!stack.isEmpty()) {
            int size = stack.size();
            while (size-- > 0) {
                TreeNode node = stack.pop();
                if (node.left!=null)
                    stack.addLast(node.left);
                if (node.right!=null)
                    stack.addLast(node.right);
            }
            count++;
        }
        return count;
    }*/

