package common;

import java.util.List;

public class ListNode {
    public int val;
    public ListNode next;
    public ListNode() {}
    public ListNode(int x) {
        val = x;
    }
    public ListNode(int x, ListNode next) {
        this.val = x;
        this.next = next;
    }

    public ListNode(int[] nums) {
        this.val = nums[0];
        ListNode dummy = this;
        for (int i = 1; i < nums.length; i++) {
            dummy.next = new ListNode(nums[i]);
            dummy = dummy.next;
        }
    }
}
