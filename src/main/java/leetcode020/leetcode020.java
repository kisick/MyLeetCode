package leetcode020;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author: gefeng
 * @created: 2021/02/27 21:23
 */
public class leetcode020 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "([)]";
        System.out.println(solution.isValid(s));
    }
}

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']'的字符串 s ，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 *
 */
class Solution {
    static Map<Character, Character> map = new HashMap<Character, Character>(){{
            put('(', ')');
            put('[', ']');
            put('{', '}');
    }};

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack();
        for (int i = 0; i < s.length(); i++) {
            if (!stack.isEmpty()
                    && map.get(stack.peek()) != null
                    && map.get(stack.peek()) == s.charAt(i)
            ) {
                stack.pop();
            } else {
                stack.push(s.charAt(i));
            }
        }
        return stack.isEmpty();
    }
}
