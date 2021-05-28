package find;

/**
 * @author s1mple
 * @create 2021/5/28-16:45
 */
public class InsertSearch {
    public static int insertSearch(int[] array, int key) {
        return search(array, key, 0, array.length - 1);
    }

    private static int search(int[] array, int key, int left, int right) {
        while (left <= right) {
            if (array[right] == array[left]) {
                if (array[right]==key)
                    return right;
                else return -1;
            }
            //left+差值
            int mid = left + ((key - array[left]) / (array[right] - array[left])) * (right - left);
            if (array[mid] == key) {
                return mid;
            }
            if (key < array[mid]) {
                right = mid - 1;
            } else {
                left = mid +1;
            }
        }
        return -1;
    }
}
