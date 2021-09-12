package lcof_38;

import java.util.HashSet;

/**
 * @author: gefeng
 * @created: 2021/05/31 21:52
 */
public class offer38 {
    public static void main(String[] args) {
        String s = "abca";
        Solution solution = new Solution();
        String[] permutation = solution.permutation(s);
        for (int i = 0; i < permutation.length; i++) {
            System.out.println(permutation[i]);
        }
    }
}


/**
 * 输入一个字符串，打印出该字符串中字符的所有排列。
 * 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
 *
 * 输入：s = "abc"
 * 输出：["abc","acb","bac","bca","cab","cba"]
 */
class Solution {
    /*HashSet<String> res = new HashSet<>();
    char[] chars;
    public String[] permutation(String s) {
        if (s == null || s.length() < 1) {
            return new String[0];
        }
        chars = s.toCharArray();
        dfs("");
        return res.toArray(new String[0]);
    }

    *//**
     * 每次从char[] 数组中挑选出一个没有用过的字符，直到所有字符都被用过
     * @param cur
     *//*
    public void dfs(String cur) {
        if (cur.length() == chars.length) {
            res.add(cur);
            return;
        }
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != ' ') {
                char curChar = chars[i];
                chars[i] = ' ';
                dfs(cur+curChar);
                chars[i] = curChar;
            }
        }
    }*/

    HashSet<String> res = new HashSet<>();
    public String[] permutation(String s) {
        dfs(new StringBuilder(s), new StringBuilder());
        String[] ans = new String[res.size()];
        res.toArray(ans);
        return ans;
    }
    public void dfs(StringBuilder s, StringBuilder curStr) {
        if (curStr.length() == s.length()) {
            res.add(new String(curStr));
            return;
        }
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) != ' ') {
                char curChar = s.charAt(i);
                curStr.append(curChar);
                s.setCharAt(i,' ');
                dfs(s, curStr);
                s.setCharAt(i,curChar);
                curStr.deleteCharAt(curStr.length()-1);
            }
        }
    }
}
