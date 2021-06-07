package com.vitoboy.leetcode.weekly.I244I;

/**
 * 
 * 给你两个大小为 n x n 的二进制矩阵 mat 和 target 。现 以 90 度顺时针轮转 矩阵 mat 中的元素 若干次 ，如果能够使 mat 与 
 * target 一致，返回 true ；否则，返回 false 。 
 * 
 *  
 * 
 *  示例 1：
 * 输入：mat = [[0,1],[1,0]], target = [[1,0],[0,1]]
 * 输出：true
 * 解释：顺时针轮转 90 度一次可以使 mat 和 target 一致。
 *  
 * 
 *  示例 2：
 * 输入：mat = [[0,1],[1,1]], target = [[1,0],[0,1]]
 * 输出：false
 * 解释：无法通过轮转矩阵中的元素使 equal 与 target 一致。
 *  
 * 
 *  示例 3：
 * 输入：mat = [[0,0,0],[0,1,0],[1,1,1]], target = [[1,1,1],[0,1,0],[0,0,0]]
 * 输出：true
 * 解释：顺时针轮转 90 度两次可以使 mat 和 target 一致。
 *  
 * 
 *  
 * 
 *  提示：
 *  n == mat.length == target.length 
 *  n == mat[i].length == target[i].length 
 *  1 <= n <= 10 
 *  mat[i][j] 和 target[i][j] 不是 0 就是 1 
 *  
 *  Related Topics 数组 
 *  👍 3 👎 0
 * 
 * 
 * @author vito
 * @version 1.0
 * @date 2021/6/7
 *
 */
public class I3I_I1886I_FindRotation {

    public static void main(String[] args) {

    }


    /**
     * 模拟翻转, 计算每个翻转角度后的値, 是否与目标值一样, 如果是, 则继续计算, 直到所有位置都做了判断,返回最后的判断结果
     *
     * 				解答成功:
     * 				执行耗时:1 ms,击败了100.00% 的Java用户
     * 				内存消耗:37.7 MB,击败了100.00% 的Java用户
     *
     *
     *
     * @param mat
     * @param target
     * @return
     */
    public boolean findRotation(int[][] mat, int[][] target) {
        int n = mat.length;
        boolean zero = true, one = true, two = true, three = true;
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                // 旋转0度 或 360度
                if(target[i][j] != mat[i][j] && zero) {
                    zero = false;
                }
                // 旋转90度
                if(target[j][n-i-1] != mat[i][j] && one) {
                    one = false;
                }
                // 旋转180度
                if(target[n - i -1][n - j -1] != mat[i][j] && two) {
                    two = false;
                }
                // 旋转270度
                if(target[n-j-1][i] != mat[i][j] && three) {
                    three = false;
                }
            }
        }
        return zero || one || two || three;
    }
}
