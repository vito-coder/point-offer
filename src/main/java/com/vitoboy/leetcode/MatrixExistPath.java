package com.vitoboy.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @Author: vito
 * @Date: 2020/6/19 18:06
 * @Version: 1.0
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
public class MatrixExistPath {

    public static void main(String[] args) {
        String word = "ABCCED";
        char[][] board = new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        String word1 = "abcd";
        char[][] board1 = new char[][]{{'a', 'b'},{ 'c', 'd'}};
        String word2 = "ba";
        char[][] board2 = new char[][]{{'a', 'b'}};
        System.out.println(exist(board, word));

        System.out.println(exist(board1, word1));
        System.out.println(exist(board2, word2));

    }

    /**
     * 判断一个字符串是否在一个二维字符数组是否存在路径
     * <p>
     * 1.取字符串的第 i (0<=i<l, l表示字符串的长度)个字符, 检查这个字符是否在二组字符数组里的第 j 行, k 列
     * (0<=j<n, 0<=k<m, n,m分别为字符数组的列长度--多少行, 和行长度--多少列)
     * 2.存在, 将路径字符位置信息存放到path栈里(位置(j,k), 方向(0,1,2,3,-1), 前一个位置的方向(0,1,2,3,-1), 字符, 字符在字符串里的位置index)
     * i < l ? 执行2.1 : 执行6
     * 2.1.取第 i+1 个字符, 在第 i 个字符存在的位置(j,k)周围[(j,k-1),(j-1,k),(j,k+1),(j+1,k)]依次判断是否有相同的字符
     * 有相同的字符, 执行第2步.
     * 没有相同的字符, 执行2.2.
     * 2.2. path栈pop()一个路径点
     * 判断路径点里的"前一个位置的方向"是否等于3, 是, 执行2.2.
     * 判断路径点里的"前一个位置的方向"是否等于-1, 是, 执行3.
     * 其它情况, 执行2.1(检查的方向是有顺序的, 方向, 出发点: -1, 左:0, 上:1, 右:2, 下:3)
     * 3.不存在, 检查字符是否在二组字符数组里的第 j 行, k+1 列(当 k+1 = m时, j=j+1, k=0, 继续执行) (0<=j<n, 0<=k<m)
     * 4 存在, 执行第2步,
     * 不存在, 执行第3步.
     * 5.直到检查j = n-1, k= m-1, 执行6.1
     * 6.返回真
     * 6.1返回假
     *
     * @param board
     * @param word
     * @return
     */
    public static boolean exist(char[][] board, String word) {
        if (word == null || word.length() == 0) return false;
        if (board == null || board.length == 0 || board[0].length == 0) return false;
        char[] chwd = word.toCharArray();
        Stack<PathPoint> path = new Stack<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                int index = 0;
                if (chwd[index] == board[i][j]) {
                    PathPoint point = new PathPoint(i, j, -1, -1, chwd[index], index);
                    int[][] checkPoint = new int[board.length][board[0].length];
                    checkPoint[i][j] = 1;
                    while (index < word.length()  && point != null) {
                        PathPoint pathPoint = findNextPoint(point, board, checkPoint, chwd);
                        if (pathPoint != null) {
                            index++;
                            if (index == word.length()) {
                                return true;
                            }
                            path.push(point);
                            checkPoint[point.row][point.cow] = 1;
                            point = pathPoint;
                        } else {
                            index--;
                            checkPoint[point.row][point.cow] = 0;
                            if (path.isEmpty()) {
                                point = null;
                            } else {
                                point = path.pop();
                            }
                        }
                    }
                }
            }
        }
        return false;
    }


    public static PathPoint findNextPoint(PathPoint prePoint, char[][] board, int[][] checkPoint, char[] word) {
        PathPoint point = new PathPoint();
        if (prePoint.index == word.length - 1) {
            if (prePoint.value == word[prePoint.index]) return prePoint;
            else return null;
        }
        point.value = word[prePoint.index + 1];
        point.index = prePoint.index + 1;
        point.way = -1;
        switch (prePoint.way) {
            case -1:
                // 计算左边方向的路径点是否符合
                if (prePoint.cow > 0 && checkPoint[prePoint.row][prePoint.cow - 1] < 1 && prePoint.preWay != 2) {
                    if (point.value == board[prePoint.row][prePoint.cow - 1]) {
                        point.row = prePoint.row;
                        point.cow = prePoint.cow-1;
                        prePoint.way = 0;
                        point.preWay = 0;
                        break;
                    }
                }
            case 0:
                // 计算上边方向的路径点是否符合
                if (prePoint.row > 0 && checkPoint[prePoint.row - 1][prePoint.cow] < 1 && prePoint.preWay != 3) {
                    if (point.value == board[prePoint.row - 1][prePoint.cow]) {
                        point.row = prePoint.row - 1;
                        point.cow = prePoint.cow;
                        prePoint.way = 1;
                        point.preWay = 1;
                        break;
                    }
                }
            case 1:
                // 计算右边方向的路径点是否符合
                if (prePoint.cow < board[0].length - 1 && checkPoint[prePoint.row][prePoint.cow + 1] < 1 && prePoint.preWay != 0) {
                    if (point.value == board[prePoint.row][prePoint.cow + 1]) {
                        point.row = prePoint.row;
                        point.cow = prePoint.cow + 1;
                        prePoint.way = 2;
                        point.preWay = 2;
                        break;
                    }
                }
            case 2:
                // 计算下边方向的路径点是否符合
                if (prePoint.row < board.length - 1 && checkPoint[prePoint.row + 1][prePoint.cow] < 1 && prePoint.preWay != 1) {
                    if (point.value == board[prePoint.row + 1][prePoint.cow]) {
                        point.row = prePoint.row + 1;
                        point.cow = prePoint.cow ;
                        prePoint.way = 3;
                        point.preWay = 3;
                        break;
                    }
                }
            case 3:
                return null;
        }
        return point;
    }

}


class PathPoint {
    // 行号
    int row;
    // 列号
    int cow;
    // 方向, 出发点: -1, 左:0, 上:1, 右:2, 下:3
    int way;
    // 前一个路径点的方向
    int preWay;
    // 值
    char value;
    // 字符的下标
    int index;

    public PathPoint() {
    }

    public PathPoint(int row, int cow, int way, int preWay, char value, int index) {
        this.row = row;
        this.cow = cow;
        this.way = way;
        this.preWay = preWay;
        this.value = value;
        this.index = index;
    }

}
