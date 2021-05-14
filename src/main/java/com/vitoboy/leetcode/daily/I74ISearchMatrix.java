package com.vitoboy.leetcode.daily;

/**
 *编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性： 
 *
 * 
 * 每行中的整数从左到右按升序排列。 
 * 每行的第一个整数大于前一行的最后一个整数。 
 * 
 *
 * 
 *
 * 示例 1： 
 *
 * 
 *输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
 *输出：true
 * 
 *
 * 示例 2： 
 *
 * 
 *输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
 *输出：false
 * 
 *
 * 
 *
 * 提示： 
 *
 * 
 * m == matrix.length 
 * n == matrix[i].length 
 * 1 <= m, n <= 100 
 * -104 <= matrix[i][j], target <= 104 
 * 
 * Related Topics 数组 二分查找 
 * 👍 404 👎 0
 * 
 * @Author: vito
 * @Date: 2021/3/30 下午11:46
 * @Version: 1.0
 */
public class I74ISearchMatrix {
    // todo 待解决问题--一直未提交, 待确认原因
    public static void main(String[] args) {
        SearchMatrixInterface searchMatrix = new SearchMatrix();
        int[][] matrix = createTest(1);
        System.out.println("search result is : " + searchMatrix.searchMatrix(matrix, 3));
        System.out.println("expect result is : true");
        System.out.println("search result is : " + searchMatrix.searchMatrix(matrix, 4));
        System.out.println("expect result is : false");
        System.out.println("search result is : " + searchMatrix.searchMatrix(matrix, 13));
        System.out.println("expect result is : false");
        System.out.println("search result is : " + searchMatrix.searchMatrix(matrix, 60));
        System.out.println("expect result is : true");

    }
    public static int[][] createTest(int var) {
        switch (var) {
            case 1:
                int[][] matrix = new int[3][];
                matrix[0] = new int[]{1,3,5,7};
                matrix[1] = new int[]{10,11,16,20};
                matrix[2] = new int[]{23,30,34,60};
                return matrix;
            case 2:
                return null;
        }
        return null;
    }

    interface SearchMatrixInterface {
        boolean searchMatrix(int[][] matrix, int target);
    }


    /**
     * 				解答成功:
     * 				执行耗时:0 ms,击败了100.00% 的Java用户
     * 				内存消耗:37.6 MB,击败了95.61% 的Java用户
     */
    static class SearchMatrix implements SearchMatrixInterface{

        @Override
        public boolean searchMatrix(int[][] matrix, int target) {
            if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
                return false;
            }
            // 使用两重二分查找即可
            if (matrix.length > 1) {
                return doubleBinarySearchArray(matrix, target);
            } else {
                return binarySearchArray(matrix[0], target);
            }
        }

        private boolean doubleBinarySearchArray(int[][] matrix, int target) {
            int high = matrix.length;
            int low = 0;
            int mid = (high+low)/2;
            while (mid < high && mid >= low) {
                if (matrix[mid][0] == target) {
                    return true;
                } else if (matrix[mid][0] < target) {
                    low = mid+1;
                    mid = (high + low)/2;
                } else {
                    high = mid;
                    mid = (high+low)/2;
                }
            }
            if (mid > 0) {
                return binarySearchArray(matrix[mid-1], target);
            }
            return false;
        }


        private boolean binarySearchArray(int[] array, int target) {
            int high = array.length;
            int low = 0;
            int mid = (high + low)/2;
            while (mid < high && mid >= low ) {
                if (array[mid] == target) {
                    return true;
                } else if (array[mid] < target) {
                    low = mid+1;
                    mid = (high+low)/2;
                } else {
                    high = mid;
                    mid = (high+low)/2;
                }
            }
            return false;
        }



    }
    
}
