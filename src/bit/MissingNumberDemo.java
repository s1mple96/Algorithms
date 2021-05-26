package bit;

/**
 * @author s1mple
 * @create 2021/5/26-16:15
 */
public class MissingNumberDemo {
    /**
     * a^a=0；自己和自己异或等于0
     * a^0=a；任何数字和0异或还等于他自己
     * a^b^c=a^c^b；异或运算具有交换律
     * @param nums
     * @return
     */
    public int missingNumber(int[] nums) {
        int xor = 0;
        for (int i = 0; i < nums.length; i++) {
            xor ^= nums[i] ^ i;
        }
        return xor ^ nums.length;
    }
}
