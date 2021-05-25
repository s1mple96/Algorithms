package tree;

import 数据结构.TreeNode;

import java.util.ArrayList;
import java.util.List;

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
     * DFS解法
     * @param root
     * @return
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        travel(root, res, 0);
        return res;
    }

    private void travel(TreeNode cur, List<List<Integer>> res, int level) {
        if (cur == null) {
            return;
        }
        //如果res.size()<=level说明下一层的集合还没创建,所以要先创建下一层的集合
        List<Integer> list = res.get(level);
        /**
         * 这里默认根节点是第0层,偶数层相当于从左往右遍历
         * 所以要添加到集合的末尾,如果是奇数层相当于从右往左遍历
         * 要把数据添加到集合的开头
         */
        if (level % 2 == 0) {
            list.add(cur.val);
        } else {
            list.add(0, cur.val);
        }
        //分别遍历左右两个子节点,到下一层了,所以层数要加1
        travel(cur.left, res, level + 1);
        travel(cur.right, res, level + 1);
    }

    /**
     * BFS双端队列
     * @param root
     * @return
     */
    /*public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        //双端队列,两边都可以操作
        Deque<TreeNode> deque = new LinkedList<>();
        //添加到队列的头
        deque.addFirst(root);
        while (!deque.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            //统计这一行有多少个节点
            int count = deque.size();
            //遍历这一行的所有节点
            TreeNode cur;
            for (int i = 0; i < count; i++) {
                if (res.size() % 2 == 1) {
                    //从左往右打印
                    //移除队列头部的元素,如果子节点不为空加入到队列的尾部
                    cur = deque.removeFirst();
                    if (cur.right != null) {
                        deque.addLast(cur.right);
                    }
                    if (cur.left != null) {
                        deque.addLast(cur.left);
                    }
                } else {
                    //从右往左打印
                    //移除队列尾部的元素,如果子节点不为空加入到队列的头部
                    cur = deque.removeLast();
                    if (cur.left != null) {
                        deque.addFirst(cur.left);
                    }
                    if (cur.right != null) {
                        deque.addFirst(cur.right);
                    }
                }
                level.add(cur.val);
            }
            res.add(level);
        }
        return res;
    }*/


    /**
     * BFS打印
     * @param root
     * @return
     */
    /*public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
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
    }*/
}
