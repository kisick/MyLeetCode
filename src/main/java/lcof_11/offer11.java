package lcof_11;

/**
 *@author: gefeng
 *@created: 2021/04/11 16:28
 */
public class offer11 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] a = new int[]{1,2,3};
        System.out.println(solution.minArray(a));
    }
}


/**
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如，数组[3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。
 *
 *
 * 示例 1：
 * 输入：[3,4,5,1,2]
 * 输出：1
 *
 * 示例 2：
 * 输入：[2,2,2,0,1]
 *
 * [1,2,3]
 * [3,1,3]
 * 输出：0
 */
class Solution {
    public int minArray(int[] numbers) {
        int tail = numbers.length - 1;
        while (tail > 0) {
            if (numbers[tail] < numbers[tail-1] && (tail == numbers.length-1 || numbers[tail] <= numbers[tail+1])) {
                return numbers[tail];
            }
            tail--;
        }
        return numbers[0];
    }
}
