package tree;

import 数据结构.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author s1mple
 * @create 2021/5/25-3:58
 */
public class LargestValuesDemo {

    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res, 1);
        return res;
    }

    /**
     *
     * @param root
     * @param res   集合res中的第一个数据表示的第一层的最大的数
     * @param level 表示的是第几层,
     */
    private void helper(TreeNode root, List<Integer> res, int level) {
        if (root == null)
            return;
        //如果走到下一层了,直接加入到集合中
        if (level == res.size() - 1) {
            res.add(root.val);
        } else {
            /**
             * 注意:我们的level是从1开始的,也就是说root
             * 是第一层,而集合list的下标是从0开始的
             * 所以之类level要减1.
             * Math.max(res.get(level-1),root.val)表示的是遍历到的第level层的root.val值
             * 和集合中的第level个元素的值哪个大,就需要哪个
             */
            res.set(level - 1, Math.max(res.get(level - 1), root.val));
        }
        //下面是DFS核心代码
        helper(root.left, res, level + 1);
        helper(root.right, res, level + 1);
    }

    /**
     * BFS遍历方法
     * @param root
     * @return
     */
    /*public List<Integer> largestValues(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        if (root != null)
            queue.add(root);//入队
        while (!queue.isEmpty()) {
            int max = Integer.MIN_VALUE;
            int levelSize = queue.size();//每一层的数量
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();//出队
                max = Math.max(max, node.val);//记录每层最大的值
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            res.add(max);
        }
        return res;
    }*/
}
