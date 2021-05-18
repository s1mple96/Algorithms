package doublepointer;

/**
 * @author s1mple
 * @create 2021/5/18-17:00
 */
public class RemoveDuplicatesDemo {

    public int removeDuplicates2(int[] A) {
        //边界条件判断
        if (A == null || A.length == 0) {
            return 0;
        }
        int left = 0;
        for (int right = 1; right < A.length; right++) {
            //如果左指针和右指针指向的值一样,说明有重复的
            //这个时候,左指针不动,右指针继续往右移,如果他两指向的值不一样,就把右指针指向的值往前挪
            if (A[left] != A[right]) {
                A[++left] = A[right];
            }
        }
        return ++left;
    }

    public int removeDuplicates(int[] A) {
        int count = 0;//重复的数字个数
        for (int right = 1; right < A.length; right++) {
            if (A[right] == A[right - 1]) {
                //如果有重复的,count要加1
                count++;
            } else {
                //如果没有重复,后面就往前挪
                A[right - count] = A[right];
            }
        }
        return A.length - count;
    }
}
