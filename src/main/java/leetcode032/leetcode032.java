package leetcode032;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author: gefeng
 * @created: 2021/01/01 20:12
 */
public class leetcode032 {
    public static void main(String[] args) {
        int i = new Solution().longestValidParentheses("(())");
        System.out.printf(String.valueOf(i));
    }
}


/**
 * 给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
 *
 * 输入: "(()"
 * 输出: 2
 * 解释: 最长有效括号子串为 "()"
 *
 * 输入: ")()())"
 * 输出: 4
 * 解释: 最长有效括号子串为 "()()"
 *
 * 输入: "()(())"
 *  * 输出: 6
 *  * 解释: 最长有效括号子串为 "()(())"
 */
class Solution {
    public  int longestValidParentheses(String s) {
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        // 栈底始终维护，最后一个未匹配的 )
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    // 表示刚才弹出的那个数据，是) 而不是 (
                    // 所以当前的 ) 没有匹配到 (
                    // 需要开启下一次查找
                    stack.push(i);
                } else {
                    // 当前的 ) 匹配到了 (
                    // 有效长度为 当前位置-最开始的( 的前一个位置
                    res = Math.max(res, i - stack.peek());
                }
            }
        }
        return res;
    }
}
