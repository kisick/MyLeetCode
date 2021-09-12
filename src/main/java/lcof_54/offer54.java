package lcof_54;

import common.ListNode;
import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: gefeng
 * @created: 2021/06/21 21:54
 */
public class offer54 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.right = new TreeNode(4);
        root.left = new TreeNode(1);
        root.left.right = new TreeNode(2);
        Solution solution = new Solution();
        int k = 2;
        System.out.println(solution.kthLargest(root, k));
    }
}


/**
 * 给定一棵二叉搜索树，请找出其中第k大的节点。
 *
 * 输入: root = [3,1,4,null,2], k = 1
 *    3
 *   / \
 *  1   4
 *   \
 *    2
 * 输出: 4
 */
class Solution {
    int res,count;
    public int kthLargest(TreeNode root, int k) {
        count = k;
        orderVisit(root);
        return res;
    }

    // 中序遍历
    public void orderVisit(TreeNode root) {
        if (root == null) {
            return;
        }
        orderVisit(root.right);
        if (count == 0) {
            return;
        }
        if (--count <= 0) {
            res = root.val;
            return;
        }
        orderVisit(root.left);
    }
}
