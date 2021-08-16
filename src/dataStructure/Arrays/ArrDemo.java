package dataStructure.Arrays;

/**
 * @author s1mple
 * @create 2021/7/2-16:20
 */
public class ArrDemo {

    /**
     * 数组是具有相同类型的数据的集合,也就是说数组的所有元素的类型都是相同的,在所有的数据结构中
     * 数组算是最常见也是最简单一种数据结构,我们最常见的也就是一维数组,还有二维三维
     * 数组需要先声明才能使用,数组的大小一旦确定就不可以改变了.
     */
    int[] arr = new int[]{1, 2, 3};
    /**
     * 操作数组的类,我们常见的估计也就是ArrayList了,他对数组的操作非常简单,所有的数据都会存放到这个数组中
     */
    transient Object[] elementData;

    /**
     * 我们来看一下他常见的几个方法,首先就是get方法
     */
    /*public E get(int index){
        if (index >= size) {
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
        }

        E oldValue = (E) elementData[index];
        elementData[index] = element;
        return oldValue;
    }*/

}
