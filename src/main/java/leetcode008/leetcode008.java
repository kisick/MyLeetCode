package leetcode008;

/**
 * @author: gefeng
 * @created: 2020/12/24 01:02
 */
public class leetcode008 {
    public static void main(String[] args) {
        String s = " ";
        int i = Solution.myAtoi(s);
        System.out.println(i);
    }
}

class Solution {
    public static int myAtoi(String s) {
        if (s == null || s.equals("")) {
            return 0;
        }
        String ts = s.trim();
        if (ts == null || ts.equals("")) {
            return 0;
        }
        int k = 0;
        boolean isNegative = false;
        if (ts.charAt(0) == 45) {
            // 如果是复数
            isNegative = true;
            ts = ts.substring(1);
        } else if (ts.charAt(0) == 43) {
            isNegative = false;
            ts = ts.substring(1);
        }
        for (int i = 0; i < ts.length(); i++) {
            if (ts.charAt(i) <= 57 && ts.charAt(i) >= 48) {
                k++;
            } else {
                break;
            }
        }
        if (k>0) {
            String substring = ts.substring(0, k);
            try {
                Integer integer = Integer.valueOf(substring);
                return isNegative?-integer:integer;
            } catch (NumberFormatException e) {
                return isNegative?Integer.MIN_VALUE:Integer.MAX_VALUE;
            }
        }
        return 0;
    }
}
