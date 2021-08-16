package tree;

import dataStructure.TreeNode;

import java.util.*;

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

    /**
     * BFS解法
     * @param root
     * @return
     */
    private List<Integer> rightSideView3(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        //终止条件判断
        if (root == null) {
            return res;
        }
        //创建队列
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            //每一层的数量
            int count = queue.size();
            while (count-- > 0) {//它的意思是循环n次，除了最常用的 for (int i = 0; i < n; ++i) {...} 之外，还可以写 while (n-- > 0) {...} 和 while (--n >= 0) {...}。
                //当前节点出队
                TreeNode cur = queue.poll();
                //因为每层是从左往右依次入队的,所以每层的
                //最后一个就是我们所需要的
                if (count == 0) {
                    res.add(cur.val);
                }
                //左子树如果不为空,左子树入队,右子树不为空,右子树入队
                if (cur.left != null) {
                    queue.add(cur.left);
                }
                if (cur.right != null) {
                    queue.add(cur.right);
                }
            }
        }
        return res;
    }
}
