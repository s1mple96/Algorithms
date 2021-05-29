package sort;

/**
 * @author s1mple
 * @create 2021/5/29-11:26
 */
public class SelectSortDemo {
    private static void selectSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int index = 1;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[index] > arr[j]) {
                    index = j;
                }
            }
            if (i != index) {
                swap(arr, i, index);
            }
        }
    }

    private static void selectSort(int arr[], int index) {
        if (index == arr.length) {
            return;
        }
        int min = index, i = index + 1;
        for (; i < arr.length; i++) {
            if (arr[i] < arr[min]) min = i;
        }
        if (min != index) {
            swap(arr, index, min);
        }
        selectSort(arr, ++index);
    }

    private static void swap(int[] arr, int i, int j) {
        if (i != j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
}