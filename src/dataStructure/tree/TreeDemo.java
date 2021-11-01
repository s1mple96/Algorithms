package dataStructure.tree;

/**
 * @author s1mple
 * @create 2021/11/1-19:00
 */
public class TreeDemo {
    /**
     * 树 是 一 个 有 n 个 有 限 节 点 组 成 一 个 具 有 层 次 关 系 的 集 合 ，
     * 每 个 节 点 有 0 个 或 者 多 个 子 节 点，没有父节点的节点称为根节点，
     * 也就是说除了根节点以外每个节点都有父节点，并 且有且只有一个。
     * 树的种类比较多，有二叉树，红黑树，AVL树，B树，哈夫曼树，字典树等等。
     * 甚至堆我们也可以把它看成是一棵树，树的这么多种类中，我们最常见的应该是二叉树 了.
     */
    public class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;
        public TreeNode(int x) {
            val = x;
        }
        public TreeNode() {
        }
        @Override
        public String toString() {
            return "[" + val + "]";
        }
    }

    public static void preOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.println(node.val + "");
        preOrder(node.left);
        preOrder(node.right);
    }
}
