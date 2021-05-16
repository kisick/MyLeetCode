package leetcode023;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: gefeng
 * @created: 2021/02/28 22:06
 */
public class leetcode023 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode[] lists = new ListNode[2];
        /*ListNode l0 = new ListNode(1, new ListNode(4, new ListNode(5)));
        ListNode l1 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode l2 = new ListNode(2, new ListNode(6));*/
        ListNode l0 = new ListNode(0);
        ListNode l1 = new ListNode(1);
//        ListNode l2 = new ListNode();
        lists[0] = l0;
        lists[1] = l1;
//        lists[2] = l2;
        ListNode listNode = solution.mergeKLists(lists);
        while (listNode!=null) {
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
 * 给你一个链表数组，每个链表都已经按升序排列。
 *
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 *
 * 输入：lists = [[1,4,5],[1,3,4],[2,6]]
 * 输出：[1,1,2,3,4,4,5,6]
 * 解释：链表数组如下：
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 将它们合并到一个有序链表中得到。
 * 1->1->2->3->4->4->5->6
 *
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        return solution1(lists);
    }

    /**
     * 神奇的解法，居然可以过
     * @param lists
     * @return
     */
    public ListNode solution1(ListNode[] lists) {
        List<Integer> vals = new ArrayList<>();
        for (int i = 0; i < lists.length; i++) {
            while (lists[i] != null) {
                vals.add(lists[i].val);
                lists[i] = lists[i].next;
            }
        }
        if (vals.size() == 0) {
            return null;
        }
        int[] array = vals.stream().mapToInt(x->x).toArray();
        Arrays.sort(array);
        ListNode dummy = new ListNode();
        ListNode ans = dummy.next;
        for (int i = 0; i < array.length-1; i++) {
            ans.val = array[i];
            ans.next = new ListNode();
            ans = ans.next;
        }
        if (array.length > 0) {
            ans.val = array[array.length-1];
        }
        return dummy.next;
    }

    /**
     * 解法2
     * @param lists
     * @return
     */
    /*public ListNode solution2(ListNode[] lists) {

    }*/
}
