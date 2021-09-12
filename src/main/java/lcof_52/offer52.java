package lcof_52;

import common.ListNode;

import java.net.Socket;

/**
 * @author: gefeng
 * @created: 2021/06/20 18:04
 */
public class offer52 {
    public static void main(String[] args) {
        ListNode commons = new ListNode(8);
        commons.next= new ListNode(4);
        commons.next.next = new ListNode(5);

        ListNode headA = new ListNode(4);
        headA.next = new ListNode(1);
        headA.next.next = commons;

        ListNode headB = new ListNode(5);
        headB.next = new ListNode(0);
        headB.next.next = new ListNode(1);
        headB.next.next.next = commons;
        Solution solution = new Solution();
        ListNode intersectionNode = solution.getIntersectionNode(headA, headB);
        System.out.println(intersectionNode.val);
    }
}


/**
 * 输入两个链表，找出它们的第一个公共节点。
 *
 * 如下面的两个链表：
 *
 * 输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
 * 输出：Reference of the node with value = 8
 * 输入解释：相交节点的值为 8 （注意，如果两个列表相交则不能为 0）。
 * 从各自的表头开始算起，
 * 链表 A 为 [4,1,8,4,5]，
 * 链表 B 为 [5,0,1,8,4,5]。
 * 在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
 *
 */
class Solution {
    /**
     * 原来不是比较值相等，我晕掉了
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode dummyA = headA, dummyB = headB;
        while (dummyA != dummyB) {
            dummyA = dummyA == null ? headB : dummyA.next;
            dummyB = dummyB == null ? headA : dummyB.next;
        }
        return dummyA;
    }

    /**
     * 判断两个链表是否相等
     */
    public boolean isEqualNode(ListNode headA, ListNode headB) {
        while (headA != null && headB != null && headA.val == headB.val) {
            headA = headA.next;
            headB = headB.next;
        }
        return headA == null && headB == null;
    }
}
