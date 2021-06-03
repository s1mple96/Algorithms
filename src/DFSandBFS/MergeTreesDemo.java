package DFSandBFS;

import 数据结构.TreeNode;

/**
 * @author s1mple
 * @create 2021/6/3-22:40
 */
public class MergeTreesDemo {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        //如果两个节点都为空,直接返回空就行了
        if (t1 == null && t2 == null) {
            return null;
        }
        //如果t1节点为空,就返回t2节点
        if (t1 == null) {
            return t2;
        }
        //如果t2节点为空,就返回t1节点
        if (t2 == null) {
            return t1;
        }
        //走到这一步,说明这两个节点都不为空,然后需要把这两个节点合并成一个新的节点
        TreeNode newNode = new TreeNode(t1.val + t2.val);
        //当前节点t1和t2合并完成后,还要继续合并t1和t2的子节点
        newNode.left = mergeTrees(t1.left, t2.left);
        newNode.right = mergeTrees(t1.right, t2.right);
        return newNode;
    }
}
