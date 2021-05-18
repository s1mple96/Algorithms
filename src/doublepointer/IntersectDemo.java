package doublepointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author s1mple
 * @create 2021/5/18-18:08
 */
public class IntersectDemo {

    public int[] intersect(int[] nums1, int[] nums2) {
        //先对两个数组进行排序
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0;
        int j = 0;
        List<Integer> list = new ArrayList<>();
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                //如果i指向的值小于j指向的值,说明i指向的值小了,i往后移动一步
                i++;
            } else if (nums1[i] > nums2[j]) {
                //如果i指向的值大于j指向的值,说明j指向的值小了,j往后移动一步
                j++;
            } else {
                //如果i和j指向的值相等,说明这两个值是重复的.
                list.add(nums1[i]);
                i++;
                j++;
            }
        }
        //把list转换为数组
        int index = 0;
        int[] res = new int[list.size()];
        for (int k = 0; k < list.size(); k++) {
            res[index++] = list.get(k);
        }
        return res;
    }
}
