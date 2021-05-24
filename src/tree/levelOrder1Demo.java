package tree;

import 数据结构.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author s1mple
 * @create 2021/5/24-4:35
 */
public class levelOrder1Demo {
    /**
     * BFS解决
     * @param root
     * @return
     */
    public int[] levelOrder(TreeNode root) {
        if (root == null) {
            return new int[0];
        }
        //队列
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        //根节点入队
        queue.add(root);
        while (!queue.isEmpty()) {
            //出队
            TreeNode node = queue.poll();
            //把节点的值存放到list中
            list.add(node.val);
            //左右子节点不为空就加入到队列中
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
        //把list集合转换为数组
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    /**
     * 递归方式解决
     * @param root
     * @return
     */
    public int[] levelOrder2(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        levelHelper(list, root, 0);
        List<Integer> tempList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            tempList.addAll(list.get(i));
        }

        //把list转换为数组
        int[] res = new int[tempList.size()];
        for (int i = 0; i < tempList.size(); i++) {
            res[i] = tempList.get(i);
        }
        return res;
    }

    private void levelHelper(List<List<Integer>> list, TreeNode root, int height) {
        if (root == null) {
            return;
        }
        if (height >= list.size()) {
            list.add(new ArrayList<>());
        }
        list.get(height).add(root.val);
        levelHelper(list, root.left, height + 1);
        levelHelper(list, root.right, height + 1);
    }
}
