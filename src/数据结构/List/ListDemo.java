package 数据结构.List;

import java.util.Date;

/**
 * @author s1mple
 * @create 2021/7/2-17:10
 */
public class ListDemo {
    /**
     * 链表是一种物理存储单元上非连续的一种数据结构,看名字我们就知道他是一种链式的结构,就像一群人手牵手一样,链表有单向的,双向的,还有环形的.
     */

    /**
     * 单向链表
     */
    class Node<E> {
        E data;
        Node<E> next;

        Node(E data, Node<E> next) {
            this.data = data;
            this.next = next;
        }
    }
    /**
     * 单向链表的增删
     *  链表不像数组那样,可以通过索引来获取,单向链表查找的时候必须从头开始往后一个个找,
     *  而不能从中间找,也不能从后往前找,
     */
    /**
     * 1.添加到尾结点比较简单,我们只需要找之前的链表,然后让他的next指向新的节点即可.
     */
    /**
     * 2.添加到中间节点,添加到中间节点,分为两步,,比如我们要在ab节点之间添加新节点n,第一步让新节点n的指针指向b.然后再让a的指针指向节点n即可
     */
    /**
     * 3.删除链表的尾结点,只需要让尾结点的上一个节点的指针指向null即可.
     */
    /**
     * 4.删除链表的中间节点,只需要把要删除节点的前一个节点的指针指向要删除节点的下一个节点即可,最好还要把要删除节点的数据清空,并且让他的指针指向null
     */

    /**
     * 双向链表:
     *  双向链表不光有指向下一个节点的指针,而且还有指向上一个节点的指针,他比单向链表多一个指向前
     *  一个节点的指针,单向链表我们只能从前往后找,而双向链表我们不光可以从前往后找,而且还可以从后往前找.
     */
    class Node<E> {
        E data;
        Node<E> next;
        Node<E> prev;

        public Node(Node<E> next, E data, Node<E> prev) {
            this.data = data;
            this.next = next;
            this.prev = prev;
        }
    }

}
