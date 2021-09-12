package lcof_68;

import common.TreeNode;

/**
 * @author: gefeng
 * @created: 2021/07/19 22:11
 */
public class offer68 {
    public static void main(String[] args) {

    }
}

/**
 * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor(root.left,p,q);
        }
        if (root.val < p.val && root.val < q.val) {
            return lowestCommonAncestor(root.right,p,q);
        }
        return root;
    }
}
