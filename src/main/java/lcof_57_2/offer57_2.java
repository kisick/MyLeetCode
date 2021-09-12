package lcof_57_2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: gefeng
 * @created: 2021/07/01 00:20
 */
public class offer57_2 {
    public static void main(String[] args) {
        int[][] continuousSequence = new Solution().findContinuousSequence(15);
        for (int i = 0; i < continuousSequence.length; i++) {
            for (int j = 0; j < continuousSequence[i].length; j++) {
                System.out.print(continuousSequence[i][j]+" ");
            }
            System.out.println("");
        }
    }
}


/**
 * 输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
 *
 * 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
 *
 * 输入：target = 9
 * 输出：[[2,3,4],[4,5]]
 *
 * 输入：target = 15
 * 输出：[[1,2,3,4,5],[4,5,6],[7,8]]
 *
 */
class Solution {
    public int[][] findContinuousSequence(int target) {
        List<int[]> res = new ArrayList<>();
        // 本次循环的最大值，本次序列的个数
        int left = 1, right = 1;
        int sum = 0;
        while (left <= right && left < target/2+1) {
            sum += right;
            while (sum > target) {
                sum -= left;
                left ++;
            }
            // 计算从left加到right之和
            if (sum == target) {
                res.add(getSequence(left, right));
            }
            right++;
        }
        return res.toArray(new int[0][0]);
    }

    public int[] getSequence(int left, int right) {
        int[] res = new int[right-left+1];
        for (int i = 0; i < right-left+1; i++) {
            res[i] = left+i;
        }
        return res;
    }
}
