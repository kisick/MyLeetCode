package leetcode053;


/**
 * @author: gefeng
 * @created: 2021/01/24 17:19
 */
public class leetcode053 {
    public static void main(String[] args) {
        int[] a = {1,2};
        // dp[2] = 1 但是
        System.out.println(Solution.maxSubArray(a));
    }
}

/**
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 输入: [-2,1,-3,4,-1,2,1,-5,4]
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 */
class Solution {
    public static int maxSubArray(int[] nums) {
        // dp[i][j] 表示数组第i位到第j位的和
        // 数组的第i位到第j位的连续子数组的最大和 如：dp[0][0] = -2 dp[0][1] = 1 dp[1][3] = 4
        // dp[i][j] = :
        // if nums[j] > 0 dp[i][j-1] > 0 -> dp[i][j] = dp[i][j-1] + nums[j]
        // if nums[j] > 0 dp[i][j-1] < 0 -> dp[i][j] = nums[j]
        // if nums[j] < 0 dp[i][j-1] > 0 -> dp[i][j] = dp[i][j-1]
        // if nums[j] < 0 dp[i][j-1] < 0 -> dp[i][j] = max(dp[i][j-1],nums[j])

        // ————————————————————————————
        // 最重要的是明确dp[i]代表什么？
        // dp[i] 表示以i结尾的数组的子数组的最大和??? 注意，dp[i]并不是答案
        // 答案是dp[i]的最大值，而不是dp[nums.length-1]
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            //[-2,1,-3,4,-1,2,1,-5,4]
            // dp[2] = -2 为什么不是等于1呢？？？？？？？
            // 因为我们的dp[2]表示的是以-3这个数字结尾的子数组的最大和，而不是nums数组第0位到第3位的子数组的最大和
            dp[i] = Math.max(dp[i-1] + nums[i],nums[i]);
            // 一开始直接写成了下面这样，直接相加，这样求出来只是连续和，而不是子数组的最大和
            // 要想求得子数组的最大和，需要
            // dp[i] = dp[i-1] + nums[i]
            max = Math.max(dp[i],max);
        }
        return max;
    }
}
