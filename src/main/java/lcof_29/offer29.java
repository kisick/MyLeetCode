package lcof_29;

/**
 * @author: gefeng
 * @created: 2021/05/09 23:31
 */
public class offer29 {
    public static void main(String[] args) {
        Solution  solution = new Solution();
        int[] ints = solution.spiralOrder(new int[][]{{1, 2, 3, 4}, {4, 5, 6,7}, {7, 8, 9, 10}});
        for (int anInt : ints) {
            System.out.print(anInt);
        }
    }
}

/**
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
 *
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 *
 * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 */
class Solution {
    public int[] spiralOrder(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new int[0];
        }
        int totalNum = matrix.length * matrix[0].length;
        int[] ans  = new int[totalNum];
        ans[0] = matrix[0][0];
        int k = 1, i = 0, j = 0;
        int width = matrix[0].length - 1, high = matrix.length - 1;
        while (k < totalNum) {
            while (k < totalNum && j < width) {
                j++;
                ans[k++] = matrix[i][j];
            }
            while (k < totalNum && i < high) {
                i++;
                ans[k++] = matrix[i][j];
            }
            while (k < totalNum && j > matrix[0].length - width -1) {
                j--;
                ans[k++] = matrix[i][j];
            }
            while (k < totalNum && i > matrix.length - high) {
                i--;
                ans[k++] = matrix[i][j];
            }
            width--;
            high--;
        }
        return ans;
    }
}
