package lcof_12;

/**
 * @author: gefeng
 * @created: 2021/03/17 22:51
 */
public class offer12 {
    public static void main(String[] args) {
        Solution solution = new Solution();
//        char[][] board = new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
//        String word = "ABCCED";
        char[][] board = new char[][]{{'A'},{'A'}};
        String word = "AAA";
        System.out.println(solution.exist(board, word));
    }
}

/**
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
 * 路径可以从矩阵中的任意一格开始，每一步可以在矩阵中向左、右、上、下移动一格。如果一条路径经过了矩阵的某一格，那么该路径不能再次进入该格子。
 * 例如，在下面的3×4的矩阵中包含一条字符串“bfce”的路径（路径中的字母用加粗标出）。
 *
 * [["a","b","c","e"],
 * ["s","f","c","s"],
 * ["a","d","e","e"]]
 *
 * 但矩阵中不包含字符串“abfb”的路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入这个格子。
 *
 */
class Solution {
    // 需要记录已经走过的路径, true表示该格子已经走过
    boolean[][] passed;

    public boolean exist(char[][] board, String word) {
        passed = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(i, j, 0, word, board)) {
                    return true;
                }
            }
        }
        return false;
    }

    // dfs 入参 index表示word字符串移动到了第几位，初始值index=0;
    // i表示现在位于第i行，j表示现在位与第j列
    public boolean dfs(int i, int j, int index, String word, char[][] board) {
        // 退出条件
        if (i < 0 || i > board.length - 1 || j < 0 || j > board[0].length-1
                || passed[i][j] ||  board[i][j] != word.charAt(index)) {
            return false;
        }
        if (index == word.length() - 1) {
            return true;
        }
        passed[i][j] = true;
        if (dfs(i - 1, j, index + 1, word, board)
                || dfs(i + 1, j, index + 1, word, board)
                || dfs(i, j - 1, index + 1, word, board)
                || dfs(i, j + 1, index + 1, word, board)) {
            return true;
        }
        passed[i][j] = false;
        return false;
    }
}
