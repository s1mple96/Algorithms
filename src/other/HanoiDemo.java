package other;

import java.util.Stack;

/**
 * @author s1mple
 * @create 2021/6/1-18:36
 */
public class HanoiDemo {
    /**
     * 把n个圆盘成功的从A移到C
     * @param n
     * @param A
     * @param B
     * @param C
     */
    public static void hanoi(int n, char A, char B, char C) {
        if (n == 1) {
            //如果只有一个,直接从A移动到C即可
            System.out.println("从" + A + "移动到" + C);
        } else {
            //表示先把n-1个圆盘成功从A移动到B
            hanoi(n - 1, A, C, B);
            //把第n个圆盘从A移动到C
            System.out.println("从" + A + "移动到" + C);
            //表示把n-1个圆盘在成功从B移动到C
            hanoi(n - 1, B, A, C);
        }
    }

    //我们还可以把每个柱子看作是一个栈，大的在下面，小的在上面，所以我们也可以使用栈来实现
    public static void move(Stack stackA, Stack stackB, Stack stackC, int n) {
        if (n == 1) {
            stackC.push(stackA.pop());
        } else {
            move(stackA, stackC, stackB, n - 1);
            stackC.push(stackA.pop());
            move(stackB, stackA, stackC, n - 1);
        }
    }

    //如果想统计总共移了多少次,可以使用公式(2^n)-1
    public static long hanoiCount(int n) {
        return (2 ^ n) - 1;
    }
}
