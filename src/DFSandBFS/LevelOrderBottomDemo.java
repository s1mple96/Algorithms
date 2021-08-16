package DFSandBFS;

import dataStructure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author s1mple
 * @create 2021/6/4-14:34
 */
public class LevelOrderBottomDemo {
    /**
     * BFS
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        //边界条件判断
        if (root == null) {
            return new ArrayList<>();
        }
        //队列
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        //根节点入队
        while (!queue.isEmpty()) {
            //BFS打印,levelCount表示的是每层的节点数
            int levelCount = queue.size();
            //subList存储的是每层的节点值
            List<Integer> subList = new ArrayList<>();
            for (int i = 0; i < levelCount; i++) {
                //出队
                TreeNode node = queue.poll();
                subList.add(node.val);
                //左右子节点如果不为空加入到队列中
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            //把每层的节点的值存储在res中,插入到最前面
            //(类似于从下往上打印,关键点在此)
            res.add(0, subList);
        }
        return res;
    }

    /**
     * DFS
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrderBottom2(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        helper(res, root, 0);
        return res;
    }

    private void helper(List<List<Integer>> list, TreeNode root, int level) {
        //边界条件判断
        if (root == null) {
            return;
        }
        /**
         * 如果level等于list的长度,说明到了下一层了,
         * 并且下一层的ArrayList还没有初始化,我们要
         * 先初始化一个ArrayList,然后放进去
         */
        if (level == list.size()) {
            list.add(0, new ArrayList<>());
        }
        //这里就相当于从后往前打印了
        list.get(list.size() - level - 1).add(root.val);
        //当前节点访问完之后,再使用递归的方式分别访问当前节点的左右子节点
        helper(list, root.left, level + 1);
        helper(list, root.right, level + 1);
    }
}
