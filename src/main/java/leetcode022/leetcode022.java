package leetcode022;

import java.util.*;

/**
 * @author: gefeng
 * @created: 2021/02/28 18:12
 */
public class leetcode022 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 3;
        System.out.println(solution.generateParenthesis(n).toString());
    }
}

/**
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * 输入：n = 3
 * 输出：["((()))","(()())","(())()","()(())","()()()"]
 */
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        dfs(0, 0, n, new StringBuilder(), result);
        return result;
    }

    /**
     * dfs的关键在于确定入参和调用之后该怎么回溯
     * @param left 左括号的个数
     * @param right 有括号的个数
     * @param n 括号对数
     * @param oneAns 一个答案
     * @param result 结果集
     */
    private void dfs(int left, int right, int n, StringBuilder oneAns, List<String> result) {
        if (left == n && right == n) {
            result.add(oneAns.toString());
        } else {
            if (left < n) {
                oneAns.append("(");
                dfs(left+1, right, n, oneAns, result);
                oneAns.deleteCharAt(oneAns.length()-1);
            }
            if (right < n && right < left) {
                oneAns.append(")");
                dfs(left, right+1, n, oneAns, result);
                oneAns.deleteCharAt(oneAns.length()-1);
            }
        }
    }
}
