package lcof_16;

/**
 * @author: gefeng
 * @created: 2021/04/17 18:19
 */
public class offer16 {
    public static void main(String[] args) {
        double x = 2.00000;
        int n = -2147483648;
        Solution solution = new Solution();
        System.out.println(solution.myPow(x, n));
    }
}

/**
 * 实现pow(x,n)，即计算 x 的 n 次幂函数（即，xn）。不得使用库函数，同时不需要考虑大数问题。
 *
 * 示例 1：
 *
 * 输入：x = 2.00000, n = 10
 * 输出：1024.00000
 * 示例 2：
 *
 * 输入：x = 2.10000, n = 3
 * 输出：9.26100
 * 示例 3：
 *
 * 输入：x = 2.00000, n = -2
 * 输出：0.25000
 * 解释：2-2 = 1
 */
class Solution {
    public double myPow(double x, int n) {
        if (x == 1) {
            return x;
        }
        if (x == -1) {
            return (n&1)==0 ? 1 : -1;
        }
        double res = 1;
        if (n < 0) {
            for (int i = 0; i > n && res > 0; i--) {
                res /= x;
            }
        } else {
            for (int i = 0; i < n; i++) {
                res *= x;
            }
        }
        return res;
    }
}
