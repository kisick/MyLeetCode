package lcof_46;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: gefeng
 * @created: 2021/06/12 19:35
 */
public class offer46 {
    public static void main(String[] args) {
        int num = 12258;
        Solution solution = new Solution();
        System.out.println(solution.translateNum(num));
    }
}


/**
 * 给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。
 * 一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
 *
 * 输入: 12258
 * 输出: 5
 * 解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi"
 */
class Solution {
    int ans = 0;
    public int translateNum(int num) {
        // nums[i-1]nums[i] > 25 ? nums[i] -> 1 :
        // 从最后一位往前遍历，如果第j位和第j-1位组成的数字
        // 大于25 则开启下一次循环 j位只有一种方案
        // 小于等于25 开启两个分支 j位作为一个方案，j和j-1一起作为一种方案
        // 怎么记录方案？如果每一位都只有一种方案，把每一位上的方案相乘即可
        cul(num);
        return ans;
    }

    public void cul(int num) {
        if (num < 9) {
            ans++;
            return;
        }
        if (num%100 <= 25 && num%100 >= 10) {
            cul(num/100);
            cul(num/10);
        } else {
            cul(num/10);
        }
    }

}
