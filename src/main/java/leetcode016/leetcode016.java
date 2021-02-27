package leetcode016;

import java.util.Arrays;

/**
 * @author: gefeng
 * @created: 2021/02/12 16:11
 */
public class leetcode016 {
    public static void main(String[] args) {
        int[] nums = {0,2,1,-3};
        int target = 1;
        System.out.println(Solution.threeSumClosest(nums, target));
    }
}

/**
 * 给定一个包括n 个整数的数组nums和 一个目标值target。
 * 找出nums中的三个整数，使得它们的和与target最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 *
 * 示例：
 *
 * 输入：nums = [-1,2,1,-4], target = 1
 * 输出：2
 * 解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
 *
 */
class Solution {
    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int res = Integer.MAX_VALUE - 10^4;
        for (int i = 0; i < nums.length; i++) {
            int a = nums[i];
            int j = i +1, k = nums.length - 1;
            while (j < k) {
                int b = nums[j], c = nums[k];
                int sum = a + b + c;
                if (sum == target) {
                    return sum;
                }
                if (Math.abs(sum - target) <= Math.abs(res - target)) {
                    res = sum;
                }
                if (sum < target) {
                    // 增大sum
                    j++;
                } else if (sum > target) {
                    // 减小sum
                    k--;
                }
            }
        }
        return res;
    }
}
