package leetcode033;

/**
 * @author: gefeng
 * @created: 2021/08/04 21:11
 */
public class leetcode33 {
    public static void main(String[] args) {
        int[] nums = new int[]{3,1};
        int target = 1;
        int search = new Solution().search(nums, target);
        System.out.printf(String.valueOf(search));
    }
}

/**
 * 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1
 *
 * 输入：nums = [4,5,6,7,0,1,2], target = 0
 * 输出：4
 *
 * 输入：nums = [4,5,6,7,0,1,2], target = 3
 * 输出：-1
 *
 *
 */
class Solution {
    public int search(int[] nums, int target) {
        // 先二分查找找到旋转的位置
        // 然后划分两段，进行二分查找
        // 把数组划分成两段
        int i = 0, j = nums.length - 1;
        while (i <= j) {
            // 0,mid-1
            int mid = (i+j)/2;
            if (target == nums[mid]) {
                return mid;
            }
            if (nums[i] <= nums[mid]) {
                // 说明这一段是有序的
                if (target >= nums[i] && target <= nums[mid]) {
                    // 说明在这一段
                    j = mid - 1;
                } else {
                    // 在另外一段 mid,length-1
                    i = mid + 1;
                }
            } else {
                // 说明这一段是有序的
                if (target >= nums[mid] && target <= nums[j]) {
                    // 说明在这一段
                    i = mid + 1;
                } else {
                    // 在另外一段 0,mid-1
                    j = mid - 1;
                }
            }
        }
        return -1;
    }

}
