package lcof_56;

import java.util.Arrays;
import java.util.HashSet;
import java.util.stream.Collectors;

/**
 * @author: gefeng
 * @created: 2021/06/23 23:29
 */
public class offer56 {
    public static void main(String[] args) {
        int[] nums = new int[]{4,1,4,6};
        int[] ints = new Solution().singleNumbers(nums);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]+" ");
        }
    }
}


/**
 * 一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。
 * 请写程序找出这两个只出现一次的数字。
 * 要求时间复杂度是O(n)，空间复杂度是O(1)。
 *
 * 输入：nums = [4,1,4,6]
 * 输出：[1,6] 或 [6,1]
 */
class Solution {
    public int[] singleNumbers(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res = res ^ nums[i];
        }
        int div = 1;
        while ((res & div) == 0) {
            // 找到一个res为1的位置
            div = div << 1;
        }
        int a = 0, b = 0 ;

        for(int num: nums) {
            if((num & div) != 0) {
                //  当 num & m != 0
                a ^= num;
            }
            else {
                b ^= num;
            }
        }
        return new int[] {a, b};
    }
}
