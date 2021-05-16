package lcof_14_1;

/**
 *@author: gefeng
 *@created: 2021/04/11 19:21
 */
public class offer14_1 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.cuttingRope(10));
    }
}


/**
 * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m-1] 。
 * 请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 *
 * 输入: 2
 * 输出: 1
 * 解释: 2 = 1 + 1, 1 × 1 = 1
 *
 * 输入: 10
 * 输出: 36
 * 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36
 *
 * 2 <= n <= 58
 */
class Solution {
    // cache[i] 表示 长度为i的绳子的最大乘积
    // 假设长度为n的绳子，先切一段长度为j，那么
    // cache[n] = max( cache[j]*cache[n-j] ); j = 2,3,4...n
    int[] cache;
    public int cuttingRope(int n) {
        cache = new int[n+1];
        int max = n-1;
        for (int i = 1; i < n; i++) {
            int tmp = dp(i, n);
            if (tmp > max) {
                max = tmp;
            }
        }
        return max;
    }

    /**
     *
     * @param right 表示截取一小段
     * @param n 表示绳子的整体长度
     * @return 返回n长度的绳子，在先截取right情况下的最大乘积
     */
    private int dp(int right, int n) {
        if (cache[n-right] > 0) {
            return right * cache[n-right];
        }
        int left = n - right;
        int left_max = left;
        for (int i = 2; i < left; i++) {
            int tmp = dp(i, left);
            if (tmp > left_max) {
                left_max = tmp;
            }
        }
        cache[left] = left_max;
        return right * left_max;
    }
}
