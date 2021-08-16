package tree;

import dataStructure.TreeNode;

/**
 * B是A的子结构不一定是从根节点开始判断B是否是A的子结构，
 * 也有可能B是A左子树或 右子树的子结构，
 * 所以如果从根节点判断B不是A的子结构的时候还要分别判断A的子树 中是否包含B
 * @author s1mple
 * @create 2021/5/24-6:09
 */
public class IsSubStructureDemo {

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        //边界条件判断,如果A和B有一个为空,返回false
        if (A == null || B == null) {
            return false;
        }
        /**
         * 还需要判断A的子树中是否包含B
         */
        return isSub(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    private boolean isSub(TreeNode A, TreeNode B) {
        //这里如果B为空,说明B已经访问完了.确定是A的子结构
        if (B == null) {
            return true;
        }
        //如果B不为空A为空,或者两个节点值不相同,说明B树不是A的子结构,直接返回false
        if (A == null || A.val != B.val) {
            return false;
        }
        //当前节点比较完之后还需要继续判断左右子节点
        return isSub(A.left, B.left) && isSub(A.right, B.right);
    }
}
