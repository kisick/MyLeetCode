package lcof_32_3;

import common.TreeNode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author: gefeng
 * @created: 2021/05/16 10:53
 */
public class offer32_3 {
    public static void main(String[] args) {
        TreeNode A = new TreeNode(1);
        A.left = new TreeNode(2);
        A.left.left = new TreeNode(4);
        A.right = new TreeNode(3);
        A.right.right = new TreeNode(5);

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
 * 请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。
 *
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 *      3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 返回其层次遍历结果：
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        Deque<TreeNode> nodeQueue = new LinkedList<>();
        if (root != null) {
            nodeQueue.add(root);
        }
        boolean leftToRight = true;
        while (!nodeQueue.isEmpty()) {
            LinkedList<Integer> tmpQueue = new LinkedList<>();
            for (int i = nodeQueue.size(); i > 0; i--) {
                TreeNode poll = nodeQueue.pop();
                if (poll.left != null) {
                    nodeQueue.add(poll.left);
                }
                if (poll.right != null) {
                    nodeQueue.add(poll.right);
                }
                if (leftToRight) {
                    tmpQueue.addLast(poll.val);
                } else {
                    tmpQueue.addFirst(poll.val);
                }
            }
            leftToRight = !leftToRight;
            ans.add(tmpQueue);
        }
        return ans;
    }
}
