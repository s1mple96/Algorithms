package backtracking;

/**
 * @author s1mple
 * @create 2021/5/18-12:05
 */
public class GetMakesquare {
    public boolean makesquare(int[] nums) {
        int total = 0;
        //统计所有火柴的长度
        for (int num : nums) {
            total += num;
        }
        //如果所有火柴的长度不是4的倍数,直接返回false
        if (total == 0 || (total & 3) != 0) {
            return false;
        }
        //如果是接着往下判断
        return backtrack(nums, 0, total >> 2, new int[4]);
    }

    /**
     *
     * @param nums
     * @param index     表示访问到当前火柴的位置
     * @param target    表示正方形的边长
     * @param size      长度为4的数组
     * @return
     */
    private boolean backtrack(int[] nums, int index, int target, int[] size) {
        if (index == nums.length) {
            //如果火柴都访问完了,并且size的4个边的长度都相等,说明是正方形,直接返回true,否则直接返回false
            if (size[0] == size[1] && size[1] == size[2] && size[2] == size[3]) {
                return true;
            }
            return false;
        }
        //到这一步说明火柴还没访问完
        for (int i = 0; i < size.length; i++) {
            //如果把当前火柴放到size[i]这个边上,他的长度大于target,我们直接跳过
            if (size[i] + nums[index] > target) {
                continue;
            }
            //如果当前火柴放到size[i]这个边上,长度不大于target,我们就放上面
            size[i] += nums[index];
            //然后在放下一个火彩,如果最终能变成正方形,直接返回true
            if (backtrack(nums, index + 1, target, size)) {
                return true;
            }
            //如果当前火柴放到size[i]这个边上,最终不能构成正方形,我们就把他从size[i]这个边上给移除,然后在试其他的边
            size[i] -= nums[index];
        }
        //如果不能构成正方形,直接返回false
        return false;
    }


}
