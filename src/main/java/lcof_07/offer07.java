package lcof_07;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


/**
 * @author: gefeng
 * @created: 2021/04/08 00:51
 */
public class offer07 {
    public static void main(String[] args) {
        int[] preorder = new int[]{3,9,20,15,7};
        int[] inorder = new int[]{9,3,15,20,7};
        Solution solution = new Solution();
        TreeNode treeNode = solution.buildTree2(preorder, inorder);

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


    Map<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree2(int[] preorder, int[] inorder) {
        int n = inorder.length;
        // 存储中序遍历的位置
        for (int i = 0; i < n; i++) {
            map.put(inorder[i], i);
        }
        return buildTree(preorder, inorder, 0, n-1, 0, n-1);
    }


    public TreeNode buildTree(int[] preorder, int[] inorder, int preorder_start, int preorder_end, int inorder_start, int inorder_end) {
        if (preorder_start > preorder_end || inorder_start > inorder_end) {
            return null;
        }
        int inorder_root_idx = map.get(preorder[preorder_start]);
        TreeNode root = new TreeNode(preorder[preorder_start]);
        // 左子树的节点数量
        int left_length = inorder_root_idx - inorder_start;
        root.left = buildTree(preorder, inorder, preorder_start + 1, preorder_start + left_length, inorder_start, inorder_root_idx - 1);
        root.right = buildTree(preorder, inorder, preorder_start + 1 + left_length, preorder_end, inorder_root_idx + 1, inorder_end);
        return root;
    }


    public TreeNode myBuildTree(int[] preorder, int[] inorder, int preorder_left, int preorder_right, int inorder_left, int inorder_right) {
        if (preorder_left > preorder_right) {
            return null;
        }

        // 前序遍历中的第一个节点就是根节点
        int preorder_root = preorder_left;
        // 在中序遍历中定位根节点
        int inorder_root = map.get(preorder[preorder_root]);

        // 先把根节点建立出来
        TreeNode root = new TreeNode(preorder[preorder_root]);
        // 得到左子树中的节点数目
        int size_left_subtree = inorder_root - inorder_left;
        // 递归地构造左子树，并连接到根节点
        // 先序遍历中「从 左边界+1 开始的 size_left_subtree」个元素就对应了中序遍历中「从 左边界 开始到 根节点定位-1」的元素
        root.left = myBuildTree(preorder, inorder, preorder_left + 1, preorder_left + size_left_subtree, inorder_left, inorder_root - 1);
        // 递归地构造右子树，并连接到根节点
        // 先序遍历中「从 左边界+1+左子树节点数目 开始到 右边界」的元素就对应了中序遍历中「从 根节点定位+1 到 右边界」的元素
        root.right = myBuildTree(preorder, inorder, preorder_left + size_left_subtree + 1, preorder_right, inorder_root + 1, inorder_right);
        return root;
    }



}
