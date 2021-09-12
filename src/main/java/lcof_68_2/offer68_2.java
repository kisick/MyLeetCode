package lcof_68_2;

import common.TreeNode;

/**
 * @author: gefeng
 * @created: 2021/07/19 22:49
 */
public class offer68_2 {
    public static void main(String[] args) {

    }
}

/**
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 *
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * 输出: 3
 * 解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
 *
 */
class Solution {
    // 返回这两个节点的最近公共祖先，若不在root下，则返回null
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == root || q == root) {
            return root;
        }
        // 在root的左子树中查找这两个节点的最近公共祖先
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }
        return root;
    }
}
