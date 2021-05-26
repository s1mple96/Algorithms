package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author s1mple
 * @create 2021/5/26-18:47
 */
public class CombinationSum3Demo {

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, new ArrayList<>(), k, 1, n);
        return res;
    }

    private void dfs(List<List<Integer>> res, List<Integer> list, int k, int start, int n) {
        //终止条件,如果满足这个条件,再往下找也没有意义了
        if (list.size() == k || n <= 0) {
            //如果找到一组合适的就把他加入到集合list中
            if (list.size() == k && n == 0) {
                res.add(new ArrayList<>(list));
            }
            return;
        }
        //通过循环,分别遍历9个子树
        for (int i = start; i <= 9; i++) {
            //选择当前值
            list.add(i);
            //递归
            dfs(res, list, k, i + 1, n - 1);
            //撤销操作
            list.remove(list.size() - 1);
        }
    }

}
