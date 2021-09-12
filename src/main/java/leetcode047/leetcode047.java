package leetcode047;

import sort.QuickSort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: gefeng
 * @created: 2021/08/28 22:32
 */
public class leetcode047 {
    public static void main(String[] args) {
        int[] nums = new int[]{2,2,1,1};
        List<List<Integer>> permute = new Solution().permuteUnique(nums);
        permute.forEach(l -> {
            l.forEach(System.out::print);
            System.out.println("");
        });
    }
}


/**
 * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 */
class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    boolean[] visited;
    public List<List<Integer>> permuteUnique(int[] nums) {
        visited = new boolean[nums.length];
        Arrays.sort(nums, 0, nums.length);
        dfs(nums, new ArrayList<>());
        return ans;
    }

    public void dfs(int[] nums, List<Integer> singleAns) {
        if (singleAns.size() == nums.length) {
            ans.add(new ArrayList<>(singleAns));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }
            // 给多个重复的值，设置一个固定的顺序
            // 比如1 1 1 三个重复的值，记为 1a 1b 1c
            // 限制: 只能以1a 开头，不能以1b 或者 1c 开头
            // 如果当前访问的值，与数组中前一个值相等，并且前面一个值没有被访问过，则跳过本次循环
            if (i > 0 && !visited[i-1] && nums[i] == nums[i-1]) {
                continue;
            }
            visited[i] = true;
            singleAns.add(nums[i]);
            dfs(nums, singleAns);
            singleAns.remove(singleAns.size() - 1);
            visited[i] = false;
        }
    }
}
