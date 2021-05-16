package leetcode131;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: gefeng
 * @created: 2021/03/07 17:14
 */
public class leetcode131 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "cbbbcc";
        List<List<String>> partition = solution.partition(s);
        partition.forEach(System.out::println);
    }
}

/**
 * 给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
 *
 * 返回 s 所有可能的分割方案。
 * 输入: "aab"
 * 输出:
 * [
 *   ["aa","b"],
 *   ["a","a","b"]
 * ]
 */
class Solution {
    List<List<String>> res = new ArrayList<>();
    List<String> oneAns = new ArrayList<>();
    public List<List<String>> partition(String s) {
        boolean[][] dp = checkIsPalindrome(s);
        dfs(s, dp,0, s.length());
        return res;
    }

    public boolean[][] checkIsPalindrome(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = true;
            for (int j = 0; j < i; j++) {
                if (j+1 == i) {
                    dp[j][i] = s.charAt(j) == s.charAt(i);
                } else {
                    dp[j][i] = dp[j+1][i-1] && s.charAt(j) == s.charAt(i);
                }
            }
        }
        return dp;
    }

    public void dfs(String s, boolean[][] dp, int start, int n) {
        if (start == n) {
            res.add(new ArrayList<>(oneAns));
            return;
        }
        for (int i = 0; i < s.length(); i++) {
            String left = s.substring(0, i + 1);
            String right = s.substring(i+1);
            if (dp[start][start+i]) {
                oneAns.add(left);
                dfs(right, dp, start+i+1, n);
                oneAns.remove(oneAns.size()-1);
            }
        }
    }

}
