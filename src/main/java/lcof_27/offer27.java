package lcof_27;

import common.TreeNode;

import java.net.Socket;
import java.util.TreeMap;

/**
 * @author: gefeng
 * @created: 2021/05/06 20:47
 */
public class offer27 {
    public static void main(String[] args) {
        TreeNode A = new TreeNode(4);
        A.left = new TreeNode(4);
        A.left.left = new TreeNode(1);
        A.right = new TreeNode(5);
        A.right.right = new TreeNode(2);

        Solution solution = new Solution();
        TreeNode treeNode = solution.mirrorTree(A);
        printTree(treeNode);
    }

    public static  void printTree(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.println(root.val);
        printTree(root.left);
        printTree(root.right);
    }
}


/**
 * 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
 *
 * 例如输入：
 *
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * 镜像输出：
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 */
class Solution {
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode tmp = root.left;
        root.left = mirrorTree(root.right);
        root.right = mirrorTree(tmp);
        return root;
    }


}
