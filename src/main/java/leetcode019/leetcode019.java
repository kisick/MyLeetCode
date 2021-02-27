package leetcode019;


import java.net.Socket;
import java.util.List;

/**
 * @author: gefeng
 * @created: 2021/02/15 14:06
 */
public class leetcode019 {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1,new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        // ListNode listNode = new ListNode(1,new ListNode(2));
//         ListNode listNode = new ListNode(1);
        Solution solution = new Solution();
        System.out.println(solution.removeNthFromEnd(listNode, 2));
    }
}

class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}


class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int f = 0;
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode p = head;
        ListNode s = dummy;
        while (p.next != null) {
            p = p.next;
            f++;
            if (f >= n) {
                s = s.next;
            }
        }
        s.next = s.next.next;
        return dummy.next;
    }
}
