package leetcode003;

import java.util.HashSet;

/**
 * @author: gefeng
 * @created: 2020/12/17 17:24
 * 给定一个字符串，请你找出其中不含有重复字符的最长子串的长度。
 *
 * 示例1:
 *
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 *
 * 示例 2:
 *
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 *
 * 示例 3:
 *
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是"wke"，所以其长度为 3。
 *    请注意，你的答案必须是 子串 的长度，"pwke"是一个子序列，不是子串。
 *
 * 0 <= s.length <= 5 * 104
 * s 由英文字母、数字、符号和空格组成
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class leetcode003 {
    public static void main(String[] args) {
        String s = "pwwkew";
        System.out.println(Solution.lengthOfLongestSubstring(s));
    }
}

class Solution {
    public static int lengthOfLongestSubstring(String s) {
        // 每个无重复字符串的 子串 一定也是无重复的
        char[] chars = s.toCharArray();
        HashSet<Integer> hashSet = new HashSet<>(128);
        int n = chars.length;
        int rk = -1;
        int max_length = 0;
        // 假设从i位到j位中的最长无重复子串的 结束位置为rk
        // 则从i到j+1 的rk1 一定大于rk
        // i从0开始递增，j从i开始递增，当找到一个重复字符时
        // 在j的循环里面判断，chars[j] 是否与之前的字符重复，若不重复，j++ rk++，若重复 则i++ 开始下一次循环
        // 怎么判断是否与之前的字符串重复？应该是从i开始到rk结束的字符串 设置一个
        // 如果i到rk是一个无重复的字符串，则i+1到rk一定也是一个无重复的字符串
        for (int i = 0; i < n; i++) {
            if (i!=0) {
                hashSet.remove((int)chars[i-1]);
            }
            for (int j = rk+1; j < n; j++) {
                if (!hashSet.contains((int)chars[j])) {
                    hashSet.add((int)chars[j]);
                    rk++;
                } else {
                    break;
                }
            }
            max_length = (rk-i+1) > max_length ? (rk-i+1): max_length;
        }
        return max_length;
    }
}

/**
 *         Set<Character> occ = new HashSet<Character>();
 *         int n = s.length();
 *         // 右指针，初始值为 -1，相当于我们在字符串的左边界的左侧，还没有开始移动
 *         int rk = -1, ans = 0;
 *         for (int i = 0; i < n; ++i) {
 *             if (i != 0) {
 *                 // 左指针向右移动一格，移除一个字符
 *                 occ.remove(s.charAt(i - 1));
 *             }
 *             while (rk + 1 < n && !occ.contains(s.charAt(rk + 1))) {
 *                 // 不断地移动右指针
 *                 occ.add(s.charAt(rk + 1));
 *                 ++rk;
 *             }
 *             // 第 i 到 rk 个字符是一个极长的无重复字符子串
 *             ans = Math.max(ans, rk - i + 1);
 *         }
 *         return ans;
 */
