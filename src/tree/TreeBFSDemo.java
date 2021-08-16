package tree;

import dataStructure.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author s1mple
 * @create 2021/5/24-5:12
 */
public class TreeBFSDemo {
    /**
     * DFS解决
     * @param root
     * @return
     */
    public TreeNode mirrorTree(TreeNode root) {
        //如果为空就直接返回
        if (root == null) {
            return null;
        }
        //栈
        Stack<TreeNode> stack = new Stack<>();
        //根节点入栈
        stack.push(root);
        //如果栈不为空就继续循环
        while (!stack.isEmpty()) {
            //出栈
            TreeNode node = stack.pop();
            //子节点交换
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
     * BFS解决
     * @param root
     * @return
     */
    public TreeNode mirrorTree2(TreeNode root) {
        //如果为空直接返回
        if (root == null) {
            return null;
        }
        //队列
        Queue<TreeNode> queue = new LinkedList<>();
        //首先把根节点加入到队列中
        queue.add(root);
        while (!queue.isEmpty()) {
            //poll方法相当于移除队列头部的数据
            TreeNode node = queue.poll();
            //交换node两个节点的子节点
            TreeNode left = node.left;
            node.left = node.right;
            node.right = left;
            //如果当前节点的左子树不为空,就把左子树节点加入到队列中
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
        return root;
    }
}
