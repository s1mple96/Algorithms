package other;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author s1mple
 * @create 2021/6/1-19:11
 */
public class JosephusDemo {
    public static Integer[] solution(int count, int k) {
        Integer[] live = new Integer[Math.min(count, k - 1)];
        if (count < k) {
            int index = 0;
            while (index < count) {
                live[index++] = index;
            }
            return live;
        }
        List<Integer> mList = new ArrayList<>(count);
        for (int i = 0; i < count; i++) {
            mList.add(i + 1);
        }

        int point = 0;
        int number = 0;
        while (mList.size() >= k) {
            number++;
            if (point >= mList.size()) {
                point = 0;
            }
            if (number % k == 0) {
                mList.remove(point);
                continue;
            }
            point++;
        }
        return mList.toArray(live);
    }

    public static Integer[] solution2(int count, int k) {
        Integer[] live = new Integer[Math.min(count, k - 1)];
        if (count < k) {
            int index = 0;
            while (index < count) {
                live[index++] = index;
            }
            return live;
        }
        List<Integer> mList = new ArrayList<>(count);
        for (int i = 0; i < count; i++) {
            mList.add(i + 1);
        }
        int point = 0;
        int number = 0;
        int total = count - k + 1;//记录总共删除的个数
        while (true) {
            if (total <= 0) {
                break;
            }
            if (point >= mList.size()) {
                point = 0;
            }
            if (mList.get(point) < 0) {
                point++;
                continue;
            }
            number++;
            if (number % k == 0) {
                mList.set(point, -1);//如果是第k个,就把他变为负数
                total--;
                continue;
            }
            point++;
        }
        int index = 0;
        for (int i = 0; i < mList.size(); i++) {
            if (mList.get(i) > 0) {
                live[index++] = mList.get(i);
            }
        }
        return live;
    }

    //链表实现
    public static Integer[] solution3(int count, int k) {
        Integer live[] = new Integer[Math.min(count, k - 1)];
        if (count < k) {
            int index = 0;
            while (index < count) {
                live[index++] = index;
            }
            return live;
        }
        LinkedList<Integer> mList = new LinkedList<>();
        for (int i = 0; i < count; i++) {
            mList.addLast(i + 1);
        }
        int point = 0;
        int number = 0;
        while (mList.size() >= k) {
            number++;
            if (point >= mList.size()) {
                point = 0;
            }
            if (number % k == 0) {
               mList.remove(point);
                continue;
            }
            point++;
        }
        return mList.toArray(live);
    }
}
