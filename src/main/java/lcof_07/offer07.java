package lcof_07;

import java.util.Arrays;


/**
 * @author: gefeng
 * @created: 2021/04/08 00:51
 */
public class offer07 {
    public static void main(String[] args) {
        int[] preorder = new int[]{3,9,20,15,7};
        int[] inorder = new int[]{9,3,15,20,7};
        Solution solution = new Solution();
        TreeNode treeNode = solution.buildTree(preorder, inorder);

    }
}





class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 *
 * 例如，给出
 *
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 *
 */
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        TreeNode treeNode = new TreeNode(preorder[0]);
        if (preorder.length == 1 && inorder.length == 1 && preorder[0] == inorder[0]) {
            return treeNode;
        }
        int root = preorder[0];
        int index = 0;
        // 找到根节点在中序遍历中的位置
        while (inorder[index] != root) {
            index++;
        }
        int[] inorder_left_child = Arrays.copyOfRange(inorder, 0, index);
        int[] inorder_right_child = Arrays.copyOfRange(inorder, index + 1, inorder.length);
        int[] preorder_left_child = Arrays.copyOfRange(preorder, 1, index + 1);
        int[] preorder_right_child = Arrays.copyOfRange(preorder, index + 1, preorder.length);
        treeNode.left = buildTree(preorder_left_child, inorder_left_child);
        treeNode.right = buildTree(preorder_right_child, inorder_right_child);
        return treeNode;
    }
}
