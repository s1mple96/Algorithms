package greedy;

import java.util.Arrays;

/**
 * @author s1mple
 * @create 2021/6/4-16:40
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
