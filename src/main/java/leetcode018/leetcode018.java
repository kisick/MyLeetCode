package leetcode018;

import com.sun.deploy.util.ArrayUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: gefeng
 * @created: 2021/02/14 21:08
 */
public class leetcode018 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {-2,-1,-1,1,1,2,2};
        int target = 0;
        System.out.println(solution.fourSum(nums,target));
    }

}

class Solution {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums.length < 4) {
            return ans;
        }
        int length = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; i++) {
            int a = nums[i];
            int minFourSumForI = a + nums[i+1] + nums[i+2] + nums[i+3];
            int maxFourSumForI = a + nums[length-3] + nums[length-2] + nums[length-1];
            if (minFourSumForI > target) {
                break;
            }
            if (maxFourSumForI < target) {
                continue;
            }
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length - 2; j++) {
                int b = nums[j];
                int minFourSumForJ = a + b +nums[j+1] + nums[j+2];
                int maxFourSumForJ = a + b +nums[length-2] + nums[length-1];
                if (minFourSumForJ > target) {
                    break;
                }
                if (maxFourSumForJ < target) {
                    continue;
                }
                if (j > i + 1 && nums[j] == nums[j-1]) {
                    continue;
                }
                // 从剩下的数组中找出两个值相加等于target-a-b;
                int left = j + 1;
                int right = nums.length - 1;
                while (left < right) {
                    int c = nums[left];
                    int d = nums[right];
                    if (c + d == target - a - b) {
                        List<Integer> oneAns = new ArrayList<>();
                        oneAns.add(a);
                        oneAns.add(b);
                        oneAns.add(c);
                        oneAns.add(d);
                        ans.add(oneAns);
                        left++;
                        right--;
                        while (left+1 < nums.length && nums[left] == nums[left-1]) {
                            left++;
                        }
                        while (right-1 > 0 && nums[right] == nums[right+1]) {
                            right--;
                        }
                    } else if (c + d < target - a - b) {
                        // 需要将cd之和增大
                        left++;
                        while (left + 1 < nums.length && nums[left] + d < target - a - b) {
                            left++;
                        }
                    } else {
                        // 将cd之和减小
                        right--;
                        while (right-1 > 0 && c + nums[right] > target - a - b) {
                            right--;
                        }
                    }
                }
            }
        }
        return ans;
    }

}
