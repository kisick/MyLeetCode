package lcof_32;

import common.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author: gefeng
 * @created: 2021/05/15 12:27
 */
public class offer32 {
    public static void main(String[] args) {
        TreeNode A = new TreeNode(4);
        A.left = new TreeNode(4);
        A.left.left = new TreeNode(1);
        A.right = new TreeNode(5);
        A.right.right = new TreeNode(2);

        Solution solution = new Solution();
        int[] ans = solution.levelOrder(A);
        for (int i = 0; i < ans.length; i++) {
            System.out.println(ans[i]);
        }
    }
}

/**
 * 从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
 *
 * 层次遍历二叉树
 *
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7]
 *
 *      3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 */
class Solution {

    public int[] levelOrder(TreeNode root) {
        if (root == null) {
            return new int[0];
        }
        Deque<TreeNode> nodeQueue = new ArrayDeque<>();
        List<Integer> resList = new ArrayList<>();
        nodeQueue.add(root);
        while (!nodeQueue.isEmpty()) {
            TreeNode pop = nodeQueue.pop();
            resList.add(pop.val);
            if (pop.left != null) {
                nodeQueue.add(pop.left);
            }
            if (pop.right != null) {
                nodeQueue.add(pop.right);
            }
        }
        return resList.stream().mapToInt(Integer::intValue).toArray();
    }
}
