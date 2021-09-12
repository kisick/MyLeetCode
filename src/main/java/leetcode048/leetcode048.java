package leetcode048;

import common.Print;

/**
 * @author: gefeng
 * @created: 2021/09/01 23:35
 */
public class leetcode048 {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        new Solution().rotate(matrix);
        Print.printArray(matrix);
    }
}

/**
 * 给定一个 n×n 的二维矩阵matrix 表示一个图像。请你将图像顺时针旋转 90 度。
 *
 * 你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。
 *
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[[7,4,1],[8,5,2],[9,6,3]]
 *
 * 输入：matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
 * 输出：[[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
 *
 * 输入：matrix = [[1]]
 * 输出：[[1]]
 *
 * 输入：matrix = [[1,2],[3,4]]
 * 输出：[[3,1],[4,2]]
 */
class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                int temp = matrix[j][n-1];
                matrix[j][n-i] = matrix[i][j];
                // j,n-1

            }
        }
    }
}
