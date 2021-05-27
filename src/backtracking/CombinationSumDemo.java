package backtracking;

import java.util.ArrayList;
<<<<<<< HEAD
=======
import java.util.Arrays;
>>>>>>> origin/master
import java.util.List;

/**
 * @author s1mple
<<<<<<< HEAD
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
=======
 * @create 2021/5/26-3:44
 */
public class CombinationSumDemo {

    /**
     * 类似的问题我们可以把他想象成一颗N叉树,我们先选择一个,然后递归选择(根据是否
     * 可以选择重复的有不同的选择,如果允许重复的,我们递归的时候还可以再选择当前的,
     * 如果不允许有重复的,我们递归的时候就从当前的下一个开始选择),沿着这个分支走完之后
     * 我们会把当前节点上次,然后再从下一个分支走...
     * @param args
     */
    public static void main(String[] args) {
        int[] candidates = {2, 3, 5};
        int target = 8;
        List<List<Integer>> lists = combinationSum(candidates, target);
        System.out.println(Arrays.toString(lists.toArray()));
    }


    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res, new ArrayList<>(), candidates, target,0);
        return res;
    }

    private static void backtrack(List<List<Integer>> res, List<Integer> cur,
                                  int[] candidates, int target, int start) {
        if (target == 0) {
            res.add(new ArrayList<>(cur));
            return;
        }
        //相当于遍历N叉树的子节点
         for (int i = start; i < candidates.length; i++) {
>>>>>>> origin/master
            //如果当前节点大于target我们就不要选了
            if (target < candidates[i]) {
                continue;
            }
            //由于在java中List是引用传递,所以这里要重新创建一个
<<<<<<< HEAD
            List<Integer> list = new ArrayList<>();
            list.add(candidates[i]);
            backtrack(result, list, candidates, target - candidates[i]);
=======
            List<Integer> list = new ArrayList<>(cur);
            list.add(candidates[i]);
            backtrack(res, list, candidates, target - candidates[i],i);
>>>>>>> origin/master
        }
    }
}
