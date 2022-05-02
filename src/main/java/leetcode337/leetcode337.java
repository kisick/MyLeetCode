package leetcode337;

import common.TreeNode;

import java.util.TreeMap;

/**
 * @author: gefeng
 * @created: 2022/01/31 20:49
 */
public class leetcode337 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);

    }

    public int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 分为两种情况，一种是打劫根节点，一种是不打劫根节点
        int sum1 = count(root);
        int sum2 = count(root.left) + count(root.right);
        return Math.max(sum1, sum2);
    }

    // 从root开始打劫
    public int count(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int tmp = root.val;
        int left = 0;
        int right = 0;
        if (root.left != null) {
            left = rob(root.left.left) + rob(root.left.right);
        }
        if (root.right != null) {
            right = rob(root.right.left) + rob(root.right.right);
        }
        return tmp + left + right;
    }

}
