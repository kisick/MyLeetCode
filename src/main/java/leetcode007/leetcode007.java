package leetcode007;

/**
 * @author: gefeng
 * @created: 2020/12/24 21:36
 */
public class leetcode007 {
    public static void main(String[] args) {
        int x = -2147483648;
        int reverse = Solution.reverse(x);
        System.out.println(reverse);
    }
}


class Solution {
    public static int reverse(int x) {
        if (x == -2147483648) {
            return 0;
        }
        if (x < 0) {
            return -reverse(-x);
        }
        if (x <= 0) {
            return 0;
        }
        String s = ""+x;
        int res = 0;
        int power = 1;
        for (int i = 0; i< s.length(); i++) {
            char c = s.charAt(i);
            String j = (String.valueOf(c));
            try {
                Math.multiplyExact(Integer.valueOf(j),power);
                Math.addExact(res, Integer.valueOf(j)*power);
            } catch(ArithmeticException e) {
                return 0;
            }
            res += Integer.valueOf(j)*power;
            power *= 10;
        }
        return res;
    }
}
