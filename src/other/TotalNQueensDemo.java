package other;

/**
 * N皇后问题
 * @author s1mple
 * @create 2021/5/26-13:19
 */
public class TotalNQueensDemo {
    public int totalNQueens(int n) {
        char[][] chess = new char[n][n];
        for (int i = 0;i < n;i++)
            for (int j = 0;j < n;j++)
                chess[i][j] = '.';
        solve(chess, 0);
    }

    private void solve(char[][] chess, int row) {
        if (row == chess.length) {
            //自己写的一个公共方法,打印二维数组的,
            //主要用于测试数据用的
            Util.printTwoCharArrays(chess);
            System.out.println();
            return;
        }
        for (int col = 0; col < chess.length; col++) {
            if (valid(chess, row, col)) {
                char[][] temp = copy(chess);
                temp[row][col] = 'Q';
                solve(temp, row + 1);
            }
        }
    }

    //row表示第几行,col表示第几列
    private boolean valid(char[][] chess, int row, int col) {
        /**
         * 判断当前列有没有皇后,因为他是一行一行往下走的,
         * 我们只需要检查走过的行数即可,通俗一点就是判断当前
         * 坐标位置上有没有皇后
         */
        for (int i = 0; i < row; i++) {
            if (chess[i][col] == 'Q') {
                return false;
            }
        }
        //判断当前坐标的右上角有没有皇后
        for (int i = row - 1, j = col + 1; i >= 0 && j < chess.length; i--, j++) {
            if (chess[i][j] == 'Q') {
                return false;
            }
        }
        //判断当前坐标的左上角有没有皇后
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (chess[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }

    //把二维数组chess中的数据测下copy一份
    private char[][] copy(char[][] chess) {
        char[][] temp = new char[chess.length][chess[0].length];
        for (int i = 0; i < chess.length; i++) {
            for (int j = 0; j < chess[0].length; j++) {
                temp[i][j] = chess[i][j];
            }
        }
        return temp;
    }
}
