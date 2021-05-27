package backtracking;

/**
 * @author s1mple
 * @create 2021/5/27-18:12
 */

/**
 * 回溯往往会伴随着递归,要想搞懂回溯,必须要搞懂递归,搞懂了递归,回溯就很容易
 * 理解了,其实递归我们可以把他抽象成一颗N叉树的遍历,递归的过程也就是沿着子
 * 节点走下去的过程,并且递归必须要有终止条件,不能无限制的递归下去
 */
public class ExistDemo {
    public boolean exist(char[][] board, String word) {
        char[] words = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                //从[i,j]这个坐标开始查找
                if (dfs(board,words,i,j,0))
                    return true;
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, char[] word, int i, int j, int index) {
        /**
         * 边界的判断,如果越界直接返回false,index表示的是查找到字符串word的第几个字符
         * 如果这个字符串不等于board[i][j],说明验证这个坐标路径是走不通的,直接返回false
         */
        if (i >= board.length || i < 0 || j >= board[0].length || j < 0 || board[i][j] != word[index]) {
            return false;
        }
        //如果word的每个字符都查完了,直接返回true
        if (index == word.length - 1) {
            return true;
        }
        //为了防止分支污染,把board数组复制一份
        char temp = board[i][j];
        //把newArr[i][j]置为特殊符号,表示已经被使用过了(注意:word中不能包含'.')
        board[i][j] = '.';
        //从当前坐标上下左右四个方向查找
        boolean res =  dfs(board, word, i + 1, j, index + 1)
                    || dfs(board, word, i - 1, j, index + 1)
                    || dfs(board, word, i, j + 1, index + 1)
                    || dfs(board, word, i, j - 1, index + 1);
        return res;
    }

    /**
     * 复制一份新的数组
     * @param word
     * @return
     */
    /*private char[][] copyArray(char[][] word) {
        char[][] newArray = new char[word.length][word[0].length];
        for (int i = 0; i < word.length; i++) {
            for (int j = 0; j < word[0].length; j++) {
                newArray[i][j] = word[i][j];
            }
        }
        return newArray;
    }*/
}
