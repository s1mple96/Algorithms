package find;

/**
 * @author s1mple
 * @create 2021/5/28-16:07
 */
public class BinarySearch {


    /*public static int binarySearch(int[] array, int value) {
        int low = 0;
        int hight = array.length - 1;
        while (low <= hight) {
//            int middle = (low + hight) / 2;当数组较大的时候,low+hight可能会溢出
            int middle = (low + hight) >> 1;
            if (value == array[middle]) {
                return middle;
            }
            if (value > array[middle]) {
                low = middle + 1;
            } else {
                hight = middle - 1;
            }
        }
        return -1;
    }*/

    public static int binarySearch(int[] array, int value) {
        int low = 0;
        int hight = array.length - 1;
        return searchmy(array, low, hight, value);
    }

    private static int searchmy(int[] array, int low, int hight, int value) {
        if (low > hight) {
            return -1;
        }
        int mid = (low + hight) / 2;
        if (value == array[mid]) {
            return mid;
        }
        if (value < array[mid]) {
            return searchmy(array, low, mid - 1, value);
        }
        return searchmy(array, mid + 1, hight, value);
    }
}
