package leetcode002;

import java.math.BigDecimal;

/**
 * @author: gefeng
 * @created: 2020/12/16 22:02
 */
public class leetcode002 {
    public static void main(String[] args) {
        /*ListNode l1 = new ListNode(9);
        ListNode l2 = new ListNode(1,
                new ListNode(9,
                new ListNode(9,
                        new ListNode(9,
                                new ListNode(9,
                                        new ListNode(9,
                                                new ListNode(9,
                                                        new ListNode(9,
                                                                new ListNode(9,new ListNode(9))))))))));*/
        ListNode l1 = new ListNode();
        ListNode l2 = new ListNode();
        l1.val = 2;
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        l2.val = 5;
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        ListNode listNode = Solution.addTwoNumbers(l1, l2);
        System.out.println(listNode.toString());
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) {
        this.val = val;
    }
    ListNode(int val,ListNode next) {
        this.val =val;
        this.next = next;
    }
}

// [9]
// [1,9,9,9,9,9,9,9,9,9]
// [0,0,0,0,0,0,0,0,0,0,1]

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例：
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 设置一个进位
        int carry = 0;
        ListNode head = null,tail = null;
        while (l1!=null || l2!=null) {
            if (l1 == null) {l1 = new ListNode(0);}
            if (l2 == null) {l2 = new ListNode(0);}
            if (head == null) {
                head = tail = new ListNode((l1.val+l2.val)%10);
            } else {
                tail.next = new ListNode((l1.val + l2.val + carry)%10);
                tail = tail.next;
            }
            carry = (l1.val+l2.val+carry)/10;
            l1 = l1.next;
            l2 = l2.next;
            if (l1 == null && l2 == null && carry == 1) {
                tail.next = new ListNode(1);
            }
        }

        return head;
    }
}













