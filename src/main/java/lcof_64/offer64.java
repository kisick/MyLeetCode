package lcof_64;

/**
 * @author: gefeng
 * @created: 2021/07/22 21:13
 */
public class offer64 {
    public static void main(String[] args) {
        System.out.println(new Solution().sumNums(9));
    }
}

/**·
 * 求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 *
 * 输入: n = 3
 * 输出: 6
 *
 * 输入: n = 9
 * 输出: 45
 */
class Solution {
    public int sumNums(int n) {
        boolean flag = n > 0 && (n += sumNums(n-1)) > 0;
        return n;
    }
}
