package sort;

/**
 * @author s1mple
 * @create 2021/5/28-18:45
 */
public class BubbleSortDemo {
    /**
     * 首先拿到第一个元素和后面的所有元素一个个比较,如果比后面的大就交换,所以始终会保证
     * 第一个元素是最小的,然后再从第二个第三个,以此类推.
     * @param arr
     */
    public static void bubbleSort(int[] arr) {
        int length = arr.length;
        for (int i = 0; i < length - 1; i++) {
            for (int j = i + 1; j < length; j++) {
                if (arr[j] < arr[i]) {
                    swap(arr, i, j);
                }
            }
        }
    }

    /**
     * 每次循环的时候j都是从0开始的,并且是相邻两个元素的比较,所以第一轮比完之后
     * 会吧最大的值放到数组的最后,第二轮的时候会把第二大的值放到数组的倒数第二
     * @param arr
     */
    public static void bubbleSort2(int[] arr) {
        boolean flag = true;
        int count = arr.length - 1;
        while (flag) {
            flag = false;
            for (int i = 0; i < count; i++) {
                if (arr[i] > arr[i + 1]) {
                    swap(arr, i, i + 1);
                    flag = true;
                }
            }
            count--;
        }
    }

    public static void bubbleSort3(int[] arr) {
        int location;
        int count = arr.length - 1;//初始化最后交换位置为最后一个元素
        for (int i = 0; i < arr.length - 1; i++) {
            location = count;
            for (int j = 0; j < location; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                    count = j;//记录无序位置的结束,有序从j+1位置开始
                }
            }
            if (count == location) {
                break;//没有次序交换,排序完成
            }
        }
    }

    public static void bubbleSort4(int[] arr, int n) {
        if (n == 1) {
            return;
        }
        if (arr == null || arr.length == 0) {
            return;
        }
        //逐渐减少n,每次都是把最大的放在最后面,知道n为1
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                swap(arr, i, i + 1);
            }
        }
        bubbleSort4(arr, n - 1);
    }

    private static void swap(int[] arr, int i, int j) {
        if (i != j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
}
