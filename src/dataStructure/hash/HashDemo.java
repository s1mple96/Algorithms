package dataStructure.hash;

/**
 * @author s1mple
 * @create 2021/11/1-17:51
 */
public class HashDemo {
    /**
     * 散列表也叫哈希表，是根据键值对（key，value）进行访问的一种数据结构。他是把一对（key，
     * value）通过key的哈希值来映射到数组中的，也就是说，它通过把关键码值映射到表中一个位置
     * 来访问记录，以加快查找的速度。这个映射函数叫做散列函数，存放记录的数组叫做散列表。
     */

    /**
     * 散列表中最常见的应该就是HashMap了，HashMap的实现原理非常简单，他其实就是数组加链表
     * 的一种数据结构。如果映射在数组中出现了冲突，他会以链表的形式存在。我们来看一下他的数
     * 据结构是什么样的。
     */

    /**
     * ArrayMap
     * 除了使用数组和链表以外，我们能不能只使用一种数据结构呢，比如数组，当然也是可以的。
     * 大家可能会怀疑，如果只使用一种数据结构的话，映射出现了冲突怎么办，其实也很好解决。
     * ArrayMap的实现原理是使用两个数组，一个存放hash值，一个存放key和value，其中存放key和
     * value的数组长度是存放hash值数组长度的二倍，其中存放hash值的数组必须是排序的。如果
     * hash值出现了冲突，说明hash值最终的计算是一样的，那么在hash数组中肯定是挨着的，所以查
     * 找的时候如果hash值有重复的就会把重复的也查找一遍。我们来看ArrayMap中的一段代码
     */

    /**
     * SparseArray
     * 在散列表中如果可以确定key值都是int类型，那么又可以简化，直接用key值当hash值存储即可，
     * 和ArrayMap一样只需要两个数组即可，一个是存放key的，一个是存放value的，不同的是这两个
     * 数组的长度都是一样的。这种情况下就不会出现hash值一样的问题了，因为这个时候如果hash值
     * 一样的话，那么他们的key肯定是一样的，而在散列表中是不可能存在了，假如在插入数据的时候 有一样的key，
     * 那么他的value是要被替换掉的，所以不会出现两个完全一样的key。他的数据结构
     */

    /**
     * ThreadLocalMap
     * 在java语言中还有一个关于散列表的，那就是ThreadLocalMap，这个类是ThreadLocal的一个静
     * 态内部类，一般我们用不到。如果出现hash冲突的时候他的实现原理和上面的几种也都不太一 样。
     * 存储的时候他首先会根据hash值映射到指定的数组，如果当前位置为空就直接存进去，如果
     * 不为空就往后找，找他的下一个，我们来看其中的一段代码
     */

    /**
     * 总结：
     * 散列表大家第一个想到的就是HashMap，需要数组加链表的方式才能实现，通过我们上面的分析，
     * 其实我们不需要链表也能实现。散列表的实现原理其实很简单。他的核心是当我们的hash值
     * 出现冲突的时候该怎么解决。
     */

}
