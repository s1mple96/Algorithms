package backtracking;

/**
 * @author s1mple
 * @create 2021/5/28-11:36
 */
public class GetMaximumGoldDemo {
    public int getMaximumGold(int[][] grid) {
        //边界条件判断
        if (grid == null || grid.length == 0) {
            return 0;
        }
        //保存最大值
        int res = 0;
        //两个for循环,遍历每一个位置,让她们当做起点
        //查找最大路径值
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                //函数dfs是以坐标(i,j),查找最大路径值
                res = Math.max(res, dfs(grid, i, j));
            }
        }
        //返回最大路径值
        return res;
    }

    private int dfs(int[][] grid, int x, int y) {
        //边界条件的判断,x,y都不能越界,同时当前坐标的位置如果是0,表示有障碍物
        //或者遍历过了
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] == 0) {
            return 0;
        }
        //先把当前坐标的值保存下来,最后再还原
        int temp = grid[x][y];
        //当前坐标已经访问过了,要把它标记为0,防止再次访问
        grid[x][y] = 0;
        //然后沿着当前坐标的上下左右4个方向查找
        int up = dfs(grid, x, y - 1);//往上找
        int down = dfs(grid, x, y + 1);//往下找
        int left = dfs(grid, x - 1, y);//往左找
        int right = dfs(grid, x + 1, y);//往右找
        //这里只要4个方向的最大值即可
        int max = Math.max(left, Math.max(right, Math.max(up, down)));
        //然后再把当前位置的值还原
        grid[x][y] = temp;
        //返回最大路径值
        return grid[x][y] + max;
    }
}
