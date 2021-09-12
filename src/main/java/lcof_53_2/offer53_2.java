package lcof_53_2;

/**
 * @author: gefeng
 * @created: 2021/06/21 21:55
 */
public class offer53_2 {
    public static void main(String[] args) {
        int[] nums = new int[]{0,1,2,3,4,5,6,7,9};
        System.out.println(new Solution().missingNumber(nums));
    }
}

/**
 * 一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。
 * 在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
 *
 * 输入: [0,1,3]
 * 输出: 2
 *
 * 输入: [0,1,2,3,4,5,6,7,9]
 * 输出: 8
 */
class Solution {
    public int missingNumber(int[] nums) {
        // nums[i] = i nums[i] = i+1
        int i = 0, j = nums.length - 1;
        while (i <= j) {
            int mid = (i + j)/2;
            if (nums[mid] == mid) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }
        return i;
    }
}
