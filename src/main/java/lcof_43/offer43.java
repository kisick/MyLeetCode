package lcof_43;

/**
 * @author: gefeng
 * @created: 2021/06/10 23:44
 */
public class offer43 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 13;
        System.out.println(solution.countDigitOne(n));
    }
}

/**
 * 输入一个整数 n ，求1～n这n个整数的十进制表示中1出现的次数。
 *
 * 例如，输入12，1～12这些整数中包含1 的数字有1、10、11和12，1一共出现了5次。
 *
 * 输入：n = 12
 * 输出：5
 *
 * 输入：n = 13
 * 输出：6
 *
 * 1 <= n < 2^31
 */
class Solution {
    public int countDigitOne(int n) {
        int count = 0;
        String num = String.valueOf(n);
        int m = 1;
        for (int i = 1; i <= num.length(); i++) {
            int curIndex = Integer.parseInt(String.valueOf(num.charAt(i-1)));
            for (int j = 0; j < curIndex; j++) {
                if (j == 1) {
                    count += m;
                }
            }
            m *= 10;
        }
        return count;
    }
}
