package leetcode024;

import java.net.Socket;
import java.util.List;

/**
 * @author: gefeng
 * @created: 2021/03/07 19:45
 */
public class leetcode024 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1,new ListNode(2,new ListNode(3, new ListNode(4))));
        Solution solution = new Solution();
        ListNode listNode = solution.swapPairs(head);
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
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 * 输入：head = [1,2,3,4]
 * 输出：[2,1,4,3]
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(-1, head);
        ListNode temp = dummy;
        // 每次都是交换temp后的两个节点
        while (temp.next != null && temp.next.next != null) {
            ListNode firstNode = temp.next;
            temp.next = firstNode.next;
            firstNode.next = temp.next.next;
            temp.next.next = firstNode;
            temp = firstNode;
        }
        return dummy.next;
    }
}
