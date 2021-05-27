package backtracking;

import 数据结构.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author s1mple
 * @create 2021/5/27-18:53
 */
public class PathSumDemo {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(root, sum, new ArrayList<>(), result);
        return result;
    }

    private void dfs(TreeNode root, int sum, List<Integer> list, List<List<Integer>> result) {
        //如果节点为空直接返回
        if (root == null) {
            return;
        }
        //把当前节点值加入到list中
        list.add(new Integer(root.val));
        //如果到达叶子节点,就不能往下走了,直接return
        if (root.left == null && root.right == null) {
            //如果叨叨叶子节点,并且sum等于叶子节点的值,说明我们找到了一组
            //要把它放入到result中
            if (sum == root.val) {
                result.add(new ArrayList<>(list));
            }
            //注意了,别忘了把最后加入的节点值给移除掉,因为在下一步直接return了,
            //不会再走最后一行的remove了,所以这里return之前提前把最后一个节点
            //的值给remove掉.
            list.remove(list.size() - 1);
            //到叶子节点之后直接返回,因为再往下走就走不动了
            return;
        }
        //如果没有叨叨叶子节点,就继续从他的左右两个子节点往下找,注意到
        //下一步的时候,sum值要减去当前节点的值
        dfs(root.left, sum - root.val, list, result);
        dfs(root.right, sum - root.val, list, result);
        //我们要理解递归的本质,当递归往下传递的时候他最后还是会往回走,
        //我们把这个值使用玩之后还要把她给移除,这就是回溯
        list.remove(list.size() - 1);
    }

    /*//DFS方法
    private void dfs(TreeNode root, int sum, List<Integer> list, List<List<Integer>> result) {
        //如果节点为空直接返回
        if (root == null) {
            return;
        }
        //因为list是引用传递,为了防止递归的时候分支污染,我们要在每个路径
        //中都要新建一个subList
        List<Integer> subList = new ArrayList<>(list);
        //把当前节点值加入到subList中
        subList.add(new Integer(root.val));
        //如果达到叶子节点,就不能往下走了,直接return
        if (root.left == null && root.right == null) {
            //如果到达叶子节点,并且sum等于叶子节点的值,说明我们找到了一组,
            //要把他放到result中
            if (sum == root.val) {
                result.add(subList);
            }
            //到叶子节点之后直接返回,因为往下走就走不动了
            return;
        }
        //如果没有达到叶子节点,就继续从他的左右两个子节点往下找,注意到
        //下一步的时候,sum值要减去当前节点的值
        dfs(root.left, sum - root.val, subList, result);
        dfs(root.right, sum - root.val, subList, result);
    }*/

}
