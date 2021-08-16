package tree;

import dataStructure.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * 返回不同的二叉搜索数II
 * @author s1mple
 * @create 2021/8/3-15:21
 */
public class GenerateTreesDemo {
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new LinkedList<TreeNode>();
        }
        return generateTrees(1, n);
    }

    private List<TreeNode> generateTrees(int start, int end) {
        List<TreeNode> allTrees = new LinkedList<TreeNode>();
        if (start > end) {
            allTrees.add(null);
            return allTrees;
        }

        //枚举可行根节点
        for (int i = start; i <= end; i++) {
            //获得所有可行的左子树集合
            List<TreeNode> leftTrees = generateTrees(start, i - 1);
            //获得所有可行的右子树集合
            List<TreeNode> rightTrees = generateTrees(i + 1, end);
            //从左子树集合中选出一颗左子树，从右子树集合中选出一颗右子树，拼接到根节点上
            for (TreeNode left : leftTrees) {
                for (TreeNode right : rightTrees) {
                    TreeNode currTree = new TreeNode(i);
                    currTree.left = left;
                    currTree.right = right;
                    allTrees.add(currTree);
                }
            }
        }
        return allTrees;
    }
}
