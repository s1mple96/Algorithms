package tree;

import 数据结构.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author s1mple
 * @create 2021/5/24-11:26
 */
public class RightSideViewDemo {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(3);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.left.left.right = new TreeNode(7);

        RightSideViewDemo viewDemo = new RightSideViewDemo();
        List<Integer> res = viewDemo.rightSideView(root);
        System.out.println(res);
    }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        dfs(root, res, 0);
        return res;
    }
    /**
     * DFS遍历
     * @param curr
     * @param res
     * @param level
     */
    private void dfs(TreeNode curr, List<Integer> res, int level) {
        //递归的终止条件判断
        if (curr == null) {
            return;
        }
        /**
         * level表示的是第几层,因为是先遍历右子树,所以每一层最先遍历
         * 的节点值就是我们所需要的.当下面语句成立的时候,就表示当前节
         * 点值所在的哪一行是最先遍历的,所以要把他加入到集合res中
         */
        if (level == res.size()) {
            res.add(curr.val);
        }
        dfs(curr.right, res, level + 1);
        dfs(curr.left, res, level + 1);
    }

    /**
     * DFS非递归写法
     * @param root
     */
    private List<Integer> rightSideView2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        //终止条件判断
        if (root == null) {
            return res;
        }
        //两个栈,一个存储当前节点,一个存储当前节点在第几层
        Stack<TreeNode> stackNode = new Stack<>();
        Stack<Integer> stackLevel = new Stack<>();
        //当前节点和当前节点的层数同时入栈
        stackNode.push(root);
        stackLevel.push(0);
        while (!stackNode.isEmpty()) {
            //当前节点和当前节点的层数同时出栈
            TreeNode node = stackNode.pop();
            int level = stackLevel.pop();
            //下一层最闲访问的节点就是我们需要的值
            if (res.size() == level) {
                res.add(node.val);
            }
            //先访问左子节点,在访问有右子节点
            if (node.left != null) {
                stackNode.push(node.left);
                stackLevel.push(level + 1);
            }
            if (node.right != null) {
                stackNode.push(node.right);
                stackLevel.push(level + 1);
            }
        }
        return res;
    }
}
