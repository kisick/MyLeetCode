package lcof_34;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: gefeng
 * @created: 2021/05/23 10:47
 */
public class offer34 {
    public static void main(String[] args) {
        TreeNode A = new TreeNode(5);
        A.left = new TreeNode(4);
        A.left.left = new TreeNode(11);
        A.left.left.left = new TreeNode(7);
        A.left.left.right = new TreeNode(2);
        A.right = new TreeNode(8);
        A.right.left = new TreeNode(13);
        A.right.right = new TreeNode(4);
        A.right.right.right = new TreeNode(1);
        A.right.right.left = new TreeNode(5);
        Solution solution = new Solution();
        int target = 22;
        List<List<Integer>> lists = solution.pathSum(A, target);
        for (List<Integer> list : lists) {
            for (Integer integer : list) {
                System.out.print(integer);
            }
            System.out.println("");
        }
    }
}

/**
 * 输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。
 * 从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。
 *
 * 示例:
 * 给定如下二叉树，以及目标和 target = 22，
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \    / \
 *         7    2  5   1
 *
 * 返回:
 * [
 *    [5,4,11,2],
 *    [5,8,4,5]
 * ]
 */
class Solution {

    private List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        dfs(root, new ArrayList<>(), target);
        return res;
    }

    public void dfs(TreeNode current, List<Integer> onePath, int target) {
        if (current == null) {
            return;
        }
        onePath.add(current.val);
        if (current.right == null && current.left == null) {
            if (current.val == target) {
                res.add(new ArrayList<>(onePath));
            }
        }
        dfs(current.left, onePath, target - current.val);
        dfs(current.right, onePath, target - current.val);
        onePath.remove(onePath.size()-1);
    }
}
