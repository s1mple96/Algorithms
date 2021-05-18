package doublepointer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author s1mple
 * @create 2021/5/18-17:23
 */
public class FindContinuousSequenceDemo {

    public int[][] findContinuousSequence(int target) {
        int left = 1;//滑动窗口的左边界
        int right = 2;//滑动窗口的右边界
        int sum = left + right;//滑动窗口中的数字的和
        List<int[]> res = new ArrayList<>();
        //窗口的左边是窗口内的最小数组,只能小于等于target/2.
        //因为图中的要求是至少含有两个数字
        while (left <= target / 2) {
            if (sum < target) {
                //若果窗口内的值比较小,右边界继续向右移动
                //来扩大窗口
                sum += ++right;
            } else if (sum > target) {
                //如果窗口内的值比较大,左边边界往右移动
                //缩小窗口
                sum -= left++;
            } else {
                //如果窗口内的值正好等于target,就把窗口内的值记录下来
                //然后窗口的左边和右边同时往右移动
                int[] arr = new int[right - left + 1];
                //因为他是连续的数组.所以可以这样写
                for (int k = left; k <= right; k++) {
                    arr[k - left] = k;
                }
                res.add(arr);
                //左边和右边同时右移
                sum -= left++;
                sum += ++right;
            }
        }
        //把结果转化为数组
        return res.toArray(new int[res.size()][]);
    }
}
