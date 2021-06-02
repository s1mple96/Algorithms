package DFSandBFS;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author s1mple
 * @create 2021/6/2-12:46
 *
 *
 * 解释:这两种方式很容易想到:
 *  一个是 沿着一个方向一直走下去.
 *  一个是 就像波浪一样,沿着一个点然后往四周一圈一圈的发散
 */
public class MaxAreaOfIslandDemo {

    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    maxArea = Math.max(maxArea, dfs(grid, i, j));
                }
            }
        }
        return maxArea;
    }

    private int dfs(int[][] grid, int i, int j) {
        //边界条件判断
        if (i >= 0 && i < grid.length && j >= 0 && j < grid[0].length && grid[i][j] == 1) {
            //当前位置如果是1,为了防止重复计算就把他置为0,然后在从他的上下左右四个方向开始查找
            grid[i][j] = 0;
            return 1 + dfs(grid, i + 1, j) + dfs(grid, i - 1, j) + dfs(grid, i, j + 1) + dfs(grid, i, j - 1);
        }
        return 0;
    }

    public int bfs(int[][] grid, int i, int j) {
        int m = grid.length, n = grid[0].length;
        if (grid[i][j] == 0) {
            return 0;
        }
        grid[i][j] = 0;
        //队列中存储的是个二维数组,这个二维数组就是格子的坐标
        Queue<int[]> queue = new LinkedList<>();
        //offer表示添加到队列的末尾
        queue.offer(new int[]{i, j});
        //分别表示左右上下四个方向
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int res = 1;
        while (!queue.isEmpty()) {
            //poll表示从队列的头部移除一个元素
            int[] pos = queue.poll();
            //然后从pos坐标的4个方向再分别查找
            for (int[] dir : dirs) {
                int x = dir[0] + pos[0];
                int y = dir[1] + pos[1];
                //边界条件的判断
                if (x < 0 || x >= m || y < 0 || y >= n || grid[x][y] == 0) {
                    continue;
                }
                grid[x][y] = 0;
                res++;
                queue.offer(new int[]{x, y});
            }
        }
        return res;
    }
}
