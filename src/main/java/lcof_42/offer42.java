package lcof_42;

/**
 * @author: gefeng
 * @created: 2021/06/10 23:42
 */
public class offer42 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxSubArray(new int[]{1, -2, 1, -2, 2, 3, -3, 2, -1}));
    }
}
class Solution {

    public int maxSubArray(int[] nums) {
        //dp[i] 表示以i结尾的数组的子数组的最大和
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        // dp[1] = max(nums[0]+nums[1],nums[1])
        // dp[2] = max(n[0]+n[1]+[2],n[1]+n[2],n[2])
        int max = dp[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = dp[i-1] > 0 ? dp[i-1] + nums[i] : nums[i];
            if (dp[i] > max) {
                max = dp[i];
            }
        }
        return max;
    }
}
