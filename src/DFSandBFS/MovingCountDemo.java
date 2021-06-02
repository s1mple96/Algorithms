package DFSandBFS;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author s1mple
 * @create 2021/6/2-16:52
 */
public class MovingCountDemo {
    /**
     * BFS搜索
     * @param m
     * @param n
     * @param k
     * @return
     */
    public int movingCount(int m, int n, int k) {
        //临时变量visited记录格子是否被访问过
        boolean[][] visited = new boolean[m][n];
        int res = 0;
        //创建一个队列,保存的是访问到的格子坐标,是个二维数组
        Queue<int[]> queue = new LinkedList<>();
        //从左上角脚本[0,0]点开始访问,add方法表示把坐标加入到队列的队尾
        queue.add(new int[]{0, 0});
        while (queue.size() > 0) {
            //这里的poll()方法表示的是一出队列头部元素,因为列队是
            //先进先出的,从队尾添加,从头部移除
            int[] x = queue.poll();
            int i = x[0], j = x[0];
            //i>=m||j>=n是边界条件的判断,k<sum(i,j)判断当前格子坐标是否满足条件,visited[i][j]判断这个格子是否被访问过
            if (i >= m || j >= n || visited[i][j]) {
                continue;
            }
            //标注这个格子被访问过
            visited[i][j] = true;
            res++;
            //把当前格子右边格子的坐标加入到队列中
            queue.add(new int[]{i + 1, j});
            //把当前格子下边格子的坐标加入到队列中
            queue.add(new int[]{i, j + 1});
        }
        return res;
    }


    /**
     * DFS搜索
     * @param i
     * @param j
     * @param m
     * @param n
     * @param k
     * @param visited
     * @return
     */
    private int dfs(int i, int j, int m, int n, int k, boolean[][] visited) {
        //i >= m || j >= n 是边界条件的判断,k < sum(i,j)判断当前格子坐标是否满足条件
        //visited[i][j]判断这个格子是否被访问过
        if (i >= m || j >= n || k < sum(i, j) || visited[i][j]) {
            return 0;
        }
        //标注这个格子没被访问过
        visited[i][j] = true;
        //沿着当格子的右边和下边继续访问
        return 1 + dfs(i + 1, j, m, n, k, visited) + dfs(i, j + 1, m, n, k, visited);
    }

    //计算两个坐标数字的和
    private int sum(int i, int j) {
        int sum = 0;
        while (i != 0) {
            sum += i % 10;
            i /= 10;
        }
        while (j != 0) {
            sum += j % 10;
            j /= 10;
        }
        return sum;
    }
}
