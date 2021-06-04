package greedy;

import java.util.Arrays;

/**
 * @author s1mple
 * @create 2021/6/4-17:01
 */
public class CandyDemo {
    public int candy(int[] ratings) {
        int length = ratings.length;
        //记录的是从左往右循环的结果
        int[] left = new int[length];
        //记录的是从右往左循环的结果
        int[] right = new int[length];
        //因为每个孩子至少有一个糖果,默认都给他们一个
        Arrays.fill(left, 1);
        Arrays.fill(right, 1);
        //统计最少的总共糖果数量
        int total = 0;
        /**
         * 先从左往右遍历,如果当前孩子的得分比左边的高,
         * 那么当前孩子的糖果要比左边孩子的多一个
         */
        for (int i = 1; i < length; i++) {
            if (ratings[i - 1] > ratings[i]) {
                right[i - 1] = ratings[i] + 1;
            }
        }
        /**
         * 要满足左右两边的条件,那么当前孩子的得分比右边的高,
         * 那么当前孩子的糖果要比右边孩子的多一个
         */
        for (int i = length - 1; i > 0; i--) {
            if (ratings[i - 1] > ratings[i]) {
                right[i - 1] = ratings[i] + 1;
            }
        }
        /**
         * 要满足左右两边的条件,那么当前孩子的糖果就要取
         * 从左到右和左右到左的最大值
         */
        for (int i = 0; i < length; i++) {
            //累加每个孩子的糖果
            total += Math.max(left[i], right[i]);
        }
        return total;
    }
}
