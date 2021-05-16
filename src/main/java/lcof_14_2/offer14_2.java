package lcof_14_2;

/**
 * @author: gefeng
 * @created: 2021/04/16 00:00
 */
public class offer14_2 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 120;
        System.out.println(solution.cuttingRope(n));
    }
}


/**
 * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m - 1] 。
 * 请问 k[0]*k[1]*...*k[m - 1] 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 *
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 *
 * 输入: 2
 * 输出: 1
 * 解释: 2 = 1 + 1, 1 × 1 = 1
 *
 * 输入: 10
 * 输出: 36
 * 解释: 10 = 3 + 3 + 4, 3 ×3 ×4 = 36
 *
 */
class Solution {
    // cache[i] 表示长度为i的绳子的最大乘积取模1000000007
    int[] cache;
    // mod[n] 表示cache[n]位置上的元素，经历了多少次取模溢出
    int[] mod;
    int constant = 1000000007;
    public int cuttingRope(int n) {
        cache = new int[n+1];
        mod = new int[n+1];
        int max = n-1;
        int max_mod = 0;
        for (int i = 1; i < n; i++) {
            int tmp = dp(i,n);
            // 怎么判断这一次截取方式比上一次截取方式得到的乘积更大
            if (mod[i]> mod[max_mod]|| (mod[i] == mod[max_mod] && tmp > max)) {
                max = tmp;
                max_mod = i;
            }
        }
        return max%constant;
    }

    /**
     *
     * @param right 表示先截取right长度
     * @param n     总长度为n
     * @return      返回什么？返回长度为n的绳子，先截取right后，得到的最大乘积
     */
    public int dp(int right, int n) {
        if (cache[n-right] > 0) {
            int r_res = right*cache[n-right];
            if (r_res > constant) {
                mod[n-right] += r_res / constant;
            }
            return r_res%constant;
        }
        int left = n - right;
        int left_max = left;
        int left_mod = 0;
        for (int i = 1; i < left; i++) {
            int tmp = dp(i,left);
            // 怎么判断这一次截取方式比上一次截取方式得到的乘积更大
            if (mod[left-i] > mod[left_mod] || (mod[left-i] == mod[left_mod] && tmp > left_max)) {
                left_max = tmp;
                left_mod = i;
            }
        }
        cache[left] = left_max;
        int res = right*left_max;
        if (res > constant) {
            mod[n-right] += res / constant;
        }
        return res%constant;
    }
}
