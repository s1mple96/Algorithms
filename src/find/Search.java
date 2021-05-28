package find;

/**
 * @author s1mple
 * @create 2021/5/28-13:28
 */
public class Search {
    /**
     * 查找算法中顺序查找
     * @param a
     * @param key
     * @return
     */
    public static int search1(int[] a, int key) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == key) {
                return i;
            }
        }
        return -1;
    }

    public static int search2(int[] a, int key) {
        int index = a.length - 1;
        if (key == a.length - 1) {
            return index;
        }
        a[index] = key;
        int i = 0;
        while (a[i++] != key);
        return i == index + 1 ? -1 : i - 1;
    }
}
