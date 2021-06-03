package DFSandBFS;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author s1mple
 * @create 2021/6/3-17:30
 */
public class SolveDemo {
    public void solve(char[][] board) {
        //边界条件判断
        if (board == null || board.length == 0) {
            return;
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                //从矩阵的四周开始判断,也就是矩阵的4条边上有O的地方开始遍历
                if (i == 0 || i == board.length - 1 || j == 0 || j == board[0].length - 1) {
                    if (board[i][j] == 'O') {
                        dfs(i, j, board);
                    }
                }
            }
        }
        //重新复原
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                //把矩阵中是'A'的还变为O,其他的都变成X
                if (board[i][j] == 'A') {
                    board[i][j] = 'O';
                } else {
                    board[i][j] = 'X';
                }
            }
        }
        return;
    }
    private void dfs(int i, int j, char[][] board) {
        //边界条件判断,首先不能跑到矩阵的外边
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
            return;
        }
        //如果当前位置不是O,就不用再判断了
        if (board[i][j] != 'O') {
            return;
        }
        //如果当前位置是O,先把他变为'A',然后往他的上下左右4个方向开始递归计算
        board[i][j] = 'A';
        dfs(i - 1, j, board);
        dfs(i + 1, j, board);
        dfs(i, j - 1, board);
        dfs(i, j + 1, board);
    }

    public void solve2(char[][] board) {
        //边界条件判断
        if (board == null || board.length == 0) {
            return;
        }

        int rows = board.length, columns = board[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                //从矩阵的四周开始判断,也就是矩阵的4条边上有O的地方开始遍历
                if (i == 0 || i == rows - 1 || j == 0 || j == columns - 1) {
                    if (board[i][j] == 'O') {
                        bfs(i, j, board);
                    }
                }
            }
        }
        //重新复原
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                //把矩阵中'A'的变为O,其他的都变成X
                if (board[i][j] == 'A') {
                    board[i][j] = 'O';
                } else {
                    board[i][j] = 'X';
                }
            }
        }
    }

    int[][] direction = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    private void bfs(int i, int j, char[][] board) {
        Queue<Integer> queue = new LinkedList<>();
        //把当前位置变为A
        board[i][j] = 'A';
        //把当前的坐标加入到队列中
        queue.offer(i);
        queue.offer(j);
        while (!queue.isEmpty()) {
            //坐标出队
            int queueI = queue.poll();
            int queueJ = queue.poll();
            //沿着当前位置(queueI,queueJ)的上下左右四个方向查找
            for (int k = 0; k < 4; k++) {
                int x = direction[k][0] + queueI;
                int y = direction[k][1] + queueJ;
                //边界条件判断,首先不能跑到矩阵的外边
                if (x < 0 || x >= board.length || y < 0 || y >= board[0].length) {
                    continue;
                }
                //如果当前位置不是O,就不用在判断了
                if (board[x][y] != 'O') {
                    continue;
                }
                //否则把他变为A
                board[x][y] = 'A';
                //然后再把这个位置的坐标存放到队列中
                queue.offer(x);
                queue.offer(y);
            }
        }
    }
}
