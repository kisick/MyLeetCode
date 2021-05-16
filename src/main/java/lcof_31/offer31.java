package lcof_31;

import java.util.Stack;

/**
 * @author: gefeng
 * @created: 2021/05/15 10:17
 */
public class offer31 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] pushed = new int[]{1,2,3,4,5};
        int[] popped = new int[]{4,3,5,2,1};
        System.out.println(solution.validateStackSequences(pushed, popped));
    }
}


/**
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。
 * 假设压入栈的所有数字均不相等。
 * 例如，序列 {1,2,3,4,5} 是某栈的压栈序列，
 * 序列 {4,5,3,2,1} 是该压栈序列对应的一个弹出序列，
 * 但 {4,3,5,1,2} 就不可能是该压栈序列的弹出序列。
 */
class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int pop_index = 0;
        for (int i = 0; i < pushed.length; i++) {
            stack.push(pushed[i]);
            while (!stack.isEmpty() && stack.peek() == popped[pop_index]) {
                stack.pop();
                if (pop_index < popped.length - 1) {
                    pop_index++;
                }
            }
        }
        return stack.isEmpty();
    }
}
