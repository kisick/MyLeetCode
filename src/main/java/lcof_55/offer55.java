package lcof_55;

import common.TreeNode;

/**
 * @author: gefeng
 * @created: 2021/06/23 00:36
 */
public class offer55 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.right = new TreeNode(4);
        root.left = new TreeNode(1);
        root.left.right = new TreeNode(2);
        System.out.println(new Solution().maxDepth(root));
    }
}

class Solution {
    int res;
    public int maxDepth(TreeNode root) {
        maxDepth(root, 0);
        return res;
    }

    public void maxDepth(TreeNode root, int curDepth) {
        if (root == null) {
            return;
        }
        curDepth++;
        if (curDepth > res) {
            res = curDepth;
        }
        maxDepth(root.left, curDepth);
        maxDepth(root.right, curDepth);
    }
}
