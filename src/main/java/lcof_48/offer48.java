package lcof_48;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author: gefeng
 * @created: 2021/06/13 11:14
 */
public class offer48 {
    public static void main(String[] args) {
        String s = "abcabcbb";
        Solution solution = new Solution();
        System.out.println(solution.lengthOfLongestSubstring(s));
    }
}


/**
 * 请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 *
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 *
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是"wke"，所以其长度为 3。
 * 请注意，你的答案必须是 子串 的长度，"pwke"是一个子序列，不是子串。
 */
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0,right = 0;
        int max = 0;
        HashSet<Character> set = new HashSet<>();
        while (right < s.length()) {
            // 如果该字符不存在
            if (set.add(s.charAt(right))) {
                right++;
                if (set.size() > max) {
                    max = set.size();
                }
            } else {
                // 该字符已存在，右移左指针
                set.remove(s.charAt(left));
                left++;
            }
        }
        return max;
    }
}
