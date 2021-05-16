package lcof_17;

import java.util.Arrays;

/**
 * @author: gefeng
 * @created: 2021/04/17 18:51
 */
public class offer17 {
    public static void main(String[] args) {
        int n = 3;
        int[] res = new Solution().printNumbers(n);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i]);
        }
    }
}

/**
 * 输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。
 *
 * 示例 1:
 *
 * 输入: n = 1
 * 输出: [1,2,3,4,5,6,7,8,9]
 *
 */
class Solution {
    public int[] printNumbers(int n) {
        int length = 1;
        while (n != 0) {
            length *= 10;
            n--;
        }
        int[] res = new int[length-1];
        for (int i = 1; i < length; i++) {
            res[i-1] = i;
        }
        return res;
    }
}
