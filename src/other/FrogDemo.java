package other;

import java.util.HashMap;

/**
 * @author s1mple
 * @create 2021/6/1-18:07
 */
public class FrogDemo {
    /**
     * 一只青蛙一次可以跳上一级台阶，也可以跳上二级台阶，求该青蛙跳上一个n级的台阶总共需要多 少种跳法。
     * @param n
     * @return
     */
    public static int frog(int n) {
        if (n <3)
            return n;
        return frog(n - 1) + frog(n - 2);
    }
    public static int frog2(int n, HashMap<Integer,Integer> map) {
        if (n<3) return n;
        if (map.containsKey(n))
            return map.get(n);
        int first = frog2(n - 1, map);
        int second = frog2(n - 2, map);
        int sum = first + second;
        map.put(n, sum);
        return sum;
    }
    public static int frog3(int n) {
        if (n<3)
            return n;
        int first = 1, sencond = 2, sum = 0;
        while (n-- > 2) {
            //fn = f(n-1) + f(n-2)
            sum = first + sencond;
            first = sencond;
            sencond = sum;
        }
        return sum;
    }

    /**
     * 一只青蛙一次可以跳上一级台阶，也可以跳上二级台阶……，也可以跳n级，求该青蛙跳上一个n级 的台阶总共需要多少种跳法。
     * @param n
     * @return
     */
    public static int f4(int n) {
        if (n==1)
            return 1;
        return f4(n - 1) * 2;
    }

    public static int f5(int n) {
        if (n ==1)
            return 1;
        return 1 << (n - 1);
    }

    /**
     * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上m级。求该青蛙跳上一个n级的 台阶总共有多少种跳法
     * @param n
     * @param m
     * @return
     */
    public static int f6(int n, int m) {
        if (n<=1)
            return 1;
        //总台阶大于跳的最高级台阶
        if (n>m)
            return 2 * f6(n - 1, m) - f6(n - 1 - m, m);
        //回退到上面的问题二了
        return 2 * f6(n - 1, n);
    }
}
