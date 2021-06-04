package DFSandBFS;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * @author s1mple
 * @create 2021/6/4-15:34
 */
public class LevelOrderDemo {
    /**
     * BFS
     * @param n
     */
    public int numSquares(int n) {
        Queue<Integer> queue = new LinkedList<>();
        //记录访问过的节点值
        Set<Integer> visited = new HashSet<>();
        queue.offer(0);
        visited.add(0);
        //树的第几层
        int level = 0;
        while (!queue.isEmpty()) {
            //每一层的节点数量
            int size = queue.size();
            level++;
            //遍历当前层的所有节点
            for (int i = 0; i < size; i++) {
                //节点的值
                int digit = queue.poll();
                //访问当前节点的子节点,类比于二叉树的左右子节点
                for (int j = 1; j <= n; j++) {
                    //子节点的值
                    int nodeValue = digit + j * j;
                    //nodeValue始终是完全平方数的和,当他等于n的
                    //时候,直接返回
                    if (nodeValue == n) {
                        return level;
                    }
                    //如果大于n.终止内层循环
                    if (nodeValue > n) {
                        break;
                    }
                    if (!visited.contains(nodeValue)) {
                        queue.offer(nodeValue);
                        visited.add(nodeValue);
                    }
                }
            }
        }
        return level;
    }
}
