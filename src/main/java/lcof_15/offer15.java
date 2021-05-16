package lcof_15;

/**
 * @author: gefeng
 * @created: 2021/04/17 18:00
 */
public class offer15 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 00000000000000000000000010010010;
        System.out.println(solution.hammingWeight(n));
    }
}

/**
 * 请实现一个函数，输入一个整数（以二进制串形式），输出该数二进制表示中 1 的个数。
 * 例如，把 9表示成二进制是 1001，有 2 位是 1。因此，如果输入 9，则该函数输出 2。
 *
 */
class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int res = 0;
        while (n != 0) {
            if ((n & 1) == 1) {
                res ++;
            }
            n = n >>> 1;
        }
        return res;
    }
}
