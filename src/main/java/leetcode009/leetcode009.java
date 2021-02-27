package leetcode009;

/**
 * @author: gefeng
 * @created: 2020/12/25 23:26
 */
public class leetcode009 {
    public static void main(String[] args) {
        int x = 10;
        System.out.println(Solution.isPalindrome(x));
    }
}

class Solution {
    public static boolean isPalindrome(int x) {
        if (x < 0 || (x%10==0 && x!=0)) {
            return false;
        }
        int high = x;
        int low = 0;
        // 反转最后half位，将得到的结果与前half位比较
        while (high>low) {
            low = low*10 + high%10;
            high = (high/10);
        }
        return low==high || low/10==high;
    }
}
