package com.vitoboy.leetcode.weekly.I247I;

import java.util.Arrays;

/**
 * @author vito
 * @version 1.0
 * @date 2021/6/27
 */
public class Test {
    public static void main(String[] args) {
        Test test = new Test();
        int[] res = test.getTurnIndex(0, 0, 0, 2, 3, 3);
        System.out.println(Arrays.toString(res));
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                res = test.getTurnIndex(0, 0, j, 2, 3, 3);
                System.out.println(Arrays.toString(res));
            }
            for (int j = 1; j < 4; j++) {
                res = test.getTurnIndex(0, j, 0, 2, 3, 3);
                System.out.println(Arrays.toString(res));
            }
            for (int j = 1; j < 4; j++) {
                res = test.getTurnIndex(0, 3, j, 2, 3, 3);
                System.out.println(Arrays.toString(res));
            }
            for (int j = 1; j < 4; j++) {
                res = test.getTurnIndex(0, j, 3, 2, 3, 3);
                System.out.println(Arrays.toString(res));
            }
        }
    }


    public int[][] rotateGrid(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        int cycle = m/2 - 1;
        int[][] res = new int[m][n];
        for (int i = 0; i < cycle; i++) {
            int maxm = m-i-1, maxn = n-i-1;
            int len = k % (2*(m-i*2) + 2*(n-i*2) - 4);
            // 右 -> 下 -> 左 -> 上
            int x = i, y = i;
            // 右
            for (int j = 0; j < maxn-y; j++) {
                int[] indexs = getTurnIndex(i, x, y+j, len, maxm,maxn);
                if (res[indexs[0]][indexs[1]] != 0) continue;
                res[indexs[0]][indexs[1]] = grid[x][y+j];
            }
            y = maxn - i;
            // 下
            for (int j = 1; j < maxm-x; j++) {
                int[] indexs = getTurnIndex(i, x, y+j, len, maxm,maxn);
                if (res[indexs[0]][indexs[1]] != 0) continue;
                res[indexs[0]][indexs[1]] = grid[x+j][y];
            }
            x = maxm - i;
            // 左
            for (int j = maxn-y-1; j > 0; j++) {
                int[] indexs = getTurnIndex(i, x, y+j, len, maxm,maxn);
                if (res[indexs[0]][indexs[1]] != 0) continue;
                res[indexs[0]][indexs[1]] = grid[x][y];
            }
            y = i;
            // 上
            for (int j = 1; j < maxn-x; j++) {
                int[] indexs = getTurnIndex(i, x, y, len, maxm,maxn);
                if (res[indexs[0]][indexs[1]] != 0) continue;
                res[indexs[0]][indexs[1]] = grid[x][y];
            }
        }
        return res;
    }

    public int[] getTurnIndex(int start , int row, int col, int time, int maxRow, int maxCol) {
        int[] index = new int[2];
        int diff = 0;
        while (time > 0) {
            if (row == start && col > start) {
                diff = col - start;
                if (diff >= time) {
                    index[0] = row;
                    index[1] = col-time;
                    return index;
                } else {
                    time = time-diff;
                    col = start;
                }
            } else if (row == start && col == start) {
                diff = maxRow - start;
                if (diff >= time) {
                    index[0] = row + time;
                    index[1] = col;
                    return index;
                } else {
                    time = time - diff;
                    row = maxRow;
                }
            } else if (row == maxRow && col == start) {
                diff = maxCol - start;
                if (diff >= time) {
                    index[0] = row;
                    index[1] = start + time;
                    return index;
                } else {
                    time = time - diff;
                    col = maxCol;
                }
            } else if (row == maxRow && col > start) {
                diff = maxRow - start;
                if (diff >= time) {
                    index[0] = row;
                    index[1] = col - time;
                    return index;
                } else {
                    time = time - diff;
                    row = start;
                }
            }
        }
        return index;
    }


//    public long wonderfulSubstrings(String word) {
//        long count = word.length();
//        for (int i = 0; i < ; i++) {
//
//        }
//    }
}
