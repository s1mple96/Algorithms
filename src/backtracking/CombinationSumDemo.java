package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author s1mple
 * @create 2021/5/27-10:42
 */

/**
 * 给 定 一 个 无 重 复 元 素 的 数 组 candidates 和 一 个 目 标 数 target ， 找 出 candidates 中所有可以使数字和为 target 的组合。
 */
public class CombinationSumDemo {
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), candidates, target, 0);
        return result;
    }

    private static void backtrack(List<List<Integer>> result, List<Integer> cur, int[] candidates, int target, int start) {
        if (target == 0) {
            result.add(new ArrayList<>(cur));
            return;
        }
        //相当于遍历N叉树的子节点
        for (int i = start; i < candidates.length; i++) {//遍历三叉树
            //如果当前节点大于target我们就不要选了
            if (target < candidates[i]) {
                continue;
            }
            //由于在java中List是引用传递,所以这里要重新创建一个
            List<Integer> list = new ArrayList<>(cur);
            list.add(candidates[i]);
            backtrack(result, list, candidates, target - candidates[i], i);//遍历3叉树,找到最合适的值
        }
    }
}
