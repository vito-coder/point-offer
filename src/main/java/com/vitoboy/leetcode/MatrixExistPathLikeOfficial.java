package com.vitoboy.leetcode;

/**
 * @Author: vito
 * @Date: 2020/6/26 16:28
 * @Version: 1.0
 *
 * <p>
 * 剑指 Offer 12. 矩阵中的路径
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
 * 路径可以从矩阵中的任意一格开始，每一步可以在矩阵中向左、右、上、下移动一格。
 * 如果一条路径经过了矩阵的某一格，那么该路径不能再次进入该格子。
 * 例如，在下面的3×4的矩阵中包含一条字符串“bfce”的路径（路径中的字母用加粗标出）。
 * <p>
 * [["a","_b_","c","e"],
 * ["s","_f_","_c_","s"],
 * ["a","d","_e_","e"]]
 * <p>
 * 但矩阵中不包含字符串“abfb”的路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入这个格子。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：board = [["A","B","C","E"],
 * ["S","F","C","S"],
 * ["A","D","E","E"]], word = "ABCCED"
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：board = [["a","b"],
 * ["c","d"]], word = "abcd"
 * 输出：false
 * 提示：
 * <p>
 * 1 <= board.length <= 200
 * 1 <= board[i].length <= 200
 */
public class MatrixExistPathLikeOfficial {

    public static void main(String[] args) {
        String word = "ABCCED";
        char[][] board = new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        String word1 = "abcd";
        char[][] board1 = new char[][]{{'a', 'b'}, {'c', 'd'}};
        String word2 = "ba";
        char[][] board2 = new char[][]{{'a', 'b'}};
        System.out.println(exist(board, word));

        System.out.println(exist(board1, word1));
        System.out.println(exist(board2, word2));
    }

    public static boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(i, j, board, 0, word.toCharArray())) return true;
            }
        }
        return false;
    }

    /**
     * solution the problem by myself
     *
     * @param i
     * @param j
     * @param board
     * @param k
     * @param words
     * @return
     */
    public static boolean dfs(int i, int j, char[][] board, int k, char[] words) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || k < 0 ) return false;
        if (k == words.length) return true;
        if (board[i][j] == words[k]) {
            char temp = board[i][j];
            board[i][j] = '/';
            boolean result = dfs(i - 1, j, board, k + 1, words)
                    || dfs(i, j - 1, board, k + 1, words)
                    || dfs(i + 1, j, board, k + 1, words)
                    || dfs(i, j + 1, board, k + 1, words);
            board[i][j] = temp;
            return result;
        } else {
            return false;
        }
    }


    // official solution this problem
    public static boolean dfs(char[][] board, char[] word, int i, int j, int k) {
        if(i >= board.length || i < 0 || j >= board[0].length || j < 0 || board[i][j] != word[k]) return false;
        if(k == word.length - 1) return true;
        char tmp = board[i][j];
        board[i][j] = '/';
        boolean res = dfs(board, word, i + 1, j, k + 1) || dfs(board, word, i - 1, j, k + 1) ||
                dfs(board, word, i, j + 1, k + 1) || dfs(board, word, i , j - 1, k + 1);
        board[i][j] = tmp;
        return res;
    }
}
