package leetcode017;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: gefeng
 * @created: 2021/02/12 18:51
 */
public class leetcode017 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.letterCombinations("2"));
    }
}

/**
 * 给定一个仅包含数字2-9的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 * 示例 1：
 *
 * 输入：digits = "23"
 * 输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
 */
class Solution {
    public String[] map = new String[]{"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public List<String> result = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        if ("".equals(digits)) {
            return new ArrayList<>();
        }
        dfs(0,digits, new StringBuffer());
        return result;
    }
    public void dfs(int index, String digits, StringBuffer singleAns) {
        // 退出条件
        if (singleAns.length() == digits.length()) {
            result.add(singleAns.toString());
            return;
        }
        // 判断当前的数字，将当前数字的某种可能选择
        // 做选择
        String s = map[digits.charAt(index) - '2'];
        for (int i = 0; i < s.length(); i++) {
            singleAns.append(s.charAt(i));
            dfs(index + 1, digits, singleAns);
            singleAns.deleteCharAt(singleAns.length()-1);
        }
    }
}

