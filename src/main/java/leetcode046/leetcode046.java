package leetcode046;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: gefeng
 * @created: 2021/08/23 23:03
 */
public class leetcode046 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,1,2,3};
        List<List<Integer>> permute = new Solution().permute2(nums);
        permute.forEach(l -> {
            l.forEach(System.out::print);
            System.out.println("");
        });
    }
}


/**
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 *
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 *
 * 输入：nums = [0,1]
 * 输出：[[0,1],[1,0]]
 */
class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    boolean[] visited;
    public List<List<Integer>> permute(int[] nums) {
        visited = new boolean[nums.length];
        dfs(nums, new ArrayList<>());
        return ans;
    }

    public void dfs(int[] nums, List<Integer> singleAns) {
        if (singleAns.size() == nums.length) {
            ans.add(new ArrayList<>(singleAns));
            return;
        }
        for (int i = 0; i < nums.length; i++) {

            if (!visited[i]) {
                singleAns.add(nums[i]);
                visited[i] = true;
                dfs(nums, singleAns);
                visited[i] = false;
                singleAns.remove(singleAns.size() - 1);
            }
        }

    }

    List<List<Integer>> ans2 = new ArrayList<>();
    public List<List<Integer>> permute2(int[] nums) {
        dfs2(nums, new ArrayList<Integer>());
        return ans2;
    }

    public void dfs2(int[] nums, List<Integer> oneAns) {
        if (oneAns.size() == nums.length) {
            ans2.add(new ArrayList<>(oneAns));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == -100) {
                continue;
            }
            oneAns.add(nums[i]);
            int tmp = nums[i];
            nums[i] = -100;
            dfs2(nums, oneAns);
            nums[i] = tmp;
            oneAns.remove(oneAns.size()-1);
        }
    }


}
