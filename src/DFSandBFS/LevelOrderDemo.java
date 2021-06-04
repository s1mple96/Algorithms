package DFSandBFS;

import 数据结构.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author s1mple
 * @create 2021/6/4-15:34
 */
public class LevelOrderDemo {
    /**
     * BFS
     * @param tree
     */
    public void levelOrder(TreeNode tree) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(tree);
        int level = 0;//统计有多少层
        while (!queue.isEmpty()) {
            //每一层的节点数
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                //打印节点
                System.out.println(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            level++;
            //打印第几层
            System.out.println(level);
        }
    }
}
