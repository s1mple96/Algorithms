package find;

/**
 * @author s1mple
 * @create 2021/5/28-17:31
 */
public class BlockSearchDemo {
    public static void main(String[] args) {
        int[] index = {22, 48, 86};
        int[] st2 = {22, 12, 13, 8, 9, 20, 33, 42, 38, 24, 48, 60, 58, 74, 49, 86, 53};
        for (int i = 0; i < 100; i++) {
            System.out.println(blocksearch(index, st2, i, 6));
        }
    }

    /**
     *
     * @param index 每个元素代表的是每块的最大值
     * @param arr   代表的是要查找的数组
     * @param key   代表要查找的元素,m代表每个块大小
     * @param m
     * @return
     */
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
