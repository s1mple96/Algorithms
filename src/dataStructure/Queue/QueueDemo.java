package dataStructure.Queue;

/**
 * @author s1mple
 * @create 2021/7/2-17:51
 */
public class QueueDemo {
    /**
     * 队列是一种特殊的线性表,他的特殊性在于我们只能操作他头部和尾部的元素,中间的元素我们操作不了,我们只能在他的头部进行删除
     * 尾部进行添加,就像大家排队到银行取钱一样,先来的肯定要排到前面,后来的只能排到队尾,所有 元素都要遵守这个操作,没有VIP会员,
     * 所以走后门插队的现象是不能存在的,他是一种“先进先出”的数据结构,
     */

    /**
     * 队列的实现方式一般有两种，一种是基于数组的，还有一种是基于链表的，如果基于链表的倒还好说，
     * 因为链表的长度是随时都可以变的，这个实现起来比较简单。如果是基于数组的，就会稍微有点不同，
     * 因为数组的大小在初始化的时候就已经固定了。
     */

    public class MyQueue<E> {
        private final Object[] data;
        private final int maxSize;
        private int size;
        private int front = 0;
        private int tail = 0;

        public MyQueue(int maxSize) {
            if (maxSize <= 0) {
                try {
                    throw new IllegalAccessException("队列容量必须大于0：" + maxSize);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
            this.maxSize = maxSize;
            data = new Object[this.maxSize];
        }

        public void add(E e) {
            if (isFull()) {//这地方可以扩容也可以抛异常，为了方便这里我们就不在扩容了。
                try {
                    throw new IllegalAccessException("队列已满了，无法再加入...");
                } catch (IllegalAccessException illegalAccessException) {
                    illegalAccessException.printStackTrace();
                }
            }
            data[tail++] = e;
            size++;
        }

        public E remove() {
            if (isEmpty()) {
                throw new IllegalStateException("队列是空的，无法移除...");
            }
            E t = (E) data[front];
            data[front++] = null;
            size--;
            return t;
        }

        //队列头和队列尾指向同一空间的时候，并且没到队尾，表示队列是空的
        private boolean isEmpty() {
            return front == tail && isFull();
        }

        public boolean isFull() {//最后一个位置是不存储数据的
            return tail == maxSize - 1;
        }

        public int getSize() {
            return size;
        }
    }

}
