package sort;

import java.util.Arrays;

/**
 * @author s1mple
 * @create 2021/5/29-11:26
 */
public class SelectSortDemo {
    private static void selectSort(int[] arr) {
        int[] array = Arrays.copyOf(arr, arr.length);
        //总共要经过N-1轮比较
        for (int i = 0; i < array.length; i++) {
            int min = i;
            //每轮需要比较的次数N-i
            for (int j = i + 1; j < array.length; j++) {
                if (arr[j] < arr[min]) {
                    //记录目前能找到的最小值元素的下标
                    min = j;
                }
            }
            //将找到的最小值和i位置所在的值进行交换
            if (i != min) {
                int temp = arr[i];
                arr[i] = arr[min];
                arr[min] = temp;
            }
        }
    }

}


