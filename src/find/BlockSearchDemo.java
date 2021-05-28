package find;

/**
 * @author s1mple
 * @create 2021/5/28-17:31
 */
public class BlockSearchDemo {
    public static void main(String[] args) {
        int index[] = {22, 48, 86};
    }

    public static int blocksearch(int[] index, int[] arr, int key, int m) {
        int i = search(index, key);
        if (i<0)
            return -1;
        for (int j = m * i, length = j + m; j < length; j++) {
            if (arr[j] == key) {
                return j;
            }
        }
        return -1;
    }

    private static int search(int[] index, int key) {
        int start = 0;
        int end = index.length - 1;
        if (key>index[end])
            return -1;
        while (start <= end) {
            int mid = start + ((end - start) >> 1);
            if (index[mid] >= key) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }
}
