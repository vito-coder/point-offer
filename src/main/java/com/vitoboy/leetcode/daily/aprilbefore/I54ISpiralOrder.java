package com.vitoboy.leetcode.daily.aprilbefore;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。 
 * 
 *
 *  示例 1：
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 *  
 * 
 *  示例 2：
 * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 *
 *  提示：
 *  m == matrix.length 
 *  n == matrix[i].length 
 *  1 <= m, n <= 10 
 *  -100 <= matrix[i][j] <= 100 
 *  
 *  Related Topics 数组 矩阵 模拟 
 *  👍 810 👎 0
 * 
 * 
 * @Author: vito
 * @Date: 2021/3/17 下午3:56
 * @Version: 1.0
 */
public class I54ISpiralOrder {
    // todo 待解决问题
    public static void main(String[] args) {
        SpiralOrderInterface spiralOrder = new SpiralOrder();
        int[][] num = new int[3][4];
        num[0] = new int[]{1, 2, 3, 4};
        num[1] = new int[]{5,6,7,8};
        num[2] = new int[]{9,10,11,12};
        System.out.println(spiralOrder.spiralOrder(num));
    }

    interface SpiralOrderInterface {
        List<Integer> spiralOrder(int[][] matrix);
    }

    static class SpiralOrder implements SpiralOrderInterface{

        @Override
        public List<Integer> spiralOrder(int[][] matrix) {
            int end = matrix.length * matrix[0].length;
            int begin = 1;
            List<Integer> list = new ArrayList<>(end);
            int left = 0, right = matrix[0].length-1, top = 0, button = matrix.length-1;
            while (begin <= end){
                // left to right
                for (int i = left; i <= right && begin <=end; i++) {
                    list.add(matrix[top][i]);
                    begin++;
                }
                top++;
                // top to button
                for (int i = top; i <= button&& begin <=end; i++) {
                    list.add(matrix[i][right]);
                    begin++;
                }
                right--;
                // right to left
                for (int i = right; i >= left&& begin <=end; i--) {
                    list.add(matrix[button][i]);
                    begin++;
                }
                button--;
                // button to top
                for (int i = button; i >= top&& begin <=end; i--) {
                    list.add(matrix[i][left]);
                    begin++;
                }
                left++;

            }
            return list;
        }
    }

    static class SpiralOrderII implements SpiralOrderInterface{

        @Override
        public List<Integer> spiralOrder(int[][] matrix) {
            return null;
        }
    }
}
