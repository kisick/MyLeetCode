package lcof_59;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author: gefeng
 * @created: 2021/07/11 00:30
 */
public class offer59 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,3,3,-3,5,3,6,7};
//        int[] nums = new int[]{1,-1};
        int k = 3;
        int[] ints = new Solution().maxSlidingWindow(nums, k);
        for (int anInt : ints) {
            System.out.print(anInt+" ");
        }
    }
}

/**
 * 给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。
 *
 * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
 * 输出: [3,3,5,5,6,7]
 * 解释:
 *
 *   滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 *
 */
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0) {
            return new int[0];
        }
        int[] res = new int[nums.length-(k-1)];
        // 最大值保存在头部
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            if (i >= k && !deque.isEmpty() && deque.peek() == nums[i-k]) {
                deque.pollFirst();
            }
            while (!deque.isEmpty() && deque.getLast() < nums[i]) {
                deque.pollLast();
            }
            deque.addLast(nums[i]);
            if (i+1 >= k) {
                res[i+1-k] = deque.peek();
            }
        }
        return res;
    }
}
