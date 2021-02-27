package leetcode011;

/**
 * @author: gefeng
 * @created: 2021/01/16 18:56
 */
public class leetcode011 {
    public static void main(String[] args) {
        int[] a = {1,2,1};
        System.out.println(Solution.maxArea(a));
    }
}

/**
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点(i,ai)。
 * 在坐标内画 n 条垂直线，垂直线 i的两个端点分别为(i,ai) 和 (i, 0) 。
 * 找出其中的两条线，使得它们与x轴共同构成的容器可以容纳最多的水。
 *
 * 说明：你不能倾斜容器。
 *
 * 输入：[1,8,6,2,5,4,8,3,7]
 * 输出：49
 * 解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。
 * 在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为49。
 * [2,8] [9,7] = 7 * 7 = 49
 *
 * 解法：双指针
 */
class Solution {
    public static int maxArea(int[] height) {
        int area = 0;
        if (height == null) {
            return 0;
        }
        int i = 0;
        int j = height.length - 1;
        while (i < j) {
            int length = Math.min(height[i], height[j]);
            int width = j-i;
            area = Math.max(area,width*length);
            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }
        return area;
    }
}
