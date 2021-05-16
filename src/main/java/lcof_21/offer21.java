package lcof_21;

/**
 * @author: gefeng
 * @created: 2021/04/20 22:27
 */
public class offer21 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,2,5,3,1,5,3,5,6,2,8};
        int[] exchange = new Solution().exchange(nums);
        for (int i = 0; i < exchange.length; i++) {
            System.out.println(exchange[i]);
        }
    }
}

/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
 *
 * 示例：
 *
 * 输入：nums =[1,2,3,4]
 * 输出：[1,3,2,4]
 * 注：[3,1,2,4] 也是正确的答案之一。
 *
 */
class Solution {
    public int[] exchange(int[] nums) {
        int left = 0, right = nums.length - 1,tmp;
        while (left < right && left < nums.length && right >= 0) {
            while ((nums[left]&1) != 0 && left < nums.length -1) {
                // 左边是奇数，则一直右移
                left++;
            }
            while ((nums[right]&1) == 0 && right > 0) {
                // 右边是偶数，则一直左移
                right--;
            }
            if (left < right && (nums[left]&1) == 0 && (nums[right]&1) != 0) {
                // 左偶右奇，交换
                tmp = nums[left];
                nums[left] = nums[right];
                nums[right] = tmp;
                left++;
                right--;
            }
        }
        return nums;
    }
}
