package tree;

import dataStructure.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author s1mple
 * @create 2021/5/22-23:09
 */
public class InvertTreeDemo {

    /**
     * DFS方式
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            //先交换
            TreeNode left = node.left;
            node.left = node.right;
            node.right = left;

            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
        }
        return root;
    }

    /**
     * BFS方式
     * @param root
     * @return
     */
    public TreeNode invertTree2(TreeNode root) {
        if (root == null) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);//相当于把数据加入到队列尾部
        while (!queue.isEmpty()) {
            //poll方法相当于移除队列头部的元素
            TreeNode node = queue.poll();
            //先交换子节点
            TreeNode left = node.left;
            node.left = node.right;
            node.right = left;

            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
        return root;
    }

    /**
     * 递归方式
     * @param root
     * @return
     */
    public TreeNode invertTree3(TreeNode root) {
        //递归的边界条件判断
        if (root == null) {
            return null;
        }
        //先交换子节点
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.right = left;
        root.left = right;
        //递归调用
        invertTree3(root.left);
        invertTree3(root.right);
        return root;
    }
}
