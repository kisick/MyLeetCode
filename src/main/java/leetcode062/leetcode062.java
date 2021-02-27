package leetcode062;

/**
 * @author: gefeng
 * @created: 2021/01/24 20:57
 */
public class leetcode062 {
    public static void main(String[] args) {
        int m = 3;
        int n = 7;
        System.out.println(Solution.uniquePaths(m, n));
    }
}

/**
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 *
 * The robot can only move either down or right at any point in time.
 * The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 *
 * How many possible unique paths are there?
 *
 * Input: m = 3, n = 7
 * Output: 28
 *
 * Input: m = 3, n = 2
 * Output: 3
 * Explanation:
 * From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
 * 1. Right -> Down -> Down
 * 2. Down -> Down -> Right
 * 3. Down -> Right -> Down
 *
 *
 */
class Solution {
    public static int uniquePaths(int m, int n) {
        // 定义dp[i][j] 表示从左上角到[i,j]这个位置有多少条路线
        // 初始化 dp[0][0] = 0;
        // 转移方程 dp[i][j] = dp[i-1][j] + dp[i][j-1]

        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0) {
                    dp[i][j] = 1;
                }
                if (j == 0) {
                    dp[i][j] = 1;
                }
                if (i>0 && j>0) {
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }
        return dp[m-1][n-1];
     }
}
