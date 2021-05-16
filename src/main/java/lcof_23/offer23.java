package lcof_23;

/**
 * @author: gefeng
 * @created: 2021/04/20 23:48
 */
public class offer23 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        Solution solution = new Solution();
        ListNode listNode = solution.reverseList(head);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {val = x;}
}

/**
 * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 *
 */

class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode pre = head;
        ListNode next = head.next;
        while(next != null) {
            pre.next = next.next;
            next.next = head;
            head = next;
            next = pre.next;
        }
        return head;
    }
}
