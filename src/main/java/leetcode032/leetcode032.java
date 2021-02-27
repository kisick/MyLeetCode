package leetcode032;

/**
 * @author: gefeng
 * @created: 2021/01/01 20:12
 */
public class leetcode032 {
}


/**
 * 给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
 *
 * 输入: "(()"
 * 输出: 2
 * 解释: 最长有效括号子串为 "()"
 *
 * 输入: ")()())"
 * 输出: 4
 * 解释: 最长有效括号子串为 "()()"
 *
 * 输入: "()(())"
 *  * 输出: 6
 *  * 解释: 最长有效括号子串为 "()(())"
 */
class Solution {
    public static int longestValidParentheses(String s) {
        // 1.状态 定义f[i][j] 表示i-j是一个有效括号
        // 2.最终状态 f[i][j]
        // 3.转移方程 如果f[i][j] 是一个有效括号，则f[i+1][j-1]也是一个有效括号
        // f[i][j] = f[i]== '(' && f[j]==')' && f[i+1][j-1]
        // 4.边界条件 f[0][0] = false
        int res = 0;
        boolean[][] dp = new boolean[s.length()+1][s.length()+1];
        dp[0][0] = false;
        for (int i = 1; i < s.length(); i++) {
            for (int j = i+1; j < s.length(); j+=2) {
                dp[i][j] = s.charAt(i)== '(' && s.charAt(j)==')' && dp[i+1][j-1];
            }
        }
        return 0;
    }
}
