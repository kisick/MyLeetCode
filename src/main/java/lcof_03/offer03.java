package lcof_03;


/**
 * @author: gefeng
 * @created: 2021/03/30 22:35
 */
public class offer03 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {2,3,1,0,2,5,3};
        System.out.println(solution.findRepeatNumber(nums));
    }
}

/**
 * 找出数组中重复的数字。
 *
 *
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。
 * 请找出数组中任意一个重复的数字。
 *
 * 示例 1：
 *
 * 输入：
 * [2, 3, 1, 0, 2, 5, 3]
 * 输出：2 或 3
 *
 */
class Solution {
    public int findRepeatNumber(int[] nums) {
        boolean[] a = new boolean[nums.length];
        for (int num : nums) {
            if (a[num]) {
                return num;
            }
            a[num] = true;
        }
        return -1;
    }
}
