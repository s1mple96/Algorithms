package greedy;

import java.util.Arrays;

/**
 * @author s1mple
 * @create 2021/6/4-16:40
 * 总结:
 *  贪心算法只需要满足局部最优解,他只能确定某些问题的可行性范围,
 *  不能保证解是最佳的.因为贪心算法总是从局部出发,并没有从整体
 *  考虑,对于有些问题使用贪心算法是可以的,有些是不可以的.这些都要
 *  根据具体问题具体分析
 */
public class FindContentChildrenDemo {
    public int findContentChildren(int[] g, int[] s) {
        //先对胃口值和饼干尺寸进行排序
        Arrays.sort(g);
        Arrays.sort(s);
        int count = 0;
        for (int j = 0; count < g.length && j < s.length; j++) {
            if (g[count] <= s[j]) {
                count++;
            }
        }
        return count;
    }

    public int intfindContentChildren2(int[] g, int[] s) {
        //先对胃口值和饼干尺寸进行排序
        Arrays.sort(g);
        Arrays.sort(s);
        int count = 0;
        int i = s.length - 1;
        for (int j = s.length - 1; j >= 0 && i >= 0; j--) {
            if (g[j] <= s[i]) {
                count++;
                i--;
            }
        }
        return count;
    }
}
