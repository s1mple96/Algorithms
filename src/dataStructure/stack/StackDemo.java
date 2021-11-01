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
}
