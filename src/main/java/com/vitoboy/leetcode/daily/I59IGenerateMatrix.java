package com.vitoboy.leetcode.daily;

import javax.script.ScriptEngine;
import java.util.Arrays;

/**
 *给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。 
 *
 * 
 *
 * 示例 1： 
 *
 * 
 *输入：n = 3
 *输出：[[1,2,3],[8,9,4],[7,6,5]]
 * 
 *
 * 示例 2： 
 *
 * 
 *输入：n = 1
 *输出：[[1]]
 * 
 *
 * 
 *
 * 提示： 
 *
 * 
 * 1 <= n <= 20 
 * 
 * Related Topics 数组 
 * 👍 383 👎 0
 * 
 * @Author: vito
 * @Date: 2021/3/17 下午1:48
 * @Version: 1.0
 */
public class I59IGenerateMatrix {
    public static void main(String[] args) {
        IGenerateMatrix generateMatrix = new GenerateMatrixII();
        int[][] result = generateMatrix.generateMatrix(3);
        System.out.println("result: \n" );
        for (int[] ints : result) {
            System.out.println(Arrays.toString(ints));
        }

    }

    interface IGenerateMatrix {
        int[][] generateMatrix(int n) ;
    }

    static class GenerateMatrixII implements IGenerateMatrix {

        @Override
        public int[][] generateMatrix(int n) {
            int[][] result = new int[n][n];
            int left = 0, right = n-1, top = 0, down = n-1;
            int num = 1;
            int end = n*n;
            while (num <= end) {
                for (int i=left; i <= right ; i++) result[top][i] = num++;    // left to right
                top++;
                for (int i=top; i<=down; i++ ) result[i][right] = num++;    // top to down
                right--;
                for (int i=right; i >= left; i-- ) result[down][i] = num++;    // right to left
                down--;
                for (int i=down; i >= top; i-- ) result[i][left] = num++;    // down to top
                left++;
            }
            return result;
        }
    }

    /**
     * 				解答成功:
     * 				执行耗时:0 ms,击败了100.00% 的Java用户
     * 				内存消耗:36.6 MB,击败了32.34% 的Java用户
     *
     */
    static class GenerateMatrix implements IGenerateMatrix {

        @Override
        public int[][] generateMatrix(int n) {
            int[][] result = new int[n][n];

            if (n == 1) {
                result[0][0] = 1;
                return result;
            }

            int begin = 1;
            int end = n*n;
            int row = 0, col=0;
            // 0 -left, 1-down, 2-right, 3-up
            int dir = 0;
            
            create(begin, end, row, col, n, dir, result);
            return result;
        }

        private void create(int begin, int end, int row, int col, int len,int dir,  int[][] result){
            if (row >= len || col >= len || dir >= 4 || dir < 0) {
                return;
            }
            if (begin <= end) {
                if (dir == 0) {
                    for (; col < len && result[row][col] == 0 && begin <= end; col++) {
                        result[row][col] = begin++;
                    }
                    if (result[row+1][col-1] == 0 && begin <= end) {
                        create(begin, end, row+1, col-1, len, 1, result);
                    }
                } else if (dir == 1) {
                    for (; row < len && result[row][col] == 0 && begin <= end; row++) {
                        result[row][col] = begin++;
                    }
                    if (result[row-1][col-1] == 0 && begin <= end) {
                        create(begin, end, row-1, col-1, len, 2, result);
                    }
                } else if (dir == 2) {
                    for (; col >= 0 && result[row][col] == 0 && begin <= end; col--) {
                        result[row][col] = begin++;
                    }
                    if (result[row-1][col+1] == 0 && begin <= end) {
                        create(begin, end, row-1, col+1, len, 3, result);
                    }
                } else if (dir == 3) {
                    for (; row >= 0 && result[row][col] == 0 && begin <= end; row--) {
                        result[row][col] = begin++;
                    }
                    if (result[row+1][col+1] == 0 && begin <= end) {
                        create(begin, end, row+1, col+1, len, 0, result);
                    }
                }
            }else {
                return;
            }
        }
    }
}
