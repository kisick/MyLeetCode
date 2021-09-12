package leetcode215;

import common.Print;
import org.junit.jupiter.api.Test;

/**
 * @author: gefeng
 * @created: 2021/09/13 00:06
 */

/**
 * 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
 *
 * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 *
 * 示例 1:
 *
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 * 示例2:
 *
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 *
 */
class Solution {

    @Test
    public void test(){
        int[] nums = new int[]{2,3,5,1,5,3,7,3,9,1};
        int kthLargest = findKthLargest(nums, 2);
        System.out.println(kthLargest);
    }
    public int findKthLargest(int[] nums, int k) {
        return quickSort(nums,0, nums.length - 1,k);
    }


    public int quickSort(int[] nums, int left, int right, int k) {
        int pivot = nums[left];
        int i = left, j = right;
        while (i < j) {
            // 从右边开始找到第一个小于pivot的数
            while (nums[j] > pivot && j > i) {
                j--;
            }
            if (j > i) {
                nums[i] = nums[j];
                i++;
            }
            // 从左边开始找到第一个大于pivot的值
            while (nums[i] < pivot && i < j) {
                i++;
            }
            if (i < j) {
                nums[j] = nums[i];
            }
        }
        nums[i] = pivot;
        if (i == nums.length - k) {
            return nums[i];
        } else if (i > nums.length - k) {
            return quickSort(nums, left, j -1, k);
        } else {
            return quickSort(nums, j + 1, right, k);
        }
    }

}
