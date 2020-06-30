package com.vitoboy.leetcode;

import java.util.Arrays;

/**
 * @Author: vito
 * @Date: 2020/6/30 12:38
 * @Version: 1.0
 * <p>
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 * 示例 2：
 * <p>
 * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 *  
 * <p>
 * 限制：
 * <p>
 * 0 <= matrix.length <= 100
 * 0 <= matrix[i].length <= 100
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shun-shi-zhen-da-yin-ju-zhen-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class XXVII_SpiralOrder {
    public static void main(String[] args) {
        XXVII_SpiralOrder spiralOrder = new XXVII_SpiralOrder();
        int[][] matrix = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] test = new int[][]{};
        System.out.println(Arrays.toString(spiralOrder.spiralOrder(test)));
    }

    /**
     * 打印二维数组
     *
     * @param matrix
     * @return
     */
    public int[] spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return null;
        if (matrix.length == 1) return matrix[0];
        int row = matrix.length, col = matrix[0].length;
        boolean[][] check = new boolean[row][col];
        int[] print = new int[row * col];
        int i = 0, j = 0, k = 0, path = 0;
        while (k < print.length) {
            print[k] = matrix[i][j];
            k++;
            if (k == print.length) break;
            check[i][j] = true;
            switch (path) {
                case 0:
                    if (j < col - 1 && !check[i][j + 1]) {
                        j++;
                        break;
                    } else {
                        path = 1;
                    }
                case 1:
                    if (i < row - 1 && !check[i + 1][j]) {
                        i++;
                        break;
                    } else {
                        path = 2;
                    }
                case 2:
                    if (j > 0 && !check[i][j - 1]) {
                        j--;
                        break;
                    } else {
                        path = 3;
                    }
                case 3:
                    if (i > 0 && !check[i - 1][j]) {
                        i--;
                        break;
                    } else {
                        path = 0;
                        if (j < col - 1 && !check[i][j + 1]) {
                            j++;
                            break;
                        } else {
                            path = 1;
                        }
                    }
            }
        }
        return print;
    }

}
