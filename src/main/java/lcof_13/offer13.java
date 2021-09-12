package lcof_13;

/**
 *@author: gefeng
 *@created: 2021/04/11 18:27
 */
public class offer13 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int m = 11, n = 8, k = 16;
        System.out.println(solution.movingCount(m, n, k));
    }
}


/**
 * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。
 * 一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。
 * 但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
 *
 * 输入：m = 2, n = 3, k = 1
 * 输出：3
 *
 * 输入：m = 3, n = 1, k = 0
 * 输出：1
 */
class Solution {
    int ans = 0;
    boolean[][] canArrive;
    public int movingCount(int m, int n, int k) {
        canArrive = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            // 求i的数位之和
            int sumI = sumOfBitNumber(i);
            if (sumI > k) {
                continue;
            }
            for (int j = 0; j < n; j++) {
                // 求j的数位之和
                int sumJ = sumOfBitNumber(j);
                canArrive[i][j] = sumI + sumJ <= k;
            }
        }
        dfs(m,n,0,0);
        return ans;
    }

    /**
     * (i,j)表示机器人当前的位置
     * canArrive[i][j] = true 表示该位置可以到达
     */
    private void dfs(int m, int n, int i, int j) {
        if (i < 0 || i >= m || j < 0 || j >= n) {
            return;
        }
        if (canArrive[i][j]) {
            ans++;
            canArrive[i][j] = false;
            dfs(m, n, i+1,j);
            dfs(m, n, i-1,j);
            dfs(m, n, i,j+1);
            dfs(m, n, i,j-1);
        }
    }

    private int sumOfBitNumber(int n) {
        int res = 0;
        while (n != 0) {
            res += n % 10;
            n /= 10;
        }
        return res;
    }
}
