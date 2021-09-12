package lcof_49;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * @author: gefeng
 * @created: 2021/06/13 14:35
 */
public class offer49 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 10;
        System.out.println(solution.nthUglyNumber(n));
    }
}

/**
 * 我们把只包含质因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数。
 *
 * 输入: n = 10
 * 输出: 12
 * 解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。
 *
 * 说明:
 * 1 是丑数。
 * n 不超过1690。
 */
class Solution {
    public int nthUglyNumber(int n) {
        // 如果一个数，因式分解后只包含 2 3 5 则满足条件
        // 求第10个丑数
        PriorityQueue<Long> priorityQueue = new PriorityQueue<>();
        Set<Long> set = new HashSet<>();
        priorityQueue.add(1L);
        while (n > 1) {
            Long poll = priorityQueue.poll();
            n--;
            if (set.add(poll*2)) {
                priorityQueue.add(poll*2);
            }
            if (set.add(poll*3)) {
                priorityQueue.add(poll*3);
            }
            if (set.add(poll*5)) {
                priorityQueue.add(poll*5);
            }
        }
        return Math.toIntExact(priorityQueue.peek());
    }
}
