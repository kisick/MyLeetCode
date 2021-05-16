package lcof_20;

/**
 * @author: gefeng
 * @created: 2021/04/19 22:51
 */
public class offer20 {
    public static void main(String[] args) {
        String s = "3.";
        System.out.println(new Solution().isNumber(s));
    }
}

/**
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 * 例如，字符串"+100"、"5e2"、"-123"、"3.1416"、"-1E-16"、"0123"都表示数值，
 * 但"12e"、"1a3.14"、"1.2.3"、"+-5"及"12e+5.4"都不是。
 */
class Solution {
    public boolean isNumber(String s) {
        s = s.trim();
        if (s.length() == 0) {
            return false;
        }
        if (s.startsWith("-") || s.startsWith("+")) {
            s = s.substring(1);
        }
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '.') {
                return s.substring(0,i).matches("\\d*") && s.substring(i+1).matches("\\d*");
            }
            if (c == 'e' || c == 'E') {
                if (i == s.length() -1) {
                    return false;
                }
                String left = s.substring(i+1);
                if (left.startsWith("-")) {
                    left = left.substring(1);
                }
                return s.substring(0,i).matches("\\d+") && left.matches("\\d+");
            }
        }
        return s.matches("\\d+");
    }

}
