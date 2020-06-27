package com.vitoboy.leetcode;

/**
 * @Author: vito
 * @Date: 2020/6/19 18:11
 * @Version: 1.0
 * <p>
 * 剑指 Offer 13. 机器人的运动范围
 * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。
 * 一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），
 * 也不能进入行坐标和列坐标的数位之和大于k的格子。
 * <p>
 * 例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。
 * 但它不能进入方格 [35, 38]，因为3+5+3+8=19。
 * <p>
 * 请问该机器人能够到达多少个格子？
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：m = 2, n = 3, k = 1
 * 输出：3
 * 示例 2：
 * <p>
 * 输入：m = 3, n = 1, k = 0
 * 输出：1
 * 提示：
 * <p>
 * 1 <= n,m <= 100
 * 0 <= k <= 20
 * <p>
 * <p>
 * 0 1 2 3 4 5 6
 * 1 2 3 4 5 6 7
 * 2 3 4 5 6 7 8
 * 3 4 5 6 7 8 9
 * 4 5 6 7 8 9 10
 * 5 6 7 8 9 10 11
 * 6 7 8 9 10 11 12
 *
 * 38
 * 15
 * 9
 */
public class XI_RobotMovingCount {

    public static void main(String[] args) {

        System.out.println(robotMovingCount(2, 3, 1));
        System.out.println(robotMovingCount(3, 1, 0));
        System.out.println(robotMovingCount(16, 8, 4));
        System.out.println(robotMovingCount(38, 15, 9));

        XI_RobotMovingCount count = new XI_RobotMovingCount();

        System.out.println(count.movingCount(2, 3, 1));
        System.out.println(count.movingCount(3, 1, 0));
        System.out.println(count.movingCount(16, 8, 4));
        System.out.println(count.movingCount(38, 15, 9));
        System.out.println(count.movingCount(100, 100, 9));

    }


    public static int robotMovingCount(int m, int n, int k) {
        if (m == 0 || n == 0) return 0;
        if (k < 0) return 0;
        else {
            if (k < 9) {
                if (m > k) {
                    m = k+1;
                }
                if (n > k) {
                    n = k+1;
                }
            }
            int count = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    int sum = j / 10 + j % 10 + i / 10 + i % 10;
                    if (k < sum) break;
                    else count++;
                }
                if (k < (i / 10 + i % 10)) break;
            }
            return count;
        }
    }

    /**
     * 深度优先
     *
     * @param m
     * @param n
     * @param k
     * @return
     */
    public int movingCount(int m, int n, int k) {
        if (m == 0 || n == 0) return 0;
        if (k < 0) return 0;
        int[][] check = new int[m][n];
        int count = moveCount(check, 0, 0, k);
        return count;
    }

    public int moveCount(int[][] check, int i, int j, int k) {
        if (i >= check.length || j >= check[0].length ) return 0;
        if ((i%10 + i/10 + j%10 + j/10) > k) return 0;
        if (check[i][j] == 1) return 0;
        check[i][j] = 1;
        return 1 + moveCount(check, i, j+1, k) + moveCount(check, i+1, j, k);
    }
}
