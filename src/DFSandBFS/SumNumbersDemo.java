package DFSandBFS;

import 数据结构.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author s1mple
 * @create 2021/6/2-19:45
 */
public class SumNumbersDemo {
    /**
     * DFS遍历
     * @param root
     * @return
     */
    public int sumNumbers(TreeNode root) {
        //如果根节点是空,直接返回0即可
        if (root == null) {
            return 0;
        }
        //两个栈,一个存储的是节点,一个存储的是节点对应的值
        Stack<TreeNode> nodeStack = new Stack<>();
        Stack<Integer> valueStack = new Stack<>();
        //全局的,统计所有路径的和
        int res = 0;
        nodeStack.add(root);
        valueStack.add(root.val);
        while (!nodeStack.isEmpty()) {
            //当前节点和当前节点的值同时出栈
            TreeNode node = nodeStack.pop();
            int value = valueStack.pop();
            if (node.left == null && node.right == null) {
                //如果当前节点是叶子节点,说明找到了一条路径,
                //把这条路径的值加入到全局变量res中
                res += value;
            } else {
                //如果不是叶子节点就指向下面的操作根到叶子节点数字之和
                if (node.right != null) {
                    //把子节点和叶子节点的值分别加入到栈中,这里子节点的值
                    //就是父节点的值*10+当前节点的值
                    nodeStack.push(node.right);
                    valueStack.push(value * 10 + node.right.val);
                }
                if (node.left != null) {
                    nodeStack.push(node.left);
                    valueStack.push(value * 10 + node.left.val);
                }
            }
        }
        return res;
    }
    //优化
    public int sumNumbers2(TreeNode root) {
        return dfs(root, 0);
    }
    private int dfs(TreeNode root, int sum) {
        //终止条件的判断
        if (root==null)
            return 0;
        //计算当前节点的值
        sum = sum * 10 + root.val;
        //如果当前节点是叶子节点,说明找到了一条完整路径,直接返回这条路径即可
        if (root.left == null && root.right == null) {
            return sum;
        }
        //如果当前节点不是叶子节点,返回左右子节点的路径和
        return dfs(root.left, sum) + dfs(root.right, sum);
    }

    public int sumNumbers3(TreeNode root) {
        //边界条件判断
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<Integer> valueQueue = new LinkedList<>();
        int res = 0;
        nodeQueue.add(root);
        valueQueue.add(root.val);
        while (!nodeQueue.isEmpty()) {
            //节点和节点对应的值同时出队
            TreeNode node = nodeQueue.poll();
            int value = valueQueue.poll();
            if (node.left == null && node.right == null) {
                //如果当前节点是叶子节点,说明找到了一条路径,把这条
                //路径的值加入到全局变量res中
                res += value;
            } else {
                //如果不是叶子节点就执行下面的操作
                if (node.left != null) {
                    //把子节点和子节点的值分别加入到队列中,这里子节点的值
                    //就是父节点的值*10+当前节点的值
                    nodeQueue.add(node.left);
                    valueQueue.add(value * 10 + node.left.val);
                }
                if (node.right != null) {
                    nodeQueue.add(node.right);
                    valueQueue.add(value * 10 + node.right.val);
                }
            }
        }
        return res;
    }
}
