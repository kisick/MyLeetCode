package lcof_39;

import java.util.HashMap;

/**
 * @author: gefeng
 * @created: 2021/06/05 13:51
 */
public class offer39 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 2, 2, 2, 5, 4, 2};
        Solution solution = new Solution();
        System.out.println(solution.majorityElement(nums));
    }
}


/**
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 * 输入: [1, 2, 3, 2, 2, 2, 5, 4, 2]
 * 输出: 2
 */
class Solution {
    public int majorityElement(int[] nums) {
        int count = 0, res = -1;
        for (int i = 0; i < nums.length; i++) {
            if (count == 0) {
                res = nums[i];
            }
            count += res==nums[i] ? 1 : -1;
        }
        return res;
    }
}
