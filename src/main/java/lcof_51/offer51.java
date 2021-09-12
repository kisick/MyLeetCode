package lcof_51;

/**
 * @author: gefeng
 * @created: 2021/06/19 20:24
 */
public class offer51 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,3,2,3,1};
        Solution solution = new Solution();
        System.out.println(solution.reversePairs(nums));
    }
}


/**
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
 * 输入一个数组，求出这个数组中的逆序对的总数。
 * 输入: [7,5,6,4]
 * 输出: 5
 */
class Solution {
    int count = 0;
    public int reversePairs(int[] nums) {
        mergeSort(nums, new int[nums.length], 0, nums.length - 1);
        return count;
    }

    public void mergeSort(int[] nums, int[] res, int start, int end) {
        if (start >= end) {
            return;
        }
        int len = end - start;
        int start1 = start, end1 = len/2 + start;
        int start2 = end1 + 1, end2 = end;
        mergeSort(nums, res, start1, end1);
        mergeSort(nums, res, start2, end2);
        int k = start;
        while (start1 <= end1 && start2 <= end2) {
            if (nums[start1] <= nums[start2]) {
                res[k++] = nums[start1++];
                count +=  start2 - end1 - 1;
            } else {
                res[k++] = nums[start2++];
            }
        }
        while (start1 <= end1) {
            res[k++] = nums[start1++];
            count +=  start2 - end1 - 1;
        }
        while (start2 <= end2) {
            res[k++] = nums[start2++];
        }
        for (int i = start; i <= end; i++) {
            nums[i] = res[i];
        }
    }
}
