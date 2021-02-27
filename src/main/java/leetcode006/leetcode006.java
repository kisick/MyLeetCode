package leetcode006;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: gefeng
 * @created: 2020/12/23 19:16
 */
public class leetcode006 {
    public static void main(String[] args) {
        //  s = "LEETCODEISHIRING", numRows = 3
        String s = "LEETCODEISHIRING";
        int numRows = 3;
        String convert = Solution.convert(s, numRows);
        System.out.println(convert);
    }
}


class Solution {
    public static String convert(String s, int numRows) {
        if (numRows <= 1) return s;
        List<StringBuilder> sbList = new ArrayList<>();
        for (int i = 0; i < Math.min(numRows,s.length()); i++) {
            sbList.add(new StringBuilder());
        }
        boolean goingDown = false;
        int index = 0;
        for (char c : s.toCharArray()) {
            if ( index == 0 || (index+1)%numRows == 0) {
                // 碰到顶或者底需要掉头
                goingDown = !goingDown;
            }
            sbList.get(index).append(c);
            index = goingDown?++index:--index;
        }
        StringBuilder res = new StringBuilder();
        sbList.forEach((b)->res.append(b));
        return res.toString();
    }
}
