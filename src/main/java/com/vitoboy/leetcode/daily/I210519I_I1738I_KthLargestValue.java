package com.vitoboy.leetcode.daily;

import java.util.*;

/**
 * 
 * 给你一个二维矩阵 matrix 和一个整数 k ，矩阵大小为 m x n 由非负整数组成。 
 * 
 *  矩阵中坐标 (a, b) 的 值 可由对所有满足 0 <= i <= a < m 且 0 <= j <= b < n 的元素 matrix[i][j]（下
 * 标从 0 开始计数）执行异或运算得到。 
 * 
 *  请你找出 matrix 的所有坐标中第 k 大的值（k 的值从 1 开始计数）。 
 * 
 *  
 * 
 *  示例 1： 
 * 
 *  输入：matrix = [[5,2],[1,6]], k = 1
 * 输出：7
 * 解释：坐标 (0,1) 的值是 5 XOR 2 = 7 ，为最大的值。 
 * 
 *  示例 2： 
 * 
 *  输入：matrix = [[5,2],[1,6]], k = 2
 * 输出：5
 * 解释：坐标 (0,0) 的值是 5 = 5 ，为第 2 大的值。 
 * 
 *  示例 3： 
 * 
 *  输入：matrix = [[5,2],[1,6]], k = 3
 * 输出：4
 * 解释：坐标 (1,0) 的值是 5 XOR 1 = 4 ，为第 3 大的值。 
 * 
 *  示例 4： 
 * 
 *  输入：matrix = [[5,2],[1,6]], k = 4
 * 输出：0
 * 解释：坐标 (1,1) 的值是 5 XOR 2 XOR 1 XOR 6 = 0 ，为第 4 大的值。 
 * 
 *  
 * 
 *  提示： 
 * 
 *  
 *  m == matrix.length 
 *  n == matrix[i].length 
 *  1 <= m, n <= 1000 
 *  0 <= matrix[i][j] <= 106 
 *  1 <= k <= m * n 
 *  
 *  Related Topics 数组 
 *  👍 21 👎 0
 * 
 * @Author: vito
 * @Date: 2021/5/19 上午7:55
 * @Version: 1.0
 */
public class I210519I_I1738I_KthLargestValue {
    public static void main(String[] args) {
        int[][] result = new int[1][1];
        System.out.println(result[0][0]);
        result = new int[2][2];
        result[0] = new int[]{5,2};
        result[1] = new int[]{1,6};
        I210519I_I1738I_KthLargestValue kthLargestValue = new I210519I_I1738I_KthLargestValue();
        System.out.println(kthLargestValue.kthLargest(result, 1));
        System.out.println(kthLargestValue.kthLargest(result, 2));
        System.out.println(kthLargestValue.kthLargest(result, 3));
        System.out.println(kthLargestValue.kthLargest(result, 4));

    }

    /**
     * 相关算法:
     * [215]数据中的第k个最大元素
     * [230]二叉搜索树中第k小的元素
     * [347]前k个高频元素
     * [378]有序矩阵中第k小的元素
     * [402]移掉k位数字?
     * [440]字典序的第k小数字
     * [668]乘法表中第k小的数
     * [692]前k个高频单词
     * [703]数据流中的第k大元素
     * [779]第k个语法符号
     * [768]第k个最小的素数分数
     *
     *
     * @param matrix
     * @param k
     * @return
     */
    public int kthLargestValue(int[][] matrix, int k) {
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] result = new int[row+1][col+1];
        System.out.println();
        int[] kthLargest = new int[k];
        int res = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                result[i+1][j+1] = result[i][j] ^ result[i][j+1] ^ result[i+1][j] ^ matrix[i][j];
                binarySearchAndInsert(kthLargest, result[i+1][j+1]);
            }
        }

        return kthLargest[k-1];
    }


    /**
     * 				解答成功:
     * 				执行耗时:335 ms,击败了24.85% 的Java用户
     * 				内存消耗:143.3 MB,击败了80.00% 的Java用户
     *
     * @param matrix
     * @param k
     * @return
     */
    public int kthLargest(int[][] matrix, int k){
        int m = matrix.length, n = matrix[0].length;
        int[][] pre = new int[m + 1][n + 1];
        List<Integer> results = new ArrayList<Integer>();
        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                pre[i][j] = pre[i - 1][j] ^ pre[i][j - 1] ^ pre[i - 1][j - 1] ^ matrix[i - 1][j - 1];
                results.add(pre[i][j]);
            }
        }

        Collections.sort(results, new Comparator<Integer>() {
            public int compare(Integer num1, Integer num2) {
                return num2 - num1;
            }
        });
        return results.get(k - 1);
    }




    public void compareAndSetKthLargest(int[] largest, int insert) {
        for (int i = 0; i < largest.length; i++) {
            if (insert >= largest[i]) {
                System.arraycopy(largest, i, largest, i+1, largest.length-i-1);
                largest[i] = insert;
                break;
            }
        }
    }

    public void binarySearchAndInsert(int[] ascArr, int n) {
        int high = ascArr.length;
        int low = 0;
        int mid = ascArr.length / 2;
        while (low < high) {
            mid = (high + low)/2;
            if (ascArr[mid] > n) {
                low = mid+1;
            } else if (ascArr[mid] < n){
                high = mid;
            } else {
                System.arraycopy(ascArr, mid, ascArr, mid+1, ascArr.length-mid-1);
                ascArr[mid] = n;
                return;
            }
        }
        if (low == ascArr.length) return;
        if (low >= ascArr.length -1) {
            ascArr[ascArr.length-1] = n;
            return;
        }
        System.arraycopy(ascArr, low, ascArr, low+1, ascArr.length-low-1);
        ascArr[low] = n;
    }

}
