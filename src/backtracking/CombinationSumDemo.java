package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author s1mple
 * @create 2021/5/26-18:32
 */
public class CombinationSumDemo {

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), candidates, target);
        return result;
    }

    private static void backtrack(List<List<Integer>> result, List<Integer> cur, int[] candidates, int target) {
        if (target == 0) {
            result.add(new ArrayList<>(cur));
            return;
        }
        //相当于遍历N叉树的子节点
        for (int i = 0; i < candidates.length; i++) {
            //如果当前节点大于target我们就不要选了
            if (target < candidates[i]) {
                continue;
            }
            //由于在java中List是引用传递,所以这里要重新创建一个
            List<Integer> list = new ArrayList<>();
            list.add(candidates[i]);
            backtrack(result, list, candidates, target - candidates[i]);
        }
    }
}
