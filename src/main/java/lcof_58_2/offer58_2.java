package lcof_58_2;

/**
 * @author: gefeng
 * @created: 2021/07/10 21:34
 */
public class offer58_2 {
    public static void main(String[] args) {
        String s = "abcdefg";
        int k = 2;
        System.out.println(new Solution().reverseLeftWords(s, k));
    }
}


/**
 * 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。
 * 请定义一个函数实现字符串左旋转操作的功能。
 * 比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。
 *
 * 输入: s = "abcdefg", k = 2
 * 输出: "cdefgab"
 *
 * 输入: s = "lrloseumgh", k = 6
 * 输出: "umghlrlose"
 *
 */
class Solution {
    public String reverseLeftWords(String s, int n) {
        return s.substring(n)+s.substring(0,n);
    }
}
