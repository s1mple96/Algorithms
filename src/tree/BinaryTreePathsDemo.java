package tree;

import 数据结构.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author s1mple
 * @create 2021/5/23-0:01
 */
public class BinaryTreePathsDemo {

    public List<String> binaryTreePaths2(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        //存储节点的栈
        Stack<TreeNode> stackNode = new Stack<>();
        //存储路径的栈,和上面的栈是同步进行的,这里路径指的是从根节点到当前节点的路径
        Stack<String> stackPath = new Stack<>();
        //根节点和根节点路径同时入栈
        stackNode.push(root);
        stackPath.push(root.val + "");
        while (!stackNode.isEmpty()) {
            //当前节点和对应的路径同时出栈
            TreeNode node = stackNode.pop();
            String path = stackPath.pop();
            //如果到达叶子节点,就把路径加入到集合res中
            if (node.left == null && node.right == null) {
                res.add(path);
            }
            //如果右子节点不为空,就把右子节点和对应的路径分别加入到栈中
            if (node.right != null) {
                stackPath.push(path + "->" + node.right.val);
                stackNode.push(node.right);
            }
            //同上
            if (node.left != null) {
                stackPath.push(path + "->" + node.left.val);
                stackNode.push(node.left);
            }
        }
        return res;
    }



    /**
     * DFS解决
     * @param root
     * @return
     */
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        dfs(root, "", res);
        return res;
    }
    private void dfs(TreeNode root, String path, List<String> res) {
        //如果到达叶子节点,就把结果存到到集合res中
        if (root.left == null && root.right == null) {
            res.add(path + root.val);
        }
        //如果左子节点不为空,就沿着左子节点走下去
        if (root.left != null) {
            dfs(root.left, path + root.val + "->", res);
        }
        //如果右子节点不为空,就沿着右子节点走下去
        if (root.right != null) {
            dfs(root.right, path + root.val + "->", res);
        }
    }

}
