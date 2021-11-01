package dataStructure.stack;

/**
 * @author s1mple
 * @create 2021/11/1-17:43
 */
public class StackDemo {
    private Object[] data;
    private int size;

    public StackDemo(int capacity) {
        if (capacity <= 0) {
            throw new IllegalStateException("栈的大小必须大于0");
        }
        data = new Object[capacity];
    }

    public void push(Object item) {
        if (isFull()) {
            throw new IllegalStateException("栈已经满了");
        }
        data[size++] = item;
    }

    public E pop() {
        if (isEmpty()) {
            throw new IllegalStateException("栈是空的");
        }
        E temp = (E) data[--size];
        data[size] = null;
        return temp;
    }

    public E peek() {
        if (isEmpty()) {
            throw new IllegalStateException("栈是空的");
        }
        return (E) data[size - 1];
    }

    public boolean isEmpty() {
        return size() == 0;
    }
    public boolean isFull() {
        return size() == data.length;
    }
    public int size() {
        return size;
    }

    private class E {
    }

    /**
     * 这里为了方便，栈的空间大小在初始化的时候就就已经固定了，
     * 并且栈满的时候没有扩容，栈是一 个非常有用的数据结构，
     * 尤其在算法中用到的还是比较多的。栈是一种先进后出的数据结构，
     * 他和 队列正好相反，队列是一种先进先出的数据结构
     */
}
