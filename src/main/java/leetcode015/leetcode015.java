package leetcode015;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: gefeng
 * @created: 2021/02/12 14:29
 */
public class leetcode015 {
    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        System.out.println(Solution.threeSum(nums));
    }
}

/**
 * 给你一个包含 n 个整数的数组nums，判断nums中是否存在三个元素 a，b，c ，使得a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 * 示例 1：
 *
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 */
class Solution {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length < 3) {
            return res;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length-2; i++) {
            int a = nums[i];
            // 重复则继续左移
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            int j = i+1, k = nums.length-1;
            while (j < k) {
                // 两个最大值之和都小于目标值，或者两个最小值之和都大于目标值，则退出本次循环
                if ((nums[k] + nums[k-1] < -a) || nums[j] + nums[j+1] > -a) {
                    break;
                }
                int b = nums[j], c = nums[k];
                if (b + c == -a) {
                    List<Integer> abc = new ArrayList<>();
                    abc.add(a);abc.add(b);abc.add(c);
                    res.add(abc);
                    j++;
                    k--;
                    // 重复则继续左移
                    while (j+1 < nums.length && nums[j] == nums[j-1]) {
                        j++;
                    }
                    // 重复则继续右移
                    while (k-1 > 2 && nums[k] == nums[k+1]) {
                        k--;
                    }
                } else if (b + c < -a) {
                    j++;
                    // 左移b直到b足够大
                    while (j+1 < nums.length && nums[j] + c < -a) {
                        j++;
                    }
                } else if (b + c > -a) {
                    k--;
                    // 右移c直到c足够小
                    while (k-1 > 2 && nums[k] + b > -a) {
                        k--;
                    }
                }
            }
        }
        return res;
    }
}
