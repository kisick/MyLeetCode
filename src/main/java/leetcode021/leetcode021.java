package leetcode021;

/**
 * @author: gefeng
 * @created: 2021/02/27 22:00
 */
public class leetcode021 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode l1 = new ListNode();
        ListNode l2 = new ListNode();
        ListNode result = solution.mergeTwoLists(l1,l2);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode() {};
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

/**
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * 输入：l1 = [1,2,4], l2 = [1,3,4]
 * 输出：[1,1,2,3,4,4]
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        return  l1;
    }
}
