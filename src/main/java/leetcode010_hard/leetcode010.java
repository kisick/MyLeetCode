package leetcode010_hard;

/**
 * @author: gefeng
 * @created: 2020/12/26 16:35
 */
public class leetcode010 {
    public static void main(String[] args) {
        String s = "";
        String p = ".*a";
        System.out.println(Solution.isMatch(s, p));
    }
}

/**
 * 输入：s = "aa" p = "a"
 * 输出：false
 * 解释："a" 无法匹配 "aa" 整个字符串。
 *
 * 输入：s = "aa" p = "a*"
 * 输出：true
 * 解释：因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
 *
 * 输入：s = "ab" p = ".*"
 * 输出：true
 * 解释：".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
 *
 * 输入：s = "aab" p = "c*a*b"
 * 输出：true
 * 解释：因为 '*' 表示零个或多个，这里 'c' 为 0 个, 'a' 被重复一次。因此可以匹配字符串 "aab"。
 *
 * 输入：s = "mississippi" p = "mis*is*p*."
 * 输出：false
 */
class Solution {
    public static boolean isMatch(String s, String p) {
        /*if (s == null || p == null) {
            return false;
        }
        // dp[i][j] = true 表示 s的0-i位可由p的0-j位完全匹配
        // dp[i][j] = false 表示 s的0-i位不能由p的0-j位完全匹配
        // 当i=0时，表示s的第一位
        // dp[i][j] = true 表示s的0-i位可由p的0-j位完全匹配
        // 最终结果由dp[s.length()][p.length()]来表示
        Boolean[][] dp = new Boolean[s.length()][p.length()];

        // if s.charAt[i] = p.charAt[j] dp[i][j] = dp[i-1][j-1]
        // else if p.charAt[j] = . dp[i][j] = dp[i-1][j-1]
        // else if p.charAt[j] = *
        //          1. if s.charAt[i] = p.charAt[j-1] dp[i][j] = dp[i-1][j-2]
        //          2. if s.charAt[i] != p.charAt[j-1] dp[i][j] = dp[i][j-2]
        // dp中任何index < 0 的情况下 dp[index][index] = false;
        // loop dp[s.length][p.length] 时结束循环
        // 双方都进行到最后一位时，才退出循环
        for (int i = 0; i <= s.length(); i++) {
            for (int j = 0; j <= p.length(); j++) {
                if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.') {
                    if (i == 0 && j == 0) {
                        dp[i][j] = true;
                    } else if (i == 0 && p.charAt(j) == '*') {
                        dp[i][j] = dp[i][j-1];
                    } else if (i == 0 && p.charAt(j-1) == '*') {
                        dp[i][j] = dp[i][j-2];
                    }
                    else if (i > 0 && j > 0) {
                        dp[i][j] = dp[i-1][j-1];
                    } else {
                        dp[i][j] = false;
                    }
                } else if (p.charAt(j) == '*') {
                    if (i == 0 && j < 2) {
                        dp[i][j] = true;
                    } else if (i == 0 ) {
                        dp[i][j] = dp[i][j-1] || dp[i][j-2];
                    } else if (s.charAt(i) == p.charAt(j-1) || p.charAt(j-1) == '.') {
                        dp[i][j] = dp[i-1][j-1] || dp[i-1][j];
                    } else if (j > 1 && s.charAt(i) != p.charAt(j-1)) {
                        dp[i][j] = dp[i][j-2];
                    } else {
                        dp[i][j] = false;
                    }
                } else {
                    dp[i][j] = false;
                }
            }
        }
        return dp[s.length()-1][p.length()-1];*/
        int m = s.length();
        int n = p.length();

        boolean[][] f = new boolean[m + 1][n + 1];
        f[0][0] = true;
        for (int i = 0; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                if (p.charAt(j - 1) == '*') {
                    f[i][j] = f[i][j - 2];
                    if (matches(s, p, i, j - 1)) {
                        f[i][j] = f[i][j] || f[i - 1][j];
                    }
                } else {
                    if (matches(s, p, i, j)) {
                        f[i][j] = f[i - 1][j - 1];
                    }
                }
            }
        }
        return f[m][n];

    }
    public static boolean matches(String s, String p, int i, int j) {
        if (i == 0) {
            return false;
        }
        if (p.charAt(j - 1) == '.') {
            return true;
        }
        return s.charAt(i - 1) == p.charAt(j - 1);
    }

}
