package lcof_22;

import java.net.Socket;

/**
 * @author: gefeng
 * @created: 2021/04/20 23:33
 */
public class offer_22 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        Solution solution = new Solution();
        int k = 2;
        ListNode kthFromEnd = solution.getKthFromEnd(head, 2);
        while (kthFromEnd != null) {
            System.out.println(kthFromEnd.val);
            kthFromEnd = kthFromEnd.next;
        }
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {val = x;}
}

/**
 * 输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。
 *
 * 例如，一个链表有 6 个节点，从头节点开始，它们的值依次是 1、2、3、4、5、6。这个链表的倒数第 3 个节点是值为 4 的节点。
 *
 * 示例：
 *
 * 给定一个链表: 1->2->3->4->5, 和 k = 2.
 *
 * 返回链表 4->5.
 *
 */
class Solution {
    /**
     * 快慢指针
     */
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode fast = head,slow = head;
        for (int i = 0; i < k; i++) {
            fast = fast.next;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
