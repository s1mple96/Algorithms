package find;

import java.util.Arrays;

/**
 * @author s1mple
 * @create 2021/5/28-17:21
 */
public class FibSearch {
    public static int search(int[] arr, int value) {
        if (arr==null||arr.length==0) return -1;
        int length = arr.length;
        int k = 0;
        while (length > fibonacci(k) - 1 || fibonacci(k) - 1 < 5) {
            k++;
        }
        int[] fb = makeFbArr(fibonacci(k) - 1);
        int[] temp = Arrays.copyOf(arr, fb[k] - 1);
        for (int i = length; i < temp.length; i++) {
            temp[i] = arr[length - 1];//用原数组最后的值填充
        }
        return fibonacciSearch(temp, fb, value, 0, length - 1, k);
    }

    private static int[] makeFbArr(int length) {
        int[] arr = new int[length];
        arr[0] = 0;
        arr[1] = 1;
        for (int i = 2; i < length; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        return arr;
    }

    private static int fibonacci(int n) {
        if (n==0||n==1) return n;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    private static int fibonacciSearch(int[] arr, int[] fb, int value, int low, int hight, int k) {
        if (value<arr[low]||value>arr[hight]||low>hight) return -1;
        int mid = low + fb[k - 1] - 1;
        if (value < arr[mid]) {
            return fibonacciSearch(arr, fb, value, low, mid - 1, k - 1);
        } else if (value > arr[mid]) {
            return fibonacciSearch(arr, fb, value, mid + 1, hight, k - 2);
        } else {
            if (mid <= hight) {
                return mid;
            } else {
                return hight;
            }
        }
    }
}
