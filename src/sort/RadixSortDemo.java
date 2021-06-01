package sort;

/**
 * @author s1mple
 * @create 2021/6/1-11:07
 */
public class RadixSortDemo {

    public static void radixSort(int[] array) {
        int digitCount = 10;//从0到9最多10位数
        int maxCount = getBitCount(getMaxNum(array));
        int radix = 1;
        int[][] tempArray = new int[digitCount][array.length];
        for (int i = 0; i < maxCount; i++) {
            int[] count = new int[digitCount];
            for (int j = 0; j < array.length; j++) {
                int temp = ((array[j] / radix) % 10);
                tempArray[temp][count[temp]++] = array[j];
            }
            int index = 0;
            for (int j = 0; j < digitCount; j++) {
                if (count[j] == 0) {
                    continue;
                }
                for (int k = 0; k < count[j]; k++) {
                    array[index++] = tempArray[j][k];
                }
            }
            radix *= 10;
        }
    }

    private static int getBitCount(int num) {
        int count = 1;
        int temp = num / 10;
        while (temp != 0) {
            count++;
            temp /= 10;
        }
        return count;
    }

    private static int getMaxNum(int[] array) {
        int max = array[0];
        for (int i = 1, length = array.length; i < length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }
}
