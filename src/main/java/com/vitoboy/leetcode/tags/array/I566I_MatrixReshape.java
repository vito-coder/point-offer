package com.vitoboy.leetcode.tags.array;

import java.util.Arrays;

/**
 * @problem leetcode
 * @description 566.重塑矩阵
 * 
 * 在MATLAB中，有一个非常有用的函数 reshape，它可以将一个矩阵重塑为另一个大小不同的新矩阵，但保留其原始数据。 
 * 
 *  给出一个由二维数组表示的矩阵，以及两个正整数r和c，分别表示想要的重构的矩阵的行数和列数。 
 * 
 *  重构后的矩阵需要将原始矩阵的所有元素以相同的行遍历顺序填充。 
 * 
 *  如果具有给定参数的reshape操作是可行且合理的，则输出新的重塑矩阵；否则，输出原始矩阵。 
 * 
 *  示例 1:
 * 输入:  nums =[[1,2],[3,4]]; r = 1, c = 4
 * 输出:  [[1,2,3,4]]
 * 解释:
 * 行遍历nums的结果是 [1,2,3,4]。新的矩阵是 1 * 4 矩阵, 用之前的元素值一行一行填充新矩阵。
 *  
 * 
 *  示例 2:
 * 输入: nums = [[1,2],[3,4]]; r = 2, c = 4
 * 输出:  [[1,2],[3,4]]
 * 解释:
 * 没有办法将 2 * 2 矩阵转化为 2 * 4 矩阵。 所以输出原矩阵。
 *  
 * 
 *  注意：
 *  给定矩阵的宽和高范围在 [1, 100]。 
 *  给定的 r 和 c 都是正数。 
 *  
 *  Related Topics 数组 矩阵 模拟 
 *  👍 224 👎 0
 * 
 * 
 * @author vito
 * @version 1.0
 * @date 2021/8/2
 */
public class I566I_MatrixReshape {
    public static void main(String[] args) {
        I566I_MatrixReshape reshape = new I566I_MatrixReshape();
        int[][] mat = new int[][]{{1,2},{3,4}};
        int[][] ans = reshape.matrixReshape(mat, 1, 4);
        for (int[] an : ans) {
            System.out.println(Arrays.toString(an));
        }
        System.out.println("expect is : [[1,2,3,4]]");
        mat = new int[][]{{1,2},{3,4}};
        ans = reshape.matrixReshape(mat, 2, 4);
        for (int[] an : ans) {
            System.out.println(Arrays.toString(an));
        }
        System.out.println("expect is : [[1,2],[3,4]]");
    }


    /**
     * 				解答成功:
     * 				执行耗时:0 ms,击败了100.00% 的Java用户
     * 				内存消耗:39.6 MB,击败了7.15% 的Java用户
     *
     * 时间复杂度: O(N);
     * 空间复杂度: O(1);
     *
     * @param mat
     * @param r
     * @param c
     * @return
     */
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        if (mat == null) return mat;
        int m = mat.length, n = mat[0].length;
        if (m*n != r*c) return mat;
        int[][] ans = new int[r][c];
        int im = 0, in = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (in >= n) {
                    in = 0;
                    im++;
                }
                ans[i][j] = mat[im][in];
                in++;
            }
        }

        return ans;
    }
    
    
}
