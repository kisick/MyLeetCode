package lcof_56_2;

/**
 * @author: gefeng
 * @created: 2021/06/30 23:41
 */
public class offer56_2 {
    public static void main(String[] args) {
        int[] nums = new int[]{4,1,4,6};
        System.out.println(new Solution().singleNumber(nums));
    }
}


/**
 * 在一个数组 nums 中除一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字。
 * 输入：nums = [3,4,3,3]
 * 输出：4
 */
class Solution {
    public int singleNumber(int[] nums) {
        // 异或 相同为0 不同为1 3^3 = 0 3^0 = 3
        // 同或 相同为1 不同为0 3^3^1 = 3 3^1^1 = 3

        // 状态机
        return 0;
    }
}
