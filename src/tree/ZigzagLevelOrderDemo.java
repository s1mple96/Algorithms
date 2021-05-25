package tree;

import 数据结构.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author s1mple
 * @create 2021/5/25-17:06
 */
public class ZigzagLevelOrderDemo {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        root.left.left = null;
        root.left.right = null;
        ZigzagLevelOrderDemo zigzagLevelOrderDemo = new ZigzagLevelOrderDemo();
        List<List<Integer>> lists = zigzagLevelOrderDemo.zigzagLevelOrder(root);
        System.out.println(lists.toString());
    }

    /**
     * BFS打印
     * @param root
     * @return
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean left2Right = true;
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            //统计这一行有多少个节点
            int count = queue.size();
            //遍历这行的所有节点
            for (int i = 0; i < count; i++) {
                //poll移除队列头部元素(列队在头部移除,尾部添加)
                TreeNode node = queue.poll();
                //判断是从左往右还是从右往左打印
                if (left2Right) {
                    level.add(node.val);
                } else {
                    level.add(0, node.val);
                }
                //左右子节点如果不为空会被加入到队列中
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            res.add(level);
            left2Right = !left2Right;
        }
        return res;
    }
}
