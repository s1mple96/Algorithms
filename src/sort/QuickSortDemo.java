package sort;

/**
 * @author s1mple
 * @create 2021/5/31-11:19
 */
public class QuickSortDemo {
    public static void quickSort(int[] arr, int start, int end) {
        if (start < end) {
            int key = arr[start];//用待排数组的第一个作为中枢
            int i = start;
            for (int j = start + 1; j <= end; j++) {
                if (key > arr[i]) {
                    swap(arr, j, ++i);
                }
            }
            arr[start] = arr[i];//先挪,然后再把中枢放到指定位置
        }
    }

    private static void swap(int[] arr, int i, int j) {
        if (i != j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
}
