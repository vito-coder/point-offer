package com.vitoboy.leetcode;

/**
 * @Author: vito
 * @Date: 2020/6/17 18:02
 * @Version: 1.0
 *
 * 面试题04. 二维数组中的查找
 * 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 *
 *
 *
 * 示例:
 *
 * 现有矩阵 matrix 如下：
 *
 * [
 *   [1,   4,  7, 11, 15],
 *   [2,   5,  8, 12, 19],
 *   [3,   6,  9, 16, 22],
 *   [10, 13, 14, 17, 24],
 *   [18, 21, 23, 26, 30]
 * ]
 * 给定 target = 5，返回 true。
 *
 * 给定 target = 20，返回 false。
 *
 *
 *
 * 限制：
 *
 * 0 <= n <= 1000
 *
 * 0 <= m <= 1000
 *
 */
public class FindNumberIn2DArray {

    public static void main(String[] args) {


    }

    public static boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int currentCol = col -1;
        for (int i = 0; i < row; i++) {
            int val = matrix[i][currentCol];
            if ( target == val) {
                // 找到数据, 直接返回
                return true;
            } else if (target < val){
                // 如果发现 目标值 小于 定位值,
                // 判断 下一个值 与 目标值的关系
                for (int j = currentCol-1; j >= 0; j--) {
                    currentCol = j;
                    if (target == matrix[i][j]) {
                        return true;
                    } else if (target > matrix[i][j]){
                        break;
                    }
                }
                if (currentCol == 0 && target < matrix[i][currentCol]) {
                    return false;
                }
            }
            // 如果发现 目标值 大于 定位值, 到下一轮再判断

        }
        return false;

    }
}
