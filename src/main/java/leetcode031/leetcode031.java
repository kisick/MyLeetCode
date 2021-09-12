package leetcode031;

import java.util.Arrays;

/**
 * @author: gefeng
 * @created: 2021/08/10 21:42
 */
public class leetcode031 {
    public static void main(String[] args) {
        int[] nums = new int[]{3,2,1};
        // 2,3,1
        new Solution().nextPermutation(nums);
        Arrays.stream(nums).forEach(System.out::print);
    }
}

/**
 * 实现获取 下一个排列 的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列（即，组合出下一个更大的整数）。
 *
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 *
 * 必须 原地 修改，只允许使用额外常数空间。
 *
 * 输入：nums = [1,2,3]
 * 输出：[1,3,2]
 *
 * 输入：nums = [3,2,1]
 * 输出：[1,2,3]
 *
 * 输入：nums = [1,1,5]
 * 输出：[1,5,1]
 */
class Solution {
    public void nextPermutation(int[] nums) {
        // 从后往前遍历，如果当前的这个值，比前一个值大，则交换
        int left = -1;
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i] > nums[i-1]) {
                left = i - 1;
                break;
            }
        }
        // 在[k,nums.length-1]这个区间内查找比left大的最小值
        if (left >= 0) {
            int right = nums.length - 1;
            for (int i = nums.length - 1; i > left; i--) {
                if (nums[i] > nums[left]) {
                    right = i;
                    break;
                }
            }
            swap(nums, left, right);
        }
        // 把left之后所有数字从小到大排序
        reverse(nums,left+1, nums.length - 1);
    }

    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public void reverse(int[] nums, int left, int right) {
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }

}
