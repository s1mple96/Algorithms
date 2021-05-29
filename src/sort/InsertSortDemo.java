package sort;

import java.util.Arrays;

/**
 * @author s1mple
 * @create 2021/5/29-12:30
 */
public class InsertSortDemo {

    private static int[] insertSort(int[] sourceArray) {

        //对arr进行拷贝,不改变参数内容
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);

        //从下标为1的元素开始选择合适的位置插入,因为下标0的只有一个元素,默认是有序的.
        for (int i = 1; i < arr.length; i++) {
            //记录要插入的数据
            int temp = arr[i];
            //从已经排序的序列最右边开始比较,找到比其小的数
            int j = i;
            while (j > 0 && temp < arr[j - 1]) {
                arr[j] = arr[j - 1];
                j--;
            }
            //存在比其小的数,插入
            if (j != i) {
                arr[j] = temp;
            }
        }
        return arr;

    }
}
