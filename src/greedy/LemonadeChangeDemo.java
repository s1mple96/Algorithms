package greedy;

/**
 * @author s1mple
 * @create 2021/6/4-16:12
 */
public class LemonadeChangeDemo {
    public boolean lemonadeChange(int[] bills) {
        /**
         * 统计店员所拥有的5元和10元的数量(20元的不需要统计
         * 因为顾客只能使用5元,10元和20元,而20元是没法给顾
         * 客找零的
         */
        int five = 0, ten = 0;
        for (int bill : bills) {
            if (bill == 5) {
                //如果顾客使用的是5元,不用找零,5元数量加1
                five++;
            } else if (bill == 10) {
                //如果顾客使用的是10元,需要找他5元,所以
                //5元数量减1,10元数量加1
                five--;
                ten++;
            } else if (ten > 0) {
                //否则顾客使用的只能是20元,顾客使用20元的时候
                //如果我们有10元的,要尽量给他找10元的,然后再给他5元的,所以这里
                //5元和10元都要减1
                ten--;
                five--;
            } else {
                //如果顾客使用的是20元,而店员没有10元的,
                //就只能给他找3个5元的,所以5元的数量要减3
                five -= 3;
            }
            //上面我们找零的时候并没有判断5元的数量,如果5元的
            //数量小于0,说明上面某一步找零的时候5元不够用了.
            //也就是说没法给顾客找零,直接返回false即可
            if (five < 0) {
                return false;
            }
        }
        return true;
    }
}
