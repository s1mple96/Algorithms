package DFSandBFS;

import 数据结构.TreeNode;

import java.util.Stack;

/**
 * @author s1mple
 * @create 2021/6/2-19:45
 */
public class SumNumbersDemo {

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
                //如果不是叶子节点就指向下面的操作
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
}
