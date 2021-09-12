package lcof_50;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author: gefeng
 * @created: 2021/06/13 19:48
 */
public class offer50 {
    public static void main(String[] args) {
        String s = "abaccdeff";
        Solution solution = new Solution();
        System.out.println(solution.firstUniqChar(s));
    }
}
/**
 * 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
 *
 * s = "abaccdeff"
 * 返回 "b"
 *
 * s = ""
 * 返回 " "
 */
class Solution {
    public char firstUniqChar(String s) {
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (count[s.charAt(i) - 'a'] == 1) {
                return s.charAt(i);
            }
        }
        return ' ';
    }
}
