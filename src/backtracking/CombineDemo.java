package backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author s1mple
 * @create 2021/5/28-12:30
 */
public class CombineDemo {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> list = new LinkedList<>();
        backtrack(list, n, k, 1, new ArrayList<>());
        return list;
    }

    private void backtrack(List<List<Integer>> list, int n, int k, int start, List<Integer> tempList) {
        //终止条件,找到一组合
        if (k == 0) {
            list.add(new LinkedList<>(tempList));
            return;
        }
        //注意这里的i不能从0开始,如果从0开始会出现重复的,比如[1,2]和[2,1]
        for (int i = start; i <= n - k + 1; i++) {
            //把当前值添加到集合中
            tempList.add(i);
            //递归调用
            backtrack(list, n, k - 1, i + 1, tempList);
            //从当前分支跳到下一个分支的时候要把之前添加的值给移除
            tempList.remove(tempList.size() - 1);
        }
    }
}
