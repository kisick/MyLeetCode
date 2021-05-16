package leetcode025;

import java.util.List;
import java.util.Stack;

/**
 * @author: gefeng
 * @created: 2021/03/07 21:52
 */
public class leetcode025 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        Solution solution = new Solution();
        ListNode listNode = solution.reverseKGroup(head, 3);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }

    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

/**
 * 给你一个链表，每k个节点一组进行翻转，请你返回翻转后的链表。
 * k是一个正整数，它的值小于或等于链表的长度。
 *
 * 如果节点总数不是k的整数倍，那么请将最后剩余的节点保持原有顺序。
 *
 * 进阶：
 *
 * 你可以设计一个只使用常数额外空间的算法来解决此问题吗？
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 *
 * 输入：head = [1,2,3,4,5], k = 2
 * 输出：[2,1,4,3,5]
 *
 * head = [1,2,3,4,5], k = 3
 * 输出：[3,2,1,4,5]
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode dummy = new ListNode(-1, head);
        ListNode temp = dummy;
        // 每次都是逆转temp后的k个节点
        ListNode firstNode = temp.next;
        Stack<ListNode> stack = new Stack<>();
        for (int i = 0; i < k; i++) {
            stack.push(firstNode);
            firstNode = firstNode.next;
        }
        for (int i = 0; i < k; i++) {
            temp.next = stack.peek();
            temp = temp.next;
            stack.pop();
        }
        return dummy.next;
    }
}
