package lcof_32_2;

import common.TreeNode;

import java.util.*;

/**
 * @author: gefeng
 * @created: 2021/05/15 21:06
 */
public class offer32_2 {
    public static void main(String[] args) {
        TreeNode A = new TreeNode(4);
        A.left = new TreeNode(4);
        A.left.left = new TreeNode(1);
        A.right = new TreeNode(5);
        A.right.right = new TreeNode(2);

        Solution solution = new Solution();
        List<List<Integer>> lists = solution.levelOrder(A);
        for (int i = 0; i < lists.size(); i++) {
            for (int j = 0; j < lists.get(i).size(); j++) {
                System.out.println(lists.get(i).get(j));
            }
        }
    }
}

/**
 * 从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。
 *
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 *
 *      3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 返回其层次遍历结果：
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        Deque<TreeNode> nodeDeque = new ArrayDeque<>();
        if (root != null) {
            nodeDeque.add(root);
        }
        while (!nodeDeque.isEmpty()) {
            List<Integer> currentLevelList = new ArrayList<>();
            int currentLevelNodeNum = nodeDeque.size();
            while (currentLevelNodeNum > 0) {
                TreeNode pop = nodeDeque.pop();
                currentLevelNodeNum--;
                currentLevelList.add(pop.val);
                if (pop.left != null) {
                    nodeDeque.add(pop.left);
                }
                if (pop.right != null) {
                    nodeDeque.add(pop.right);
                }
            }
            ans.add(currentLevelList);
        }
        return ans;
    }
}
