package lcof_57;

import java.util.Arrays;

/**
 * @author: gefeng
 * @created: 2021/06/30 23:59
 */
public class offer57 {
    public static void main(String[] args) {
        Arrays.stream(new Solution().twoSum(new int[]{2,7,11,15},9)).forEach(System.out::println);
    }
}


/**
 * 输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。如
 * 果有多对数字的和等于s，则输出任意一对即可。
 *
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[2,7] 或者 [7,2]
 *
 */
class Solution {
    public int[] twoSum(int[] nums, int target) {

        // 最大的加最小的都比target大，所以最大的数舍弃；最小的加最大的都比target小，所以最小的舍弃
        int i = 0, j = nums.length - 1;
        while (i < j) {
            if (nums[i] + nums[j] == target) {
                return new int[]{nums[i],nums[j]};
            } else if (nums[i] + nums[j] > target) {
                j--;
            } else {
                i++;
            }
        }
        return new int[0];
        /*for (int i = 0; i < nums.length-1; i++) {
            int curTarget = target - nums[i];
            // 在[i,nums.length-i]区间内查找curTarget
            int right = i + 1, left = nums.length - 1;
            int j = (right + left)/2;
            while (right <= left) {
                if (nums[j] == curTarget) {
                    return new int[]{nums[i],nums[j]};
                } else if (nums[j] < curTarget) {
                    right = j + 1;
                } else {
                    left = j - 1;
                }
                j = (right + left)/2;
            }
        }
        return new int[]{0,0};*/
    }
}
