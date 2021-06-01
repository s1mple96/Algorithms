package sort;

/**
 * @author s1mple
 * @create 2021/6/1-11:15
 */
public class BucketSort1Demo {
    public static void bucketSort(int[] array) {
        int arrayLength = array.length;
        int max = array[0];
        int min = array[0];
        for (int i = 0; i < arrayLength; i++) {
            if (array[i] > max) {
                max = array[i];
            } else if (array[i] < min) {
                min = array[i];
            }
        }
        int bucketLength = max - min + 1;//桶的数量
        int[] temp = new int[arrayLength];
        int[] buckets = new int[bucketLength];//桶
        for (int i = 0; i < arrayLength; i++) {
            buckets[array[i] - min]++;//落在某个桶里就加1
        }
        //从小到大排序
        for (int i = 1; i < bucketLength; i++) {
            //后面桶对
        }
    }
}
