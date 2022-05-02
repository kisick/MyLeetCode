package leetcode043;

import org.junit.jupiter.api.Test;

/**
 * @author: gefeng
 * @created: 2021/11/05 22:49
 */
public class leetcode043 {
    public static void main(String[] args) {
        String nums1 = "123";
        String nums2 = "456";
        String multiply = new Solution().multiply(nums1, nums2);
        System.out.printf(multiply);
    }
}

/**
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 *
 * 输入: num1 = "123", num2 = "456"
 * 输出: "56088"
 */
class Solution {
    @Test
    public void test() {
//        StringBuilder multiply = multiply("123", '2');
//        String sum = sumString("123", "232");
        String res = multiply("9", "9");
//        System.out.println(multiply.toString());
//        System.out.println(sum);
        System.out.println(res);
    }

    public String multiply(String num1, String num2) {
        String res = "0";
        if (num1.startsWith("0") || num2.startsWith("0")) {
            return res;
        }
        for (int i = num2.length() - 1; i >= 0; i--) {
            char a = num2.charAt(i);
            StringBuilder sum = multiply(num1, a);
            for (int j = num2.length() - i; j > 1; j--) {
                sum.append("0");
            }
            res = sumString(res, sum.toString());
        }
        return res;
    }

    /**
     * 求一位数与一个数字的乘积
     */
    public StringBuilder multiply(String num1, char a) {
        StringBuilder sb = new StringBuilder();
        int add = 0;
        for (int i = num1.length() - 1; i >= 0; i--) {
            char b = num1.charAt(i);
            int s = add + (a - '0')*(b - '0');
            add = s / 10;
            sb.append(s % 10);
        }
        if (add >= 1) {
            sb.append(add);
        }
        return sb.reverse();
    }

    /**
     * 对两个字符串数字求和
     */
    public String  sumString(String num1, String num2) {
        int i = num1.length() - 1, j = num2.length() - 1, carry = 0;
        StringBuilder res = new StringBuilder();
        while (i >= 0 || j >=0) {
            int a = i >= 0 ? num1.charAt(i) - '0' : 0;
            int b = j >= 0 ? num2.charAt(j) - '0' : 0;
            int sum = a + b + carry;
            carry = sum / 10;
            res.append(sum%10);
            i--;j--;
        }
        if (carry == 1) {
            res.append(1);
        }
        return res.reverse().toString();
    }
}
