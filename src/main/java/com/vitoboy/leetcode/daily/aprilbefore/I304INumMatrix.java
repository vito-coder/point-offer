package com.vitoboy.leetcode.daily.aprilbefore;

/**
 * 
 * 给定一个二维矩阵，计算其子矩形范围内元素的总和，该子矩阵的左上角为 (row1, col1) ，右下角为 (row2, col2) 。 
 * 
 *  
 * 上图子矩阵左上角 (row1, col1) = (2, 1) ，右下角(row2, col2) = (4, 3)，该子矩形内元素的总和为 8。 
 * 
 *  
 * 
 *  示例： 
 * 
 *  
 * 给定 matrix = [
 *   [3, 0, 1, 4, 2],
 *   [5, 6, 3, 2, 1],
 *   [1, 2, 0, 1, 5],
 *   [4, 1, 0, 1, 7],
 *   [1, 0, 3, 0, 5]
 * ]
 * 
 * sumRegion(2, 1, 4, 3) -> 8
 * sumRegion(1, 1, 2, 2) -> 11
 * sumRegion(1, 2, 2, 4) -> 12
 *  
 * 
 *  
 * 
 *  提示： 
 * 
 *  
 *  你可以假设矩阵不可变。 
 *  会多次调用 sumRegion 方法。 
 *  你可以假设 row1 ≤ row2 且 col1 ≤ col2 。 
 *  
 *  Related Topics 动态规划 
 *  👍 196 👎 0
 * 
 * 
 * @Author: vito
 * @Date: 2021/3/2 下午2:47
 * @Version: 1.0
 */
public class I304INumMatrix {
    public static void main(String[] args) {
        int[][] matrix = new int[5][];
        matrix[0] = new int[]{3, 0, 1, 4, 2};
        matrix[1] = new int[]{5, 6, 3, 2, 1};
        matrix[2] = new int[]{1, 2, 0, 1, 5};
        matrix[3] = new int[]{4, 1, 0, 1, 7};
        matrix[4] = new int[]{1, 0, 3, 0, 5};
        INumMatrix numMatrix = new NumMatrix(matrix);
        System.out.println("result is : " + numMatrix.sumRegion(2, 1, 4, 3));
        System.out.println("expect is : 8");
        System.out.println("result is : " + numMatrix.sumRegion(1, 1, 2, 2));
        System.out.println("expect is : 11");
        System.out.println("result is : " + numMatrix.sumRegion(1, 2, 2, 4));
        System.out.println("expect is : 12");
    }
    
}

interface INumMatrix {
    int sumRegion(int row1, int col1, int row2, int col2);
}

/**
 * 				解答成功:
 * 				执行耗时:15 ms,击败了60.40% 的Java用户
 * 				内存消耗:44 MB,击败了71.79% 的Java用户
 */
class NumMatrix implements INumMatrix{

    int[][] sum;

    public NumMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0 ) {
            return;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        sum = new int[row+1][col+1];
        for (int i = 0; i <= row; i++) {
            sum[i][0] = 0;
            for (int j = 1; j <= col; j++) {
                sum[i][j] = sum[i][j-1] + sum[i-1][j] + matrix[i-1][j-1] - sum[i-1][j-1];
            }
        }
    }

    @Override
    public int sumRegion(int row1, int col1, int row2, int col2) {
        if (sum == null) {
            return 0;
        }
        return sum[row2+1][col2+1] - sum[row2+1][col1] - sum[row1][col2+1] + sum[row1][col1];
    }
}
