package lcof_58;

import java.util.Stack;

/**
 * @author: gefeng
 * @created: 2021/07/10 20:10
 */
public class offer58 {
    public static void main(String[] args) {
        System.out.println(new Solution().reverseWords("     the     sky is   blue     "));
    }
}


/**
 * 输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。
 * 为简单起见，标点符号和普通字母一样处理。
 * 例如输入字符串"I am a student. "，则输出"student. a am I"。
 *
 * 输入: "the sky is blue"
 * 输出: "blue is sky the"
 */
class Solution {
    public String reverseWords(String s) {
        StringBuilder res = new StringBuilder();
        // left表示单词左侧的起始位置，right表示单词右侧的起始位置
        s = s.trim();
        int j = s.length()-1;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                if (i == j) {
                    j = i-1;
                    continue;
                }
                res.append(s, i+1, j+1);
                if (i > 0) {
                    res.append(' ');
                }
                j = i-1;
            }
        }
        res.append(s, 0, j+1);
        return res.toString();
    }
}
