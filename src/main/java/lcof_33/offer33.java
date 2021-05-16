package lcof_33;

import java.net.Socket;

/**
 * @author: gefeng
 * @created: 2021/05/16 14:03
 */
public class offer33 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] a = new int[]{5, 4, 3, 2, 1};
        System.out.println(solution.verifyPostorder(a));
    }
}


/**
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。
 * 如果是则返回 true，否则返回 false。
 * 假设输入的数组的任意两个数字都互不相同。
 *
 * 参考以下这颗二叉搜索树：
 *      5
 *     / \
 *    2   6
 *   / \
 *  1   3
 *
 *
 * 输入: [1,6,3,2,5]
 * 输出: false
 *
 * 输入: [1,3,2,6,5]
 * 输出: true
 */
class Solution {
    public boolean verifyPostorder(int[] postorder) {
        // 最后一个节点是根节点，遍历数组，找到最大的一个值，为最右端的一个节点
        // 从0到最大的节点之间的数都小于根节点
        // 从最大的节点到数组最后的数都大雨根节点
        // 从前往后，找到大于root的第一个节点，以此节点为分界线
        if (postorder == null || postorder.length == 0) {
            return false;
        }
        int root = postorder[postorder.length-1];
        int i = 0;

        while (postorder[i] < root) {
            i++;
        }
        int right_min = postorder[i];
        for ( ; i < postorder.length - 1; i++) {
            if (postorder[i] < root) {
                return false;
            }
        }
        return true;
    }
}
