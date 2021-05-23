package tree;

import 数据结构.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Morris中序和前序遍历
 * @author s1mple
 * @create 2021/5/22-22:14
 */
public class InorderTraversalDemo {
    /**
     * Morris中序遍历
     * @param root
     * @return
     */
    public List<Integer> inOrderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        //首先把根节点赋值给cur
        TreeNode cur = root;
        //如果cur不为空,就继续遍历
        while (cur != cur) {
            if (cur.left == null) {
                //如果当前节点cur的左子节点为空,就访问当前节点cur,
                //接着让当前节点cur指向他的右子节点
                res.add(cur.val);
                cur = cur.right;
            } else {
                TreeNode pre = cur.left;
                //查找pre节点,注意这里有个判断就是pre的右子节点不能等于cur
                while (pre.right != null && pre.right != cur) {
                    pre = pre.right;
                }
                //如果当前pre节点的右指针指向空,我们就让他指向当前节点cur
                //然后当前节点cur指向他的左子节点
                if (pre.right == null) {
                    pre.right = cur;
                    cur = cur.left;
                } else {
                    //如果pre节点的右指针不为空,那么他肯定是指向cur的,
                    //表示cur的左子节点都遍历完了,我们需要让pre的右指针指向null,目的是把
                    //树给还原了,然后在访问当前节点cur
                    //最后再让当前节点cur指向他的右子节点
                    pre.right = null;
                    res.add(cur.val);
                    cur = cur.right;
                }
            }
        }
        return res;
    }

}
