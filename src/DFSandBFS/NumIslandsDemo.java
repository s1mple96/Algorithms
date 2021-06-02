package DFSandBFS;

/**
 * @author s1mple
 * @create 2021/6/2-18:41
 */
public class NumIslandsDemo {
    public int numIslands(char[][] grid) {
        //边界条件判断
        if (grid == null || grid.length == 0) {
            return 0;
        }
        //统计岛屿的个数
        int count = 0;
        //两个for循环遍历每一格子
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                //只有当格子是1才开始计算
                if (grid[i][j] == 1) {
                    //如果当前的格子是1,岛屿的数量+1
                    count++;
                    /**
                     * 然后通过dfs把当前格子的上下左右4个
                     * 位置为1的都要置为0,因为他们是连着的
                     * 一起的算一个岛屿
                     */
                    dfs(grid, i, j);
                }
            }

        }
        //最后返回岛屿数量
        return count;
    }

    /**
     * 这个方法会把当前格子以及它临近的格子都会置为0
     * @param grid
     * @param i
     * @param j
     */
    public void dfs(char[][] grid, int i, int j) {
        //边界条件判断
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '1') {
            return;
        }
        //把当前格子置为0,然后再从他的上下左右四个方向继续遍历
        grid[i][j] = '0';
        dfs(grid, i - 1, j);
        dfs(grid, i + 1, j);
        dfs(grid, i, j - 1);
        dfs(grid, i, j + 1);
    }
}
