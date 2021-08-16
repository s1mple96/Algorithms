package tree;

import dataStructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 这题首先要搞懂的是:二叉搜索树的中序遍历结果是排序的
 * @author s1mple
 * @create 2021/5/22-21:37
 */
public class FindModeDemo {
    public int[] findMode(TreeNode root) {
        inOrderTraversal(root);
        int[] res = new int[mList.size()];
        //把集合list转换为数组
        for (int i = 0; i < mList.size(); i++) {
            res[i] = mList.get(i);
        }
        return res;
    }

    List<Integer> mList = new ArrayList<>();
    int current = 0;    //表示当前节点的值
    int count = 0;      //当前节点值相同的节点数量
    int maxCount = 0;   //最大的重复数量

    //递归方式
    public void inOrderTraversal(TreeNode node) {
        //条件终止判断
        if (node == null) {
            return;
        }
        //遍历左子树
        inOrderTraversal(node.left);
        //下面是对当前节点的一些逻辑操作
        int nodeValue = node.val;
        if (nodeValue == current) {
            //如果当前节点值等于current,count就+1
            count++;
        } else {
            //否则,就表示遇到了一个新的值,current和count都要
            //重新赋值
            current = nodeValue;
            count = 1;
        }
        if (count == maxCount) {
            //如果count==maxCount,就把当前节点加入到集合中
            mList.add(nodeValue);
        } else if (count > maxCount) {
            //否则,当前节点的值重复量是最多的,直接list清空,然后
            //把当前节点的值加入到集合中
            mList.clear();
            mList.add(nodeValue);
            maxCount = count;
        }
        //遍历右子树
        inOrderTraversal(node.right);
    }
}
