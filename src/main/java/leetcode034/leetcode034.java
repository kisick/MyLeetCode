package leetcode034;

import java.util.Arrays;

/**
 * @author: gefeng
 * @created: 2021/08/19 01:01
 */
public class leetcode034 {
    public static void main(String[] args) {
        int[] nums = new int[]{5,7,7,8,8,10};
        int target = 8;
        int[] ints = new Solution().searchRange(nums, target);
        Arrays.stream(ints).forEach(System.out::print);
    }
}


/**
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * 如果数组中不存在目标值 target，返回[-1, -1]。
 *
 * 进阶：
 *
 * 你可以设计并实现时间复杂度为O(log n)的算法解决此问题吗？
 *
 * 输入：nums = [5,7,7,8,8,10], target = 8
 * 输出：[3,4]
 *
 * 输入：nums = [5,7,7,8,8,10], target = 6
 * 输出：[-1,-1]
 */
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int left = midSearch(nums, target, true);
        int right = midSearch(nums, target, false);
        return new int[]{left, right};
    }

    public int midSearch(int[] nums, int target, boolean searchLeft) {
        int i = 0, j = nums.length - 1;
        while (i <= j) {
            int mid = (i+j)/2;
            if (nums[mid] == target) {
                if (searchLeft) {
                    if (mid == 0 || nums[mid-1] != target) {
                        return mid;
                    } else {
                        j = mid - 1;
                    }
                } else {
                    if (mid == nums.length - 1 || nums[mid+1] != target) {
                        return mid;
                    } else {
                        i = mid + 1;
                    }
                }
            } else if (nums[mid] > target) {
                j = mid - 1;
            } else {
                i = mid + 1;
            }
        }
        return -1;
    }
}
