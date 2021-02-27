package leetcode005;

/**
 * @author: gefeng
 * @created: 2020/12/21 23:01
 */
public class leetcode005 {
    public static void main(String[] args) {
        String s = "a";
        Solution.longestPalindrome(s);
    }
}



class Solution {
    public static String longestPalindrome(String s) {
        char[] chars = s.toCharArray();
        int length = s.length();
        Boolean[][] dp = new Boolean[length][length];
        int right = 0,left = 0;
        StringBuffer res = new StringBuffer();
        // dp[i][j] =  chars[i] == chars[j] if j=i+1
        // dp[i][j] =  chars[i] == chars[j] && dp[i+1][j-1] if j>i+1
        for (int j = 0; j < length; j++) {
            dp[j][j] = true;
            for (int i = 0; i < j; i++) {
                if (j == i+1) {
                    dp[i][j] =  chars[i] == chars[j];
                }
                if (j > i+1) {
                    dp[i][j] =  chars[i] == chars[j] && dp[i+1][j-1];
                }
                if (dp[i][j] && j-i>left-right) {
                    right = i;
                    left = j;
                }
            }
        }
        for (int i = right; i <= left; i++) {
            res.append(chars[i]);
        }
        return res.toString();
    }
}
