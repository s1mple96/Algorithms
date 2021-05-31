package sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author s1mple
 * @create 2021/5/31-11:50
 */
public class BucketSortDemo {
    public static void bucketSort(int[] arr, int bucketSize) {
        int arrLength = arr.length;
        int max = arr[0];
        int min = arr[0];
        for (int i = 0; i < arrLength; i++) {
            if (arr[i] > max) {
                max = arr[i];
            } else if (arr[i] < min) {
                min = arr[i];
            }
        }
        //bucketSize表示每个桶存放数据的大小,bucketSort总共桶的数量
        int bucketCount = (max - min) / bucketSize + 1;
        List<List<Integer>> buckets = new ArrayList<>(bucketCount);
        for (int i = 0; i < bucketCount; i++) {
            buckets.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < arrLength; i++) {
            //根据value的大小存放到不同的桶里,最终的寄过是小的出现在前面的桶里,
            //大的出现在后面的桶里,中奖的也就在中中间的桶里了,然后再对每个桶分别进行排序
            buckets.get((arr[i] - min) / bucketSize).add(arr[i]);
        }
        int currentIndex = 0;
        for (int i = 0; i < buckets.size(); i++) {
            //取出每个桶的数据
            Integer[] bucketArray = new Integer[buckets.get(i).size()];
            bucketArray = buckets.get(i).toArray(bucketArray);
            //每个桶进行排序,这里面可以选择其他排序算法进行排序
            Arrays.sort(bucketArray);
            for (int j = 0; j < bucketArray.length; j++) {
                arr[currentIndex++] = bucketArray[j];
            }
        }
    }
}
