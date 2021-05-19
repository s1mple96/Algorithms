package doublepointer;

/**
 * @author s1mple
 * @create 2021/5/19-16:23
 */
public class GetMaxArea {
    public int maxArea(int[] height) {
        int maxarea = 0, left = 0, right = height.length - 1;
        int area = 0;
        while (left < right) {
            //计算面积,面积等于宽*高,宽就是left和right直接的距离,高就是left和right所对应的最低高度
            area = Math.min(height[left], height[right]) * (right - left);
            //保存计算过的最大的面积
            maxarea = Math.max(maxarea, area);
            //柱子矮的往中间靠
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxarea;
    }
}
