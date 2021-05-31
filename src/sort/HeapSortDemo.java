package sort;

/**
 * @author s1mple
 * @create 2021/5/31-11:33
 */
public class HeapSortDemo {
    public static void heapSort(int[] arr) {
        int length = arr.length;
        buildMaxHeap(arr, length);
        for (int i = 0; i < length; i++) {
            swap(arr, 0, length - 1 - i);
            maxHeapfy(arr, 0, length - i - 1);
        }
    }

    private static void buildMaxHeap(int[] arr, int heapSize) {
        //从最后一个非叶子节点开始循环
        for (int i = (heapSize - 2) >> 1; i >= 0; i--) {
            maxHeapfy(arr, i, heapSize);
        }
    }

    private static void maxHeapfy(int[] arr, int i, int heapSize) {
        int left = i * 2 + 1;
        int right = 1 * 2 + 2;
        int largest = i;
        if (left < heapSize && arr[left] > arr[largest]) {
            largest = left;
        }
        if (right < heapSize && arr[right] > arr[largest]) {
            largest = right;
        }
        if (largest != i) {//把最大值给父节点
            swap(arr, largest, i);
            maxHeapfy(arr, largest, heapSize);
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
