package lcof_53;

import java.util.Arrays;

/**
 * @author: gefeng
 * @created: 2021/06/20 19:40
 */
public class offer53 {
    public static void main(String[] args) {
//        int[] nums = new int[]{5,7,7,8,8,8,8,8,8,10};
        int[] nums = new int[0];
        int target = 8;
        System.out.println(new Solution().search(nums, target));
    }
}

/**
 * 统计一个数字在排序数组中出现的次数。
 *
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: 2
 *
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: 0
 *
 */
class Solution {
    public int search(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
        // 找到最左边的target
        while (i <= j) {
            int mid = (i + j)/2;
            if (nums[mid] < target) {
                // 最左边的target在mid-j这个区间范围内
                i = mid + 1;
            } else {
                // 最左边的target在i-mid这个区间范围内
                j = mid - 1;
            }
        }
        // 最左边的target即为i所在的位置
        int left = i;
        if (i < nums.length - 1 && nums[i] != target) {
            return 0;
        }
        // 寻找最右边的target,肯定位于mid-j范围内
        i = 0;
        j = nums.length - 1;
        while (i <= j) {
            int mid = (i + j)/2;
            if (nums[mid] > target) {
                // 最右边的target在i-mid-1这个区间范围内
                j = mid - 1;
            } else {
                // 最右边的target在mid-j这个区间范围内
                i = mid + 1;
            }
        }
        int right = j;
        return right - left + 1;
    }

}
